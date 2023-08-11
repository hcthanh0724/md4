function displayEmployeeDetails(employee) {
    document.getElementById("code").innerHTML = employee.employeeCode;
    document.getElementById("name").innerHTML = employee.name;
    document.getElementById("age").innerHTML = employee.age;
    document.getElementById("salary").innerHTML = employee.salary;
    document.getElementById("department").innerHTML = employee.department.name;
}

function getAccountDetails(id) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/admin/employee/detail/" + id, // Điều chỉnh URL
        success: function (data) {
            console.log(data);
            displayEmployeeDetails(data);
        },
        error: function (err) {
            console.log(err);
        }
    });
}

const urlParams = new URLSearchParams(window.location.search);
const employeeId = urlParams.get('id');
getAccountDetails(employeeId);