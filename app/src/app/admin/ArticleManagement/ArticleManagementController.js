/**
 * Created by Shine on 18/5/2559.
 */
(function () {
  angular
    .module('app')
    .controller('ArticleManagementController', ArticleManagementController);


  /** @ngInject */
  function ArticleManagementController($scope, $rootScope, queryArticleAdminService, ArticleAdminService,$routeParams) {
    var vm = this;
    //$http.get("/product/").success(function (data) {
    vm.queryPromise = queryArticleAdminService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
      vm.articles = data;

      console.log(vm.articles);
    }).$promise;

    $scope.$on('$locationChangeStart', function () {
      $rootScope.addSuccess = false;
      $rootScope.editSuccess = false;
      $rootScope.deleteSuccess = false;
    });
    vm.deleteArticle = function (id) {
      var answer = confirm("Do you want to delete the article ?");
      if (answer) {
        ArticleAdminService.delete({id: id}, function () {
          $rootScope.deleteSuccess = true;
          $route.reload();
        })
      }
    };


  }
})();
