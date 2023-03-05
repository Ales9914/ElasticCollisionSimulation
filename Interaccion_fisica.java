public class Interaccion_fisica extends Propiedades_fisicas {
    
    double Energia;
    double Momento;
    double Velocidad;
    
    public Interaccion_fisica(double Masa, double Lado, double Velocidad){
        super(Masa, Lado);
        this.Momento  = Masa*Velocidad;
        this.Energia = 0.5*Masa*Velocidad*Velocidad;
        this.Velocidad = Velocidad;
    }

}
