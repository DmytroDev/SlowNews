$(function () {
    // basic implementation
    /*    $(".hello-button").click(function () {

     var req = new XMLHttpRequest();
     req.open('GET', '/test', true);
     /!* Третий аргумент true означает асинхронность *!/
     req.onreadystatechange = function (aEvt) {
     if (req.readyState == 4) {
     if (req.status == 200) {
     document.getElementById('temp-weather').innerText = req.responseText;
     }
     else
     console.log('Error loading page');
     }
     };
     req.send(null);
     });*/


    // basic ajax-method
    $(".update-button").click(function () {
        $.ajax({
            type: 'GET',
            url: '/updateweather',
            success: function (responseText) {
                document.getElementById('temp-weather').innerText = responseText;
                console.log('Weather updated successful')
            },
            error: function () {
                console.log('Error loading data');
            }
        });
    });

});
