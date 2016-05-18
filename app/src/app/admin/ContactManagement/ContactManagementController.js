/**
 * Created by Shine on 18/5/2559.
 */
/**
 * Created by Shine on 18/5/2559.
 */
(function () {
  angular
    .module('app')
    .controller('ContactManagementController', ContactManagementController);


  /** @ngInject */
  function ContactManagementController($scope, $rootScope,queryContactAdminService,ContactAdminService) {
    var vm = this;
    //$http.get("/product/").success(function (data) {
    vm.queryPromise = queryContactAdminService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
      vm.contacts = data;

      console.log(vm.contacts);
    }).$promise;

    $scope.$on('$locationChangeStart', function () {
      $rootScope.addSuccess = false;
      $rootScope.editSuccess = false;
      $rootScope.deleteSuccess = false;
    });
    vm.deleteArticle = function (id) {
      var answer = confirm("Do you want to delete the article ?");
      if (answer) {
        ContactAdminService.delete({id: id}, function () {
          $rootScope.deleteSuccess = true;
          $route.reload();
        })
      }
    };

    ContactAdminService.get({id: id},
      // success function
      function (data) {
        vm.contact = data;
      }
    );
    vm.editArticle = function () {
      //$http.put("/product", $scope.product).then(function () {
      queryContactAdminService.update({id: vm.contact.id}, vm.contact, function () {
        $rootScope.editSuccess = true;
        $location.path("listProduct");
      });
    }
  }

})();
