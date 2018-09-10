app.controller('studentIndexController', function($scope, $http, $modal, $location,myAlert) {
		var storage = window.sessionStorage
		//反序列化json
		var student = JSON.parse(storage.getItem("student"));
		$scope.student = student;

		$http.get("/getLockInfo").then(function(data) {
			$scope.control = data.data;
		})

		$scope.studentInfo = function() {
			if($scope.student == null) {
				myAlert.show("登陆失效，请重新登录");
				window.location.href = "../../loginx.html"
			}
			var num = $scope.student.studentNum;
			var modalInstance = $modal.open({
				templateUrl: 'studentInfo.html',
				controller: 'studentInfoController',
				size: 'md',
				resolve: {
					data: function() {
						return $scope.student.studentNum;
					}
				}
			});
			modalInstance.result.then(function(data) {
				$scope.student = data;
				storage.setItem("student", JSON.stringify(data));
			})
		}

		$scope.gradeList = function() {
			if($scope.student == null) {
				myAlert.show("登陆失效，请重新登录");
				window.location.href = "../../loginx.html"
			}
			var num = $scope.student.studentNum;
			var modalInstance = $modal.open({
				templateUrl: 'gradeList.html',
				controller: 'gradeListController',
				size: 'lg',
				resolve: {
					data: function() {
						return $scope.student.studentNum;
					}
				}
			});
			modalInstance.result.then(function(data) {
				$scope.student = data;
			})
		}
		
		$scope.CourseSelectList = function() {
			if($scope.student == null) {
				myAlert.show("登陆失效，请重新登录");
				window.location.href = "../../loginx.html"
			}
			var num = $scope.student.studentNum;
			var modalInstance = $modal.open({
				templateUrl: 'courseSelectList.html',
				controller: 'courseSelectController',
				size: 'lg',
				resolve: {
					data: function() {
						return num;
					}
				}
			});
			modalInstance.result.then(function(data) {
				$scope.student = data;
			})
		}

	})
	.controller('studentInfoController', [
		'$modalInstance', '$scope', '$http', 'data',
		function($modalInstance, $scope, $http, data) {
			$scope.vo = {};

			$http.post('/student/get/' + data)
				.then(function(data) {
					$scope.vo = data.data;
				})
			$scope.ok = function() {
				$http.post('/student/update', $scope.vo)
					.then(function(data) {
						$modalInstance.close($scope.vo);
					})
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])
	.controller('gradeListController', [
		'$modalInstance', '$scope', '$http', 'data',
		function($modalInstance, $scope, $http, data) {
			$scope.vo = {};
			
			var vm = $scope.vm = {};
			var vm = $scope.vm = {};
			vm.pages = {
				pageSize: 15,
				index: 1,
				totalResult: 0,
				totalPage: 0
			};
			
			$scope.gradeList=function(){
			$http.post('/grade/getStuGrades/' + data)
				.then(function(data) {
					$scope.vm.items = data.data;
				})	
			}
			$scope.gradeList();
			
			$scope.ok = function() {
				$scope.gradeList();
			};
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])
	.controller('courseSelectController', [
		'$modalInstance', '$scope', '$http', 'data','myAlert',
		function($modalInstance, $scope, $http, data,myAlert) {
			$scope.vo = {};
			
			var vm = $scope.vm = {};
			vm.pages = {
				pageSize: 15,
				index: 1,
				totalResult: 0,
				totalPage: 0
			};
			
			$scope.gradeList=function(){
			$http.post('/grade/getStuGrades/' + data)
				.then(function(data) {
					$scope.vm.items = data.data;
				})	
			}
			$scope.gradeList();
			
			$scope.drop = function(item) {
				var b=confirm("是否确认删除此门课程");
				if(b){
					$http.get("/getLockInfo").then(function(data) {
						if(data.data.selectCourse==false){
							alert("选课已停止，请勿操作");
						}else{
							$http.post('/grade/delete/' + item.studentNum+'/'+item.courseNum)
							.then(function(data) {
							})	
						}
					})
				}
			}
			$scope.gradeList();
		
			
			$scope.ok = function() {
				$scope.gradeList();
			};
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		}
	])