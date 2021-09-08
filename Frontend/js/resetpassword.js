// window.onload = function(){
    $(document).ready(function(){   
        var t = document.getElementById('reset_form');
        var value;
    
        t.addEventListener('submit', function(event){
            var xhr = new XMLHttpRequest();
    
            var formData ={
                "id": $('#id').val(),
                "email": $('#email').val()
            }
            console.log(JSON.stringify(formData))
            
            $.ajax({
                url : "http://localhost:9000/users/resetpassword",
                type : "POST",
                data : JSON.stringify(formData), 
                // dataType: 'json',
                contentType : "application/json; charset=UTF-8",
                async: false,
                success : function(data) {
                    if(data=="" || undefined || null){
                        alert("아이디와 이메일을 확인해주세요.");
                    }
                    else{
                        alert("비밀번호가 1234로 초기화 되었습니다.")
                        window.location.replace('http://localhost:5500/login.html');
                    }
                },
                error : function(xhr, status, error) {
                    alert("에러발생");
                }
            })
        })
    })