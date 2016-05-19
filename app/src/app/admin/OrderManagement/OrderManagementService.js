/**
 * Created by Shine on 18/5/2559.
 */
(function() {
  'use strict'
  angular
    .module('app')
    .factory('OrderManagementService',OrderManagementService);



  /** @ngInject */
  function OrderManagementService($resource){
    return $resource('/shoppingcart/:action/:id:name', { id: '@_id' }, {
      progress: {
        method: 'GET',
        params:{
          action:'progress'
        },
        isArray: true
      }
    });

  }

})();

