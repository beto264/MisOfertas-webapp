<%@ include file="layout/header.jsp" %>

<nav>
    <div class="nav-wrapper">
        <a href="#!" class="brand-logo center"></a> <a href="#"
                                                       data-activates="mobile-demo" class="button-collapse"><i
                class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
            <li><a href="${pageContext.request.contextPath}/logout">Cerrar sesión</a></li>
            <li><a href=""></a></li>
            <li><a href=""></a></li>
            <li><a href=""></a></li>
        </ul>
        <ul class="side-nav" id="mobile-demo">
            <li><a href="${pageContext.request.contextPath}/logout">Cerrar sesión</a></li>
            <li><a href=""></a></li>
            <li><a href=""></a></li>
            <li><a href=""></a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row"></div>
    <div class="row">
        <div class="chip">
            Bienvenid@ ${sessionScope.usuario} 
        </div>

        <div class="row"></div>
        <c:choose>
            <c:when test="${rol=='Consumidor'}">
                <div class="row">
                    <c:forEach items="${ofertas}" var="element" varStatus="rowCounter"> 
                        <div class="col s12 m6 l6">
                            <h4 class="header">${element.productoDTO.nombre}</h4>
                            <div class="card horizontal">
                                <div class="card-image">
                                    <img src="img/ofertas/${element.imagen}">
                                </div>
                                <div class="card-stacked">
                                    <div class="card-content">
                                        <p>${element.descripcion}</p>
                                    </div>
                                    <div class="card-action">
                                        <a class="waves-effect waves-light btn modal-trigger" href="#modal1" id="${element.idOferta}">Detalles</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:if test="${rowCounter.index eq 1}">
                        </div>
                    </c:if>
                </c:forEach>

                <!-- Modal Structure -->
                <div id="modal1" class="modal bottom-sheet">
                    <div class="modal-content">
                        <div class="row">
                            <div class="col s6 m6 l6">
                                                        <ul class="collection">
                            <li class="collection-item avatar">
                                <!--<img src="images/yuna.jpg" alt="" class="circle">-->
                                 <i class="mdi-action-assessment circle orange"></i>
                                <span class="title">Visualizaciones</span>
                                <p>5.850</p>
                                <a href="#!" class="secondary-content"><i class="mdi-action-grade"></i></a>
                            </li>
                            <li class="collection-item avatar">
                                <i class="mdi-action-assessment circle blue"></i>
                                <span class="title">Nota promedio</span>
                                <p>¡Excelente!</p>
                                <a href="#!" class="secondary-content"><i class="mdi-action-grade"></i></a>
                            </li>
                            <li class="collection-item avatar">
                                <i class="mdi-action-assessment circle green"></i>
                                <span class="title">Ver valoraciones de otros usuarios</span>
                                <p>
                                </p>
                                <a href="#!" class="secondary-content"><i class="mdi-action-grade"></i></a>
                            </li>
                        </ul>
                            </div>
                            <div class="col s6 m6 l6">
                                
                            </div>
                        </div>
                    </div>
                    <!--<div class="col s12 m6 l4">
                        <h2 class="header">Oferta 2</h2>
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="https://www.superinter.com.co/wp-content/uploads/2014/07/1207-ATUN-VAN-CAMPS184g-LOMITOS-AGUA.jpg">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content">
                                    <p>Descripción de la oferta</p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Ver más...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <h2 class="header">Oferta 3</h2>
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="http://2.bp.blogspot.com/-ippFRalR-vo/Up_g-MCB80I/AAAAAAAAALI/piwWz9kZ124/s1600/monster-energy-drink.jpg">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content">
                                    <p>Descripción de la oferta</p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Ver más...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12 m6 l4">
                        <h2 class="header">Oferta 4</h2>
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="http://images.lider.cl/wmtcl?source=url[file:/productos/707197a.jpg]&sink">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content">
                                    <p>Descripción de la oferta</p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Ver más...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <h2 class="header">Oferta 5</h2>
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="https://cuantoazucar.com/sites/default/files/fichas/card/d7/g021ad7.png">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content">
                                    <p>Descripción de la oferta</p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Ver más...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m6 l4">
                        <h2 class="header">Oferta 6</h2>
                        <div class="card horizontal">
                            <div class="card-image">
                                <img src="https://jumbo.vteximg.com.br/arquivos/ids/160550-230-230/264577.jpg">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content">
                                    <p>Descripción de la oferta</p>
                                </div>
                                <div class="card-action">
                                    <a href="#">Ver más...</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
                </c:when>    
                <c:otherwise>
                    <div class="row"></div>
                    <div class="row"></div>
                    <div class="row">
                        <a class="waves-effect waves-light btn"><i class="material-icons left">cloud_download</i>Descargar reporte</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <%@ include file="layout/footer.jsp" %>

