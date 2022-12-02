<script>    
    export let friendName = "";
	import { beforeUpdate, afterUpdate } from 'svelte';

	let div;
	let autoscroll;
	//autometically going down the scroll
	beforeUpdate(() => {
		autoscroll = div && (div.offsetHeight + div.scrollTop) > (div.scrollHeight - 20);
	});
	afterUpdate(() => {
		if (autoscroll) div.scrollTo(0, div.scrollHeight);
	});

    let comments = [	];
	
	//send and print my msg
	function handleKeydown(event) {
		if (event.key === 'Enter') {
			const text = event.target.value;
			if (!text) return;

			comments = comments.concat({
				author: 'user',
				text
			});

			event.target.value = '';

			sendChat(text);
			
		}
	}

	//receive the chat
	async function sendChat(t){
        let path = "http://localhost:5000/chatting?&text="+t
        const res = await fetch(path,{
            method: 'GET'
        })
        let result = await res.text()
		if(result != null){
			comments = comments.concat({
				author: 'friend',
				text: result
			});
		}
		else	alert("fail for sending message")

		//receiveMsg();
	}

	//receive the chat
	async function receiveMsg(){
		let path = "http://localhost:5000/chatting"
		const res = await fetch(path,{
            method: 'GET'
        })
        let result = await res.text()
		console.log(result)
		//console.log(result);
		if(result != null){
			comments = comments.concat({
				author: 'friend',
				text: result
			});
		}
		
    }
	
</script>


<div class="chat">
	<header>
		<h1>{friendName}</h1>
	</header>
	
	<div class="scrollable" bind:this={div}>
        {#each comments as comment}
        <article class={comment.author}>
            <span>{comment.text}</span>
        </article>
		{/each}
		
	</div>

	<input on:keydown={handleKeydown}>
</div>

<style>
    h1{
        margin-left: 20px;
		color: white;
    }

	.chat {
		display: flex;
		flex-direction: column;
		height: 100%;
        background-color: #8B9D77;
	}

	.scrollable {
		flex: 1 1 auto;
		border-top: 3px solid black;
		margin: 0 0 0.5em 0;
		overflow-y: auto;
	}

	article {
		margin: .5em 0;
	}

	.user {
		text-align: right;
	}

	span {
		padding: 0.5em 1em;
		display: inline-block;
	}

	.friend span {
		background-color: rgb(94, 122, 100);
		color : rgb(228, 233, 230);
		border-radius: 1em 1em 1em 0;
		margin-left: 1em;
	}

	.user span {
		background-color: rgb(228, 233, 230);
		color: black;
		border-radius: 1em 1em 0 1em;
		margin-right: 1em;
	}

	input{
		margin-left: 1rem;
		margin-right: 1rem;
	}
</style>

