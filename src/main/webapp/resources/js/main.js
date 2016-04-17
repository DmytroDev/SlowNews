$(function () {
    $(document).ready(function () {
        $.get("/view" + window.location.pathname, function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "#update-button", function (event) {
        $.get("/updateweather", function (responseText) {
            document.getElementById('temp-weather').innerText = responseText;
        });
    });

    $(document).on("click", "input#logout-button", function (event) {
        $.get("/logout", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("submit", "#login-form", function (event) {
        event.preventDefault();
        var formData = {
            'username': $('input[name=username]').val(),
            'password': $('input[name=password]').val()
        };
        $.post("/view/login", formData, function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "input#search-button", function (event) {
        var searchedText = $('.search-field').val();
        console.log("searchedText: " + searchedText);
        var theRegEx = new RegExp("(" + searchedText + ")", "igm");

        // each function ~ for each in java (i - iteration, elem = p.news[i])
        $('p.news').each(function (i, elem) {
            var pageText = $(elem).text().replace("<span class='temp'>", "").replace("</span>");
            var newHtml = pageText.replace(theRegEx, "<span class='temp'>$1</span>");
            $(elem).html(newHtml);
        });
    });

    $(document).on("submit", "#add-to-archive-form", function (event) {
        event.preventDefault();
        var formData = $(this).serialize();  // get all data from current form :)
        $.post("/view/news", formData, function (data) {
        });
    });

    $(document).on("click", "a#ref-news", function (event) {
        event.preventDefault();
        $.get("/view/news", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#ref-archive", function (event) {
        event.preventDefault();
        $.get("/view/archive", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#ref-show", function (event) {
        event.preventDefault();
        $.get("/view/show", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#skip-authentication", function (event) {
        event.preventDefault();
        $.get("/view/news", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("click", "a#new-user", function (event) {
        event.preventDefault();
        $.get("/view/registration", function (data) {
            $("#content").html(data);
        });
    });

    $(document).on("submit", "#registration-user-form", function (event) {
        event.preventDefault();
        /*var formData = $(this).serialize();*/  // get all data from current form :)
        var formData = {
            'username': $('input[name=username]').val(),
            'password': $('input[name=password]').val(),
            'confirm-password': $('input[name=confirm-password]').val()
        };
        $.post("/view/registration", formData, function (data) {
            $("#content").html(data);
        });
    });

});
