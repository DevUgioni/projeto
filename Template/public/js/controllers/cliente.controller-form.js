(function () {
    "use strict";

    angular
        .module("MyApp")
        .controller("ClienteFormController", ClienteFormController);

        ClienteFormController.$inject = [
        "ClienteService",
        "$location",
        "$routeParams",
        "$scope",
    ];

    function ClienteFormController(
        ClienteService,
        $location,
        $routeParams
    ) {
        var vm = this;
        vm.cadastro = {};
        vm.titulo = "Novo Cliente";
        vm.item = null;
        vm.salvar = salvar;
        vm.select = select;

        activate();

        function activate() {
            if ($routeParams.id) {
                ClienteService.findById($routeParams.id).success(function (data) {
                    vm.cadastro = data;
                    vm.titulo = "Editando Cliente";
                });
            }
        }

        function salvar() {
            ClienteService.save(vm.cadastro).success(function () {
                $location.path("/clientes");             
                message('sucesso','Cliente realizado com sucesso!');
            }).error(function (erro) {
                let msg = erro;
                if(msg.erro){
                    message('erro',msg.erro);
                }else{
                    message('erro',JSON.stringify(erro));
                }
                
            });
        }

        function select(valor){
            return '"'+valor+'"';
        }

        function message(tipo, mensagem) {
            let text = "";
            if (tipo === 'info') {
                tipo = 'alert alert-info';
                text = 'Informação!';
            }
            if (tipo === 'sucesso') {
                tipo = 'alert alert-success';
                text = 'Sucesso!';
            }
            if (tipo === 'erro') {
                tipo = 'alert alert-danger';
                text = 'Erro!';
            }
            let message = '<div id="alerta" class="' + tipo + '" id="bsalert">';
                message += '    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> ';
                message += '    <strong>' + text + '</strong> ' + mensagem + '  ';
                message += ' </div> ';
            $("#divPrincipal").append(message);

            setTimeout(function(){ 
                $("#alerta").alert('close');
            }, 3000);
    }

    }
})();