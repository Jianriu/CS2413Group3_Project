<body class="signup_body">
    <div id="signup_page">
        <header class="title_header">
            <p>SIGN  UP</p>
        </header>
        <section class="signup_form" id="signup_form">
            <form name="signupform" action="index.html" >
                <input type="text" class="new_info" name="name" alt="EnterName" placeholder="NAME" required>
                <input type="text" class="new_info" name="email" alt="EnterEmailS" placeholder="EMAIL" required>
                <input type="text" class="new_info" name="id" alt="EnterID" placeholder="ID" required>
                <input type="password" class="new_info" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                <input type="submit" class="signupbutton" value="Enter" alt="signupBtn">
                <!--connect to the db-->
            </form>
        </section>
    </div>
</body>

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
.signupbutton{
    border: 1px solid rgb(219, 219, 219);
}
.signupbutton{
    margin-top: 0.3125rem; 
    color: #8B9D77;
}


/* sign up */
</style>

