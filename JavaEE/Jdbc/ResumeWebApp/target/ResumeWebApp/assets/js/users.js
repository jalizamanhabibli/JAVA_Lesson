function setId(id) {
    var elem=document.getElementById("idForDelete");
    elem.value=id;
}
function clear() {
    var obj = document.getElementById("incorrectUser");
    console.log(obj);
    obj.innerHTML="";
}