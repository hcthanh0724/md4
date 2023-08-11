function login(){
    let username = $("#username").val();
    let password = $("#password").val();
    let account = {username,password};
    $.ajax({
        type: "Post",
        contentType: "application/json",
        url: "http://localhost:8080/login",
        data: JSON.stringify(account),
        success: function (data) {
            console.log(data)
            localStorage.setItem("token", data.token);
            localStorage.setItem("user", JSON.stringify(data));
            console.log(data.roleName.name)
            if (data.roleName.name === "ROLE_USER"){
                location.href = "ok1.html"
            }else {
                location.href = "ok.html"
            }
        },
        error: function (err) {
            console.log(err);
        }
    })
}