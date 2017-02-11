app.controller('NewSeguroController', ['$scope', 'remoteResource', '$location', function ($scope, remoteResource, $location) {
        $scope.sexos = [{
                codSexo: 'H',
                descripcion: 'Hombre'
            }, {
                codSexo: 'M',
                descripcion: 'Mujer'
            }];

        $scope.seguro = {
            nif: "",
            nombre: "",
            ape1: "",
            edad: undefined,
            sexo: "",
            casado: false,
            numHijos: undefined,
            embarazada: false,
            coberturas: {
                oftalmologia: false,
                dental: false,
                fecundacionInVitro: false
            },
            enfermedades: {
                corazon: false,
                estomacal: false,
                rinyones: false,
                alergia: false,
                nombreAlergia: ""
            },
            fechaCreacion: new Date()
        };

        $scope.guardar = function () {
            if ($scope.form.$valid) {
                remoteResource.insert($scope.seguro).then(function () {
                    $location.path('/seguro/listado');
                }, function (bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            } else {
                alert('Hay datos invalidos');
            }
        };

    }]);

app.controller('EditSeguroController', ['$scope', 'seguro', 'remoteResource', '$location', function ($scope, seguro, remoteResource, $location) {
        $scope.filtro = {
            ape1: ""
        };

        $scope.sexos = [{
                codSexo: 'H',
                descripcion: 'Hombre'
            }, {
                codSexo: 'M',
                descripcion: 'Mujer'
            }];

        $scope.seguro = seguro;
        $scope.guardar = function () {
            if ($scope.form.$valid) {
                remoteResource.update($scope.seguro.idSeguro, $scope.seguro).then(function () {
                    $location.path('/seguro/listado');
                }, function (bussinessMessages) {
                    $scope.bussinessMessages = bussinessMessages;
                });
            } else {
                alert('Hay datos invalidos');
            }
        };
    }]);
