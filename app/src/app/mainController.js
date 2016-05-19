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

    $scope.images = [
      'http://placehold.it/350x150',
      'http://placehold.it/800x600',
      'http://placehold.it/200x200',
      'http://placehold.it/400x200',
      'http://placehold.it/400x400',
      'http://placehold.it/1000x400',
      'http://placehold.it/900x700'
    ];

  }

})();
