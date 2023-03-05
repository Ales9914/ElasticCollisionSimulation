import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class Main{
    static int contador = 0;
    public static void main(String[] args) throws InterruptedException {
        //El método constructor del objeto tiene que llamarse igual que la clase.
        //Aquí creo el objeto Objeto_1, el método constructor el asigna el atributo Masa y Lado.
        int w = 640;
        int step = 1;
        int h = 480;
        int PotenciaMasa_Ob1 = 2;
        double XObj1 = 500;
        double XObj2 = XObj1 + PotenciaMasa_Ob1*10 + 10; 
        Interaccion_fisica Objeto_1 = new Interaccion_fisica(Math.pow(100,PotenciaMasa_Ob1),5,0.05);
        Interaccion_fisica Objeto_2 = new Interaccion_fisica(1,5,0);
        Interaccion_fisica Muro = new Interaccion_fisica(10e100, 0, 0);
        JFrame f = new JFrame();
        Canvas dc = new Canvas(w,h,XObj1,XObj2,PotenciaMasa_Ob1*10,10,contador);
        f.add(dc);
        f.setSize(w,h);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        while (Objeto_1.Velocidad > Objeto_2.Velocidad){

            dc.x_Obj_1 = dc.x_Obj_1 + Objeto_1.Velocidad;
            dc.x_Obj_2 = dc.x_Obj_2 + Objeto_2.Velocidad;
            // System.out.println(dc.x_Obj_1);
            // System.out.println(dc.x_Obj_2);
            
            while (dc.x_Obj_2 >= dc.x_Obj_1 + PotenciaMasa_Ob1*10){
                if (Math.abs(dc.x_Obj_2 - dc.x_Obj_1 - PotenciaMasa_Ob1*10) < 0.5){
                    break;
                }
                dc.x_Obj_1 = dc.x_Obj_1 + Objeto_1.Velocidad;
                dc.x_Obj_2 = dc.x_Obj_2 + Objeto_2.Velocidad;
                Thread.sleep(step);
                dc.Repintar();
            }

            Solucion_colision Colision_12 = new Solucion_colision(Objeto_1.Masa, Objeto_2.Masa, Objeto_1.Velocidad, Objeto_2.Velocidad);
            dc.cont_int ++;
            Objeto_1.Velocidad = Colision_12.V1f;
            Objeto_2.Velocidad = Colision_12.V2f;

            while (dc.x_Obj_2 + 10 <= w - 30){
                if (Math.abs(dc.x_Obj_2 - w + 40)<0.5){
                    break;
                }
                dc.x_Obj_1 = dc.x_Obj_1 + Objeto_1.Velocidad;
                dc.x_Obj_2 = dc.x_Obj_2 + Objeto_2.Velocidad;
                Thread.sleep(step);
                dc.Repintar();
            }

            if (Objeto_2.Velocidad > 0){
                Solucion_colision Colision_2M = new Solucion_colision(Objeto_2.Masa, Muro.Masa, Objeto_2.Velocidad, Muro.Velocidad);
                Objeto_2.Velocidad = Colision_2M.V1f;
                dc.cont_int ++;
            }
        
            
        }
        
    }

}