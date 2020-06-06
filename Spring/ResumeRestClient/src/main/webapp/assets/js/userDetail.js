function getUser(index) {
    var id=document.getElementById(index).value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var result = JSON.parse(this.responseText);
            var obj = result.object;
            console.log(obj);
            loadUserDetailForm(obj);
        }
    };
    xhttp.open("GET", "http://localhost:8080/resumerest/user/" + id, true);
    xhttp.send();
}
function loadUserDetailForm(jsonObj) {
    document.getElementById("userId").value = jsonObj.id;
    document.getElementById("userName").value = jsonObj.name;
    document.getElementById("userSurname").value = jsonObj.surname;
    document.getElementById("userEmail").value = jsonObj.email;
    document.getElementById("userNumber").value = jsonObj.number;
    document.getElementById("userProfileDescription").innerHTML = jsonObj.profileDescription;
    document.getElementById("userAddress").value=jsonObj.address;
    document.getElementById("userBirthday").value=jsonObj.birthDate;
}