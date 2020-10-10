<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Disable</title>
    <style>
    	.button1 {
 	margin-left: 50px;
 	padding: 15px 40px;
 	text-align: center;
 	font-size: 15px;
 	background-color: grey;
}
 .button2 {
 	margin-left: 100px;
 	padding: 15px 40px;
 	text-align: center;
 	font-size: 15px;
 	background-color: grey;
 }
  </style>
</head>
<body>
	<h2 style="color:green">Dissable Users</h2>
      <div class="container">
         <span style="color:red">Filter users by User name</span>
         <div class="row">
            <div class="col-md-3">
            <table class="table table-bordered table-condensed table-hover table-striped text-center">
   <thead>
      <tr>
         <th scope="col">User Names</th>
      </tr>
   </thead>
   <tbody class="text-left">
      <tr>
         <td><input type="checkbox" name="user">Apple</td>
      </tr>
      <tr>
         <td><input type="checkbox" name="user">Samsung</td>
      </tr>
      <tr>
         <td><input type="checkbox" name="user">Google</td>
      </tr>
      <tr>
         <td><input type="checkbox" name="user">Huawei</td>
      </tr>
   </tbody>
</table>
 <button type="button" name ="disable" value="disable" class="button1" onclick="submit()">Disable</button>
 <button type="button" value="deselectAll" class="button2" onclick="uncheckAll()">Clear</button>
 </div>
  </div>
  </div>
  
  <script type="text/javascript">
function uncheckAll(){
    var items = document.getElementsByName('user');
      for (var i = 0; i < items.length; i++) {
          if (items[i].type == 'checkbox')
              items[i].checked = false;
      }
  }
function submit()
{
	var items = document.getElementsByName('user');
	for (var i = 0; i < items.length; i++) {
        if (items[i].checked == true)
            items[i].disabled = true;
}
}

</script>
</body>

</html>