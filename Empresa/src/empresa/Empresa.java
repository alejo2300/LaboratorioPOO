/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;
import Entidades.Empleado;
import java.util.Scanner;
/**
 *
 * @author alejo
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("SISTEMA DE NOMINAS||LABORATORIO POO\n\n");
        
        //Creacion de empleados
        Empleado emp[]= new Empleado[10];
        int n;
        System.out.print("Digite el numero de empleados: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("");
        for(int i=0;i<n;i++){
            System.out.println("");
            String name;
            System.out.print("Digite el nombre de su "+(i+1)+" trabajador: ");
            name = sc.next();
            long cedula;
            System.out.print("Digite la cedula de su "+(i+1)+" trabajador: ");
            cedula = sc.nextLong();
            int salario;
            System.out.print("Digite el salario de su "+(i+1)+" trabajador: ");
            salario = sc.nextInt();
            emp[i] = crearEmpleado(name,cedula,salario);
        }
        System.out.println("");
        System.out.println("La nomina total de la empresa es "+NominaTotal(emp,n));
        System.out.println("El aporte total de la empresa al SENA es "+NominaTotal(emp,n)*0.04);
    }
    
    //Metodos externos
    
    public static Empleado crearEmpleado(String nombre,long cedula, double salario){
       Empleado empleado=new Empleado(nombre,cedula,salario);
       return empleado;
    }
    
    public static void Informacion(Empleado empleado){
        System.out.println("El nombre del empleado es: "+ empleado.getNombre()+" \nLa cedula del empleado es: "+empleado.getCedula()+"\nEl total devengado es: "+ empleado.TotalDevengado() + "\nEl total de descuentos es: "+ empleado.CalcularDescuentoTotal()+ "\nEl total de la nomina es: "+ empleado.CalcularTotalNomina()+ "\n");
    }

    public static double NominaTotal(Empleado Emp[],int j){
        double k=0;
        for(int q=0;q<j;q++){
            k+=Emp[q].CalcularTotalNomina();
        }
           return k;
    }      
}


