<!-- Modal button -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="${'#modal' + a.id}">Detail</button>
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