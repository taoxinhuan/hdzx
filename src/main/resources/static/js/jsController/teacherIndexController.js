app.controller('teacherIndexController', function($scope,$http,$modal,$location) {
	var storage = window.sessionStorage
	//反序列化json
	var teacher =JSON.parse(storage.getItem("teacher"));
	$scope.teacher=teacher;
	
	$http.get("/getLockInfo").then(function(data) {
		$scope.control = data.data;
	})
	
	
		$scope.teacherInfo = function() {
			if($scope.teacher == null) {
				alert("请重新登录");
				window.location.href = "../../loginx.html"
			}
			var num = $scope.teacher.teacherNum;
			var modalInstance = $modal.open({
				templateUrl: 'teacherInfo.html',
				controller: 'teacherInfoController',
				size: 'md',
				resolve: {
					data: function() {
						return num;
					}
				}
			});
			modalInstance.result.then(function(data) {
				$scope.teacher = data;
				storage.setItem("teacher", JSON.stringify(data));
			})
		}
	

	$scope.courseList = function() {
		if($scope.teacher == null) {
			alert("请重新登录");
			window.location.href = "../../loginx.html"
		}
		var num = $scope.teacher.teacherNum;
		var modalInstance = $modal.open({
			templateUrl: 'courseList.html',
			controller: 'courseListController',
			size: 'md',
			resolve: {
				data: function() {
					return num;
				}
			}
		});
		modalInstance.result.then(function(data) {
			$scope.teacher = data;
		})
	}
	
})
.controller('teacherInfoController', [
		'$modalInstance', '$scope', '$http', 'data',
		function($modalInstance, $scope, $http, data) {
			$scope.vo = {};

			$http.post('/teacher/get/' + data)
				.then(function(data) {
					$scope.vo = data.data;
				})
			$scope.ok = function() {
				$http.post('/teacher/update', $scope.vo)
					.then(function(data) {
						$modalInstance.close($scope.vo);
					})
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])
	.controller('courseListController', [
		'$modalInstance', '$scope', '$http', 'data',
		function($modalInstance, $scope, $http, data) {
			$scope.vo = {};
			var vm = $scope.vm = {};
			vm.pages = {
				pageSize: 15,
				index: 1,
				totalResult: 0,
				totalPage: 0
			};
			$scope.vo.teacherNum=data;
			$scope.vo.pageIndex = 1;
			$scope.vo.pageSize = 100;
			$http.post("/course/list", $scope.vo).then(function(data) {
				$scope.vm.items = data.data.dataList;
				$scope.vm.pages.totalResult = data.data.pager.recordCount;
				$scope.vm.pages.totalPage = data.data.pager.totalPage;
			})
			$scope.ok = function() {
				$http.post('/teacher/update', $scope.vo)
					.then(function(data) {
						$modalInstance.close($scope.vo);
					})
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])