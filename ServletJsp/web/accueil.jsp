<%-- 
    Document   : accueil
    Created on : 16 juin 2023, 14:02:15
    Author     : diak.ibrahim
--%>

<%@page import="moi.Infos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="Fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="style.css"> -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <title>Bienvenue</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;800&display=swap');
*{
    font-family: 'poppins' ,sans-serif;
}
body{
    background-image: url("images/1.jpg");
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    background-repeat: no-repeat;
    
}
.box{
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 80vh;
}
.container{
    width: 350px;
    display: flex;
    flex-direction: column;
    padding: 0 15px 0 15px;
    
}
.bienvenue{
	font-size: 60px;
	width: 100%;
	font-weight: bolder;
}
header{
    color: #fff;
    font-size: 30px;
    display: flex;
    justify-content: center;
    padding: 10px 0 10px 0;
}
.liste{
	height: 200px;
    border-radius: 20px;
	background: rgba(255, 255, 255, 0.185);
	overflow: auto;
}
li{
	list-style: none;
	text-align: center;
	height: 20px;
    width: 80%;
    border: none;
    color: #fff;
    font-size: 15px;
    padding: 5%;
}

::-webkit-input-placeholder{
    color: #fff;
}
.log{
	margin-top: 20px;
	text-align: center;
}
.logout{
    border: none;
    border-radius: 50px;
	text-decoration: none;
    font-size: 15px;
    height: 50px;
	font-weight: bold;
    outline: none;
	padding: 10px;
    width: 100%;
    color: black;
    background: rgba(255,255,255,0.7);
    cursor: pointer;
    transition: .3s ;
}
.logout:hover{
	background-color: gold;
	color: #fff;
    box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}

    </style>

</head>
<body>
    <header class="bienvenue">Bienvenue cher Mr.<c:out value="${pseudo}"/></header>
   <div class="box">
    <div class="container">
        <div class="top">
            <header>Liste des Inscrits </header>
        </div>
        <ul class="liste">
            <% List<Infos> liste = (List<Infos>) request.getAttribute("liste"); %>

            <% for (Infos personne : liste) { %>
            <li class="list"> <%= personne.getNom() %> 
            <%= personne.getPrenom() %> </li>
            <% } %>
		</ul>

        <div class="log">
            <a class="logout" href="./login">Se deconnecter</a>
        </div>
    </div>
</div>  

</body>
</html>