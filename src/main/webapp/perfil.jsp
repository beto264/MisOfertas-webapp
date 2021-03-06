<%@ include file="layout/header.jsp" %>

<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center"><img src="img/logo_fondo_blanco.png" width="82%"></a><a href="#"
                                                     data-activates="mobile-demo" class="button-collapse"><i
                class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
            <c:choose>
                <c:when test="${rol=='Consumidor'}">
                    <li ><a href="${pageContext.request.contextPath}/home">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados?action=list">Cupones</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados?action=list">Cupones</a></li>
                    <li><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                    </c:when>
                </c:choose>
        </ul>
    </div>
</nav>
<div class="container">

    <br>

    <c:if test="${not empty mensaje}">
        <div id="card-alert" class="card green">
            <div class="card-content white-text">
                <p><i class="mdi-alert-error"></i> ${mensaje} </p>
            </div>
        </div>
    </c:if>

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
                    <div class="col s1 offset-s1 center-align hide-on-small-only">
                        <i class="large material-icons">person</i>
                    </div>
                    <div class="col s3 offset-s1">                        
                        <h4 class="card-title grey-text text-darken-4">${usuario.nombre}</h4>                  
                    </div>
                    <div class="col s2 offset-s1 center-align">
                        <h4 class="card-title grey-text text-darken-4">${usuario.valoracionesTotales}</h4>
                        <p class="medium-small grey-text">Valoraciones realizadas</p>                        
                    </div>
                    <div class="col s2 center-align">
                        <h4 class="card-title grey-text text-darken-4">${usuario.puntosAcumulados}</h4>
                        <p class="medium-small grey-text">Puntos acumulados</p>      
                        <c:if test="${not empty cupon}">
                            <a class="btn" href="${pageContext.request.contextPath}/certificados?action=add">Cup�n
                            </a>
                        </c:if>
                    </div>                    
                </div>
            </div>
        </div>
        <!--/ profile-page-header -->

        <!-- profile-page-content -->
        <div id="profile-page-content" class="row">
            <!-- profile-page-sidebar-->
            <div id="profile-page-sidebar" class="col s12 m4">
                <!-- Profile About  -->
                <div class="card light-blue">
                    <div class="card-content white-text">
                        <span class="card-title">�Actualiza tus datos!</span>
                        <p>Recuerda  especificar datos reales. Con esto estar�s ayudando a los dem�s usuarios a identificar las valoraciones m�s sobresalientes. </p>
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
                                        <label for="password">Contrase�a</label>
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
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <button class="btn cyan waves-effect waves-light right" type="submit">Actualizar
                            <i class="mdi-content-send right"></i>
                        </button>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>

<%@ include file="layout/footer.jsp" %>        