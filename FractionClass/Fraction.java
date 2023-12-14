
/**
 * Write a description of class Fraction here.
 *
 * @author Parsa S.
 * @version 05-12-2023
 */
public class Fraction {
    private int numer, denomin;
    /**
     * Default constructor runs Constructor Method with random single digit inputs (1-9)
     * 
     */
    public Fraction() {
        construct((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1);
    }

    /**
     * Constructor with two ints as inputs runs Constructor Method
     */
    public Fraction(int n, int d) {
        construct(n, d);
    }
    
    /**
     * Constructor takes string with "/" inbetween two single digits ints, which serve as numerator and denominator
     * You guessed it, this constructor ALSO runs Constructor Method
     * This method breaks if not inputted in the form of "numerator/denominator"
     */
    public Fraction(String s) {
        int a = s.indexOf("/");
        if (a < 1) {
            System.out.println("Inputted string is not formatted correctly. Fraction object is set to 1/2.");
            construct(1, 2);
        } else {
            construct(Integer.parseInt(s.substring(0, a)), Integer.parseInt(s.substring(a+1, s.length())));
        }
    }
    
    /**
     * Constructor method copies another Fraction object using getNum & getDenom methods
     * ALSO uses Constructor Method (not even a question at this point)
     */
    public Fraction(Fraction f) {
        construct(f.getNum(), f.getDenom());
    }
    
    /**
     * "Constructor Method", which all methods point back towards. Sets denominator to 1 if recieves 0 as denominator
     * 
     */
    private void construct(int a, int b) {
        numer = a;
        if (b == 0) {
            System.out.println("Denominator cannot be set to 0. Fraction has been set to be " + numer + "/1.");
            denomin = 1;
        } else denomin = b;
    }
    
    /**
     * Returns numerator instance variable
     */
    public int getNum() {
        return numer;
    }
    
    /**
     * Returns denominator instance variable
     */
    public int getDenom() {
        return denomin;
    }
    
    /**
     * Returns fraction in the form of "numerator/denominator". Overrides toString() method.
     */
    public String toString() {
        return numer + "/" + denomin;
    }
    
    /**
     * Returns fraction in the form of a double.
     */
    public double toDouble() {
        return ((double) numer)/denomin;
    }
    
    /**
     * Sets numerator to inputted integer
     */
    public void setNum(int a) {
        numer = a;
    }
    
    /**
     * Sets denominator to inputted integer
     * Unlike setNum, construct() method needs to be called to check if inputted denominator is 0.
     */
    public void setDenom(int a) {
        construct(numer, a);
    }
    
    /**
     * Reduces fraction to its lowest term. Returns nothing.
     */
    public void reduce() {
        if (numer == denomin) {
            numer = 1;
            denomin = 1;
            return;
        } else if (numer == 0) {
            denomin = 1;
            return;
        }
        
        int a = Math.abs(numer), b = Math.abs(denomin);
        while (a != b) {
            if (a > b) {
                a -= b;
            } else if (b > a) {
                b -= a;
            }
        }
        
        numer = numer / a;
        denomin = denomin / a;
        
        if (denomin < 0) {
            denomin *= -1;
            numer *= -1;
        } 
    }
    
    /**
     * Static method that adds two fractions.
     */
    public static Fraction add(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.getNum() * b.getDenom() + a.getDenom() * b.getNum(), b.getDenom() * a.getDenom());
        c.reduce();
        return c;
    }
    
    /**
     * Static method that subtracts two fractions.
     */
    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.getNum() * b.getDenom() - a.getDenom() * b.getNum(), b.getDenom() * a.getDenom());
        c.reduce();
        return c;
    }
    
    /**
     * Static method that multiplies two fractions.
     */
    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.getNum() * b.getNum(), b.getDenom() * a.getDenom());
        c.reduce();
        return c;
    }
    
    /**
     * Static method that divides two fractions.
     */
    public static Fraction divide(Fraction a, Fraction b) {
        Fraction c = new Fraction(a.getNum() * b.getDenom(), b.getNum() * a.getDenom());
        c.reduce();
        return c;
    }
    
    public static boolean equals(Fraction a, Fraction b) {
        a.reduce();
        b.reduce();
        return a.getNum() == b.getNum() && a.getDenom() == b.getDenom();
    }
}
