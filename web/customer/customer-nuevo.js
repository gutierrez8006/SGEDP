app.controller('NewCustomerController', ['$scope', 'remoteResourceCustomer', '$location', '$window', function ($scope, remoteResourceCustomer, $location, $window) {
        var $ctrlNewCust = this;

        $ctrlNewCust.customer = {
            name: ""
        };

        $ctrlNewCust.guardar = function () {
            if ($scope.formNuevo.$valid) {
                remoteResourceCustomer.insert($ctrlNewCust.customer).then(function () {
                    $window.alert('Datos insertados satisfactoriamente');
                    $location.path('/customer/listado');
                }, function (bussinessMessages) {
                    $ctrlNewCust.bussinessMessages = bussinessMessages;
                });
            }
        };
        $scope.closeAlert = function (index) {
            $ctrlNewCust.bussinessMessages.splice(index, 1);
        };
    }]);
