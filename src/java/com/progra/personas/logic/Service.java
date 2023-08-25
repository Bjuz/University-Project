package com.progra.personas.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Service {

    private static Service uniqueInstance;
    
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }
    
    HashMap<String,Persona> personas;
    static Map<String,Usuario> usuarios;
    static Map<String,Doctor> Doctores;

    
    private Service(){
        personas = new HashMap<String,Persona> ();
        personas.put("111", new Persona("111","Juan","M"));
        personas.put("222", new Persona("222","Maria","F"));
        ArrayList<Paciente> pacientes =  new ArrayList<Paciente>();
        pacientes.add(new Paciente("Dolor de cabeza","Urgente"," Camila"));
        pacientes.add(new Paciente("Pereza","Urgente"," Jeaustin"));
        pacientes.add(new Paciente("Hola","Urgente"," Francisco"));
        
         ArrayList<Paciente> pacientes2 =  new ArrayList<Paciente>();
        pacientes2.add(new Paciente("Dolor de cabeza","Urgente"," Marco"));
        pacientes2.add(new Paciente("Pereza","Urgente"," Pablo"));
        pacientes2.add(new Paciente("Hola","Urgente"," Juan"));
        
         ArrayList<Paciente> pacientes3 =  new ArrayList<Paciente>();
        pacientes3.add(new Paciente("Dolor de cabeza","Urgente"," Stanlee"));
        pacientes3.add(new Paciente("Pereza","Urgente"," Daniel"));
        pacientes3.add(new Paciente("Hola","Urgente"," Sofia"));
        usuarios = new HashMap<>();

        Doctores = new HashMap<>();
        usuarios.put("001", new Doctor("7","16","20","001","001","Juan Perez","ADM",pacientes));
        usuarios.put("002", new Doctor("7","16","30","002","002","Juan Mariano","ADM",pacientes2));
        usuarios.put("003", new Doctor("7","16","60","003","003","Juan Arburola","ADM",pacientes3));
    }

    public List<Persona> personaListAll() {
        return new ArrayList(personas.values());
    } 
    
    public List<Persona> personaSearch(String nombre) {
        List<Persona> result = new ArrayList<>();
        for(Persona p:personas.values()){
            if(p.getNombre().contains(nombre)) result.add(p);
        }
        return result;
    } 
    public Persona personaAdd(Persona per)throws Exception {
        if (personas.get(per.getCedula())!=null){
            throw new Exception ("406-persona ya existe");
        }
        else{
            personas.put(per.getCedula(),per);
            return per;
        }
    }
    
    public void personaUpdate(Persona per)throws Exception {
        if (personas.get(per.getCedula())==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.put(per.getCedula(), per);
        }
    }
    
    public void personaDelete(String cedula)throws Exception {
        if (personas.get(cedula)==null){
            throw new Exception ("404-persona no existe");
        }
        else{
            personas.remove(cedula);
        }
    }
    
    public Persona personaEdit(String cedula)throws Exception {
        if (personas.get(cedula)!=null){
            return personas.get(cedula);
            
        }
        else{
            throw new Exception ("404-persona no existe");
        }
    }
    
    public static Usuario get(Usuario id)throws Exception{
        Usuario result = usuarios.get(id.getId());
        if (result==null) throw new Exception("Usuario no existe");
        return result;
    }      
    
     public static Doctor get(Doctor id)throws Exception{
        Doctor result = Doctores.get(id.getId());
        if (result==null) throw new Exception("Usuario no existe");
        return result;
    }   
    
}
