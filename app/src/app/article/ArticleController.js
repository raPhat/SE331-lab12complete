(function () {
  angular
    .module('app')
    .controller('ArticleController', ArticleController);

  /** @ngInject */
  function ArticleController($scope, $rootScope) {
    var vm = this;
  }

})();
