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

      <div class="offset-3">
      <h1>Login</h1>
      <form action="" method="post"></form>
      <div class="mb-3">
        <label for="cpf" class="form-label">CPF</label>
        <input placeholder="999.999.999-99" type="text" name="cpf" class="form-control">
      </div>
      <div class="mb-3">
        <label for="senha" class="form-label">Senha</label>
        <input type="password" name="senha" class="form-control">
      </div>
      <div>
        <input type="submit" value="Enviar" class="btn btn-primary">
        <span class="offset-1">Não possui acesso? <a href="registro.jsp">Registre-se aqui</a></span> 
      </div>
       </div>
    </div>
</body>
</html>