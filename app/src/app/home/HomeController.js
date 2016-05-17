/**
 * Created by Bitee on 4/20/2016.
 */
(function () {
  angular
    .module('app')
    .controller('HomeController', HomeController);

  /** @ngInject */
  function HomeController($scope, $rootScope) {
    var vm = this;
    vm.myInterval = 8000;
    vm.slides = [
      {
        image: 'http://wallpaper.thaiware.com/upload/wallpaper/2009_08/16405_7349_090813162558_41.jpg'
      },
      {
        image: 'http://f.ptcdn.info/183/007/000/1373684879-0001-o.jpg'
      }
    ];
    vm.reviews = [
      {
        image: 'http://wallpaper.thaiware.com/upload/wallpaper/2009_08/16405_7349_090813162558_41.jpg'
      },
      {
        image: 'http://f.ptcdn.info/183/007/000/1373684879-0001-o.jpg'
      }
    ];
  }

})();
