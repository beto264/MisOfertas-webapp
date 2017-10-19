<%@ include file="layout/header.jsp" %>

<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center"></a><a href="#"
                                                     data-activates="mobile-demo" class="button-collapse"><i
                class="material-icons">Menú</i></a>
        <ul class="right hide-on-med-and-down">
            <c:choose>
                <c:when test="${rol=='Consumidor'}">
                    <li ><a href="${pageContext.request.contextPath}/home">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/cupones">Cupones</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/cupones">Cupones</a></li>
                    <li><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                    </c:when>
                </c:choose>
            <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
        </ul>
    </div>
</nav>
<div class="container">

    <div id="profile-page" class="section">
        <!-- profile-page-header -->
        <div id="profile-page-header" class="card">
            <div class="card-image waves-effect waves-block waves-light">

            </div>
            <!--<figure class="card-profile-image">
               <i class="large material-icons">account_circle</i>
            </figure>-->
            <div class="card-content">
                <div class="row">                    
                    <div class="col s3 offset-s2">                        
                        <h4 class="card-title grey-text text-darken-4">${usuario.nombre}</h4>                  
                    </div>
                    <div class="col s2 center-align">
                        <h4 class="card-title grey-text text-darken-4">10+</h4>
                        <p class="medium-small grey-text">Ofertas visualizadas</p>                        
                    </div>
                    <div class="col s2  center-align">
                        <h4 class="card-title grey-text text-darken-4">10+</h4>
                        <p class="medium-small grey-text">Valoraciones realizadas</p>                        
                    </div>
                    <div class="col s2 center-align">
                        <h4 class="card-title grey-text text-darken-4">6</h4>
                        <p class="medium-small grey-text">Puntos acumulados</p>                        
                    </div>                    
                </div>
            </div>
            <div class="card-reveal">
                <p>
                    <span class="card-title grey-text text-darken-4">Roger Waters <i class="mdi-navigation-close right"></i></span>
                    <span><i class="mdi-action-perm-identity cyan-text text-darken-2"></i> Project Manager</span>
                </p>

                <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>

                <p><i class="mdi-action-perm-phone-msg cyan-text text-darken-2"></i> +1 (612) 222 8989</p>
                <p><i class="mdi-communication-email cyan-text text-darken-2"></i> mail@domain.com</p>
                <p><i class="mdi-social-cake cyan-text text-darken-2"></i> 18th June 1990</p>
                <p><i class="mdi-device-airplanemode-on cyan-text text-darken-2"></i> BAR - AUS</p>
            </div>
        </div>
        <!--/ profile-page-header -->

        <!-- profile-page-content -->
        <div id="profile-page-content" class="row">
            <!-- profile-page-sidebar-->
            <div id="profile-page-sidebar" class="col s6 m4">
                <!-- Profile About  -->
                <div class="card light-blue">
                    <div class="card-content white-text">
                        <span class="card-title">¡Actualiza tus datos!</span>
                        <p>Recuerda  especificar datos reales. Con esto estarás ayudando a los demás usuarios a identificar las valoraciones más sobresalientes. </p>
                    </div>                  
                </div>
                <!-- Profile About  -->

            </div>


            <div id="profile-page-wall" class="col s12 m8">

                <!--/ profile-page-wall-share -->
                <div class="card">
                    <div class="card-content">
                        <div class="row">
                            <form class="col s12" action="perfil" method="post">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="email5" type="email" value="${usuario.username}">
                                        <label for="email"> Correo</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="password6" type="password" value="${usuario.password}">
                                        <label for="password">Contraseña</label>
                                    </div>
                                </div>
                              <div class="row">
                                    <div class="input-field col s12">
                                        <input id="password6" type="text" value="${usuario.fono}">
                                        <label for="fono">Fono</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <input id="password6" type="text" value=" ${usuario.direccion}" required>
                                        <label for="direccion">Direccion</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <button class="btn cyan waves-effect waves-light right" type="submit">Actualizar
                                                <i class="mdi-content-send right"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div
            </div>
        </div>
    </div>
</div>
</div>

<%@ include file="layout/footer.jsp" %>        