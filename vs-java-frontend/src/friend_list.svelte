<script>
    import AddList from "./add_friend.svelte";
    import ChatRoom from "./chat_room.svelte";
    let userimgsrc = "./vs-java-frontend/src/images/user.png";
    let addNewVis = false;
    let chatVis = false;
    export let myname;
    
    let friendname = "";
    
    function handler(fname){
        chatVis = !chatVis;
        friendname = fname;
    }

   
</script>

{#if !addNewVis & !chatVis}
    <body>
        <div id="content">
            <!-- we should add newfriend button -->
            <header>
                <h1>FRIENDS</h1>
                <span>
                    <button on:click={() => (addNewVis = !addNewVis)}>
                        <img {userimgsrc} alt="addNew" />
                        <br />New Friend
                    </button>
                </span>
            </header>
            <!-- style-->
            <nav />
            <!-- Main -->
            <main>
                <!-- My Profile -->
                <div>
                    <ul>
                        <li>
                            <img src="/images/me.png" alt="MyprofilePic" />
                            <div class="profile">
                                <p>{myname}</p>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- Each profile Directly connec to chat room-->
                <div>
                    <div class="profile-title">
                        <h2>FRIENDS</h2>
                    </div>
                    <ul>
                        <!--connect to the db-->
                        <button on:click={() => handler("Ellie")}>
                            <li>
                                <!-- svelte-ignore a11y-missing-attribute -->
                                <img {userimgsrc} />
                                <div class="profile">
                                    <p>Ellie</p>
                                </div>
                            </li>
                        </button>
                        <button on:click={() => handler("Florence")}>
                            <li>
                                <!-- svelte-ignore a11y-missing-attribute -->
                                <img {userimgsrc} />
                                <div class="profile">
                                    <p>Florence</p>
                                </div>
                            </li>
                        </button>
                        <button on:click={() => handler("Kate")}>
                            <li>
                                <!-- svelte-ignore a11y-missing-attribute -->
                                <img {userimgsrc} />
                                <div class="profile">
                                    <p>Kate</p>
                                </div>
                            </li>
                        </button>
                        <button on:click={() => handler("Halo")}>
                            <li>
                                <!-- svelte-ignore a11y-missing-attribute -->
                                <img {userimgsrc} />
                                <div class="profile">
                                    <p>Halo</p>
                                </div>
                            </li>
                        </button>
                    </ul>
                </div>
            </main>
        </div>
    </body>
{/if}
{#if addNewVis}
    <AddList />
{/if}
{#if chatVis}
    <ChatRoom friendName={friendname} myName={myname}/>
{/if}

<style>
    /* Contents style in header => go to main-layout.css */
    body {
        font-family: fontello, "Nanum Gothic", sans-serif, Arial;
        background-color: white;
    }
    * {
        box-sizing: border-box;
    }
    /* Contents style in nav => main-layout.cs */
    body {
        margin: 0;
    }

    /* grid container */
    #content {
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
    header {
        grid-area: header;
        position: sticky;
        top: 1.875rem;
        background-color: white;
    }
    header > * {
        line-height: 3.125rem;
        vertical-align: middle;
    }

    /* contents style in header(add friends) */

    header span > button {
        width: 5rem;
        float: right;
        margin-left: 1rem;
        left: 1px;
    }

    h1 {
        font-size: 1.375rem;
        font-weight: bold;
        display: inline;
    }

    /* navigation layout */
    nav {
        grid-area: nav;
        background-color: #8b9d77;
        align-self: start;
        position: sticky;
        top: 0;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        height: 100vh;
    }

    /* Main layout */
    main {
        /* Friend list (layout using flex box) */
        grid-area: main;
        margin-left: 0.125rem;
    }
    ul > button {
        width: 500px;
        background-color: transparent;
        border-color: #b7cc9f;
        border-width: 3px;
    }
    li {
        transition-property: all;
        transition-duration: 1ms;
        transition-timing-function: linear;
        /* transition-delay: 0; */
    }
    li:hover {
        background-color: #f1fbe6;
    }
    li:active {
        /* transition-delay: 0; */
        background-color: #c9d2bf;
    }
    /* Contents style in main */
    main {
        /* Layout of friend list is designed by flex box */
        display: flex;
        flex-wrap: wrap;
        flex-direction: column;
        justify-content: flex-start;
    }
    ul {
        list-style: none;
        padding-left: 0;
        /* delete list-style(unordered list) */
    }

    /* resize of h2, p */
    .profile-title > * {
        font-size: 0.75rem; /* 16px 브라우저 기준 12px 의미*/
        color: gray;
        display: inline-block;
        margin: 0;
    }
    li {
        /* my profiles are designed by flex box */
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        align-items: center;
        padding-bottom: 0.4375rem;
        padding-top: 0.4375rem;
    }
    li > img {
        /* resize profile pic */
        width: 3.125rem;
    }
    .profile > * {
        /* control margin of name and profile pic */
        margin: 0.3125rem; /* 5px (16px 브라우저 기준) */
        margin-left: 0.625rem;
    }
    .profile > *:first-of-type {
        /* change name style */
        font-weight: bold;
        font-size: 0.875rem; /* 16 브라우저 기준 14px */
    }
    .profile-title {
        border-top: 1px solid rgb(202, 200, 200);
        padding-top: 0.625rem;
    }
</style>
