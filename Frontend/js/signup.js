// window.onload = function(){
$(document).ready(function(){   
    var t = document.getElementById('register_form');
    var value;
    console.log(value = $('id').val());

    t.addEventListener('submit', function(event){
        var xhr = new XMLHttpRequest();

        var formData ={
            "id": $('#id').val(),
            "password": $('#password').val(),
            "email": $('#email').val()
        }

        var id = $('#id').val();
        console.log(id);

        console.log(formData);
        
        $.ajax({
            url : "http://localhost:9000/users",
            type : "POST",
            data : JSON.stringify(formData), 
            // dataType: 'json',
            contentType : "application/json; charset=UTF-8",
            async: false,
            success : function(data) {
                alert('회원가입 되셨습니다.');
                window.location.replace('http://localhost:5500/login.html');

            },
            // complete : function(data) {
            //     console.log(data);
            //         alert('통신완료 data : ' + data);
            //         console.log(JSON.stringify(formData));
            // },
            error : function(xhr, status, error) {
                alert("에러발생");
            }
    });
    })
})