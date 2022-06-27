var url="http://localhost:8080/PersonasIntegradoMultipart/";

function ObtenerDoctor(){
       usuario =  JSON.parse(sessionStorage.getItem("Doctor"));
       console.log(usuario);
        Doctor = {
            id: usuario.id,
            clave: usuario.clave,
            horaEntrada: usuario.horaEntrada,
            HoraSalida:usuario.HoraSalida,
            Frecuencia:usuario.Frecuencia,
            nombre:usuario.nombre,
            rol: usuario.rol,
            pacientes: usuario.pacientes
        };
        console.log(Doctor);      
}

function GuardarPaciente(){
     usuario =  JSON.parse(sessionStorage.getItem("Doctor"));
       console.log(usuario)
        Doctor = {
             id: usuario.id,
            clave: usuario.clave,
            horaEntrada: usuario.horaEntrada,
            HoraSalida:usuario.HoraSalida,
            Frecuencia:usuario.Frecuencia,
            nombre:usuario.nombre,
            rol: usuario.rol,
            pacientes: usuario.pacientes
        };
    
    let doctores =  Doctor.pacientes;
    paciente = {
        clave: "",
        id: " ",
        motivo: document.getElementById("justification").value,
        nombre: document.getElementById("pacient-name").value,
        rol: "",
        tipo: document.getElementById("type").value
    };
    
    doctores.push(paciente);
    Doctor.pacientes = doctores;
    console.log(doctores);
    sessionStorage.setItem('Doctor', JSON.stringify(Doctor));
}

  
  window.addEventListener('DOMContentLoaded',  (e) =>{
      event.preventDefault();
    ObtenerDoctor();
     
});

function logout(){

        window.location.href ="about.html";
    }




