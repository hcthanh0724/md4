function findAllFriendRequest(id) {
    $.ajax({
        url: `http://localhost:8080/friendrequest/${id}`,
        type: "GET",
        success: function (data) {
            displayFriendRequest(data)
        }
    })
}
function displayFriendRequest(value){
    let content =`<h1>Lời mời kết bạn</h1>`
    for (let i = 0; i < value.length; i++) {
        content += `<div>${value.sender.avatar}</div>
                    <div>${value.sender.name}</div>
                    <button onclick="accept(${value.id})">Chấp nhận</button>
                    <button onclick="cancel(${value.id})">Huỷ lời mời</button>
                   `
    }
    document.getElementById("friend_request").innerHTML = content
    document.getElementById("friend_request").style.display = "block"

}
let idCreate
function accept(id) {
    idCreate = id;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `http://localhost:8080/friendrequest/${idCreate}`,
        type: "POST",
        data: JSON.stringify(),
        success: function () {
            findAllFriendRequest()
        }
    })
}





function cancel(id) {
  idCancel = id;
    if (confirm("Are you sure?")) {
        $.ajax({
            url: `http://localhost:8080/friendrequest/${idCancel}`,
            type: "DELETE",
            success: function (data) {
                findAllFriendRequest()
            }
        })
    }
}
let idCancel
