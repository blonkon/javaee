<%-- 
    Document   : login
    Created on : 16 juin 2023, 14:03:35
    Author     : diak.ibrahim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set  var="page" value="1" scope="session"/>
<!DOCTYPE html>
<html lang="Fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <title>Login</title>

</head>
<body>
   <div class="box">
    <div class="container">

        <div class="top">
            <header>Se connecter</header>
        </div>
        <form method="post" action="./accueil">
            <div class="input-field">
                <input type="text" class="input" placeholder="Pseudo" id="" name="pseudo" required>
                <i class='bx bx-user' ></i>
            </div>

            <div class="input-field">
                <input type="Password" class="input" placeholder="Password" id="" name="password" required>
                <i class='bx bx-lock-alt'></i>
            </div>
            
            <input type="hidden"  id="" name="page" value="login">
            
            <div class="input-field">
                <c:if test="${ !logResult }">
                    <p class="error">Donnee invalide</p>
                </c:if>
                <input type="submit" class="submit" value="Login" id="">
            </div>
        </form>
   
    </div>
</div>  
</body>
</html>