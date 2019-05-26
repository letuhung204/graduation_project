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
	if (re.test(String(email).toLowerCase())) {
		return true;
	} else {
		alert("Please enter the correct email ! ");
		return false;
	}
}

function validateGender() {
	var gender;
	gender = document.getElementById("gender").value;
	if (gender != "male" && gender != "female") {
		alert("Please enter gender is male or female !");
		return false;
	}
	return true;
}
function checkmaxsize() {
	var firstName;
	var lastName;
	var fullName;
	var discription;
	var skill;
	var possition;

	 firstName = document.getElementById("firstname").value;
	 lastName = document.getElementById("lastname").value;
	 fullName = document.getElementById("fullname").value;
	 discription = document.getElementById("discription").value;
	 skill = document.getElementById("skill").value;
	 possition = document.getElementById("possition").value;

	if (firstName.length > 50 || lastName.length > 50) {
		alert("max size of first name and last name is 50 character !");
		return false;
	}
	if (fullName.length > 100 || skill.length > 100
			|| possition.value.length > 100) {
		alert("max size of full name , skill and possition is 100 character !");
		return false;
	}
	if (discription.length > 500) {
		alert("max size of discription is 500 character !");
		return false;
	}
	return true;
}
function checkmaxdepartment(){
	var discription;
	discription = document.getElementById("discription").value;
	if (discription.length > 255) {
		alert("max size of description is 255 character !");
		return false;
	}
	return true;
}
function checkemailissame(){
	var email;
	var accounName;
	email = document.getElementById("email").value;
	accounName = document.getElementById("").value;
	if(email != accounName){
		alert("email của staff phải giống với account name !");
		return false;
	}else{
		return true;
	}
}
