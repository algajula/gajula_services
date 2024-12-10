$(document).ready(function () {
    alert('user service '+contextPath);

    $('#getcountries').click(function() {
               alert('get customer');
               $.ajax({
                  type: "GET",
                  url: contextPath+"/api/v1/master/getCountries/All",
                  data: "json",
                  contentType: "application/json",
                  headers:{
                      'Content-Type': 'application/json',
                      'Accept': 'application/json',
                      'X-Requested-With': 'XMLHttpRequest',
                  },
                  success: function(data){
                    let obj = JSON.stringify(data.result);
                    alert('response'+obj);
                    $.each(obj, function(key, value) {
                        console.log(key+"=="+value);
                     });
                  },
                  error: function(error){
                     alert('error'+error);
                  }
               });
        });


        function loginuser() {
            alert('login_submit');
            /*let data = JSON.stringify($('#loginform').serialize());*/
            let data = JSON.stringify( $('#loginform').serializeArray() );
            alert(data);
            $.ajax({
                type: "POST",
                url: "login",
                headers:{
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                    'X-Requested-With': 'XMLHttpRequest',
                },
                data: data,
                success: function (jsondata) {
                    alert('success==='+jsondata);
                    $('#content').empty().load('html/welcome.html', function() {
                        $('#username').val(data.userinfo.username);
                        $('#gender').val(data.userinfo.gender);
                        $('#mobile').val(data.userinfo.mobile);
                        $('#country').val(data.userinfo.country);
                        return true;
                    });
                }
            });
        }
});
