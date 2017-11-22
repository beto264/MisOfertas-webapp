<%@ include file="layout/header.jsp" %>

<style>

    .material-icons{
        display: inline-flex;
        vertical-align: top;
    }

</style>

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
                    <span class="card-title">Cupón generado este mes</span>
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
                            <div class="col s2 offset-m2 offset-l3">
                                <a class="waves-effect waves-light btn right-align" href="${pageContext.request.contextPath}/cupon?idCupon=${element.idCertificado}">Ver</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </ul>
    </div>
</div>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script src="js/materialize.min.js"></script>
<script src="js/validarRUT.js"></script>
<script src="js/jquery.elevateZoom-3.0.8.min.js"></script>



<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAwCJwc27SDv8JI_WXk2FUdco_ca5pwx3E&callback=initMap">
</script>

<script type="text/javascript">

    $(document).ready(function () {
        $('.collapsible').collapsible();
    });

    $(document).ready(function () {
        $('select').material_select();
    });

    $(document).ready(function () {
        $(".button-collapse").sideNav();
        $('.modal').modal({
            dismissible: true, // Modal can be dismissed by clicking outside of the modal
            opacity: .5, // Opacity of modal background
            inDuration: 300, // Transition in duration
            outDuration: 200, // Transition out duration
            startingTop: '4%', // Starting top style attribute
            endingTop: '10%', // Ending top style attribute
            ready: function (modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
                var id = trigger.data('id');
                alert(id);
                console.log(modal, trigger);
            },
            complete: function () {

            } // Callback for Modal close
        }
        );
    });

    $('[data-click]').on('click', function (e) {
        initMap();
    });
    
    

</script>

  <script>
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 16,
                // center: latLng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            });

            var bounds = new google.maps.LatLngBounds();

        <c:forEach var="element" items="${tiendas}" varStatus="status">
            var latLng = new google.maps.LatLng(<c:out value="${element.latitud}"/>, <c:out value="${element.longitud}"/>);

            bounds.extend(latLng);

            var windowDialog = new google.maps.InfoWindow({
                content: "content display dialog"
            });

            var marker = new google.maps.Marker({
                position: latLng,
                map: map,
                animation: google.maps.Animation.DROP,
            });

            marker.addListener('click', toggleBounce);

            function toggleBounce() {
                if (marker.getAnimation() !== null) {
                    marker.setAnimation(null);
                } else {
                    marker.setAnimation(google.maps.Animation.BOUNCE);
                }
            }
            google.maps.event.addListener(marker, 'click', function () {
                window.location.href = 'https://www.google.com/maps/search/?api=1&query=<c:out value="${element.latitud}"/>,<c:out value="${element.longitud}"/>';
            });

        </c:forEach>

            map.fitBounds(bounds);
        }

    </script>


</body>
</html>
 