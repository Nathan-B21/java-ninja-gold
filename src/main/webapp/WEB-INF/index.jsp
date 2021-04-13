<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
<title>ninja gold</title>

</head>
<header>
    <div class="container ml-5">

        <h1 class='container-flex w-25 mt-5 '>Your gold: <c:out value="${totalGold}"/>

        </h1>

    </div>

</header>

<body>

    <div class="container-xl text-center">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title"><h5>Farm</h5></div>
                        <form action="/process_money" method="post">

                            <input type="image" src="img/farm.PNG" class="card-img-top"
                                alt="image of a farm">
                            <input type="hidden" name="location_form" value="farm">

                        </form>

                        <div class="card-text">earns 10-20 gold</div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title"><h5>Cave</h5></div>
                        <form action="/process_money" method="post">

                            <input type="image" src="img/cave.PNG" class="card-img-top" alt="">
                            <input type="hidden" name="location_form" value="cave">
                        </form>
                        <div class="card-text">earns 5-10 gold</div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title"><h5>House</h5></div>
                        <form action="/process_money" method="post">

                            <input type="image" src="img/farm.PNG" class="card-img-top" alt="">
                            <input type="hidden" name="location_form" value="house">
                        </form>
                        <div class="card-text">earns 2-5 gold</div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title"><h5>Casino</h5></div>
                        <form action="/process_money" method="post">
 
                            <input type="image" src="img/casino.PNG" class="card-img-top" alt="">
                            <input type="hidden" name="location_form" value="casino">
                        </form>
                        <div class="card-text">earns/takes 0-50 gold</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-sm">
        <form action="/destory">
            <a href="/destory">reset</a>
        </form>
    </div>
    <div id="lowersection">
        <div class="box">
            <table>

                <tr>
                    <td><c:out value="${activities}"/></td>
                </tr>



            </table>
        </div>
    </div>








</body>
</html>