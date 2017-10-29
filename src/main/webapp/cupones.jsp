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
                    <li><a href="${pageContext.request.contextPath}/certificados">Cupones</a></li>
                    <li class=""><a href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
                    <li><a href="${pageContext.request.contextPath}/logout">Salir</a></li>
                </ul>
                <ul class="side-nav" id="mobile-demo">
                    <li><a href="">Ofertas</a></li>
                    <li><a href="${pageContext.request.contextPath}/certificados">Cupones</a></li>
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
                    <span class="card-title">Cupones generados</span>
                </div>
            </div>
            <br>
            <c:forEach items="${certificados}" var="element" >
                <div class="card">
                    <div class="card-content">
                        <div class="row">
                            <div class="col s6">
                                <span>Fecha emisión: ${element.fechaEmision}</span>
                            </div>
                            <div class="col s2 offset-s1 offset-m2 offset-l3">
                                <a class="waves-effect waves-light btn right-align" href="${pageContext.request.contextPath}/certificados?action=get?id=${element.idCertificado}">Descargar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </ul>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>   