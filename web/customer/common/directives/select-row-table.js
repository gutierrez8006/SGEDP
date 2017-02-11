app.directive('selRowTbl', ['$log', function ($log) {
        return {
            restrict: 'A',
            transclude: false,
            scope: {
                selectedRow: '='
            },
            link: function (scope, iElement, attrs) {
                iElement.bind('click', function () {
                    //$log.info(attrs.index);
//                    $log.info((JSON.parse(attrs.index)).seltr);
                    scope.$apply(function () {
                        scope.selectedRow = JSON.parse(attrs.index);
                    });
                });
            }
        };
    }]);