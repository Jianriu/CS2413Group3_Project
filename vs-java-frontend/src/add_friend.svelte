<style>
    /* Contents style in header => go to main-layout.css */

/* Contents style in nav => main-layout.cs */

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
li > img{
    /* resize profile pic */
    width: 3.125rem;
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

<html lang="eng" data-dark="false">
    <head>
        <meta charset="utf-8">
        <title>Simple Encrypt Chatting</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="description" content="Simple Encrypt Chatting New Friend View">
        <meta name="keywords" content="Chatting, Encrypt">
        <meta name="robotos" content="noindex, nofollow">
        <link rel="stylesheet" href="CSS/main-layout.css">
        <link rel="stylesheet" href="CSS/general.css">
        <link rel="stylesheet" href="fontello/css/fontello.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="content">
            <!-- we should add newfriend button -->
            <header>
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
</html>