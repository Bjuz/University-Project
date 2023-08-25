/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.progra.personas.logic;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author jeaus
 */
public class Doctor extends Usuario {
    String HoraEntrada;
    String HoraSalida;
    String Frecuencia;
     ArrayList<Paciente> pacientes;
    
    public void IngresaPaciente(Paciente paciente){
        pacientes.add(paciente);
    }
    public  ArrayList<Paciente> getPacientes(){
        return pacientes;
    }
    
    public void setPaciente(ArrayList<Paciente> pacientes){
        this.pacientes = pacientes;
    }
    
    public Paciente getPaciente(String nombre){
        for(Paciente paciente : pacientes){
            if(paciente.getNombre().equals(nombre)){
                return paciente;
            }
        }
        return null;
    }
            
    public Doctor(String HoraEntrada, String HoraSalida, String Frecuencia, String id, String clave, String nombre, String rol , ArrayList<Paciente> pacientes ) {
        super(id, clave, nombre, rol);
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.Frecuencia = Frecuencia;
        this.pacientes =  pacientes;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String HoraEntrada) {
        this.HoraEntrada = HoraEntrada;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(String Frecuencia) {
        this.Frecuencia = Frecuencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

}
