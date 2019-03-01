package freds.helperlib.lang;

/**
 * Complex provides a complex number type
 * <p>
 * Complex c = new Complex(1, 2); // 1 + 2i
 * @author Frederik Lundbeck Jørgensen
 * @since 01-03-2019
 */
public class Complex 
{
    private double a;
    private double b;

    /**
     * @param a The real part
     * @param b The imaginary part
     */
    public Complex(double a, double b) 
    {
        this.a = a;
        this.b = b;
    }

    public static Complex add(Complex c1, Complex c2)
    {
        return new Complex(c1.a + c2.a, c1.b + c2.b);
    }

    public static Complex multiply(Complex c1, Complex c2)
    {
        return new Complex(c1.a * c2.a - c1.b * c2.b, c1.a * c2.b + c1.b * c2.a);
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %si", a, b > 0 ? '+' : "", b == 1 ? "" : b);
    }
}