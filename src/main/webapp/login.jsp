<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Ingreso de consumidores">
        <meta name="author" content="Alberto Tejos S.">

        <title>MisOfertas</title>

        <link rel="stylesheet"
              href="css/materialize.min.css" />
        <link href="css/icons.css"
              rel="stylesheet" />

    </head>
    <body>
        <div class="container">
            <div class="row"></div>
            <div class="row"></div>
            <div class="row">
                <div class="col s12 m4 offset-m4">
                    <div class="card">
                        <div class="card-content">
                            <div class="row">
                                <div class="input-field col s12 center">
                                    <img src="img/logo.png"
                                         alt="" width="50%"
                                         class="circle responsive-img valign profile-image-login">
                                </div>
                            </div>
                            <form action="login" method="post">
                                <div class="form-group">

                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input name="correo" type="email" autofocus class="validate"
                                                   required /> <label for="correo"
                                                   data-error="Formato de correo inválido">Correo</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input name="password" type="password" class="validate"
                                                   required /> <label for="password" class="active">
                                                Contraseña</label>
                                        </div>
                                        <div class="input-field col s12 m12 l12  login-text">
                                            <input type="checkbox" id="remember-me"> <label
                                                for="remember-me">Recordarme</label>
                                        </div>
                                    </div>

                                    <br>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <button class="btn waves-effect waves-light col s12"
                                                    type="submit">Ingresar</button>
                                        </div>
                                    </div>

                                </div>
                            </form>
                        </div>
                        <div class="card-action">
                            <p>${error}</p>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <p class="margin medium-small">
                                <a href="${pageContext.request.contextPath}/registro">Registrate ahora!</a>
                            </p>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <p class="margin right-align medium-small">
                                <a href="">Olvidaste la contraseña?</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="layout/footer.jsp" %>

