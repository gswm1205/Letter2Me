
$(document).ready(function(){   
    var id = document.getElementById('id');
    id.value = localStorage.user_id;

    getEmail();

    var t = document.getElementById('update_form');
    var value;

    t.addEventListener('submit', function(event){
        var xhr = new XMLHttpRequest();


        var formData ={
            "number": localStorage.getItem("userIdx"),
            "password": $('#password').val(),
            "newpassword": $('#newpassword').val(),
            "email": $('#email').val()
        }

        var id = $('#id').val();
        console.log(id);

        console.log(formData);
        
        $.ajax({
            url : "http://localhost:9000/users",
            type : "PUT",
            data : JSON.stringify(formData), 
            // dataType: 'json',
            contentType : "application/json; charset=UTF-8",
            async: false,
            success : function(data) {
                if(data=="" || undefined || null){
                    alert("비밀번호가 틀렸습니다.");
                }
                else{
                    alert('수정되었습니다.');
                    window.location.replace('http://localhost:5500/board.html');
                }
            },
            error : function(xhr, status, error) {
                alert("에러발생");
            }
    });
    })
})

function getEmail(){
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:9000/users/'+localStorage.user_id);
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            data = JSON.parse(xhr.responseText);

            var email = document.getElementById('email');
            email.value = (data.email);
        } else {
            alert("Error!");
        }
    };
}