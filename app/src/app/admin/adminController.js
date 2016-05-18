/**
 * Created by Bitee on 4/20/2016.
 */
(function () {
  angular
    .module('app')
    .controller('AdminController', AdminController)
    .controller('ChartCtrl', ChartCtrl);

  /** @ngInject */
  function AdminController($scope, $rootScope) {
    var vm = this;
  }

  /** @ngInject */
  function ChartCtrl($scope, $timeout) {
    $scope.line = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      series: ['Income'],
      data: [
        [40, 59, 80, 81, 56, 55, 70]
      ],
      onClick: function (points, evt) {
        console.log(points, evt);
      }
    };

    $scope.bar = {
      labels: ['2006', '2007', '2008', '2009', '2010', '2011', '2012'],
      series: ['Series A', 'Series B'],

      data: [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
      ]

    };

    $scope.donut = {
      labels: ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
      data: [300, 500, 100]
    };

    $scope.radar = {
      labels:["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],

      data:[
        [65, 59, 90, 81, 56, 55, 40],
        [28, 48, 40, 19, 96, 27, 100]
      ]
    };

    $scope.pie = {
      labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales"],
      data : [300, 500, 100]
    };

    $scope.polar = {
      labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
      data : [300, 500, 100, 40, 120]
    };

    $scope.dynamic = {
      labels : ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales"],
      data : [300, 500, 100, 40, 120],
      type : 'PolarArea',

      toggle : function ()
      {
        this.type = this.type === 'PolarArea' ?
          'Pie' : 'PolarArea';
      }
    };
  }

})();
