window.onload = function () {

    var addButton = $("#add_button");
    var messageBox = $("#message_div");
    var messageBoxSpan = $("#message_text");


    addButton.click(function () {
        showMessage("Пополняем базу резюме");
        messageBox.fadeOut("slow");
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: getRootUrl() + "/parse/magic",
            data: null,
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                showMessage(data);
                setTimeout(function () {
                    location.reload();
                }, 10000);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    });

    function showMessage(messageText) {
        messageBoxSpan.text(messageText);
        messageBox.fadeIn("slow");
        messageBox.css("display", "flex");
        messageBox.delay(5000);
        messageBox.fadeOut("slow");
    };

    function getRootUrl() {
        return window.location.origin ? window.location.origin + '/' : window.location.protocol + '/' + window.location.host + '/';
    }

};
