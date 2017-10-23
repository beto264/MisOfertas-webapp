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

<footer class="page-footer">
    <div class="container">
        <div class="row">
            <div class="col l6 s12">
                <h5 class="white-text"></h5>
                <p class="grey-text text-lighten-4"></p>
            </div>
            <div class="col l4 offset-l2 s12">
                <h5 class="white-text"></h5>
                <ul>
                    <!--<li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>-->
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            © 2017 MisOfertas
            <!--<a class="grey-text text-lighten-4 right" href="#!">More Links</a>-->
        </div>
    </div>
</footer>
</body>
</html>
