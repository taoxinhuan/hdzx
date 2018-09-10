app.controller('selectCourseController',
	function($scope, $http, $location, $modal,myAlert) {

		var storage = window.sessionStorage
		//反序列化json
		var student = JSON.parse(storage.getItem("student"));
		
		if(student==null){
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
			pageIndex: 1
		};
		$scope.so.deptNum=student.deptNum;
		$http.post("/teacher/list", $scope.so).then(function(data) {
			$scope.vm.teachers = data.data.dataList;
		})
		$scope.getCourseList = function() {
			$scope.vo.pageIndex = vm.pages.pageIndex;
			$scope.vo.pageSize = vm.pages.pageSize;
			$scope.vo.deptNum=student.deptNum;
			$http.post("/course/listForStudent", $scope.vo).then(function(data) {
				$scope.vm.items = data.data.dataList;
				$scope.vm.pages.totalResult = data.data.pager.recordCount;
				$scope.vm.pages.totalPage = data.data.pager.totalPage;
			})
		}
		
		$scope.add=function(courseNum,teacherNum){
			var grade={
				courseNum:courseNum,
				teacherNum:teacherNum,
				studentNum:student.studentNum
			};
			
			$http.post("/grade/get/"+grade.studentNum+"/"+grade.courseNum).then(function(data) {
				if(data.data.studentNum!=null){
					myAlert.show("不能重复操作");
				}else{
					myAlert.confirm("是否确认选择此门课程").result.then(function(){
						$http.post("/grade/add", grade).then(function(data) {
							myAlert.show("选择成功");
						})
                    });
				}
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
	})