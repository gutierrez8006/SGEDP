app.controller('DelCustomerController', ['$scope', '$uibModalInstance', 'remoteResourceCustomer', 'idCustomer', function ($scope, $uibModalInstance, remoteResourceCustomer, idCustomer) {
        var $ctrlDelCust = this;

        $ctrlDelCust.ok = function () {
            remoteResourceCustomer.delete(idCustomer).then(function () {
                remoteResourceCustomer.list().then(function (customers) {
                    $ctrlDelCust.customers = {nombre: 'customers', customers: customers, yn: 'y'};
                    $uibModalInstance.close($ctrlDelCust.customers);
                }, function (bussinessMessages) {
                    $ctrlDelCust.bussinessMessages = {nombre: 'bussinessMessages', bussinessMessages: bussinessMessages, yn: 'y'};
                    $uibModalInstance.close($ctrlDelCust.bussinessMessages);
                });
            }, function (bussinessMessages) {
                $ctrlDelCust.bussinessMessages = {nombre: 'bussinessMessages', bussinessMessages: bussinessMessages, yn: 'n'};
                $uibModalInstance.close($ctrlDelCust.bussinessMessages);

            });

        };

        $ctrlDelCust.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    }]);