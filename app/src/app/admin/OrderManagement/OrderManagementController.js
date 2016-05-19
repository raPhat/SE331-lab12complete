/**
 * Created by Shine on 18/5/2559.
 */
(function () {
  angular
    .module('app')
    .controller('OrderManagementController', OrderManagementController);


  /** @ngInject */
  function OrderManagementController($scope, $rootScope, OrderManagementService) {
    var vm = this;
    vm.progresses = [];

    OrderManagementService.progress(function(data){
      vm.progresses = data;
      console.log( vm.progresses );
    });
  }

})();
