angular
    .module("MyApp", ["ngRoute", "satellizer"])
    .config(function($routeProvider, $locationProvider, $authProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when("/", {
                templateUrl: "partials/login.html",
                controller:"LoginCtrl"
            })
            .when("/login", {
                templateUrl: "partials/login.html",
                controller:"LoginCtrl"
            })
            .when("/home", {
                templateUrl: "partials/home.html",
            })

            .when("/clientes", {
                templateUrl: "partials/cliente.html",
            })
            .when("/clientes/:id", {
                templateUrl: "partials/cliente-form.html",
            })
            .when("/clientes/new", {
                templateUrl: "partials/cliente-form.html",
            })

            .when("/telefones", {
                templateUrl: "partials/telefone.html",
            })
            .when("/telefones/:id", {
                templateUrl: "partials/telefone-form.html",
            })
            .when("/telefones/new", {
                templateUrl: "partials/telefone-form.html",
            })
            
            .when("/enderecos", {
                templateUrl: "partials/endereco.html",
            })
            .when("/enderecos/:id", {
                templateUrl: "partials/endereco-form.html",
            })
            .when("/enderecos/new", {
                templateUrl: "partials/endereco-form.html",
            })

            .otherwise({
                templateUrl: "partials/404.html",
            });
    })
    .run(function($rootScope, $window) {
        
    })
    .directive("ngConfirmClick", [
        function() {
            return {
                link: function(scope, element, attr) {
                    var msg = attr.ngConfirmClick || "Are you sure?";
                    var clickAction = attr.confirmedClick;
                    element.bind("click", function(event) {
                        if (window.confirm(msg)) {
                            scope.$eval(clickAction);
                        }
                    });
                },
            };
        },
    ]);