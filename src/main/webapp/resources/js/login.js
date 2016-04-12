$(function(){
    $(".hello-button").click(function(){
        //console.log('Hello!');

        //  synchro (false)
/*        var req = new XMLHttpRequest();
        req.open('GET', 'http://localhost:8080/login', false);
        req.send(null);
        if(req.status == 200){
            /!*dump(req.responseText);*!/
            console.log(req.responseText);
        }*/

        // asynchro (true)

        var req = new XMLHttpRequest();
        req.open('GET', '/test', true); /* Третий аргумент true означает асинхронность */
        req.onreadystatechange = function (aEvt) {
            if (req.readyState == 4) {
                if(req.status == 200){
                    document.getElementById('temp-weather').innerText = req.responseText;
                }
                else
                    console.log('Error loading page');
            }
        };
        req.send(null);
    });

    $('.skip-authentication, .new-user').click(function(event) {
        event.preventDefault();
        // ...
    });
});
