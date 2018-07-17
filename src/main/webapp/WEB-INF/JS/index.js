window.onload = function () {

    var addButton = $("#add_button");



    //calls servlet to get information about last table update
    function addNewResumes() {
        sendAjaxToUrl("./parse/addPack",
            "POST",
            null,
            null,
            null,
            null
        );

        addButton.click(function () {
        $()
        });

    }
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
