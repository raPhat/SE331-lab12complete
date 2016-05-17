(function() {
  'use strict'
  angular
    .module('app')
    .factory('mainService',mainService);



  /** @ngInject */
  function mainService($resource){
    return $resource('/user/:id', { id: '@_id' }, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }});

  }

})();
