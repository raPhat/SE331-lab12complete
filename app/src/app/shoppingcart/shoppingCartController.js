(function () {
  'use strict';

  angular
    .module('app')
    .controller('shoppingCartController', ShoppingCartController);


  /** @ngInject */
  function ShoppingCartController(shoppingCartService,cartManagement,$scope, $rootScope, $cookies,$log, queryUserService, $timeout ) {
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
      console.log( vm.orders );
    });


    vm.updateCart = function () {
        $rootScope.cartUpdateSuccess = true;
    }

    vm.totalEach = function (index) {
      return vm.cart.selectedProducts[index].product.totalPrice * vm.cart.selectedProducts[index].amount;
    }

    vm.NewTotalEach = function (index) {
      return $rootScope.shoppingCart.selectedProducts[index].product.totalPrice * $rootScope.shoppingCart.selectedProducts[index].amount;
    };

    vm.saveCart = function (cart){

      var answer = confirm("Are you sure?");
      if (answer) {
        cart.user = {};
        cart.user.username = $rootScope.user.name;
        cartManagement.saveCart(cart,function(returnData){
          $rootScope.shoppingCart = {};
          cart = {};
          queryUserService.query({ id: $rootScope.user.name }, function(data) {
            vm.orders = data;
          });
          //success add cart
          $log.debug("save cart success");
        });
      }
    };

    vm.removeProduct = function(index){
      var answer = confirm("Do you want to remove the product?");
      if (answer) {
        $rootScope.shoppingCart.selectedProducts.splice(index, 1);
      }
    };


    vm.total = function () {
      var total = 0;
      angular.forEach(vm.cart.selectedProducts, function (item) {
        total += item.amount * item.product.totalPrice;
      })

      return total;
    }

    vm.getLength = function (order , num) {
      return order.progresses.length == num;
    }
  }
})();
