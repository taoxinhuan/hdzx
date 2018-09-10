app.controller('loginController', function($scope, $http, $location,myAlert) {
	$scope.vo = {};
	$scope.login = function() {
		 if($scope.vo.permission == ""||$scope.vo.permission == null) {
			myAlert.show("请选择身份");
		}else if($scope.vo.permission == 1) {
			$http.get("/studentLogin/" + $scope.vo.account + "/" + $scope.vo.password)
				.then(function(data) {
					if(data.data != "") {
						var storage = window.sessionStorage
						//序列化json对象
						storage.setItem("student", JSON.stringify(data.data));
						window.location = "views/student/index.html";
					} else {
						myAlert.show("账号或密码错误");
					}
				});
		} else if($scope.vo.permission == 2) {
			$http.get("/teacherLogin/" + $scope.vo.account + "/" + $scope.vo.password)
				.then(function(data) {
					if(data.data != "") {
						var storage = window.sessionStorage
						//序列化json对象
						storage.setItem("teacher", JSON.stringify(data.data));
						window.location = "views/teacher/index.html";
					} else {
						myAlert.show("账号或密码错误");
					}
				});
		} else if($scope.vo.permission == 3) {
			$http.get("/managerLogin/" + $scope.vo.account + "/" + $scope.vo.password)
				.then(function(data) {
					if(data.data != "") {
						var storage = window.sessionStorage
						//序列化json对象
						storage.setItem("manager", JSON.stringify(data.data));
						window.location = "views/manager/index.html";
					} else {
						myAlert.show("账号或密码错误");
					}
				});
		} 
	}
});