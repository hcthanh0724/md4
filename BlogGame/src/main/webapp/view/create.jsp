<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Stacked form</h2>
  <form method="post">
    <div class="form-group">
      <label>IMG:</label>
      <input type="text" class="form-control"  placeholder="Enter img url:" name="img">
    </div>
    <div class="form-group">
      <label>Background IMG:</label>
      <input type="text" class="form-control" placeholder="Enter background img url" name="background_img">
    </div>
    <div class="form-group">
      <label>Header:</label>
      <input type="text" class="form-control" placeholder="Enter header" name="header">
    </div>
    <div class="form-group">
      <label>Role:</label>
      <input type="text" class="form-control" placeholder="Enter role" name="role">
    </div>
    <div class="form-group">
      <label>Biography:</label>
      <input type="text" class="form-control" placeholder="Enter biography" name="biography">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>
