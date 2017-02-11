app.directive('caDatepicker', [function (dateFormat) {
        return {
            restrict: 'A',
            link: function ($scope, element, attributes) {
                element.datepicker({
                    dateFormat: attributes.caDatepicker,
                    onSelect: function () {
                        $(this).trigger('change');
                    }
                });
            }
        };
    }]);