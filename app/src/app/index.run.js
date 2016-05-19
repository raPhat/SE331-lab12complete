(function () {
  'use strict';

  angular
    .module('app')
    .run(runBlock)
    .run(runSecurity);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

  /** @ngInject */
  function runSecurity($rootScope, $location, $cookies, UserService,$window,$translate) {
    var removeErrorMsg = $rootScope.$on('$viewContentLoaded', function () {
      delete $rootScope.error;
    });
    removeErrorMsg();

    $rootScope.hasRole = function (role) {
      if ($rootScope.user == undefined) {
        return false;
      }

      if ($rootScope.user.roles[role] == undefined) {
        return false;
      }

      return $rootScope.user.roles[role];
    }

    $rootScope.logout = function () {
      delete $rootScope.user;
      delete $rootScope.authToken;
      $cookies.remove('authToken');
      $cookies.remove('user');
      $location.path("/")

      // remove shopping Cart
      $rootScope.shoppingCart = {};
    }

    /* Try getting valid user from cookie or go to login page */
    var originalPath = $location.path();
    //$location.path("/listProduct");
    var authToken = $cookies.get('authToken');
    if (authToken != undefined) {
      $rootScope.authToken = authToken;
      UserService.get(function (user) {
        $rootScope.user = user;
        $cookies.put('user', user.name);
        $location.path(originalPath);

        $rootScope.checkAdmin();

      })
    } else {
      var sp = $location.path().split('/');
      if ( sp.length > 1 )  {
        if( sp[1] == 'admin' ) {
          $window.location.href = '/';
        }
      }
    }

    $rootScope.initialized = true;
    $rootScope.shoppingCart = {};
    $rootScope.$on('$routeChangeStart', function (event, next, current) {
      if( $rootScope.user !== undefined ) {
        $rootScope.checkAdmin();
      }
    });

    $rootScope.checkAdmin = function() {
      var sp = $location.path().split('/');
      if ( sp.length > 1 )  {
        if( sp[1] == 'admin' && !$rootScope.hasRole( "admin" ) ) {
          $window.location.href = '/';
        }
      }
    }
    $rootScope.checkUser = function() {
      if( !$rootScope.hasRole( "retail" ) && !$rootScope.hasRole( "wholesale" ) ) {
        $window.location.href = '/';
      }
    }

    $rootScope.checkLocale = function( lang ) {
      if( $translate.use() === lang ) {
        return true;
      } else {
        return false;
      }
    };
  }



})();
