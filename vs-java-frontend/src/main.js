import App from './App.svelte';

const app = new App({
	target: document.body,
	props: {
		name: 'world'
	}
});

// app.use((req,res,next) => {
// 	res.header({"Access-Control-Allow-Origin": "*"});
// })

export default app;