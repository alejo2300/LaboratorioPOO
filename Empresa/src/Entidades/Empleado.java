/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author alejo
 */
public class Empleado {
    
    //Atributos
    
    private String nombre;
    private long cedula;
    private double salario;
    private static double salarioMin=818116;
    
    //Constructores

    public Empleado() {
        this.nombre=null;
        this.cedula=0;
        this.salario=0;
    }

    public Empleado(String nombre, long cedula, double salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.salario = salario;
    }

    //Getters and setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static double getSalarioMin() {
        return salarioMin;
    }

    public static void setSalarioMin(double salarioMin) {
        Empleado.salarioMin = salarioMin;
    }
    
    //Metodos
    
    public double SubsidioTransporte (){
         if (this.salario<this.salarioMin*2){
             return 90000;
         }else{
             return 0;
         }
    }
  
    public double TotalDevengado(){
    return this.salario+SubsidioTransporte();
    }
   
    public double CalcularIBC(){
    return TotalDevengado()*0.75;
    }
   
    public double CalcularDescuentoPension(){
        return CalcularIBC()*0.3875;
    }   
    
    public double CalcularDescuentoSalud(){
            return CalcularIBC()*0.45;
    }
    
    public double CalcularDescuentoFS(){
        if(this.salario>salarioMin*4)
            return CalcularIBC()*0.1;
        else 
            return 0; 
    }
    
    public double CalcularDescuentoTotal()
    {
        return CalcularDescuentoSalud() + CalcularDescuentoPension() + CalcularDescuentoFS();
    }
    
    public double CalcularTotalNomina(){
        return salario-CalcularDescuentoTotal();
    }
}
