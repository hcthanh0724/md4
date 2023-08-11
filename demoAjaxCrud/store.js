function getAll(){
    $.ajax({
        type: "GET",
        headers: {
            'Accept' : 'application/json'
        },
        url: "http://localhost:8080/store",
        success: function (data){
            showProduct(data)
        },
        error: function (err){
            console.log(err);
        }
    })
}

function showProduct(arr){
    let str = ""
    for (const p of arr){
        str += `<div class="cards">
                    <div class="cards__item cards__item--clr1">
                        <div class="cards__price" >
                          ${p.price}
                          </div>
                            <div class="cards__name">
                             ${p.name}
                            </div>
            <div class="cards__product">
                    <img src="${p.img}" alt="">
            </div>
        </div>
<!--        //hiển thị modal-->
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="${'#modal'+p.id}">Edit</button>
        <button type="button" class="btn btn-danger" data-toggle="modal" onclick="delete1(${p.id})">delete</button>
         <div class="modal fade" id="${'modal'+p.id}" role="dialog">
        <div class="modal-dialog">

       
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Edit</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <input id="${'name' + p.id}" value="${p.name}">
                    <br>
                    <input id="${'img' + p.id}" value="${p.img}"><br>
                    <input id="${'content' + p.id}"value="${p.content}"><br>
                    <input id="${'price' + p.id}"value="${p.price}"><br>
                    <input id="${'quantity' + p.id}"value="${p.quantity}"><br>
                </div>
                <div class="modal-footer">
                    <button type="button" onclick="edit(${p.id})" class="btn btn-success" data-dismiss="modal">Edit</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    </div>`
    }
    document.getElementById("show").innerHTML = str
}
getAll();
function create(){
    let name = $("#name").val();
    let img = $("#img").val();
    let price = $("#price").val();
    let quantity = $("#quantity").val();
    let content = $("#content").val();

    let  product = {
        quantity: quantity,
        name: name,
        img: img,
        content: content,
        price: price
    }
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/create",
        data:JSON.stringify(product),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err);
        }
    })
}

function edit(id){
    let name = $("#name" +id).val();
    let img = $("#img" +id).val();
    let price = $("#price" +id).val();
    let quantity = $("#quantity" +id).val();
    let content = $("#content" +id).val();

    let  product = {
        id: id,
        quantity: quantity,
        name: name,
        img: img,
        content: content,
        price: price
    }
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/edit",
        data:JSON.stringify(product),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err);
        }})
}

function delete1(id){
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/edit",
        data:JSON.stringify(id),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err);
        }})

}