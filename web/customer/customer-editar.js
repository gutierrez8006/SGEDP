app.controller('EditCustomerController', ['$scope', '$uibModalInstance', 'customer', 'remoteResourceCustomer', '$log', function ($scope, $uibModalInstance, customer, remoteResourceCustomer, $log) {
        var $ctrlEditCust = this;

        $ctrlEditCust.customer = customer;

        $ctrlEditCust.guardar = function () {
            if ($scope.formEditar.$valid) {
                remoteResourceCustomer.update($ctrlEditCust.customer.idCustomer, $ctrlEditCust.customer).then(function () {
                    remoteResourceCustomer.list().then(function (customers) {
                        $ctrlEditCust.customers = {nombre: 'customers', customers: customers, yn: 'y'};
                        $uibModalInstance.close($ctrlEditCust.customers);
                    }, function (bussinessMessages) {
                        $ctrlEditCust.bussinessMessages = {nombre: 'bussinessMessages', bussinessMessages: bussinessMessages, yn: 'y'};
                        $uibModalInstance.close($ctrlEditCust.bussinessMessages);
                    });
                }, function (bussinessMessages) {
                    $ctrlEditCust.bussinessMessages = {nombre: 'bussinessMessages', bussinessMessages: bussinessMessages, yn: 'n'};
                    $uibModalInstance.close($ctrlEditCust.bussinessMessages);
                });
            }
        };

        $ctrlEditCust.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };

        $ctrlEditCust.prueba = function () {
            $log.info($scope.formEditar.$valid);
        };
    }]);