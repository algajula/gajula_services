$(document).ready(function () {
    alert('java script alert', contextPath);

    $('#getcountries').click(function() {
           alert('get customer');
           $.ajax({
              type: "GET",
              dataType: "application/json",
              url: contextPath+"/api/v1/master/getCountries/All",
              success: function(data){
                alert('response', data);
              },
              error: function(data){
                 alert('error', data);
              }
           });
    });

});
