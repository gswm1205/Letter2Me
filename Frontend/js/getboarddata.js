$(document).ready(function() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:9000/boards');
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            alert(xhr.responseText);
        } else {
            alert("Error!");
        }
    };
});