app.controller('deptListController', function($scope, $http, $location,$modal,myAlert) {
	$scope.vo = {};
	var vm = $scope.vm = {};
	vm.pages = {
		pageSize: 15,
		pageIndex: 1,
		totalResult: 0,
		totalPage: 0
	};
	$scope.getDeptList = function() {
		$scope.vo.pageIndex = vm.pages.pageIndex;
		$scope.vo.pageSize = vm.pages.pageSize;
		$http.post("/dept/list", $scope.vo).then(function(data) {
			$scope.vm.items = data.data.dataList;
			$scope.vm.pages.totalResult = data.data.pager.recordCount;
			$scope.vm.pages.totalPage = data.data.pager.totalPage;
		})
	}
	$scope.getDeptList();

	$scope.searchClick = function() {
		$scope.getDeptList();
	}
	$scope.resetClick = function() {
		$scope.vo = {};
		$scope.getDeptList();
	}

	// 增加修改规则弹出框
	$scope.updateDept = function(deptNum) {

		var modalInstance = $modal.open({
			templateUrl: 'updateDept.html',
			controller: 'updateDeptController',
			size: 'md',
			resolve: {
				data: function() {
					var data = deptNum;
					return data;
				}
			}
		});
		modalInstance.result.then(function() {
			$scope.getDeptList();

		})
	}
	//增加系部
	$scope.add= function() {

		var modalInstance = $modal.open({
			templateUrl: 'addDept.html',
			controller: 'addDeptController',
			size: 'md',
			resolve: {
				data: function() {
					return null;
				}
			}
		});
		modalInstance.result.then(function() {
			$scope.getDeptList();

		})
	}

})
.controller('updateDeptController', [
    	'$modalInstance', '$scope', '$http', 'data','myAlert',
    	function ($modalInstance, $scope, $http, data,myAlert) {
    		$scope.vo={};
    		$http.post('/dept/get/'+ data)
    			.then(function (data) {
    				$scope.vo=data.data;
    			})
    		$scope.ok = function () {
    			$http.post('/dept/update', $scope.vo)
    			.then(function (data) {
    				myAlert.show("修改成功");
    			$modalInstance.close();
    			})
    		};
    		
    		$scope.cancel = function () {
    			$modalInstance.dismiss('cancel');
    		};
    	}])
 .controller('addDeptController', function($modalInstance,$scope, $http, $location,myAlert) {
	$scope.vo = {};
	
	$scope.ok = function () {
		$http.post('/dept/add', $scope.vo)
		.then(function (data) {
			myAlert.show("添加成功");
		    $modalInstance.close();
		})
	};
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};

});