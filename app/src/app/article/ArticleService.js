(function () {
  'use strict';
  angular
    .module('app')
    .factory('ArticleService', ArticleService);

  /** @ngInject */
  function ArticleService($resource) {
    return $resource ('/user/:action', {},
      {
        authenticate: {
          method: 'POST',
          params: {'action': 'authenticate'},
          header: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
      })
  }

})();
