<body>
    <div id="chat-body">
        <!-- Chat profile -->
        <header>
            <img class="profile-img" src="./pic/default.png" alt="LeoDefault">
            <div class="profile-col">
                <span class="profile-name">Leo</span>
            </div>
        </header>
        <main>                
            <!-- Chat content -->
            <div class="chat-content">
                <!-- Date
                <div class="date-line">
                    <time datetime="2022-10-31"></time>
                </div>
                -->
                <!-- chat -->
                <div class="main-chat">
                    <div class="friend-chat">
                        <img class="profile-img" src="./pic/default.png" alt="LeoProfile">
                        <div class="friend-chat-col">
                            <span class="profile-name">Leo</span>
                            <span class="balloon">Hello~ excuse me~</span>
                            <span class="balloon">HII</span>
                        </div>
                        <time datetime="09:00:00+09:00">9:00 </time>
                    </div>
                    <div class="me-chat">        
                        <div class="me-chat-col">
                            <span class="balloon">hello </span>
                        </div>
                        <time datetime="09:30:00+09:00">9:30</time>
                    </div>
                    <div class="friend-chat">
                        <img class="profile-img" src="./pic/default.png" alt="LeoProfile">
                        <div class="friend-chat-col">
                            <span class="profile-name">Leo</span>
                            <span class="balloon">what are you doning~</span>
                        </div>
                        <time datetime="09:00:00+09:00">9:00 </time>
                    </div>
                </div>
            </div>
            <!-- Enter the chat -->
            <div class="insert-content">
                <form name="chatform" method="post">
                    <textarea name="chat-insert" required></textarea>
                    <input type="submit" class="chat-submit" value="SEND">
                </form>
            </div>
        </main>
    </div>
</body>


<style>
    /*only for chatting*/

body{
    margin: 0; 
}

/* grid container */
#chat-body{
    top: 0;
    left: 0;
    display: grid;
    grid-template-columns: minmax(3.125rem, auto) 6.25rem;
    grid-template-rows: 2.5rem 2.5rem auto;
    align-items: stretch;
    grid-template-areas:
        " header   setting  "
        " header  main_menu "
        "  main     main    ";
}

/* backgroud setting */
#chat-body, .main-menu, header{
    background-color: #8B9D77;
    background-repeat: repeat;
    background-position: top left;
    background-attachment: fixed;
    z-index: 98;
}

/* profile pic, name */
header{
    grid-area: header;
    padding-top: 0.9375rem;
    padding-bottom: 0.9375rem;
    position: sticky;
    top: 0;
    display: flex;
    flex-direction: row;
    align-items: center;
    margin-left: 0.625rem;
}
.profile-col{
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
}
.profile-img{
    width: 3.125rem;
    margin-right: 0.625rem;
}
header *{
    font-size: 0.8125rem;
    font-weight: bold;
    color:white;
}
.profile-name{
    font-size: 0.8125rem;
}

/* main(each chatting bubble content) */
main{
    /* chatting flex box */
    grid-area: main;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
}

/* main */
.chat-content{
    margin-left: 0.625rem;
    margin-right: 0.625rem;
}

/* common bubble style */
.friend-chat-col, .me-chat-col{
    display: flex;
    flex-direction: column;
    position: relative;
}

/* friend chat bubble flex layout */
.friend-chat{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: stretch;
    margin-top: 0.3125rem;
    margin-bottom: 0.3125rem;
}
.friend-chat > .profile-img{
    align-self: flex-start;
}
.friend-chat-col > .balloon{
    margin-top: 0.3125rem;
    padding: 0.4375rem;
    border: 1px solid rgb(228, 233, 230);
    border-radius: 0.1875rem;
    background-color: rgb(228, 233, 230);
    font-size: 0.8125rem;
    color: black;
}
.friend-chat-col > .balloon::before{
    content: "";
    border-bottom: 0.6875rem solid transparent;
    border-right: 0.6875rem solid rgb(228, 233, 230);
    position: absolute;
    top: 1.563rem;
    left: -0.5rem;
}


/* my chat flex layout */
.me-chat{
    display: flex;
    flex-direction: row-reverse;
    justify-content: flex-start;
    align-items: flex-start;
    margin-right: 0.625rem;
    margin-top: 0.3125rem;
    margin-bottom: 0.3125rem;
}
.me-chat-col > .balloon{
    margin-top: 0.3125rem;
    padding: 0.4375rem;
    border: 1px solid rgb(94, 122, 100);
    border-radius: 0.1875rem;
    background-color: rgb(94, 122, 100);
    font-size: 0.8125rem;
    color: white;
}
.me-chat-col > .balloon::before{
    content: "";
    border-bottom: 0.6875rem solid transparent;
    border-left: 0.6875rem solid rgb(94, 122, 100);
    position: absolute;
    top: 0.625rem;
    right: -0.5rem;
}

/* time align*/
.main-chat time{
    align-self: flex-end;
    flex-basis: 3.75rem;
    flex-shrink: 0;
    margin-left: 0.3125rem;
    margin-right: 0.3125rem;
    font-size: 0.75rem;
    color: rgb(88, 88, 88);
    text-align: center;
}
.friend-chat > time{
    margin-right: 2.5rem;
}
.me-chat > time{
    margin-left: 2.5rem;
}

/* (date-line) style */
.date-line{
    /* flex 사용 */
    display: flex;
    flex-basis: 100%;
    align-items: center;
    color: rgb(88, 88, 88);
    font-size: 0.875rem;   
}
.date-line::before, .date-line::after{
    content: "";
    flex-grow: 1;
    height: 1px;
    background-color: rgba(88, 88, 88, 0.3);
    font-size: 0px;
    line-height: 0px;
}

/* chatting bar */
.insert-content{
    background-color: white;
    padding: 0.5rem;
    position: sticky;
    bottom: 0;
}
textarea{
    resize: vertical;
    border: solid;
    height: 3.375rem;
}

/* 채팅 입력창 flex로 정렬 */
form[name="chatform"]{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: flex-start;
}
form[name="chatform"] > textarea{
    flex-basis: 100%;
    flex-grow: 1;
}
.chat-submit{
    margin-left: 10px;
    border: 1px solid rgb(94, 122, 100);
    background-color:rgb(248, 248, 248);
    color: rgb(94, 122, 100);
    padding: 0.1875rem;
    width: 3.125rem;

    transition-property: background-color, color;
    transition-duration: 1s;
    transition-timing-function: linear;
}
.chat-submit:hover{
    background-color: rgb(94, 122, 100);
    color: rgb(248, 248, 248);
}
</style>
