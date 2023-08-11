function findAllImage() {
    $.ajax({
        url: "http://localhost:8080/admin/image",
        type: "GET",
        success: function (data) {
            displayImage(data)
        }
    })
}
function displayImage(value) {
    let content = ``
    for (let i = 0; i < value.length; i++) {
        content += `<div>
                    <div>${value[i].post.name}</div>
                    <img src="${value[i].image}">
                    <button onclick="updateCity(${value[i].id})">Update</button>
                    <button onclick="deleteCity(${value[i].id})">Delete</button>
                    </div>
                   `
    }
    content += `</table>`
    document.getElementById("list_city").innerHTML = content
}

function createImage() {
    let img = $("#img-c").val()
    let image = {
        image: img,
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/admin/image",
        type: "POST",
        data: JSON.stringify(image),
        success: function () {
            displayImage()
        }
    })
}
function updateCity() {
    let img = $("#img-u").val()
    let image = {
        image: img,
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `http://localhost:8080/api/cities/${idUpdate}`,
        processData: false,
        contentType: false,
        type: "PUT",
        data: JSON.stringify(image),
        success: function () {
            displayImage()
        },
    })
}


function deleteCity(id) {
    if (confirm("Are you sure?")) {
        $.ajax({
            url: `http://localhost:8080/admin/image/${id}`,
            type: "DELETE",
            success: function (data) {
                displayImage()
            }
        })
    }
}
let idUpdate
