function getUsers() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var result = JSON.parse(this.responseText);
            var obj = result.object;
            document.getElementById("Tbody").innerHTML = "";
            for (var i = 0; i < obj.length; i++) {
                document.getElementById("Tbody").innerHTML += "<tr>" + loadUsersForm(obj[i], i + 1) + "</tr>";
            }

        }
    };
    xhttp.open("GET", "http://localhost:8080/resumerest/users", true);
    xhttp.send();
}

function setDeleteIdModal(id) {
    document.getElementById("idForDelete").value = id;
}

function deleteUser() {
    var xhttp = new XMLHttpRequest();
    var id = document.getElementById("idForDelete").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getUsers();
        }
    };
    xhttp.open("DELETE", "http://localhost:8080/resumerest/user/" + id, true);
    xhttp.send();
}

function searchUsers() {
    var xhttp = new XMLHttpRequest();
    var name = document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (name === null && surname === null) {
                getUsers();
            } else {
                var searchResult = JSON.parse(this.responseText);
                var obj = searchResult.object;
                document.getElementById("Tbody").innerHTML = "";
                for (var i = 0; i < obj.length; i++) {
                    document.getElementById("Tbody").innerHTML += "<tr>" + loadUsersForm(obj[i], i + 1) + "</tr>";
                }
            }
        }
    };
    xhttp.open("GET", "http://localhost:8080/resumerest/users/search?name=" + name + "&surname=" + surname, true);
    xhttp.send();
}


function loadUsersForm(jsonObj, index) {
    var action = " <td scope=\"col\">\n" +
        "                <div class=\"row\">\n" +
        "                    <button type=\"button\" class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#deleteModal\"" +
        "                               onclick='setDeleteIdModal(" + jsonObj.id + ")'>\n" +
        "                        <i class=\"fas fa-trash-alt\"></i>\n" +
        "                    </button>\n" +
        "                    <form action=\"userDetail.html\" method=\"get\">\n" +
        "                        <button type=\"button\" class=\"btn btn-warning\"\n" +
        "                                style=\"margin-left: 10px;\">\n" +
        "                            <i class=\"fas fa-info-circle\">\n" +
        "                                <input type=\"hidden\" name=\"id\" id="+index+" value="+jsonObj.id+">\n" +
        "                            </i>\n" +
        "                        </button>\n" +
        "                    </form>" +
        "                </div>\n" +
        "            </td>"
    var row = "";
    row += "<td scope=\"col\">" + index + "</td>"
    row += "<td scope=\"col\">" + jsonObj.name + "</td>"
    row += "<td scope=\"col\">" + jsonObj.surname + "</td>"
    row += "<td scope=\"col\">" + jsonObj.email + "</td>"
    row += action;
    return row;

}