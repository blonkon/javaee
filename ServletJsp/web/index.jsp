<%-- 
    Document   : index
    Created on : 16 juin 2023, 13:56:30
    Author     : diak.ibrahim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="Fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- <link rel="stylesheet" href="style.css"> -->
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

    <title>Inscription</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;800&display=swap');
*{
    font-family: 'poppins' ,sans-serif;
}
.error{
    color:red;
    font-size: smaller;
    margin: 1px;
    padding: 1px;
    text-align: center;
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
    min-height: 90vh;
}
.container{
    width: 350px;
    display: flex;
    flex-direction: column;
    padding: 0 15px 0 15px;
    
}
span{
    color: #fff;
    font-size: small;
    display: flex;
    justify-content: center;
    padding: 10px 0 10px 0;
}
header{
    color: #fff;
    font-size: 30px;
    display: flex;
    justify-content: center;
    padding: 10px 0 10px 0;
}

.input-field .input{
    height: 45px;
    width: 87%;
    border: none;
    border-radius: 30px;
    color: #fff;
    font-size: 15px;
    padding: 0 0 0 45px;
    background: rgba(255,255,255,0.1);
    outline: none;
}
i{
    position: relative;
    top: -33px;
    left: 17px;
    color: #fff;
}
::-webkit-input-placeholder{
    color: #fff;
}
.submit{
    border: none;
    border-radius: 30px;
    font-size: 15px;
    height: 45px;
    outline: none;
    width: 100%;
    color: black;
    background: rgba(255,255,255,0.7);
    cursor: pointer;
    transition: .3s ;
}
.submit:hover{
    background-color: gold;
	color: #fff;
    box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}

.link{
    padding: 15px 5px 10px 0;
    font-weight: bolder;
    float: right;
}

.link a {
    color:aliceblue;
    text-decoration: none;
}

.link a:hover{
    color: gold;
}
    </style>

</head>
<body>
   <div class="box">
    <div class="container">

        <div class="top">
            <header>S'inscrire</header>
        </div>
        <form method="post" action="./accueil">
            <div class="input-field">
                <input type="text" class="input" placeholder="Nom" id="" name="nom" required>
                <i class='bx bx-user' ></i>
            </div>

            <div class="input-field">
                <input type="text" class="input" placeholder="Prenom" id="" name="prenom" required>
                <i class='bx bx-user' ></i>
            </div>

            <div class="input-field">
                
                <c:if test="${ pseudoError }">
                    <p class="error">Quelqu'un utilise deja cet Pseudo</p>
                </c:if>
                <input type="text" class="input" placeholder="Pseudo" id="" name="pseudo" required>
                <i class='bx bx-user' ></i>
            </div>

            <div class="input-field">
                <input type="email" class="input" placeholder="Email" id="" name="email" required>
                <i class='bx bx-envelope'></i>
            </div>

            <div class="input-field">
                <c:if test="${ passwordError }">
                <p class="error">Verifier vos mot de passe</p></c:if>
                <input type="Password" class="input" placeholder="Mot de passe" id="" name="password" required>
                <i class='bx bx-lock-alt'></i>
            </div>

            <div class="input-field">
                <input type="Password" class="input" placeholder="Repeter mot de passe" id="" name="repassword" required>
                <i class='bx bx-lock-alt'></i>
            </div>
            
            <input type="hidden"  id="" name="page" value="index">
            
            <div class="input-field">
                <input type="submit" class="submit" value="Login" id="">
            </div>
        </form>
        <div class="link">
            <a href="./login">Se connecter</a>
        </div>

    </div>

</div>  

</body>
</html>
