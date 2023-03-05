import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Canvas extends JComponent{
    int width;
    int heigth;
    double x_Obj_1;
    double x_Obj_2;
    double H_Obj1;
    double H_Obj2;
    int cont_int;
    String cont;

    public Canvas(int w, int h, double XObj1, double XObj2, double HOb1, double HOb2, int contador){
        width = w;
        heigth = h;
        x_Obj_1 = XObj1;
        x_Obj_2 = XObj2;
        H_Obj1 = HOb1;
        H_Obj2 = HOb2;
        cont_int = contador;
        cont = String.valueOf(cont_int);

    }

    protected void paintComponent(Graphics g){ //g es un objeto de tipo gráfica
        Graphics2D g2D = (Graphics2D) g; //Graphics 2D es una version mejorada de Graphics

        Rectangle2D.Double Muro_r = new Rectangle2D.Double(width-30,0,30,heigth);
        g2D.setColor(new Color(100,152,245));
        g2D.fill(Muro_r);

        Rectangle2D.Double Piso_r = new Rectangle2D.Double(0,heigth/2+40,width,heigth/2);
        g2D.setColor(new Color(100,152,245));
        g2D.fill(Piso_r);

        Rectangle2D.Double Objeto_1_r = new Rectangle2D.Double(x_Obj_1,heigth/2+40-H_Obj1,H_Obj1,H_Obj1);
        g2D.setColor(Color.black);
        g2D.fill(Objeto_1_r);

        Rectangle2D.Double Objeto_2_r = new Rectangle2D.Double(x_Obj_2,heigth/2+40-H_Obj2,H_Obj2,H_Obj2);
        g2D.setColor(Color.black);
        g2D.fill(Objeto_2_r);
        this.repaint();

        Font f = new Font("Dialog", Font.PLAIN, 25);
        cont = String.valueOf(cont_int);
        g2D.setFont(f);
        g2D.drawString(cont, ALLBITS, ABORT);
        

    }

    public void Repintar(){
        repaint();
    }

}
