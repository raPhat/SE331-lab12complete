/**
 * Created by Shine on 18/5/2559.
 */
(function () {
  angular
    .module('app')
    .controller('ProductManagementController', ProductManagementController)
    .controller('addProductAdminController', addProductAdminController)
    .controller('listProductAdminController', listProductAdminController)
    .controller('editProductAdminController', editProductAdminController);

  /** @ngInject */
  function ProductManagementController($scope, $rootScope, $window) {
    var vm = this;

    vm.redirectToReload = function () {
      $window.location.reload();
    }
  }

  /** @ngInject */
  function addProductAdminController($scope, $location, $rootScope, productService, $timeout,$window) {
    $scope.product = {};
    $scope.addProduct = function (flowFiles) {
      $scope.product.descriptionTh = escape($scope.product.descriptionTh);
      $scope.product.nameTh = escape($scope.product.nameTh);
      productService.save($scope.product, function (data) {

        // after adding the object, add a new picture
        // get the product id which the image will be addded

        var productid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {productid: productid};
        flowFiles.upload();
        $timeout(function () {
          // $message is the json response from the post
        });

      });
    };

    $scope.redirectToHome = function () {
      $rootScope.addSuccess = true;
      $window.location.reload();
    }

  }


  /** @ngInject */
  function listProductAdminController($scope, $location, $rootScope, productService, $route, queryProductService, cartManagement) {
    var vm = this;

    vm.pageSet = 0;
    vm.pageNumber = 0;
    vm.groupPage = 5;
    vm.Math = window.Math;
    $rootScope.currentProduct = {};

    vm.editProduct = function (id) {

      productService.get({id: id},
        // success function
        function (data) {
          data.descriptionTh = unescape(data.descriptionTh);
          data.nameTh = unescape(data.nameTh);
          $rootScope.currentProduct = data;
        }
      );
    };

    //$http.get("/product/").success(function (data) {
    vm.queryPromise = productService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
      vm.products = data;
    }).$promise;
    $scope.$on('$locationChangeStart', function () {
      $rootScope.addSuccess = false;
      $rootScope.editSuccess = false;
      $rootScope.deleteSuccess = false;
    });

    vm.getNoPage = function () {
      var sum = 0;
      if (vm.products !== undefined) {
        sum = vm.Math.ceil(vm.products.length / vm.groupPage);
      }
      return new Array(sum);
    };

    vm.deleteProduct = function (id) {
      var answer = confirm("Do you want to delete the product?");
      if (answer) {
        productService.delete({id: id}, function () {
          $rootScope.deleteSuccess = true;
          $route.reload();
        })
      }
    };

    vm.searchProduct = function (name) {
      queryProductService.query({name: name}, function (data) {
        vm.products = data;
      });
    };

    vm.addToCart = function (product) {

      var answer = confirm("Do you want to add the product to cart?");
      if (answer) {
        console.log($rootScope.shoppingCart);
        cartManagement.addToCart({id: product.id}, $rootScope.shoppingCart, function (shoppingCart) {
          //success event
          $rootScope.shoppingCart = shoppingCart;

        }, function () {
          // fail event
        })
      }

    };
    vm.removeProduct = function (index) {
      $rootScope.shoppingCart.selectedProducts.splice(index, 1);
    }


  }


  /** @ngInject */
  function editProductAdminController($scope, productImageService, $rootScope, productService,$timeout) {

    $scope.editProduct = function (flowFiles) {
      var product = $rootScope.currentProduct;
      product.descriptionTh = escape(product.descriptionTh);
      product.nameTh = escape(product.nameTh);
      productService.update({id: product.id}, product, function (data) {
        var productid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {productid: productid};
        flowFiles.upload();
        $timeout(function () {
          // $message is the json response from the post
        });
      });
    };

    $scope.deleteImg = function (id) {
      var answer = confirm("Do you want to delete the image?");
      if (answer) {
        productImageService.delete({id: id, pid:$rootScope.currentProduct.id}, function (data) {
          console.log(data);
          $rootScope.currentProduct = data;
        })
      }
    }


  }


})();

