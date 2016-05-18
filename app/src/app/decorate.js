(function(){
  'use strict';

  var API_PREFIX = 'http://192.168.1.8:8080';
  /** @ngInject */
  angular.module('ngResource+apiPrefix', [
    'ngResource'
  ]).decorate('$resource', function ($delegate) {

    return function decoratedResource() {
      arguments[0] = API_PREFIX + arguments[0];
      return $delegate.apply(this, arguments);
    };

  });
})();
