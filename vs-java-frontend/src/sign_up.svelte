<script>
	export let name;
	async function loadData(){
				let response = await fetch("http://localhost:5000",{
					method: 'GET'
				});
				console.log(response)
				name = await response.text();

	}
	loadData();
</script>

<style>
    /* Only for styling sign up (almost same version as login*/

.signup_body{
    background-color: #8B9D77;
}
.title_header{
    text-align: center;
    font-size: 5rem;
    -webkit-text-fill-color: white;
    margin-top: 12.75rem; 
}

/* border for left of the 2nd element */
.setting_bar > *:nth-child(2){
    border-left: 1px solid rgb(163, 163, 163);
    padding-left: 0.625rem; /* browser fontSize 16px standard : 10px */
}

/* Outline of loginform */
form[name="signupform"]{
    display: flex;
    flex-direction: column;
    justify-content: flex-start; 
    align-items: center;

    margin-top: 1.75rem;  
    margin-bottom: 1.875rem;  
}

/* specific design */
form[name="signupform"] > *{
    width: 17.19rem;  
    height: 2.5rem;  
    font-size: 1rem;  
}
.newInfo, .signupbutton{
    border: 1px solid rgb(219, 219, 219);
}
.signupbutton, #signup_form label{
    margin-top: 0.3125rem; 
    color: #8B9D77;
}
.newInfo:focus::placeholder{
    color: transparent;
    /* When sign up button is clicked, remove placeholder */
}

/* sign up */
.signUp_account{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    color: gray;
}
</style>

<html lang="eng" data-dark="false">
    <head>
        <meta charset="utf-8">
        <title>Simple Encrypt Chatting</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Simple Encrypt Chatting Signup View">
        <meta name="keywords" content="Chatting, Encrypt, Login">
        <meta name="robots" content="noindex,nofollow">
        <link rel="stylesheet" href="CSS/general.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    </head>
    <body class="signup_body">
        <div id="signup_page">
            <header class="title_header">
                <p>SIGN UP</p>
            </header>
            <section class="signup_form" id="signup_form">
                <form name="signupform" action="index.html" >
                    <input type="text" class="new_info" name="name" alt="EnterName" placeholder="NAME" required>
                    <input type="text" class="new_info" name="email" alt="EnterEmailS" placeholder="EMAIL" required>
                    <input type="text" class="new_info" name="id" alt="EnterID" placeholder="ID" required>
                    <input type="password" class="new_info" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                    <input type="submit" class="signupbutton" value="Enter" alt="signupBtn">
                </form>
            </section>
        </div>
    </body>
</html>