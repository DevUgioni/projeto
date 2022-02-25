(function() {
    "use strict";

    angular.module("MyApp").controller("HomeController", HomeController);

    HomeController.$inject = ["$rootScope", "$location", "$window"];

    function HomeController($rootScope, $location, $window) {
        var vm = this;
        var itemSelecionado = -1;

        vm.isAdministrador = isAdministrador;

        vm.clientesPage = clientesPage;
        vm.telefonesPage = telefonesPage;
        vm.enderecosPage = enderecosPage;

        activate();

        function activate() {
        }

        function isAdministrador (){
            return $window.localStorage.administrador;
        };

        function clientesPage() {
            $location.path("/clientes");
        }

        function telefonesPage() {
            $location.path("/telefones");
        }

        function enderecosPage() {
            $location.path("/enderecos");
        }
    }
})();