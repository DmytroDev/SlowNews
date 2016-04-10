$(function () {
    $(".submit-button").click(function () {
        var searchedText = $('.search-field').val();
        var theRegEx = new RegExp("("+searchedText+")", "igm");

        $('p.news').each(function (i, elem) {
            var pageText = $(elem).text().replace("<span class='temp'>","").replace("</span>");
            var newHtml = pageText.replace(theRegEx ,"<span class='temp'>$1</span>");
            $(elem).html(newHtml);
        });

    });
});