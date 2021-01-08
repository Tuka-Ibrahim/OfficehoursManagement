<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<script>
/* Function to Generat Captcha */  
function GenerateCaptcha() {  
    var x = Math.ceil(Math.random() * 15) + '';  
    var y = Math.ceil(Math.random() * 15) + '';  
    var z = Math.ceil(Math.random() * 15) + '';  
    var str = new Array(4).join().replace(/(.|$)/g, function () { return ((Math.random() * 36) | 0).toString(36)[Math.random() < .5 ? "toString" : "toUpperCase"](); });  
    var captchaCode = str + x + ' ' + y + ' ' + z;  
    document.getElementById("txtCaptcha").value = captchaCode  
}
/* Validating Captcha Function */  
function ValidCaptcha() {  
    var string1 = removeSpaces(document.getElementById('txtCaptcha').value);  
    var strint2 = removeSpaces(document.getElementById('txtCompare').value);  

    if (string1 == string2) 
    {	
    return true;
    }
    else
    {
    alert("Input is not valid");
    return false;  
}  
}
/* Remove spaces from Captcha Code */  
function removeSpaces(string) {  
    return string.split(' ').join('');  
}  

	

</script>
</head>

<body onload="GenerateCaptcha()"> 
			<form>
            <div style="border: 2px solid gray; width: 700px;">   
	        <input type="text" id="txtCompare"/>  
	        <input type="text" id="txtCaptcha" style="text-align: center; border: none; font-weight: bold; font-size: 20px; font-family: Modern" />  
	        <input type="button" id="btnrefresh" value="Refresh" onclick="GenerateCaptcha();" />  
	        <input type="submit" id="btnValid" type="button" value="I'm not a robot" onclick="alert(ValidCaptcha());" />  
	        <br/>  
	        <br/> 
	        </div>
            <br/></br>
	        </form>

</body>
</html>