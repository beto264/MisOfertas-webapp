<%@ include file="layout/header.jsp" %>

<style>

    .material-icons{
        display: inline-flex;
        vertical-align: top;
    }

</style>

<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center"></a><a href="#"
                                                     data-activates="mobile-demo" class="button-collapse"><i
                class="material-icons">Menú</i></a>
        <ul class="right hide-on-med-and-down">
            <c:choose>
                <c:when test="${rol=='Consumidor'}">
                    <li ><a href="${pageContext.request.contextPath}/home">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados?action=list">Cupones</a></li>
                    <li class=""><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
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
<div class="container"

     <br>
    <br>

    <div class="row">

        <ul class="collapsible popout" data-collapsible="accordion">
            <div class="card">
                <div class="card-content">
                    <span class="card-title">Últimas valoraciones</span>
                </div>
            </div>
            <br>
            <c:forEach items="${valoraciones}" var="element" >
                <li>
                    <div class="collapsible-header active">
                        <c:if test="${element.nota=='Excelente'}">
                            <i class="material-icons">star</i><i class="material-icons">star</i><i class="material-icons">star</i>
                        </c:if>
                        <c:if test="${element.nota=='Buena'}">
                            <i class="material-icons">star</i><i class="material-icons">star</i>
                        </c:if>
                        <c:if test="${element.nota=='Mala'}">
                            <i class="material-icons">star</i>
                        </c:if>
                        &nbsp;&nbsp;¡${element.nota}!</div>
                    <div class="collapsible-body">
                        <i class="material-icons">face</i><span id="txt1">&nbsp;&nbsp;&nbsp;${element.usuarioDTO.nombre} comentó: </span>
                        <div class="row">
                            <div class="col  s6 m6">
                                <div class="card">
                                    <div class="card-content">
                                        <c:if test="${empty element.comentario}">
                                            <p>Sin comentarios.</p>
                                        </c:if>
                                            <c:if test="${not empty element.comentario}">
                                            <p>"${element.comentario}"</p>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="col  s6 m6">
                                <div class="card">
                                    <div class="card-content">
                                        <center><img class="materialboxed" src="<c:url value="boletas/${element.imagen}"></c:url>" width="40%"></center>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>   