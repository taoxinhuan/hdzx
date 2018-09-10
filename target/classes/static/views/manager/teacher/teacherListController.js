app.controller('teacherListController', function($scope, $http, $location,$modal,myAlert) {
	$scope.vo = {};
	var vm = $scope.vm = {};
	vm.pages = {
		pageSize: 15,
		pageIndex: 1,
		totalResult: 0,
		totalPage: 0
	};
	$scope.so={pageSize: 100,pageIndex: 1};
	$http.post("/dept/list", $scope.so).then(function(data) {
			$scope.vm.depts = data.data.dataList;
	})
	$scope.getTeacherList = function() {
		$scope.vo.pageIndex = vm.pages.pageIndex;
		$scope.vo.pageSize = vm.pages.pageSize;
		$http.post("/teacher/list", $scope.vo).then(function(data) {
			$scope.vm.items = data.data.dataList;
			$scope.vm.pages.totalResult = data.data.pager.recordCount;
			$scope.vm.pages.totalPage = data.data.pager.totalPage;
		})
	}
	$scope.getTeacherList();

	$scope.searchClick = function() {
		$scope.getTeacherList();
	}
	$scope.resetClick = function() {
		$scope.vo = {};
		$scope.getTeacherList();
	}

		// 增加修改规则弹出框
		$scope.update = function(num) {

			var modalInstance = $modal.open({
				templateUrl: 'updateTeacher.html',
				controller: 'updateTeacherController',
				size: 'md',
				resolve: {
					data: function() {
						var data = num;
						return data;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getTeacherList();
			})
		}
		$scope.add = function() {
			
			var modalInstance = $modal.open({
				templateUrl: 'addTeacher.html',
				controller: 'addTeacherController',
				size: 'md',
				resolve: {
					data: function() {
						return null;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getTeacherList();
			})
		}

	})
	.controller('updateTeacherController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};

			$http.post('/teacher/get/' + data)
				.then(function(data) {
					$scope.vo = data.data;
				})
			$scope.ok = function() {
				$http.post('/teacher/update', $scope.vo)
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
	.controller('addTeacherController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};
			var vm = $scope.vm = {};
			vm.pages = {
				pageSize: 10,
				pageIndex: 1,
				totalResult: 0,
				totalPage: 0
			};
			$scope.so={pageSize: 100,pageIndex: 1};
			$http.post("/dept/list", $scope.so).then(function(data) {
					$scope.vm.depts = data.data.dataList;
			})
			$scope.vo.teacherPassword = "123456";
			$scope.ok = function() {
				$http.post('/teacher/add', $scope.vo)
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