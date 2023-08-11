function getAll(){
    $.ajax({
        type:"GET",
        headers:{
            'Accept' : 'application/json'
        },
        url: "http://localhost:8080/accounts",
        success: function (data){
            console.log(data)
            showAccount(data)
        },
        error: function (err){
            console.log(err);
        }
    })
}
function showAccount(arr){
    let str = ""
    for(const a of  arr){
        str += ` <tr>
                                            <td>${a.id}</td>
                                            <td>${a.username}</td>
                                            <td>${a.password}</td>
                                            <td>${a.gender}</td>
                                            <td>${a.birthday}</td>
                                            <td>${a.country}</td>
                                            <td>${a.email}</td>
                                            <td>${a.created_at}</td>
                                            <td class="text-right">
                                                <a href="#" class="btn btn-link btn-info btn-just-icon like"><i
                                                        class="material-icons">favorite</i></a>
                                                <a href="#" class="btn btn-link btn-warning btn-just-icon edit"><i
                                                        class="material-icons">dvr</i></a>

                                                <a data-toggle="modal"
                                                   onclick="RenderActions('/Users/EditUser/3d735a4f-bb91-4bd2-9daa-94f33cfca676')"
                                                   title="Click to edit" data-target="#modalUser"
                                                   class="btn btn-sm btn-success"> <i
                                                        class="material-icons">edit</i></a>

                                                <button type="button" rel="tooltip"
                                                        class="btn btn-sm btn-danger remove">
                                                    <i class="material-icons">close</i>
                                                </button>
                                            </td>
                                        </tr>`
    }
    document.getElementById("show").innerHTML = str
}
getAll()