$(document).ready(function () {
    //alert('book service '+contextPath);

    $('#savebook').click(function() {
          alert('save book');
          let data = { "title": $('#title').val(),
                     "genre": $('#genre').val(),
                     "publicationDate": $('#publicationDate').val(),
                     "price":$('#price').val()
                     };
          console.log('Request---'+JSON.stringify(data));
          $.ajax({
              type: "POST",
              url: contextPath+"/api/v1/book/saveBook/save",
              data: JSON.stringify(data),
              contentType: "application/json",
              headers:{
                 'Content-Type': 'application/json',
                 'Accept': 'application/json',
                 'X-Requested-With': 'XMLHttpRequest',
              },
              success: function(data){
                  var result = JSON.stringify(data.result);
                  var res1 = JSON.parse(result)
                  var labels = JSON.stringify(res1.errorlabels);
                  alert("title error"+labels);

                  $.each(JSON.parse(result), function(key, value) {
                      console.log(key+"=="+value);
                  });
                  return true;
              },
              error: function(error){
                  alert('error'+error);
              }
          });
     });
});
