<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Where Is A Kabinett? | WK</title>
<link rel="stylesheet" href="ressources/css/index-styles.css">
</head>

<body>

	<div class="container">

		<!-- 	Navegation Menü -->
		<nav> <figure> <img src="img/logowk.png" width="150px"
			height="150px" title="Where Is A Kabinett?"> <figcaption>Where
		Is A Kabinett?</figcaption> </figure> <a href="index.jsp">[ Home | </a> <a href="index.jsp">Blog
			|</a> <a href="registrierunguser.jsp">Registier a Kabinett |</a> <a
			href="index.jsp">Contact Us |</a> <a href="index.jsp">About Us ]</a>
		</nav>


		<div id="content1">
			<h4>Lorem ipsum is placeholder text commonly</h4>
			<h5>Hier kommt eine kurze Intro zu einem Blog-Artikel. Artikel
				des Monats</h5>
			<img id="bilderMiddle" alt="Toilet in Norwegen"
				src="img/toiltet1.png">

			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
				eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut culpa
				qui officia deserunt mollit anim id est laborum. <a
					href="index.jsp " style=""> Read More</a>
			</p>
		</div>

		<div id="content2">
			<h4>Display Infos about the location, where the kabinet is
				finded.</h4>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d19461.43861987589!2d13.532166865566927!3d52.43059876403048!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47a8462ec57ed701%3A0xa8ee8209f395cbe5!2sCity%20Toilette!5e0!3m2!1sde!2sde!4v1634753730703!5m2!1sde!2sde"
				width="500" height="300" style="border: 0;" allowfullscreen=""
				loading="lazy"> </iframe>
		</div>


		<div id="content3" class="login-page">
			<h4>
				<p>Do you like send us a short text about your experience with
					picture from a cool kabinett, that you used visit.</p>
				<p>So register now. We'll post your text and picture on your
					blog.</p>
				<p>Don't forget to send the location adress, cause you find a
					kabinett! ;-)</p>
				<p>
					If you was registred, please enter your username or email and clic
					<b>edit</b>
				</p>
			</h4>

			<!-- Eingabe Formular -->
			<form action="QuickRegistrierungServlet" method="post"
				class="login-page">

				<h2>${warnungAnNutzer}</h2>

				<input type="text" id="username" name="username"
					placeholder="username" /> <input type="text" id="emailadresse"
					name="emailadresse" placeholder="e-mail" />
					<input type="submit" value="send" /> 
			</form>
		</div>


		<div id="footer">
			<img alt="" src="img/2021-10-21 20_59_16-Window.png">
		</div>

	</div>



</body>
</html>

