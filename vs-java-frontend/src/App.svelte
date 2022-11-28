<script>
	export let name;
    let username;
    let pass;
    let result = null
    import {fade} from 'svelte/transition';
    let signVisible = false;
    let listpageVisible = false;
	async function loadData(){
				let response = await fetch("http://localhost:8080",{
					method: 'GET'
				});
				console.log(response)
				name = await response.text();

	}
	loadData();

    //Sends request to the backend server at localhost:5000. This url path is mapped to MyController.java 
    async function login(){
        let path = "http://localhost:5000/users?username="+ username +"&password="+pass
        const res = await fetch(path,{
            method: 'GET'
        })
        result = await res.text()
        if(result == "true"){
            listpageVisible = true;
        }
        else{
            alert('wrong username and password');
        }
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
                        <form name="signupform" action="index.html" >
                            <input type="text" class="new_info" name="name" alt="EnterName" placeholder="NAME" required>
                            <input type="text" class="new_info" name="email" alt="EnterEmailS" placeholder="EMAIL" required>
                            <input type="text" class="new_info" name="id" alt="EnterID" placeholder="ID" required>
                            <input type="password" class="new_info" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                            <input type="submit" class="signupbutton" value="Enter" alt="signupBtn">
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
    <FriendList/>
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



    