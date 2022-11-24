//Sends request to the backend server at localhost:5000. This url path is mapped to MyController.java 
async function login(username,pass){
    let path = "http://localhost:5000/users?username="+ username +"&password="+pass
    const res = await fetch(path,{
        method: 'GET'
    })
    let result = await res.json()
    if(result){
        return true;
    }
    else{
        return false;
    }
}
export default login;