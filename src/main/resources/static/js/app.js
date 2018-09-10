var app = angular.module('app', ["ng","ui.router","ui.bootstrap","toastr"]);
app.directive('pageContent', [function () {
    return {
        restrict: 'AE',
        replace: true,
        transclude: true,
        templateUrl: "/pageContent.html"
    };
}]);

/**
 *页面搜索框
 **/
app.directive('pageSearch', [function () {
    return {
        restrict: 'AE',
        replace: true,
        transclude: true,
        templateUrl: "/pageSearch.html",
    };
}]);

app.service('myAlert', ['$modal', '$http', 'toastr', function ($modal, $http, toastr) {
    /*消息提示模式窗口*/
    this.show = function (config) {
        var DEFAULT = {
            templateUrl: '/popupMessage.html',
            controller: function ($scope, $modalInstance, items) {
                $scope.results = items;
                // 确认按钮
                $scope.ok = function () {
                    $modalInstance.close();
                };
                // 取消按钮
                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };
            },
            size: 'sm',
            title: '提示消息',
            msg: ''
        };
        var cfg = (Object.prototype.toString.call(config) === "[object String]") ? $.extend(DEFAULT, {msg: config}) : $.extend(DEFAULT, config);

        //创建弹框对象
        var modalInstance = $modal.open({
            templateUrl: cfg.templateUrl,
            controller: cfg.controller,
            size: cfg.size,
            resolve: {
                items: function () {
                    return {title: cfg.title, msg: cfg.msg};
                }
            }
        });
        return modalInstance;
    };
    /* 消息确认窗口 */
    this.confirm = function (config){
    	var DEFAULT = {
    			templateUrl:'/popupConfirmMessage.html',
    			controller:function($scope, $modalInstance, items){
    				$scope.results = items;
    				// 确认按钮
    				$scope.ok = function() {
    					$modalInstance.close();
    				}; 
    				// 取消按钮
    				$scope.cancel = function() {
    					$modalInstance.dismiss('cancel');
    				};
    			},
    			size:'sm',
    			title:'确认消息',
    			msg:''
    	}
    	var cfg = (Object.prototype.toString.call(config) === "[object String]") ? $.extend(DEFAULT, {msg:config}) : $.extend(DEFAULT, config);
    	//创建弹框对象
        var modalInstance = $modal.open({
            templateUrl: cfg.templateUrl,
            controller: cfg.controller,
            size: cfg.size,
            resolve: {
            	items: function() {
                    return {title:cfg.title,msg:cfg.msg};
                }
            }
        });
        return modalInstance;
    }
}]);
