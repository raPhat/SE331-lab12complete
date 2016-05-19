(function () {
  'use strict'
  angular
    .module('app')
    .factory('shoppingCartService', shoppingCartService)
    .factory('cartManagement', cartManagement);

  /** @ngInject */
  function shoppingCartService($resource) {
    return $resource('http://localhost:8080/shoppingcart/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });

  }

  /** @ngInject */
  function cartManagement($resource) {
    return $resource('/shoppingcart/:action/:id', {id:'@_id'}, {
      addToCart: {
        method: 'POST',
        params: {'action': 'addToCart', id: '@_id'}
      },
      addToCartNew: {
        method: 'POST',
        params: {'action': 'addToCartNew', id: '@id'}
      },
      saveCart:{
        method: 'POST',
        params: {'action' : 'saveCart'}
      },
      progresses:{
        method: 'GET',
        params: {'action' : 'progress'},
        isArray: true
      }
    })
  }
})();
