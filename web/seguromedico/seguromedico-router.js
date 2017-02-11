app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/seguro/listado', {
            templateUrl: 'seguromedico/seguromedico-listado.html',
            controller: 'ListadoSeguroController',
            resolve: {
                seguros: ['remoteResource', function (remoteResource) {
                        return remoteResource.list();
                    }]
            }
        });

        $routeProvider.when('/seguro/edit/:idSeguro', {
            templateUrl: 'seguromedico/seguromedico-detalle.html',
            controller: 'EditSeguroController',
            resolve: {
                seguro: ['remoteResource', '$route', function (remoteResource, $route) {
                        return remoteResource.get($route.current.params.idSeguro);
                    }]
            }
        });

        $routeProvider.when('/seguro/new', {
            templateUrl: 'seguromedico/seguromedico-detalle.html',
            controller: 'NewSeguroController'
        });
    }]);

