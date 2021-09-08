
$(document).ready(function(){  
    var submit = document.getElementById('submit');
    var home = document.getElementById('home');

    var seoul = new Date();
    seoul.setHours(seoul.getHours()+9);
    document.getElementById('date').value= seoul.toISOString().slice(0, 16);
    
    home.addEventListener('click', function(event){
        var jbResult = confirm( '나가시겠습니까?' );
        if(jbResult == true) {
            window.location.replace(document.referrer); 
        }
    })

    submit.addEventListener('click', function(event){

        var formData = {
            "open_date": $('#date').val(),
            "content": $('#content').val(),
            "user": {
                "id": localStorage.getItem('user_id')
            }
        }

        console.log(localStorage.getItem('user_id'));

        $.ajax({
            url : 'http://localhost:9000/boards',
            type : "POST",
            data : JSON.stringify(formData),
            contentType : "application/json; charset=UTF-8",
            async: false,
            success : function(data) {
                if(data=="" || undefined || null){
                    alert("저장되었습니다.");
                    window.location.replace('http://localhost:5500/board.html'); 
                }
                else{
                    console.log(data);
                    add_row(eval(data));
                }
            },
            error : function(xhr, status, error) {
                alert("에러발생");
            }
        })
    })

})