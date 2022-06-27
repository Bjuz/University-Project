var url="http://localhost:8080/PersonasIntegradoMultipart/";

function ObtenerDoctor(){

       usuario =  JSON.parse(sessionStorage.getItem("Doctor"));
        Doctor = {
            id: usuario.id,
            clave: usuario.clave,
            horaEntrada: usuario.horaEntrada,
            HoraSalida:usuario.horaSalida,
            Frecuencia:usuario.frecuencia,
            nombre:usuario.nombre,
            rol: usuario.rol,   
            array: usuario.pacientes
        };
        console.log(Doctor);
        
        
}

  
  window.addEventListener('DOMContentLoaded',  (e) =>{
    ObtenerDoctor();
     event.preventDefault();
    dragdrop(e);
});




