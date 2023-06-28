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
    <div class="container ">
        <h1>Área Pública</h1>
        <h2>Lista de Comentários</h2>
        <div class="card mb-2">
          <div class="card-body">
          <h4>22/07/2022 - Comentarista Leo</h4>
          <h6 class="card-subtitle mb-2 text-muted">Categoria: Artes</h6>
          <p>comentário 1</p>
        </div>

        </div>
        <div class="card mb-2">
          <div class="card-body">
          <h4>22/07/2022 - Comentarista Leo</h4>
          <h6 class="card-subtitle mb-2 text-muted">Categoria: Esportes</h6>
          <p>comentário 2</p>
        </div>
        </div>
    </div>
</body>
</html>