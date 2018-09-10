app.controller('inputGradeController',
	function($scope, $http, $location, $modal,myAlert) {
	
	var storage = window.sessionStorage
	//反序列化json
	var teacher =JSON.parse(storage.getItem("teacher"));
	
	if(teacher==null){
		myAlert.show("登陆失效，请重新登陆");
		return ;
	}
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
				pageIndex: 1,
				teacherNum:teacher.teacherNum
			};
			$http.post("/course/list", $scope.so).then(function(data) {
				$scope.vm.courses = data.data.dataList;
			})
	
		$scope.getCourseList = function() {
			$scope.vo.pageIndex = vm.pages.pageIndex;
			$scope.vo.pageSize = vm.pages.pageSize;
			$scope.vo.teacherNum=teacher.teacherNum;
			$http.post("/grade/listForTeacher", $scope.vo).then(function(data) {
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
		$scope.updateGrade=function(item){
			var modalInstance = $modal.open({
				templateUrl: 'updateGrade.html',
				controller: 'updateGradeController',
				size: 'md',
				resolve: {
					data: function() {
						return item;
					}
				}
			});
			modalInstance.result.then(function(data) {
				$scope.getCourseList();
			})
		}
	})
	
	.controller(
	'updateGradeController', [
		'$modalInstance',
		'$scope',
		'$http',
		'data',
		function($modalInstance, $scope, $http, data) {
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
			$http.post("/grade/get/"+data.studentNum+"/"+data.courseNum).then(function(data) {
				$scope.vo=data.data;
			})

			$scope.ok = function() {
				$http.post('/grade/update', $scope.vo).then(
					function(data) {
						$modalInstance.close();
					})
			};
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])