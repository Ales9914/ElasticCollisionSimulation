import java.lang.Math;
public class Solucion_colision{
    
    double Suma_momentos;
    double Suma_energia;
    double M1;
    double M2;
    double V1o;
    double V2o;
    double V2f;
    double V1f;
    double A;
    double B;
    double C;

    //Quiero resolver para V1f y V2f
    public Solucion_colision (double M1, double M2, double V1o, double V2o){
        Suma_energia = 0.5*M1*V1o*V1o + 0.5*M2*V2o*V2o;
        Suma_momentos = M1*V1o + M2*V2o;
        A = 0.5*M1+((M1*M1)/(2*M2));
        B = -Suma_momentos*M1/M2;
        C = (Suma_momentos*Suma_momentos/(2*M2)) - Suma_energia;
        V1f = (-1*B - Math.sqrt(B*B - 4*A*C))/(2*A);
        V2f = (Suma_momentos - M1*V1f)/M2;



    }

}
