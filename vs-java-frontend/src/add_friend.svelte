<script>
    import FriendList from './friend_list.svelte';
    
    let userimgsrc = "./vs-java-frontend/src/images/user.png";
    let friendVis = false;
</script>

{#if !friendVis}
<body>
    <div id="content">
        <!-- we should add newfriend button -->
        <header>
            <button on:click={() => friendVis = !friendVis}>ᐸ FRIEND LIST</button>
            <h1>ADD FRIENDS</h1>
        </header>
        <!-- style-->
        <nav>           
        </nav>
        <!-- Main -->
        <main>
            <!-- My Profile -->
            <div>
                <ul>
                    <li>
                        <form name="searchingform" >
                            <input type="text" class="new_friend" name="name" alt="EnterName" placeholder="NAME" required>
                            <input type="submit" class="signupbutton" value="Enter" alt="signupBtn">
                        </form>
                    </li>
                </ul>
            </div>
            <!-- Each profile Directly connec to chat room-->
            <div>
                <div class="profile-title">
                    <h2>VALID</h2>
                </div>
                <!--If there is valid users-->
                <ul>
                    <li>
                        <button>
                            <img src="./pic/default.png">
                        <div class="profile">
                            <p>Ellie</p>
                        </div> 
                        </button>
                    </li>
                    
                </ul>
            </div>
        </main>
    </div>
</body>
{/if}
{#if friendVis}
<FriendList></FriendList>
{/if}

<style>
body{
    font-family: fontello, 'Nanum Gothic', sans-serif, Arial;
    background-color: white;
}
*{
    box-sizing: border-box;
}
/* Contents style in nav => main-layout.cs */
body{
    margin: 0;
}

/* grid container */
#content{
    top: 0;
    left: 0;
    display: grid;
    grid-template-columns: 5rem 1.25rem auto 1.25rem; 
    grid-template-rows: 1.875rem 3.125rem auto 6.25rem;
    gap: 0;
    align-items: stretch;
    /* justify-items: stretch; */
    grid-template-areas:
        "nav  .  setting  setting "
        "nav  .   header     .    "
        "nav  .    main      .    "
        "ad  ad     ad      ad    ";
}


/* Header layout */
header{
    grid-area: header;
    position: sticky;
    top: 1.875rem; 
    background-color: white;
}
header > *{
    line-height: 3.125rem; 
    vertical-align: middle;
}

/* contents style in header(add friends) */


h1{
    position: relative;
    top: -50px;
    left: +5px;
    font-size: 1.375rem; 
    font-weight: bold;
    
}

header > button{
    position: relative;
    top: -30px;
    height: 40px;
    font-size: 0.8rem; 
    font-weight: bold;
    
    color:grey;
    background-color: transparent;
    border-color: transparent;
}

/* navigation layout */
nav{
    grid-area: nav;
    background-color: #8B9D77;
    align-self: start;
    position: sticky;
    top: 0;
    display: flex;
    flex-direction: column;
    justify-content:space-between;
    height: 100vh; 
}

/* Main layout */
main{
    /* Friend list (layout using flex box) */
    grid-area: main; 
    margin-left: 0.125rem;
}
li{
    transition-property: all;
    transition-duration: 1ms;
    transition-timing-function: linear;
    /* transition-delay: 0; */
}
li:hover{
    background-color: rgb(244, 248, 253);
}
li:active{
    /* transition-delay: 0; */
    background-color: rgb(207, 226, 250);
}
/* Contents style in main */
main{
    /* Layout of friend list is designed by flex box */
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    justify-content: flex-start;
}
ul{
    list-style: none;
    padding-left: 0;
    /* delete list-style(unordered list) */
}


/* resize of h2, p */
.profile-title > *{
    font-size: 0.75rem; 
    color: gray;
    display: inline-block;
    margin: 0;
}
li{
    /* my profiles are designed by flex box */
    display: flex;
    flex-direction: row;
    align-items: center;
    padding-bottom: 0.4375rem;
    padding-top: 0.4375rem;
}
.profile > *{
    /* control margin of name and profile pic */
    margin: 0.3125rem; /* 5px (16px 브라우저 기준) */
    margin-left: 0.625rem;
}
.profile > *:first-of-type{
    /* change name style */
    font-weight: bold;
    font-size: 0.875rem; /* 16 브라우저 기준 14px */
} 
.profile-title{
    border-top: 1px solid rgb(202, 200, 200);
    padding-top: 0.625rem;
}
</style>
