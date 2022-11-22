<script>
	export let name;
	async function loadData(){
				let response = await fetch("http://localhost:8080",{
					method: 'GET'
				});
				console.log(response)
				name = await response.text();

	}
	loadData();

    import {fade} from 'svelte/transition';
    let signVisible = false;
    let listpageVisible = false;

    import FriendList from './friend_list.svelte';
    import SignUp from './sign_up.svelte';

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
            <form name="loginform"  method="post">
                <input type="text" class="id-pw" name="id" alt="EnterID" placeholder="ID" required>
                <input type="password" class="id-pw" name="pwd" alt="EnterPW" placeholder="PASSWORD" required>
                <!--connect to the db-->
                <button on:click={() => listpageVisible = true}> Enter </button> 
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
                <SignUp></SignUp>
            {/if}
        </section>
    </div>
</body>
{/if}

{#if listpageVisible}
    <FriendList></FriendList>
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
    .id-pw{
        border: 1px solid rgb(219, 219, 219);
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
    