/**
 * Created by Shine on 18/5/2559.
 */
(function() {
  'use strict';
  angular
    .module('app')
    .factory('dashboardService',dashboardService);



  /** @ngInject */
  function dashboardService($resource){
    return $resource('/user/:id', { id: '@_id' }, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }});

  }

})();
