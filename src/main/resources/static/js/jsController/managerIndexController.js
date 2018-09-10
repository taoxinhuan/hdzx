app.controller('managerIndexController', function($scope, $http, $location) {
	var storage = window.sessionStorage
	//反序列化json
	var manager = JSON.parse(storage.getItem("manager"));
	$scope.manager = manager;
	$http.get("/getLockInfo").then(function(data) {
		$scope.control = data.data;
	})

	$scope.controlSelect = function(b) {
		so = {
			id: "1",
			selectCourse: b
		}
		$http.post("/updateLockInfo", so).then(function(data) {
			$scope.control.selectCourse=b;
		})
	}
	$scope.controlInputGrade = function(b) {
		io = {
			id: "1",
			inputGrade: b
		}
		$http.post("/updateLockInfo", io).then(function(data) {
			$scope.control.inputGrade=b;
		})
	}

});