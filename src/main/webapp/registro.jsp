<%@ include file="layout/header.jsp" %>

<div class="container">
    <div class="row"></div>
    <div class="row"></div>
    <div class="row">
        <div class="col s12 m6 offset-m6">
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <div class="input-field col s12 center">
                            <h4>Registro</h4>
                        </div>
                    </div>
                    <form method="POST" action="registro">
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="rut" id="rut" type="text" class="validate" required
                                       autofocus="true" oninput="checkRut(this)"> <label
                                       for="rut" data-error="Formato de rut inválido">RUT</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input name="nombre" type="text" required> <label
                                    for="nombre" data-error="">Nombre</label>
                            </div>
                            <div class="input-field col s6">
                                <input name="apellido" type="text" class="validate" required>
                                <label for="apellido" class="active"> Apellido</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input name="fono" type="text" class="validate" required>
                                <label for="fono">Fono</label>
                            </div>
                            <div class="input-field col s6">
                                <input name="correo" type="email" class="validate" required>
                                <label for="correo" data-error="Formato de correo inválido">Correo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="direccion" type="text" class="validate" required>
                                <label for="direccion" class="active"> Dirección</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="password" type="password" class="validate"
                                       required> <label for="password" class="active">
                                    Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <button type="submit"
                                    class="btn waves-effect waves-light col s12" id="btnRegistrar">Registrarse</button>
                        </div>

                    </form>
                </div>
                <div class="card-action">
                    <p>${error}</p>
                </div>
                <div class="input-field col s12 m12">
                    <p class="margin right-align medium-small">
                        Ya tienes una cuenta?, <a href="${pageContext.request.contextPath}/login">Inicia sesión</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>        