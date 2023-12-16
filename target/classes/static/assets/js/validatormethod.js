$.validator.addMethod("strong_password", function(value, element) {
	let password = value;
	if (!(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&])(.{8,20}$)/.test(password))) {
		return false;
	}
	return true;
}, function(value, element) {
	let password = $(element).val();
	if (!(/^(.{8,20}$)/.test(password))) {
		return 'Password must be between 8 to 20 characters long.';
	}
	else if (!(/^(?=.*[A-Z])/.test(password))) {
		return 'Password must contain at least one uppercase.';
	}
	else if (!(/^(?=.*[a-z])/.test(password))) {
		return 'Password must contain at least one lowercase.';
	}
	else if (!(/^(?=.*[0-9])/.test(password))) {
		return 'Password must contain at least one digit.';
	}
	else if (!(/^(?=.*[@#$%&])/.test(password))) {
		return "Password must contain special characters from @#$%&.";
	}
	return false;
});


$.validator.addMethod("phonenumber_valid", function(value, element) {
	var filter = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;    
    if (filter.test(value)) {
        return true;
    }
    else {
        return false;
    }
});