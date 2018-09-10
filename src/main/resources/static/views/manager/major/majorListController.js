app.controller('majorListController', function($scope, $http, $location, $modal,myAlert) {
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
		$scope.getMajorList = function() {
			$scope.vo.pageIndex = vm.pages.pageIndex;
			$scope.vo.pageSize = vm.pages.pageSize;
			$http.post("/major/list", $scope.vo).then(function(data) {
				$scope.vm.items = data.data.dataList;
				$scope.vm.pages.totalResult = data.data.pager.recordCount;
				$scope.vm.pages.totalPage = data.data.pager.totalPage;
			})
		}
		$scope.getMajorList();

		$scope.searchClick = function() {
			$scope.getMajorList();
		}
		$scope.resetClick = function() {
			$scope.vo = {};
			$scope.getMajorList();
		}

		// 增加修改规则弹出框
		$scope.update = function(num) {

			var modalInstance = $modal.open({
				templateUrl: 'updateMajor.html',
				controller: 'updateMajorController',
				size: 'md',
				resolve: {
					data: function() {
						var data = num;
						return data;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getMajorList();

			})
		}
		$scope.add = function(num) {

			var modalInstance = $modal.open({
				templateUrl: 'addMajor.html',
				controller: 'addMajorController',
				size: 'md',
				resolve: {
					data: function() {
						return null;
					}
				}
			});
			modalInstance.result.then(function() {
				$scope.getMajorList();

			})
		}

	})
	.controller('updateMajorController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};

			$http.post('/major/get/' + data)
				.then(function(data) {
					$scope.vo = data.data;
				})
			$scope.ok = function() {
				$http.post('/major/update', $scope.vo)
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
	.controller('addMajorController', [
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
			$scope.ok = function() {
				$http.post('/major/add', $scope.vo)
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