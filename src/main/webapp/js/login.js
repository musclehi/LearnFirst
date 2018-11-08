function check() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var password_confirm = document.getElementById("password_confirm").value;
    if (password!=password_confirm){
        alert("两次密码不一致");
        return false;
    }
    else{
        var reg =  /^[a-zA-Z0-9]{6,20}$/;
        if (!reg.test(password)){
            alert("密码格式错误");
            return false;
        }
    }
    // $.ajax({
    //     type:"POST",
    //     url:"userRegisterAction",
    //     dataType:"json",
    //     data:{"username":username,"password":password},
    //     beforeSend:function(){
    //         //some js code
    //     },
    //     success:function(msg){
    //         console.log(msg)
    //     },
    //     error:function(){
    //         console.log("error")
    //     }
    // })
}
