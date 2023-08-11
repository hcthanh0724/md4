function getAll(page){
    $.ajax(
        {
            type: "GET",
            headers:{
                'Accept' : 'application/json',
                'Authorization' : 'Bearer' +localStorage.getItem('token')
            },
            url:""
        }
    )
}