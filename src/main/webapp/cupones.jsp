<%-- 
    Document   : cupones
    Created on : 25/10/2017, 02:18:33 PM
    Author     : Beto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina no encontrada</title>
        <style type="text/css">
            body { margin: 0px; }

            .background {
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
            }

            /* 
            http://jsfiddle.net/6KaMy/1/
            is there a better way than the absolute positioning and negative margin.
            It has the problem that the content will  will be cut on top if the window is smalller than the content.
            */

            .content {
                width: 900px;
                height: 500px;

                position:absolute;
                left:0; right:0;
                top:0; bottom:0;
                margin:auto;

                max-width:100%;
                max-height:100%;
            }

            -->
        </style>
    </head>
    <body>
        <div class="background">
            <div class="content">
            <img class="center-align" src="img/404.jpg"/>
            </div>
        </div>
    </body>
</html>
