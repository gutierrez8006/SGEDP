app.controller('ListadoSeguroController', ['$scope', 'seguros', 'remoteResource', function ($scope, seguros, remoteResource) {
        $scope.seguros = seguros;

        $scope.filtro = {
            ape1: ''
        };

        $scope.borrar = function (idSeguro) {
            remoteResource.delete(idSeguro).then(function () {
                remoteResource.list().then(function (seguros) {
                    $scope.seguros = seguros;
                }, function (bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            }, function (bussinessMessages) {
                $scope.bussinessMessages = bussinessMessages;
            });
        };

        $scope.closeAlert = function (index) {
            $scope.bussinessMessages.splice(index, 1);
        };

    }]);