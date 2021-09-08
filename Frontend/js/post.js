$(document).ready(function() {

    var board_id = localStorage.getItem('boardIdx');
    var url = 'http://localhost:9000/boards/each/' + board_id;
    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            data = JSON.parse(xhr.responseText);

            var date = document.getElementById('date');
            var content = document.getElementById('content');

            date.value = (data.open_date).substring(0, 10);
            content.value = (data.content);
        } else {
            alert("Error!");
        }
    };

    home.addEventListener('click', function(event){
        window.location.replace(document.referrer); 
    })
});