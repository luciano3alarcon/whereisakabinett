<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="ressources/css/registrierung-styles.css">

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<!-- Wichtig jQuery Tag damit das Seite-Aufladen durch jQuery funktionieren kann -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<title>Knock On The Door | Kabinett</title>
</head>
<body>

	<div class="container">

		<nav> <figure> <img src="img/logowk.png" width="150px"
			height="150px" title="Where Is A Kabinett?"> <figcaption>Where
		Is A Kabinett?</figcaption> </figure> <a href="index.jsp">[ Home | </a> <a href="index.jsp">Blog
			|</a> <a href="index.jsp">Send Us A Kabinett |</a> <a href="index.jsp">Contact
			Us |</a> <a href="index.jsp">About Us ]</a> </nav>

		<div id="content1"></div>

		<div id="content2">

			<from action="quickRegistrierung" method="post" id="registrierunguser"
				onsubmit=" return eingabeValidierung() ? true : false"
				enctype="multipart/form-data"> <!--  Fehlermeldung taucht in den HTML - Künftig wird in Js gewandert. -->

			<h2>${warnungAnNutzer}</h2>

			<table id="tabelleBreit">
				<h3>Please complete your register</h3>
				<tr>
					<td id="linkSpalte">id</td>
					<td id="rechtSpalte"><input type="text" id="id"
						placeholder="id" readonly="readonly" value="${datenNutzer.id}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">username</td>
					<td id="rechtSpalte"><input type="text" id="username"
						placeholder="username" readonly="readonly"
						value="${datenNutzer.username}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">email</td>
					<td id="rechtSpalte"><input type="text" id="email"
						placeholder="email" value="${datenNutzer.emailadresse}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">name</td>
					<td id="rechtSpalte"><input type="text" id="vorname"
						placeholder="vorname" value="${datenNutzer.vorname}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">last name</td>
					<td id="rechtSpalte"><input type="text" id="name"
						placeholder="name" value="${datenNutzer.name}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">city</td>
					<td id="rechtSpalte"><input type="text" id="stadt"
						placeholder="stadt" value="${datenNutzer.stadt}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">gender</td>
					<td id="rechtSpalte"><input type="text" id="geschlecht"
						placeholder="geschlecht" value="${datenNutzer.geschlecht}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">beautifull</td>
					<td id="rechtSpalte"><input type="text" id="beautifll"
						placeholder="beautifull" value="${datenNutzer.beautifull}" /></td>
				</tr>
				<tr>
					<td id="linkSpalte">newsletter</td>
					<td id="rechtSpalte"><input type="text" id="newsletter"
						placeholder="newsletter" value="${datenNutzer.newsletter}" /></td>
				</tr>

				<tr>
					<td><a
						href="EditRegisterServlet?aktion=save&datenNutzer=${datenNutzer.id}"><img
							src="ressources/img/save.png" id="steuerungsbuttons" alt="save" />
					</a> <a href="EditRegisterServlet?aktion=edit&datenNutzer=${datenNutzer.id}">
							<img src="ressources/img/edit_button.png" id="steuerungsbuttons"
							alt="edit" />
					</a> <a href="EditRegisterServlet?aktion=delete&datenNutzer=${datenNutzer.id}"><img
							alt="deleter" src="ressources/img/delete_button.png" id="steuerungsbuttons" > </a></td>
				</tr>

			</table>
			</from>

		</div>

		<div id="content3"></div>

		<div id="footer">
			<img alt="" src="img/2021-10-21 20_59_16-Window.png">
		</div>
	</div>

	<script type="text/javascript">
		function eingabeValidierung() {

			if (document.getElementById("username").value == '') {
				alert('Geben Sie Ihren Username ein.');
				return false;
			}
			return true;
		}

		function loadBearbeitungRegistrierung() {

			$("#loadChildRegistrierung").load("childRegistrierungUser.jsp");

		}
	</script>

</body>
</html>