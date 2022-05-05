<%@page import="anagramator.bean.AnagramatorBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="anagramatorBean" scope="request" class="anagramator.bean.AnagramatorBean" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wynik</title>
<link rel="Stylesheet" href="resources/css/default.css">
</head>
<body>
	<h2>Lista ułożonych słów</h2>
	<p>
	na podstawie slowa wejsciowego : 
	<jsp:getProperty property="slowoWejsciowe" name="anagramatorBean"/>
	</p>
	
	<ul>
		
		<%
			String[] znalezioneSlowa =
				anagramatorBean.getWyjsciowaListaSlow();
			
			for(int i=0; i < znalezioneSlowa.length; i++){
			
		%>
		<li> <%= znalezioneSlowa[i] %> </li>
		<% } %>
		
		
	</ul>
	
	<a href="index.jsp"><button value="Nowe wyszukiwanie">Nowe wyszukiwanie</button> </a>
	
	
</body>
</html>