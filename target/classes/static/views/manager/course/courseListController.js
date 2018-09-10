app.controller('courseListController',
	function($scope, $http, $location, $modal,myAlert) {
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
		$http.post("/teacher/list", $scope.so).then(function(data) {
			$scope.vm.teachers = data.data.dataList;
		})
		$scope.getCourseList = function() {
			$scope.vo.pageIndex = vm.pages.pageIndex;
			$scope.vo.pageSize = vm.pages.pageSize;
			$http.post("/course/list", $scope.vo).then(function(data) {
				$scope.vm.items = data.data.dataList;
				$scope.vm.pages.totalResult = data.data.pager.recordCount;
				$scope.vm.pages.totalPage = data.data.pager.totalPage;
			})
		}
		$scope.getCourseList();

		$scope.searchClick = function() {
			$scope.getCourseList();
		}
		$scope.resetClick = function() {
			$scope.vo = {};
			$scope.getCourseList();
		}
		// 增加修改规则弹出框
		$scope.update = function(num) {

			var modalInstance = $modal.open({
				templateUrl: 'updateCourse.html',
				controller: 'updateCourseController',
				size: 'md',
				resolve: {
					data: function() {
						var data = num;
						return data;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getCourseList();

			})
		}
		$scope.add = function() {

			var modalInstance = $modal.open({
				templateUrl: 'addCourse.html',
				controller: 'addCourseController',
				size: 'md',
				resolve: {
					data: function() {
						return null;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getCourseList();

			})
		}

	}).controller(
	'updateCourseController', [
		'$modalInstance',
		'$scope',
		'$http',
		'data',
		'myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};

			$http.post('/course/get/' + data).then(function(data) {
				$scope.vo = data.data;
			})
			$scope.ok = function() {
				$http.post('/course/update', $scope.vo).then(
					function(data) {
						myAlert.show("修改成功");
						$modalInstance.close();
					})
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	]).controller(
	'addCourseController', [
		'$modalInstance',
		'$scope',
		'$http',
		'data',
		'myAlert',
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
			$scope.so = {
				pageSize: 100,
				pageIndex: 1
			};
			$http.post("/teacher/list", $scope.so).then(function(data) {
				$scope.vm.teachers = data.data.dataList;
			})

			$scope.ok = function() {
				$http.post('/course/add', $scope.vo).then(
					function(data) {
						myAlert.show("添加成功");
						$modalInstance.close();
					})
			};
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])