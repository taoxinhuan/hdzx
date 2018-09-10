app.controller('studentListController', function($scope, $http, $location,$modal,myAlert) {
	$scope.vo = {};
	var vm = $scope.vm = {};
	vm.pages = {
		pageSize: 15,
		pageIndex: 1,
		totalResult: 0,
		totalPage: 0
	};
	$scope.so = {
		pageSize: 100,
		pageIndex: 1
	};
	$http.post("/dept/list", $scope.so).then(function(data) {
		$scope.vm.depts = data.data.dataList;
	})
	$scope.listMajorByDeptNum = function() {
		$scope.so.deptNum = $scope.vo.deptNum
		$http.post("/major/list", $scope.so).then(function(data) {
			$scope.vm.majors = data.data.dataList;
		})
	}
	$scope.check = function() {
		var deptNum = $scope.so.deptNum = $scope.vo.deptNum;
		if(deptNum == null || deptNum == "") {
			alert("请先选择系部");
		}
	}

	$scope.getStudentList = function() {
		$scope.vo.pageIndex = vm.pages.pageIndex;
		$scope.vo.pageSize = vm.pages.pageSize;
		$http.post("/student/list", $scope.vo).then(function(data) {
			$scope.vm.items = data.data.dataList;
			$scope.vm.pages.totalResult = data.data.pager.recordCount;
			$scope.vm.pages.totalPage = data.data.pager.totalPage;
		})
	}
	$scope.getStudentList();
	$scope.searchClick = function() {
		$scope.getStudentList();
	}
	$scope.resetClick = function() {
		$scope.vo = {};
		$scope.getStudentList();
	}

		// 增加修改规则弹出框
		$scope.update = function(num) {

			var modalInstance = $modal.open({
				templateUrl: 'updateStudent.html',
				controller: 'updateStudentController',
				size: 'md',
				resolve: {
					data: function() {
						var data = num;
						return data;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getStudentList();

			})
		}
		$scope.add = function() {

			var modalInstance = $modal.open({
				templateUrl: 'addStudent.html',
				controller: 'addStudentController',
				size: 'md',
				resolve: {
					data: function() {
						return null;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getStudentList();

			})
		}

	})
	.controller('updateStudentController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};

			$http.post('/student/get/' + data)
				.then(function(data) {
					$scope.vo = data.data;
				})
			$scope.ok = function() {
				$http.post('/student/update', $scope.vo)
					.then(function(data) {
						myAlert.show("修改成功");
						$modalInstance.close();
					})
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])
	.controller('addStudentController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};
			$scope.vo = {};
			var vm = $scope.vm = {};
			vm.pages = {
				pageSize: 10,
				pageIndex: 1,
				totalResult: 0,
				totalPage: 0
			};
			$scope.vo.studentPassword = "123456";
			
			$scope.so = {
				pageSize: 100,
				pageIndex: 1
			};
			$http.post("/dept/list", $scope.so).then(function(data) {
				$scope.vm.depts = data.data.dataList;
			})
			$scope.listMajorByDeptNum = function() {
				$scope.so.deptNum = $scope.vo.deptNum
				$http.post("/major/list", $scope.so).then(function(data) {
					$scope.vm.majors = data.data.dataList;
				})
			}
			$scope.check = function() {
				var deptNum = $scope.so.deptNum = $scope.vo.deptNum;
				if(deptNum == null || deptNum == "") {
					myAlert.show("请先选择系部");
				}
			}
			$scope.ok = function() {
				$http.post('/student/add', $scope.vo)
				.then(function(data) {
					myAlert.show("添加成功");
					$modalInstance.close();
				})
			};
			
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
		])