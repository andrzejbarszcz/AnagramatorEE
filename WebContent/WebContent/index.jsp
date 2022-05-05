
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Anagramator</title>
<link rel="Stylesheet" href="resources/css/default.css">
</head>
<body>
	<h2>Anagramator</h2>
	<h3>Program wyszukuje wszystkie 7-literowe słowa na podstawie podanych liter</h3>
	<h3>Dopuszcza się zastąpienie 1 litery znakiem ? - traktowanym jako "blank"</h3>

	<form name="insertWord" action="ControllerServlet" method="post" onsubmit="return validation()" >
		<table>
				<tr>
					<td>tu wpisz 7 liter</td>
					<td><input type="text" name="slowoWejsciowe" value=""></td>
				</tr>
			
				<tr>
					<td></td>
					<td><input type="submit" value="Prześlij"></td>
				</tr>
			
		</table>
	</form>
	
	<script type="text/javascript">
	function validation() {
		var x = document.forms["insertWord"]["slowoWejsciowe"].value;
		if(x == null || x.length != 7 ){
			alert("wyraz powinien mieć 7 znaków");
			return false;
		}		
	}
	
	</script>
</body>
</html>