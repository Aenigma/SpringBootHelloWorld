var redrawUsersTable = function (usersList) {
    var element = document.getElementById("usersContainer");
    var tbl = element.getElementsByTagName("table").item(0);

    // let's clear the table
    tbl.innerHTML = "";
    tbl.appendChild(document.createElement("tbody"));

    var tableHeaders = Object.keys(usersList[0]);
    var headerRow = tbl.appendChild(document.createElement("tr"));

    tableHeaders.forEach(function (key) {
        var header = document.createElement("th");
        header.appendChild(document.createTextNode(key));
        headerRow.appendChild(header);
    });

    console.log(tableHeaders);

    usersList.forEach(function (v) {
        var row = document.createElement("tr");
        tableHeaders.forEach(function (header) {
            var column = document.createElement("td");
            column.appendChild(document.createTextNode(v[header]));
            row.appendChild(column);
        });
        tbl.appendChild(row);
    });

    tbl.innerHTML = tbl.innerHTML;
};

var drawUser = function () {
    var req = new XMLHttpRequest();
    req.onload = function () {
        var rsp = req.response;
        console.table(rsp);

        // if the JSON is empty, don't generate the table
        if (rsp.length < 1) {
            return;
        }

        redrawUsersTable(rsp);
    };

    req.open("GET", "/users/", true);
    req.responseType = "json";
    req.send();
};

var addUser = function () {
    var formData = new FormData(document.getElementById("addUserForm"));
    var req = new XMLHttpRequest();

    req.onload = function() {
        drawUser();
    };

    req.open("POST", "/users/", true);
    req.responseType = "text";

    req.send(formData);
};

var drawRecords = function () {

};

document.getElementById("usersBtn").addEventListener("click", drawUser, false);
document.getElementById("recordsBtn").addEventListener("click", drawRecords, false);
document.getElementById("addUserSubmit").addEventListener("click", addUser, false);