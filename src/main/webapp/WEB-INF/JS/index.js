window.onload = function () {

    var addButton = $("#add_button");
    var messageBox = $("#message_div");



    addButton.click(function () {
        $.post("../parse/addPack",null,     function(data,status){
            alert("Data: " + data + "\nStatus: " + status);
        });
        messageBox.fadeToggle("slow");
        messageBox.delay(2000);
        messageBox.fadeOut("slow");

    });

    //calls controller for put new resumes
    function addNewResumes() {
        sendAjaxToUrl("../parse/addPack",
            "POST",
            null,
            null,
            alert("DONE!"),
            null
        );

    };
    function sendAjaxToUrl(url, method, headers, data, success, error) {
        $.ajax({
            url: url,
            type: method,
            headers: headers,
            dataType: "json",
            data: data
        }).done(success).fail(error)
    }
};
