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
      <h1>Registro</h1>
      <form action="" method="post"></form>
      <div class="mb-3">
        <label for="nome" class="form-label">Nome</label>
        <input placeholder="Seu nome" type="text" name="nome" class="form-control">
      </div>
      <div class="mb-3">
        <label for="endereco" class="form-label">Endereço</label>
        <input placeholder="Seu endereço" type="text" name="endereco" class="form-control">
      </div>
      <div class="mb-3">
        <label for="cpf" class="form-label">CPF</label>
        <input placeholder="999.999.999-99" type="text" name="cpf" class="form-control">
      </div>
      <div class="mb-3">
        <label for="senha" class="form-label">Senha</label>
        <input type="password" name="senha" class="form-control">
      </div>
      <div class="mb-3">
        <label for="senha" class="form-label">Redigite a senha</label>
        <input type="password" name="senha" class="form-control">
      </div>
      <div>
        <input type="submit" value="Enviar" class="btn btn-primary">
      </div>
    </div>
  </div>
</body>

</html>