window.onload = function () {


    var messageBox = $("#message_div");
    var messageTextDiv = $("#message_text");
    var loadingDiv = $(".loading_box");
    var addButton = $("#add_button");
    var findForm = $("#findForm");
    findForm.prop("action", getRootUrl());

    var searchInput = $(".search-input");
    var city = $("#city");
    var wageLevel = $("#wageLevel");
    var experience = $("#experience");
    var age = $("#age");
    var positionName = $("#positionName");

    addButton.click(function () {
        showLoadingMessage();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: getRootUrl() + "/parse/addPack",
            data: null,
            dataType: 'json',
            timeout: 10000000,
            success: function (data) {
                showAndHideMessage(data);
                addButton.prop("disabled", false);
                setTimeout(function () {
                    location.reload();
                }, 10000);
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE ", e);
            }
        });
    });

    function showLoadingMessage() {
        addButton.prop("disabled", true);
        messageTextDiv.css("display", "none");
        messageBox.fadeIn("slow");
        loadingDiv.css("display", "flex");
    }

    function showAndHideMessage(messageText) {
        loadingDiv.css("display", "none");
        messageTextDiv.text(messageText);
        messageBox.fadeIn("slow");
        messageTextDiv.css("display", "flex");
        messageBox.css("display", "flex");
        messageBox.delay(5000);
        messageBox.fadeOut("slow");
    }

    // function for getting root url of app
    function getRootUrl() {
        return window.location.origin ? window.location.origin + '/' : window.location.protocol + '/' + window.location.host + '/';
    }

    searchInput.on("keyup",function () {
        if (age.val().length >= 1) {
            findForm.prop("action", getRootUrl() + "filter/city=" + city.val() + "/wageLevel=" + wageLevel.val() + "/experience=" + experience.val() + "/age=" + age.val() + "/positionName=" + positionName.val());
        }
        else
        {
            findForm.prop("action", getRootUrl() + "filter/city=" + city.val() + "/wageLevel=" + wageLevel.val() + "/experience=" + experience.val() + "/positionName=" + positionName.val());
        }
    });
};
