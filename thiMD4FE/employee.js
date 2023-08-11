function getAll(){
    $.ajax({
        type:"GET",
        headers:{
            'Accept' : 'application/json'
        },
        url: "http://localhost:8080/employee",
        success: function (data){
            showEmployee(data)
        },
        error: function (err){
            console.log(err);
        }
    })
}

function showEmployee(arr){
    let str = ""
    for (const a of arr){
        str += `<tr>
      <td>${a.employeeCode}</td>
      <td>${a.name}</td>
      <td>${a.age}</td>
      <td>${a.salary}</td>
      <td>${a.department.name}</td>
      <td>
      <!-- Modal button -->
      <a href="Detail.html?id=${a.id}">
      <button type="button" class="btn btn-primary">Detail</button>
</a>

<button type="button" class="btn btn-warning" data-toggle="modal" data-target="${'#modal' + a.id}">Edit</button>
<button type="button" class="btn btn-danger" data-toggle="modal" onclick="delete1(${a.id})">Delete</button>

  <!-- Modal -->
  <div id="modal${a.id}" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Edit Account</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <input id="employeeCode${a.id}" value="${a.employeeCode}">
                <br>
                <input id="name${a.id}" value="${a.name}">
                <br>
                <input id="age${a.id}" value="${a.age}">
                <br>
                <input id="salary${a.id}" value="${a.salary}">
                <br>
                <select name="department" id="department${a.id}">
                    <option value="1">RnD</option>
                    <option value="2">Sale</option>
                    <option value="3">IT</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="edit(${a.id})" class="btn btn-warning" data-dismiss="modal">Edit</button>
            </div>
        </div>
    </div>
</div>
     </td>
    </tr>`
    }
    document.getElementById("show").innerHTML = str
}
getAll();

function create() {
    let employeeCode = $("#code").val();
    let name = $("#name").val();
    let age = $("#age").val();
    let salary = $("#salary").val();
    let departmentId = $("#departmentSelect").val(); // Lấy giá trị id của phòng ban được chọn

    let employee = {
        employeeCode: employeeCode,
        name: name,
        age: age,
        salary: salary,
        department: {
            id: departmentId
        }
    };

    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/employee",
        data: JSON.stringify(employee),
        success: function (data) {
            getAll();
        },
        error:function (err) {
            console.log(employee);
            console.log(err);
        }
    });
}
//
function edit(id) {
    let employeeCode = $(`#employeeCode${id}`).val();
    let name = $(`#name${id}`).val();
    let age = $(`#age${id}`).val();
    let salary = $(`#salary${id}`).val();
    let departmentId = $(`#department${id}`).val();
    let employee = {
        id: id,
        employeeCode: employeeCode,
        name: name,
        age: age,
        salary: salary,
        department: {
            id: departmentId
        }
    };
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/employee/update",
        data: JSON.stringify(employee),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(employee);
            console.log(err);
        }
    });
}
//
function delete1(id){
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        url: "http://localhost:8080/employee/delete/"+id,
        data:JSON.stringify(id),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err);
        }})
}

