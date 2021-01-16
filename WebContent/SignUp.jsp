<!DOCTYPE html>  
<html>  
<head> 
<link rel="stylesheet" type="text/css" href="style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>  
<body onload="GenerateCaptcha()">
		<div class="body">
		<ul>
		 <li><a href="#Contact">Contact</a></li>
		 <li><a href="#Support">Support</a></li>
		 <li><a href="#Why US">Why us</a></li>
		 <li><a href="#Services">Services</li>
		 <li><a href="#about Us" >About us</a></li>
		 <li><a href="#Home">Home</a></li>
		 <li style="float:left; padding: 10px 10px 10px 50px;"><a style="font-size:30px;" href="#booking">Booking.com</a></li>
		</ul>
		</div>
		<script src="validationForm.js"></script>
		 	<form name="signUpform" onsubmit="return validateRegisterForm()" action="SendMail" method="post">
			<label>First name:</label> 
            <input type="text" name="fname" id="fname"> 
            <br/></br> 
            <label>Last name:</label>
            <input type="text" name="lname" id="lname"> 
            <br/></br> 
            <label>Email address:</label>
            <input type="email" name="email" id="email">
            <br/></br> 
            <input type="radio"  id="Student" name="typeofUsers" value="Student">
			<label for="Client">Student</label><br>
			<input type="radio" id="Doctor" name="typeofUsers" value="Doctor">
			<label for="Admin">Doctor</label><br>
			<input type="radio" id="Assitant" name="typeofUsers" value="Assistant">
			<label for="Admin">Assistant</label><br>
            <div style="border: 2px solid gray; width: 700px;">   
	        <input type="text" id="txtCompare"/>  
	        <input type="text" id="txtCaptcha" style="text-align: center; border: none; font-weight: bold; font-size: 20px; font-family: Modern" />  
	        <input type="button" id="btnValid"  value="I'm not a robot" onclick="alert(ValidCaptcha());" />  
	        <input type="submit" id="btn" value="Sign up" ></input>
	        <br/>  
	        <br/> 
	        </div>
	        <p>Already have an account?</p>
           	<a href="Home.jsp">Login</a>
	        </form>
	        <script>
	        /* Function to send data to servlets to check if the user already exists or not */
	    	$(document).ready(function(){
	    	 $('#btnValid').click(function(){
	            var email = $('#email').val();
	            var fname = $('#fname').val();
	            var lname = $('#lname').val();
	            var users= $('input[name="typeofUsers"]:checked').val();
	                  $.ajax({
	        		  type: 'POST',
	        		  url: "validate",
	        		  data: {
	        		mail: email,
	              	firstname: fname,
	              	lastname: lname,
	              	typeofusers: users,
	        		  },
	        		  success: function( response ) {
	        			alert(response);
	        	  		  },
	        	  		  error:function(data,status,er,response) {
	        	  		   }
	        	});
	        		 });
	        		});	
	              /*
	            /*
	            $.post("validate",{
	            	
	            },function(){
	            	alert(status);
	            });
	        
	    	*/
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
	    var string2 = removeSpaces(document.getElementById('txtCompare').value);  
	    if (string1 == string2) 
	    {	
	    return true;
	    }
	    else
	    {
	    return false;  
		}  
	}
	/* Remove spaces from Captcha Code */  
	function removeSpaces(string) {  
	    return string.split(' ').join('');  
	} 
	</script>
</body>  
</htm>