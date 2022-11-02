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
    font-size: 0.75rem; /* 16px 브라우저 기준 12px 의미*/
    color: gray;
    display: inline-block;
    margin: 0;
}
li{
    /* my profiles are designed by flex box */
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
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
        <meta name="description" content="Simple Encrypt Chatting Friend List View">
        <meta name="keywords" content="Chatting, Encrypt, List">
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
                <h1>FRIENDS</h1>
                <span>
                    <a href = add_user.html>
                        <img src="./pic/add-user.png" alt="profilePic">
                    </a>
                </span>
                
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
                            <img src="./pic/me.png" alt="profilePic">
                                <div class="profile">
                                    <p>Hero</p>
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
                        <li>
                            <img src="./pic/default.png">
                            <div class="profile">
                                <p>Ellie</p>
                            </div>
                        </li>
                        <li>
                            <img src="./pic/default.png" >
                            <div class="profile">
                                <p>Florence</p>
                            </div>
                        </li>
                        <li>
                            <img src="./pic/default.png">
                            <a href = chat_room.html>
                                <div class="profile">
                                    <p>Leo</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <img src="./pic/default.png">
                            <div class="profile">
                                <p>Mama</p>
                            </div>
                        </li>
                    </ul>
                </div>
            </main>
        </div>
    </body>
</html>