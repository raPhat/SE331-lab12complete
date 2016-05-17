(function () {
  'use strict';

  angular
    .module('app')
    .controller('shoppingCartController', ShoppingCartController);


  /** @ngInject */
  function ShoppingCartController(shoppingCartService,cartManagement,$scope, $rootScope, $cookies,$log, queryUserService, $http ) {
    var vm = this;

    var user = $cookies.get('user');


    if ($rootScope.shoppingCart != null){
      vm.cart = $rootScope.shoppingCart;
    }

    $scope.$on('$locationChangeStart', function () {
      $rootScope.cartUpdateSuccess = false;

    });


    queryUserService.query({ id: user }, function(data) {
      vm.orders = data;
      console.log(vm.orders);
    });



    vm.updateCart = function () {
        $rootScope.cartUpdateSuccess = true;
    }

    vm.totalEach = function (index) {
      return vm.cart.selectedProducts[index].product.totalPrice * vm.cart.selectedProducts[index].amount;
    }

    vm.NewTotalEach = function (index) {
      console.log(1);
      return $rootScope.shoppingCart.selectedProducts[index].product.totalPrice * $rootScope.shoppingCart.selectedProducts[index].amount;
    };

    vm.saveCart = function (cart){
      console.log(cart);
      cart.user = {};
      cart.user.username = $rootScope.user.name;
      cartManagement.saveCart(cart,function(returnData){
        $rootScope.shoppingCart = returnData;
        //success add cart
        $log.debug("save cart success");
      })
    }


    vm.total = function () {
      var total = 0;
      angular.forEach(vm.cart.selectedProducts, function (item) {
        total += item.amount * item.product.totalPrice;
      })

      return total;
    }


  }
})();
