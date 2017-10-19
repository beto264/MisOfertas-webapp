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
                    <li class=""><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
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
<div class="container"

     <br>
    <br>

    <div class="row">
        <div class="col  s6 m6">
            <!-- profile-page-header -->
            <div  class="card">
                <!--<figure class="card-profile-image">
                   <i class="large material-icons">account_circle</i>
                </figure>-->
                <div class="card-content">
                    <div class="card-image">
                        <center><img src="img/ofertas/${oferta.imagen}" id="${oferta.imagen}" style="width: 70%;
                                     height: auto; max-width: 70%;"></center>
                    </div>
                </div>
            </div>
        </div>
        <div class="col  s6 m6">
            <div  class="card">
                <!--<figure class="card-profile-image">
                   <i class="large material-icons">account_circle</i>
                </figure>-->
                <div class="card-content">

                    <!--<p>${productoDTO.rubro.nombre}</p>
                    <h4 class="header">${productoDTO.nombre}</h4>-->

                    <div class="card-stacked">
                        <div class="card-content">
                            <p>Datos de la tienda acá</p>
                            <hr>
                            <p>Descuento: $${oferta.descuento}</p>
                            <p>Valor final: $${oferta.valorFinal}</p>
                            <p>Visualizaciones: ${oferta.visitas}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">

        <div  class="card s12 m12">

            <!--/ profile-page-wall-share -->
            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <form action="valoraciones" method="get">
                            <div class="input-field col l4">
                                <select name="nota">
                                    <option value="" disabled selected></option>
                                    <option value="Mala">Mala</option>
                                    <option value="Buena">Buena</option>
                                    <option value="Excelente">Excelente</option>
                                </select>
                                <label>Dale una puntuación</label>
                            </div>
                            <div class="file-field input-field col l4">
                                <div class="btn">
                                    <span>Boleta</span>
                                    <input type="file">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text" name="image">
                                </div>
                            </div>
                            <div class="field input-field col l1 offset-l1">
                                <input type="submit" class="btn" value="Enviar valoración">
                            </div>
                            <input type="hidden" name="id_oferta" value="${oferta.idOferta}">
                            <input type="hidden" name="rut" value="${usuario.rut}">
                        </form>
                    </div>
                </div>
            </div>
        </div
    </div>
</div>
</div>
</div>
</div>

<script>
    
    $("#${oferta.imagen}).elevateZoom();
    
</script>

<%@ include file="layout/footer.jsp" %>        