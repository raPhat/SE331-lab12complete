/**
 * Created by Shine on 18/5/2559.
 */
(function () {
  'use strict'
  angular
    .module('app')
    .factory('ArticleAdminService', ArticleAdminService)
    .factory('queryArticleAdminService', queryArticleAdminService);


  /** @ngInject */
  function ArticleAdminService($resource) {
    return $resource('/article/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });
  }


  /** @ngInject */
  function queryArticleAdminService($resource) {
    return $resource('/article/:topic',
      {
        query: {method: 'GET', params: {topic: ''}, isArray: true}

      });
  }

})();
