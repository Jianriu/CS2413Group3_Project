<script>
	//export let name;
    //sign up vars
    let sign_name = "";
    let sign_email = "";
    let sign_id = "";
    let sign_pass = "";
    
    //login vars
    let username;
    let pass;
    let result = null
    let signVisible = false;
    let listpageVisible = false;

    //Sends request to the backend server at localhost:5000. This url path is mapped to MyController.java 
    async function login(){
        {let path = "http://localhost:5000/users?username="+ username +"&password="+pass
        const res = await fetch(path,{
            method: 'GET'
        })
        result = await res.text()
        if(result == "true"){
            listpageVisible = true;
            currName = username;
        }
        else{
            alert('wrong username and password');
        }}
    }
    
    async function signup(username,name,pass,email){
    let path = "http://localhost:5000/signup"
    const res = await fetch(path,{
        method: 'POST',
        body: JSON.stringify({
            username: username,
            fullname: name,
            password: pass,
            email: email,
        }),
        headers: {
            "Content-Type": "application/json",
        }
    })
    let result = await res.json()
    if(!result){
        alert("username and/or password must be filled")
    }
    return result;
    }


    import FriendList from './friend_list.svelte';
</script>

<!--FIRST PAGE-->
<!--IF DB confirmed users Open the Chat-->
{#if !listpageVisible}
<body class="login_body">
    {#if !signVisible}
    <div id="login_page">
        <header class="title_header">
            <p>LOG IN</p>
        </header>
        <section class="login_form" id="login_form">
            <form name="loginform">
                <input bind:value={username} type="text" class="id-pw" name="id" alt="EnterID" placeholder="USERNAME" required>
                <input bind:value={pass} type="password" class="id-pw" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                <button type="button" on:click={login}>Submit</button>
            </form>
        </section>
    </div>
    {/if}
    <div class="signUp">
        <section class="signUp_account">
            <label>
                <input type = "checkbox" bind:checked={signVisible}>
                SIGNUP
            </label>
            {#if signVisible}
                <div id="signup_page">
                    <header class="title_header">
                        <p>SIGN UP</p>
                    </header>
                    <section class="signup_form" id="signup_form">
                        <form name="signupform" >
                            <input bind:value = {sign_name} type="text" class="new_info" name="name" alt="EnterName" placeholder="NAME" required>
                            <input bind:value = {sign_email} type="text" class="new_info" name="email" alt="EnterEmail" placeholder="EMAIL" required>
                            <input bind:value = {sign_id} type="text" class="new_info" name="id" alt="EnterID" placeholder="ID" required>
                            <input bind:value = {sign_pass} type="text" class="new_info" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                            <button type="submit" on:click = {signup(sign_id,sign_name,sign_pass,sign_email).then(res => console.log(res))}>Sign Up</button>
                        </form>
                    </section>
                </div>
            {/if}
        </section>
    </div>
</body>
{/if}
<!--Friend List PAGE-->
{#if listpageVisible}
    <FriendList myname= {username}/>
{/if}    


<style>
    /*General*/
    body{
        font-family: fontello, 'Nanum Gothic', sans-serif, Arial;
        background-color: white;
    }
    *{
        box-sizing: border-box;
    }
    a:visited, a:link{
        color: gray;
        text-decoration: none;
    }
    
    /* Log in & Sign up */
    .login_body{
        background-color: #8B9D77;
    }
    .title_header{
        text-align: center;
        font-size: 5rem;
        -webkit-text-fill-color: white;
        margin-top: 12.75rem; 
    }
    form{
        /* Outline of loginform */
        display: flex;
        flex-direction: column;
        justify-content: flex-start; 
        align-items: center;
    
        margin-top: 1.75rem;  
        margin-bottom: 1.875rem;  
    }
    form > *{
        /* specific form design */
        width: 17.19rem;  
        height: 2.5rem;  
        font-size: 1rem;  
    }
    .id-pw, .loginbutton, .newInfo, .signupbutton{
        border: 1px solid rgb(219, 219, 219);
    }
    .loginbutton, #login_form label, .signupbutton, #signup_form label{
        margin-top: 0.3125rem; 
        color: #8B9D77;
    }
    /* sign up button */
    .signUp_account{
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
        color: white;
    }
    </style>    



    