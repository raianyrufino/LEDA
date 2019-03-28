package formas;

public class Triangulo implements Forma{

    protected double base;
    protected double altura;

    public Triangulo(double base, double altura){
        super();
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (this.base*this.altura)/2;
    }
}
