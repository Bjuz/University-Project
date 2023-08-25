var url="http://localhost:8080/PersonasIntegradoMultipart/";

function login(){
        usuario = {
            id: document.getElementById("id").value,
            clave: document.getElementById("clave").value
        };
        
        console.log(usuario.id);
        console.log(usuario.clave);
        
        let request = new Request(url+'api/login', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(usuario)});
        (async ()=>{
            const response = await fetch(request);
            
            if (!response.ok) {alert("Usuario o contraseña incorrecta.");}
            
            usuario = await response.json();
            sessionStorage.setItem('user', JSON.stringify(usuario));
            
            if(usuario.rol === "ADM"){
               
            document.location = url + "Schedule.html";
            console.log("ADM");
            return;

            }else{
                alert("Pacientes no tienen acceso al sistema.");
                return;
            }
            alert("Usuario o contraseña incorrecta.");                    
        })(); 
}


    function logout(){
        let request = new Request(url+'api/login', {method: 'DELETE', headers: { }});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#loginDialog #errorDiv"));return;}
            sessionStorage.removeItem('user');       
            sessionStorage.removeItem('Doctor');
        })();      
    }

  function errorMessage(status,place){  
        switch(status){
            case 404: error= "Registro no encontrado"; break;
            case 401: case 403: error="Usuario no autorizado"; break;
            case 406: case 405: error="Usuario ya existe"; break;
        };            
        place.html('<div class="alert alert-danger fade show">' +
        '<button type="button" class="close" data-dismiss="alert">' +
        '&times;</button><h4 class="alert-heading">Error!</h4>'+error+'</div>');
        return;        
    }  
  
  
  window.addEventListener('DOMContentLoaded',  (e) =>{
    logout();
})
