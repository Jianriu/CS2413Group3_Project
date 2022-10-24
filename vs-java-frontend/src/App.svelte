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

	window.onload = function(){
		var username = "";
         var password = "";

		//login button process
		("#logInBtn").on("click",function(){
			var usernameValue = ("input[name='username']").val();
            var passwordValue = ("input[name='password']").val();
            
			//might be Encrypted and send to server
			username = usernameValue;
            password = passwordValue;

			//socket.emit("userCheck",{username:usernameValue, password:passwordValue});
		});

		// after server confirm the validity, open the chat page

		// signup Button process
        ("#signUpBtn").on("click",function(){
            ("#logInForm").css("display","none");   // hide the login form 
            //("#signUpForm").removeClass("signUpDisabled").addClass("signUpabled"); //open Signup form
        });

	}
</script>


<style>
	body {
		background-color: #192841
		
	}

	h1 {
		color: white;
		text-transform: uppercase;
		font-size: 5em;
		font-weight: 100;
	}

	logInabled{
        display: block;
    }

	signUpDisabled{
        display:none;
    }

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>

<body>
	<main>
		<h1>Encrypted Simple Chatting</h1>
		<p style='font-size:1em; line-height:200%; color: white;'>
    		You should log in before you start the chat<br>
    		After you log in, you can add your friend with their ID<br><br>
    	</p>
	</main>
	
	<!--login-->
	<logInabled style="margin-top: 20px;" id="logInForm">
		<form style="form-horizontal">
			<form-group>
				<input type="text" name="username" class="form-control" maxlength="100" id="username" placeholder="Username">
            	<input type="text" name="password" class="form-control" maxlength="100" id="password" placeholder="Password">
            	<button class="btn btn-primary" id="logInBtn">Enter</button>
            	<button class="btn btn-primary" id="signUpBtn">Sign Up</button>
			</form-group>
		</form>
	</logInabled>

	<!--signup-->
	<signUpDisabled style="margin-top: 20px;" id="signUpForm">
		<form style="form-horizontal">
			<form-group>
				<input type="text" name="fullname" class="form-control" maxlength="100" id="fullname" placeholder="Fullname">
            	<input type="text" name="email" class="form-control" maxlength="200" id="email" placeholder="Email">
            	<input type="text" name="username" class="form-control" maxlength="100" id="username" placeholder="Username">
            	<input type="text" name="password" class="form-control" maxlength="100" id="password" placeholder="Password">
            	<button class="btn btn-primary" id="ConfirmedBtn">Enter</button></form-group>
		</form>
	</signUpDisabled>





</body>