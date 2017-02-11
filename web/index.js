app.controller('MainController', ['$scope', '$log', function ($scope, $log) {
        $scope.toggled = function (open) {
            $log.log('Dropdown is now: ', open);
        };
    }]);



