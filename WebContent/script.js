/*Function to validate form for signup form inputs */
function validateRegisterForm(){
	var fname = document.forms["signUpform"]["fname"].value;
	var lname = document.forms["signUpform"]["lname"].value;
 	var email = document.forms["signUpform"]["email"].value;
 	if (fname == "") {
 		alert("Firstname must be filled out");
 			return false;
		 }
 	if (lname == "") {
 		alert("Lastname must be filled out");
 			return false;
		}
	if (email == "") {
 		alert("Email must be filled out");
 			return false;
		}
	}
	/*Function to validate form for signin form inputs */
	function validateForm(){
	var fname = document.forms["signInform"]["fname"].value;
	var lname = document.forms["signInform"]["lname"].value;
 	var email = document.forms["signInform"]["email"].value;
	var pass  = document.forms["signInForm"]["password"].value;
 	if (fname == "") {
 		alert("Firstname must be filled out");
 			return false;
		 }
 	if (lname == "") {
 		alert("Lastname must be filled out");
 			return false;
		}
	if (email == "") {
 		alert("Email must be filled out");
 			return false;
		}	
	if (y == "") {
 		alert("Password must be filled out");
 			return false;
 		}
	}
	
	/*$(document).ready(function(){
		    $("button").click(function(){
		        $.ajax({method:"post",url: "validate", success: function(result,status,xhr){
		            $("#div1").html(result);
		            console.log(status);
		            console.log(xhr);
		        }});
		    });
		});*/
	/*$(document).ready(function(){
        $("input").keyup(function(){
            var email = $("input").val();
            $.get("", {suggest: email}, function(result,status){
                  $("span").html(result);
            });
        });});
*/