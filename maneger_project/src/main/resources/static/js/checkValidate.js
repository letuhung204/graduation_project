/**
 * @author LE T.HUNG
 * @creatdate Oct 27, 2018
 * @modifieddate Oct 27, 2018
 * @content check phone number
 */
function checkPhone() {
	var x;
	x = document.getElementById("telephone").value;
	var phoneno = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;
	if (x.match(phoneno)) {
		return true;
	} else {
		alert("Please enter the correct 10-digit phone number format! ");
		return false;
	}
}

function validateEmail() {
	var email;
	email = document.getElementById("email").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(re.test(String(email).toLowerCase())){
    	return true;
    }else{
    	alert("Please enter the correct email ! ");
    	return false;
    }
}
