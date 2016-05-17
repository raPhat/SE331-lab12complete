(function () {
  angular
    .module('app')
    .controller('MainController', MainController);

  /** @ngInject */
  function MainController($scope, $rootScope, mainService) {
    $scope.addRetailUser = function () {
      mainService.save($scope.newuser, function (data) {
        console.log(data);
      });
    }
  }

})();
