function getAll(){
    $.ajax({
        type:"GET",
        headers:{
            'Accept' : 'application/json'
        },
        url: "http://localhost:8080/signIn",
        success: function (data){
            showAccount(data)
        },
        error: function (err){
            console.log(err);
        }
    })
}

function showAccount(arr){
    let str = ""
    for (const a of arr){
        str += `<tr>
      <td>${a.username}</td>
      <td>${a.password}</td>
      <td><img src="${a.avatar}" style="width: 150px;height: 130px"></td>
      <td>
      <!-- Modal button -->
  <button type="button" class="btn btn-warning" data-toggle="modal" data-target="${'#modal' + a.id}">Edit</button>
  <button type="button" class="btn btn-danger" data-toggle="modal" >Delete</button>

  <!-- Modal -->
  <div id="${'modal' + a.id}" class="modal fade" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Edit Account</h4>
           <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
          <input id="${'username' + a.id}" value="${a.username}">
          <br>
          <input id="${'password' + a.id}" value="${a.password}">
          <br>
          <input id="${'avatar' + a.id}" value="${a.avatar}">
          <br>
        </div>
        <div class="modal-footer">
          <button type="button" onclick="edit(${a.id})" class="btn btn-warning" data-dismiss="modal">Edit</button>
          <button type="button" class="btn btn-default" onclick="delete1(${a.id})" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
     </td>
    </tr>`
    }
    document.getElementById("show").innerHTML = str
}
getAll();

function create(){
    let username = $("#username").val();
    let password = $("#password").val();
    let avatar = $("#avatar").val();
    let account = {
        username: username,
        password: password,
        avatar: avatar,
    }
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        url: "http://localhost:8080/signIn",
        data:JSON.stringify(account),
        success: function (data){
            getAll();
        },
        error:function (err){
            console.log(err);
        }
    })
}

function edit(id){
    let username = $("#username" +id).val();
    let password = $("#password" +id).val();
    let avatar = $("#avatar" +id).val();
    let account = {
        id: id,
        username: username,
        password: password,
        avatar: avatar,
    }
    $.ajax({
        type: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        url: "http://localhost:8080/signIn",
        data:JSON.stringify(account),
        success: function (data){
            getAll();
        },
        error:function (err){
            console.log(err);
        }
    })
}

function delete1(id){
    $.ajax({
        type: "DELETE",
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        url: "http://localhost:8080/signIn?id="+id,
        data:JSON.stringify(id),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err);
        }})
}