<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="Ingreso de consumidores">
        <meta name="author" content="Alberto Tejos S.">

        <title>MisOfertas</title>

        <link rel="stylesheet"
              href="css/materialize.min.css" />

    </head>
    <body>
        <div class="container">
            <div class="row"></div>
            <div class="row"></div>
            <div class="row">
                <div class="col s12 m6 offset-m3 l4 offset-l4">
                    <div class="card">
                        <div class="card-content">
                            <div class="row">
                                <div class="input-field col s12 center">
                                    <img src="img/new_logo.png"
                                         alt="" width="70%"
                                         class="responsive-img valign profile-image-login">
                                </div>
                            </div>
                            <form action="login" method="post">
                                <div class="form-group">

                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input name="correo" type="email" autofocus class="validate"
                                                   required /> <label for="correo"
                                                   data-error="Formato de correo inválido">Correo</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <input name="password" type="password" class="validate"
                                                   required /> <label for="password" class="active">
                                                Contraseña</label>
                                        </div>

                                    </div>

                                    <br>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <button class="btn waves-effect waves-light col s12"
                                                    type="submit">Ingresar</button>
                                        </div>
                                    </div>

                                </div>
                            </form>
                        </div>
                        <div class="card-action">
                            <p>${error}</p>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <p class="margin medium-small">
                                <a href="${pageContext.request.contextPath}/registro">Registrate ahora!</a>
                            </p>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <!--<p class="margin right-align medium-small">
                                <a href="">Olvidaste la contraseña?</a>
                            </p>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="js/validarRUT.js"></script>
        <script src="js/jquery.elevateZoom-3.0.8.min.js"></script>

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

