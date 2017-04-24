(function () {
    'use strict';

    var VIEWER_DEFAULT_FILE = 'candy.pdf';

    angular
        .module('GroupDocsViewer', ['ngMaterial', 'ngResource'])
        .factory('FilesFactory', FilesFactory)
        .factory('DocumentInfoFactory', DocumentInfoFactory)
        .factory('DocumentPagesFactory', DocumentPagesFactory)
        .controller('ToolbarController', ToolbarController)
        .controller('ThumbnailsController', ThumbnailsController)
        .controller('PagesController', PagesController)
        .controller('AvailableFilesController', AvailableFilesController)
    ;

    function FilesFactory($resource) {
        return $resource('/files', {}, {
            query: {
                method: 'GET',
                isArray: true
            }
        });
    }

    function DocumentInfoFactory($resource) {
        return $resource('/document/info?file=:filename', {}, {
            get: {
                method: 'GET'
            }
        });
    }

    function DocumentPagesFactory($resource) {
        return $resource('/document/pages?file=:filename', {}, {
            query: {
                method: 'GET',
                isArray: true
            }
        });
    }

    function ToolbarController($rootScope, $scope, $mdSidenav) {
        $scope.toggleLeft = function () {
            $mdSidenav('left').toggle().then(function () {
                $rootScope.$broadcast('md-sidenav-toggle-complete', $mdSidenav('left'));
            });
        };

        $scope.$on('selected-file-changed', function ($event, selectedFile) {
            $scope.selectedFile = selectedFile;
        });
    }

    function ThumbnailsController($rootScope, $scope, $sce, $mdSidenav, DocumentPagesFactory) {

        $scope.isLeftSidenavVislble = false;

        $scope.$on('selected-file-changed', function (event, selectedFile) {
            $scope.selectedFile = selectedFile;
            $scope.pages = DocumentPagesFactory.query({
                filename: selectedFile
            });
        });

        $scope.$on('md-sidenav-toggle-complete', function ($event, component) {
            $scope.isLeftSidenavVislble = component.isOpen();
        });

        $scope.onThumbnailClick = function ($event, item) {
            $mdSidenav('left').toggle().then(function () {
                location.hash = 'page-view-' + item.number;
                $rootScope.$broadcast('md-sidenav-toggle-complete', $mdSidenav('left'));
            });
        };

        $scope.createThumbnailUrl = function (pageNumber) {
            if ($scope.isLeftSidenavVislble) {
                return $sce.trustAsResourceUrl('/page/image?width=300&file=' + $scope.selectedFile + '&page=' + pageNumber);
            }
        };

    }

    function PagesController($scope, $sce, DocumentPagesFactory) {
        $scope.$on('selected-file-changed', function (event, selectedFile) {
            $scope.selectedFile = selectedFile;
            $scope.pages = DocumentPagesFactory.query({
                filename: selectedFile
            });
        });

        $scope.createPageUrl = function (pageNumber) {
            return $sce.trustAsResourceUrl('/page/html?file=' + $scope.selectedFile + '&page=' + pageNumber);
        };
    }

    function AvailableFilesController($rootScope, $scope, FilesFactory) {
        $scope.onOpen = function () {
            $scope.list = FilesFactory.query();
        };

        $scope.onChange = function ($event) {
            $rootScope.$broadcast('selected-file-changed', $scope.selectedFile);
        };

        setTimeout(function () {
            if (VIEWER_DEFAULT_FILE) {
                $scope.list = [VIEWER_DEFAULT_FILE];
                $scope.selectedFile = $scope.list[0];
                $rootScope.$broadcast('selected-file-changed', $scope.selectedFile);
            }
        }, 1000);

    }

})();

function iframe_auto_height(iframe) {
    var body = iframe.contentWindow.document.body,
        html = iframe.contentWindow.document.documentElement,
        height = Math.max(
            body.scrollHeight,
            body.offsetHeight,
            html.clientHeight,
            html.scrollHeight,
            html.offsetHeight
        );

    iframe.parentNode.style.height = height + 'px';
}
