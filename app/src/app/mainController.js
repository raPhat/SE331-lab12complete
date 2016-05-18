(function () {
  angular
    .module('app')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($scope, $rootScope, mainService, productService) {
    $scope.addRetailUser = function () {
      mainService.save($scope.newuser, function (data) {
        console.log(data);
      });
    };

    $scope.removeProduct = function(index){
      var answer = confirm("Do you want to remove the product?");
      if (answer) {
        //productService.delete({id: index}, function () {
        //})
        $rootScope.shoppingCart.selectedProducts.splice(index, 1);
      }
    }

  }

})();
