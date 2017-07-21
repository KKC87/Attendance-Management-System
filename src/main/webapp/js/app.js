var app = angular.module("amsapp", []);

app.controller("loginCtrl", function($scope, $http, $window) {

	$scope.emailid = null;
	$scope.password = null;

	$scope.login = function() {

		$http.get('/validateUserLogin/' + $scope.emailid + "/" + $scope.password)
				.then(function(response, status, headers) {
					if (response.data == null || response.data == '') {
						alert("Not a valid user name and password")
					} else {
						$window.location.href = 'home.html';
					}
				});
	}

});