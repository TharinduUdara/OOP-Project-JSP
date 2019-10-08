function ValidateForm()
{
    var username= document.forms["login-form"]["username"].value;
    var error = document.getElementById("error");
    var prefix = username.charAt(0);

    if(prefix == 'S' || prefix == 's' || prefix == 'T' || prefix == 't' || username == "admin" || username == "cashier"){
        error.innerHTML = "";
        error.className = ""
        return(true);
    }
    else{
        error.innerHTML = "Error: Invalid username";
        error.className = "error"
    }    
    return false;
}