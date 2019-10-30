var app = angular.module('bfCodeTest', []);

app.controller('studentCtrl', function($scope, $location, $http) {
	console.log("StudentCtrl loaded.");
	
	$http.get('http://localhost:8080/api/getStudents')
	.then(function(response) {
		$scope.students = response.data;
		console.log(response)
	});

	$scope.enroll = function(studentID, subjectID){
            if (typeof studentID === 'undefined' && subjectID === 'undefined'){
                console.log("Options not selected.");
                return;
            }
            console.log(studentID);
            console.log(subjectID);
            // POST request to enroll student
            $http.post('http://localhost:8080/api/assignSubject?studentID=' + studentID + '&subjectID=' + subjectID)
            .then(response => {
                window.location.reload();
                }
            );

        }
});