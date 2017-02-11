app.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/customer/listado', {
        templateUrl: 'customer/customer-listado.html',
        controller: 'ListCustomerController',
        controllerAs: '$ctrlListCust',
        resolve: {
            customers: ['remoteResourceCustomer', function(remoteResourceCustomer){
                    return remoteResourceCustomer.list();
            }]
        }
    });
    
    $routeProvider.when('/customer/new', {
        templateUrl: 'customer/customer-nuevo.html',
        controller: 'NewCustomerController',
        controllerAs: '$ctrlNewCust'
    });
}]);
