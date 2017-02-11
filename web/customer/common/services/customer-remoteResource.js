function RemoteResourceCustomer($http, $q, baseUrl, $log) {
    this.list = function () {
        var defered = $q.defer();
        var promise = defered.promise;
        $http({
            method: 'GET',
             url: baseUrl + '/api/Customer'
            //url: 'http://localhost:8083/SpringRestFulSegMedOraB/api/Customer'
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo obtener los datos: ' + status + '\n' + data);
            }
        });
        return promise;
    };

    this.get = function (idCustomer) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/Customer/' + idCustomer
            //url: 'http://localhost:8083/SpringRestFulSegMedOraB/api/Customer/' + idCustomer
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo al obtener los datos: ' + status + '\n' + data);
            }
        });
        return promise;
    };

    this.delete = function (idCustomer) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/Customer/' + idCustomer
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo al elminiar registro: ' + status + '\n' + data);
            }
        });
        return promise;
    };

    this.update = function (idCustomer, customer) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http.put('http://localhost:8083/SGDEP/api/Customer/' + idCustomer,
                customer
                ).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo al actualizar registro: ' + status + "\n" + data);
            }
        });
        return promise;
    };

    this.insert = function (customer) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/Customer',
            data: customer
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo al insertar customer: ' + status + '\n' + data);
            }
        });
        return promise;
    };

    this.listCusDet = function (idCustomer) {
        var defered = $q.defer();
        var promise = defered.promise;
        $http({
            method: 'GET',
            url: baseUrl + '/api/Customer/' + idCustomer + '/CustomerDetail'
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error('Fallo obtener los datos: ' + status + '\n' + data);
            }
        });
        return promise;
    };
}

function RemoteResourceProviderCustomer() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };

    this.$get = ['$http', '$q', '$log', function ($http, $q, $log) {
            return new RemoteResourceCustomer($http, $q, _baseUrl, $log);
        }];
}

app.provider('remoteResourceCustomer', RemoteResourceProviderCustomer);
