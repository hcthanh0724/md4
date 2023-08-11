function findAllFriendShip(id) {
    $.ajax({
        url: `http://localhost:8080/friendship/${id}`,
        type: "GET",
        success: function (data) {
            displayFriendShip(data)
        }
    })
}
function displayFriendShip(value){
        let content =`<h1>Danh sách bạn bè</h1>`
    for (let i = 0; i < value.length; i++) {
        content += `<div>${value.sender.avatar}</div>
                    <div>${value.sender.name}</div>
                    <button onclick="accept(${value.id})">Xoá</button>
                    <button onclick="cancel(${value.id})">Huỷ lời mời</button>
                   `
    }
    document.getElementById("friend_ship").innerHTML = content
    document.getElementById("friend_ship").style.display = "block"

}
let idCreate
function accept(id) {
    idCreate = id;
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `http://localhost:8080/friendship/${idCreate}`,
        type: "POST",
        data: JSON.stringify(),
        success: function () {
            findAllFriendRequest()
        }
    })
}





function cancel(id) {
    idUnFriend = id;
    if (confirm("Are you sure?")) {
        $.ajax({
            url: `http://localhost:8080/friendship/${idUnFriend}`,
            type: "DELETE",
            success: function (data) {
                findAllFriendRequest()
            }
        })
    }
}
let idUnFriend
