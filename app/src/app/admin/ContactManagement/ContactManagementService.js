/**
 * Created by Shine on 18/5/2559.
 */
(function() {
  'use strict'
  angular
    .module('app')
    .factory('ContactManagementService',ContactManagementService);



  /** @ngInject */
  function ContactManagementService($resource){
    return $resource('/contact/:id', { id: '@_id' }, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }});

  }

})();
