(function() {
  'use strict';

  angular
    .module('app')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'app/home/home.html',
        controller: 'HomeController',
        controllerAs: 'vm'
      }).
      when('/article', {
        templateUrl: 'app/article/article.html',
        controller: 'ArticleController',
        controllerAs: 'vm'
      }).
      when('/product', {
        templateUrl: 'app/product/products.html',
        controller: 'listProductController',
        controllerAs: 'vm'
      }).
      when('/addProduct', {
        templateUrl: 'app/product/editProduct.html',
        controller: 'addProductController',
        controllerAs: 'vm'
      }).
      when('/editProduct/:id', {
        templateUrl: 'app/product/editProduct.html',
        controller: 'editProductController',
        controllerAs: 'vm'
      }).
      when('/listProduct', {
        templateUrl: 'app/product/productList.html',
        controller: 'listProductController',
        controllerAs: 'vm'
      }).
      when('/shoppingCart/:id', {
        templateUrl: 'app/shoppingcart/shoppingCart.html',
        controller: 'showShoppingCartController',
        controllerAs: 'vm'
      }).
      when('/shoppingCart', {
        templateUrl: 'app/shoppingcart/shoppingCart.html',
        controller: 'shoppingCartController',
        controllerAs: 'vm'
      }).
      when('/admin/', {
        templateUrl: 'app/admin/dashboard/dashboard.html',
        controller: 'AdminController',
        controllerAs: 'vm'
      }).
      when('/admin/ProductManagement', {
        templateUrl: 'app/admin/ProductManagement/ProductManagement.html',
        controller: 'listProductAdminController',
        controllerAs: 'vm'
      }).
      when('/admin/MemberManagement', {
        templateUrl: 'app/admin/MemberManagement/MemberManagement.html',
        controller: 'AdminController',
        controllerAs: 'vm'
      }).
      when('/admin/OrderManagement', {
        templateUrl: 'app/admin/OrderManagement/OrderManagement.html',
        controller: 'OrderManagementController',
        controllerAs: 'vm'
      }).
      when('/admin/ArticleManagement', {
        templateUrl: 'app/admin/ArticleManagement/ArticleManagement.html',
        controller: 'ArticleManagementController',
        controllerAs: 'vm'
      }).
      when('/admin/ContactManagement', {
        templateUrl: 'app/admin/ContactManagement/ContactManagement.html',
        controller: 'AdminController',
        controllerAs: 'vm'
     }).
      when('/admin/PaymentManagement', {
        templateUrl: 'app/admin/PaymentManagement/PaymentManagement.html',
        controller: 'AdminController',
        controllerAs: 'vm'
     }).
      when('/admin/StatisticManagement', {
        templateUrl: 'app/admin/dashboard/dashboard.html',
        controller: 'AdminController',
        controllerAs: 'vm'
     }).
      otherwise({redirectTo: '/'});

  }

})();
