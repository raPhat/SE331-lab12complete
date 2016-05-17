(function () {
  'use strict'
  angular
    .module('app')
    .factory('UserService', UserService)
    .factory('queryUserService', queryUserService);

  /** @ngInject */
  function UserService($resource) {
    return $resource('/user/:action', {},
      {
        authenticate: {
          method: 'POST',
          params: {'action': 'authenticate'},
          header: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
      })
  }


  /** @ngInject */
  function queryUserService($resource){
    return $resource('/user/find/:id', {},{
      'query': {method: 'GET', isArray: true }
    });
  }


})();
