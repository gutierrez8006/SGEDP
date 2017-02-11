function RemoteResource($http, $q, baseUrl) {
    this.get = function (idSeguro) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro
                    //            url: 'http://localhost:8084/SpringRestFulB/api/SeguroMedico/' + idSeguro
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
    this.list = function () {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/SeguroMedico'
                    //            url: 'http://localhost:8084/SpringRestFulB/api/SeguroMedico'
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

    this.insert = function (seguroMedico) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/SeguroMedico',
            data: seguroMedico
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.update = function (idSeguro, seguroMedico) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro,
            data: seguroMedico
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.delete = function (idSeguro) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/SeguroMedico/' + idSeguro
        }).success(function (data, status, headers, config) {
            defered.resolve(data);
        }).error(function (data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

}

function RemoteResourceProvider() {
    var _baseUrl;
    this.setBaseUrl = function (baseUrl) {
        _baseUrl = baseUrl;
    };
    // Factory Provider
    this.$get = ['$http', '$q', function ($http, $q) {
            return new RemoteResource($http, $q, _baseUrl);
        }];
}

app.provider('remoteResource', RemoteResourceProvider);