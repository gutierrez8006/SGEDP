app.constant('baseUrl', '.');

app.run(['$rootScope', 'urlLogo', function ($rootScope, urlLogo) {
        $rootScope.urlLogo = urlLogo;
    }]);

app.value('urlLogo', 'http://www.cursoangularjs.es/lib/exe/fetch.php?cache=&media=unidades:04_masdirectivas:medical14.png');
