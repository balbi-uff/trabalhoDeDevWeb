<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Desenvolvimento Web</title>
  <link href="bootstrap/bootstrap.min.css" rel="stylesheet">
  <script src="bootstrap/bootstrap.bundle.min.js"></script>
</head>

<body>
  <jsp:include page="menu.html"></jsp:include>
  <div class="container">
    <div class="offset-1 col-sm-4 mt-5">
      <h1>Alterar Categoria</h1>
      
      <form action="admin/CategoriaController" method="POST"></form>
      <input type="hidden" name="id">
      <div class="mb-3">
        <label for="nome" class="form-label">Descrição</label>
        <input placeholder="Insira categoria" type="text" name="nome" class="form-control">
      </div>
      <div>
        <input type="submit" value="Alterar" class="btn btn-primary">
        <input type="submit" value="Retornar" class="btn btn-danger">
      </div>
    </div>
  </div>
</body>

</html>