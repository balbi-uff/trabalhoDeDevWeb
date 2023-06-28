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
    <div>
      <h1>Área Restrita</h1>
      <h2>Lista de Usuários</h2>
      <div>
        <input type="submit" value="Incluir" class="btn btn-primary">
      </div>
      <div class="table-responsive">
        <table class="table">
          <thead>
            <tr>
              <th class="col-sm-1">Id</th>
              <th class="col-sm-3">Nome</th>
              <th class="col-sm-1">Ações</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>Daniele</td>
              <td>
                <input type="submit" value="Alterar" class="btn btn-warning">
                <input type="submit" value="Excluir" class="btn btn-danger">
              </td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>André</td>
              <td>
                <input type="submit" value="Alterar" class="btn btn-warning">
                <input type="submit" value="Excluir" class="btn btn-danger">
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>


  </div>



</body>

</html>