<%@ include file="layout/header.jsp" %>

<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center"></a><a href="#"
                                                     data-activates="mobile-demo" class="button-collapse"><i
                class="material-icons">Menú</i></a>
        <ul class="right hide-on-med-and-down">
            <c:choose>
                <c:when test="${rol=='Consumidor'}">
                    <li  class="active"><a href="">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados?action=list">Cupones</a></li>
                    <li><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados?action=list">Cupones</a></li>
                    <li><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                    </c:when>
                </c:choose>
            <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row"></div>
    <div class="row">

        <p>${error}</p>

        <div id="card-alert" class="card blue">
            <div class="card-content white-text">
                <p>Conectad@ como <b>${sessionScope.usuario.nombre}</b></p>
            </div>
        </div>

        <div class="row"></div>
        <c:if test="${not empty success}">
            <div id="card-alert" class="card green">
                <div class="card-content white-text">
                    <p><i class="mdi-alert-error"></i> Su valoración ha sido recibida con éxito.</p>
                </div>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${rol=='Consumidor'}">
                <div class="row">
                    <c:forEach items="${ofertas}" var="element" varStatus="rowCounter">
                        <div class="col s12 m6 l6 left" >
                            <p>${element.productoDTO.rubro.nombre}</p>
                            <h4 class="header">${element.productoDTO.nombre}</h4>
                            <div class="card horizontal">
                                <div class="card-image">
                                    <img src="img/ofertas/${element.imagen}">
                                </div>
                                <div class="card-stacked">
                                    <div class="card-content">
                                        <p><del>Antes:  $${element.productoDTO.valor}</del></p>
                                        <h5><b>Ahora: $${element.valorFinal}</b></h5>
                                        <p>&nbsp;</p>
                                        <p>&nbsp;</p>
                                        <p>&nbsp;</p>
                                    </div>
                                    <div class="card-action">
                                        <a class="waves-effect waves-light btn modal-trigger" href="${pageContext.request.contextPath}/oferta?id=${element.idOferta}" id="${element.idOferta}"><i class="material-icons"></i>Detalles</a>                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:if test="${rowCounter.index eq 3}">
                        </div>
                    </c:if>
                </c:forEach>
                <!--<div class="row"></div>
                <div class="row"></div>
                <div class="row">
                    <div class="col s12 m6 offset-m3 l4 offset-l4 z-depth-6">
                        <ul class="pagination">
                            <li class="disabled"><a href="#!"><i class="material-icons"><</i></a></li>
                            <li class="active"><a href="#!">1</a></li>
                            <li class="waves-effect"><a href="#!">2</a></li>
                            <li class="waves-effect"><a href="#!">3</a></li>
                            <li class="waves-effect"><a href="#!">4</a></li>
                            <li class="waves-effect"><a href="#!">5</a></li>
                            <li class="waves-effect"><a href="#!"><i class="material-icons">></i></a></li>
                        </ul>
                    </div>
                </div>-->
                <div class="row"></div>

                <!-- Modal Structure -->
                <div id="${element.idOferta}" class="modal bottom-sheet">
                    <div class="modal-content">
                        <div class="row">
                            <div class="col s6 m6 l6">
                                <ul class="collection">
                                    <li class="collection-item avatar">
                                        <!--<img src="images/yuna.jpg" alt="" class="circle">-->
                                        <i class="mdi-action-assessment circle orange"></i>
                                        <span class="title">Visualizaciones</span>
                                        <p>${element.numero_visitas}</p>
                                        <a href="#!" class="secondary-content"><i class="mdi-action-grade"></i></a>
                                    </li>
                                    <li class="collection-item avatar">
                                        <i class="mdi-action-assessment circle blue"></i>
                                        <span class="title">Nota promedio</span>
                                        <p>¡Excelente!</p>
                                        <a href="#!" class="secondary-content"><i class="mdi-action-grade"></i></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col s6 m6 l6">
                                <ul>
                                    <li>
                                        <a class="btn waves-effect waves-light" type="submit" name="action" href="${pageContext.request.contextPath}/perfil/">Valorar
                                            <i class="material-icons right">star</i>
                                        </a>
                                    </li>
                                    <br>
                                    <li>
                                        <a class="btn waves-effect waves-light" type="submit" name="action">Ver valoraciones
                                            <i class="material-icons right">star_half</i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:when>    
                <c:otherwise>
                    <div class="row"></div>
                    <div class="row"></div>
                    <div class="row">
                        <a class="waves-effect waves-light btn"><i class="material-icons left"></i>Descargar reporte</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%@ include file="layout/footer.jsp" %>

