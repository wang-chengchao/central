!function() {
    var ngModule = angular.module('tasklist.plugin.sample-plugin', []);
    ngModule.config([
        '$routeProvider', 'MenuProvider',
        function ($routeProvider, MenuProvider) {
            $routeProvider
                .when('/myworks', {
                    template: '我的插件'
                });

            MenuProvider.register({ header: '主菜单', url: '/myworks', name: '样例菜单', class: 'fa fa-star' });
        }
    ]);
}();
