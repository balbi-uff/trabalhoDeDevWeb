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
       <div class="offset-1">
        <h1>Área Restrita</h1>
        <h2>Lista de Categorias</h2>
        <div>
          <input type="submit" value="Incluir" class="btn btn-primary">
        </div>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Descrição</th>
              <th scope="col">Ações</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>Artes</td>
              <td>
                <input type="submit" value="Alterar" class="btn btn-warning">
                <input type="submit" value="Excluir" class="btn btn-danger">
              </td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>Esportes</td>
              <td>
                <input type="submit" value="Alterar" class="btn btn-warning">
                <input type="submit" value="Excluir" class="btn btn-danger">
              </td>
            </tr>
          </tbody>
        </table>

      </div>
    </div>

</body>
</html>