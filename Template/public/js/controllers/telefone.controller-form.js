(function () {
    "use strict";

    angular
        .module("MyApp")
        .controller("TelefoneFormController", TelefoneFormController);

        TelefoneFormController.$inject = [
        "TelefoneService",
        "$location",
        "$routeParams",
        "$scope",
    ];

    function TelefoneFormController(
        TelefoneService,
        $location,
        $routeParams
    ) {
        var vm = this;
        vm.cadastro = {};
        vm.titulo = "Adicionar Número de Telefone";
        vm.item = null;
        vm.salvar = salvar;

        activate();

        function activate() {
            if ($routeParams.id) {
                TelefoneService.findById($routeParams.id).success(function (data) {
                    vm.cadastro = data;
                    vm.titulo = "Editando Número de Telefone";
                });
            }
        }

        function salvar() {
            TelefoneService.save(vm.cadastro).success(function () {
                $location.path("/telefones");
                //alert("sucesso!!");
                message('sucesso','Telefone cadastrado com sucesso!');
            }).error(function (erro) {
                //alert(JSON.stringify(erro));
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

    $(document).ready(function(){
        $('#birth-date').mask('00/00/0000');
        $('#numero').mask('(00) 00000-0000');
      });

    }
})();