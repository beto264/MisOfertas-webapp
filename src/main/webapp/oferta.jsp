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
    <a href="${pageContext.request.contextPath}/valoraciones?id=${oferta.idOferta}"  class="btn pulse" value="Ver valoraciones">Ver valoraciones</a>
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

            <div class="card">
                <div class="card-content">
                    <div class="row">
                        <form action="valoraciones" method="post" enctype="multipart/form-data">
                            <span class="card-title">Califica esta oferta</span>
                            <br>
                            <div class="input-field col s3 m3">
                                <select name="nota" required>
                                    <option value="Excelente"  selected>Excelente</option>
                                    <option value="Buena">Buena</option>
                                    <option value="Mala">Mala</option>
                                </select>
                                <label>Nota</label>
                            </div>
                            <div class="file-field input-field col s9 m9">
                                <div class="btn">
                                    <span>Boleta</span>
                                    <input type="file" name="dataFile" required oninvalid="this.setCustomValidity('Debes adjuntar una fotografía de la boleta')"
                                           oninput="setCustomValidity('')">
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text" name="image">
                                </div>
                            </div>
                            <input type="hidden" name="id_oferta" value="${oferta.idOferta}">
                            <input type="hidden" name="rut" value="${usuario.rut}">
                            <div class="input-field col s12">
                                <textarea id="comentario" name="comentario" class="materialize-textarea" maxlength="400" required></textarea>
                                <label for="comentario">Comentario</label>
                            </div>
                    </div>
                </div>
                <div class="card-action">
                    <div class="field input-field right-align">
                        <input type="submit" class="btn pulse" value="Enviar valoración">
                        </form>
                    </div>
                    <br>
                    <!--<div id="card-alert" class="card red">
                        <div class="card-content white-text">
                            <p><i class="mdi-alert-error"></i> DANGER : You have done 5 actions.</p>
                        </div>
                    </div>-->
                </div>
            </div>
        </div>
        <div class="col  s6 m6">
            <div  class="card">
                <div class="card-content">
                    <span class="card-title">Información de la oferta</span>
                    <div class="card-stacked">
                        <br>
                        <p>${oferta.descripcion}</p>
                        <br>
                        <div class="chip">
                            <i class="material-icons" style="font-size: 13px">local_offer</i>
                            Descuento: $${oferta.descuento}
                        </div>
                        <div class="chip">
                            <i class="material-icons" style="font-size: 13px">attach_money</i>
                            Valor final: $${oferta.valorFinal}
                        </div>
                        <div class="chip">
                            <i class="material-icons" style="font-size: 13px">remove_red_eye</i>
                            Visualizaciones: ${oferta.visitas}
                        </div>
                        <div class="chip">
                            <i class="material-icons" style="font-size: 13px">star</i>
                            Valoraciones: ${oferta.valoraciones}
                        </div>
                        <div class="chip">
                            <i class="material-icons"style="font-size: 13px">face</i>
                            Publicado por: ${oferta.publicador.nombre}
                        </div>
                        <br>
                        <br>
                        <div class="row">
                            <c:forEach items="${tiendas}" var="element" >

                            </c:forEach>
                            <ul class="collapsible" data-collapsible="accordion">
                                <li>
                                    <div class="collapsible-header" id="master" data-click="remap"s>
                                        <i class="material-icons">store</i> Mapa de tiendas </div>
                                    <div >
                                        ${element.nombre}
                                        ${element.latitud}
                                        ${element.longitud}
                                        <span class="badge"></span>
                                        <div id="map"></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>


                </div>
            </div>

        </div>
    </div>
</div>
</div>


<%@ include file="layout/footer.jsp" %>        