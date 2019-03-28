package formas;

public class Quadrado implements Forma {

    protected  double lado;
    public Quadrado(double lado){
        super();
        this.lado = lado;
    }

    @Override
    public double area() {
        return Math.pow(this.lado,2);
    }
}
