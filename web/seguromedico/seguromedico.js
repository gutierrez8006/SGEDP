app.config(['baseUrl', 'remoteResourceProvider', function (baseUrl, remoteResourceProvider) {
        remoteResourceProvider.setBaseUrl(baseUrl);
    }]);