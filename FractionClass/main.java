
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
        

public class main
{
    public static void main() {
        /**
         * Milu PI Approximation
         */
        
        Fraction pseudoPI = new Fraction("1/2");
        Fraction MILU = new Fraction(355, 113);
        final double EPSILON = Math.abs( Math.PI - MILU.toDouble() );
        
        while (Math.abs(Math.PI - pseudoPI.toDouble()) >= EPSILON) {
            if (Math.PI > pseudoPI.toDouble()) pseudoPI.setNum(pseudoPI.getNum() + 1);
            else pseudoPI.setDenom(pseudoPI.getDenom() + 1);
        }
        
        System.out.println(pseudoPI);
        
        /**
         * Fraction Game: START!
         */
        
        String s = "";
        Scanner input = new Scanner(System.in);

        
        Fraction a;
        Fraction b;
        Fraction c;
        int wins = 0, losses = 0;
        int operator = 0;
        boolean gameContinue = true;
        System.out.println("Game Start! Fraction Game:\n");
        while (gameContinue) {
            a = new Fraction();
            b = new Fraction();
            operator = (int) (Math.random() * 4);
            
            System.out.print(a);
            switch (operator) {
                case 0:
                    System.out.print(" + ");
                    break;
                case 1:
                    System.out.print(" - ");
                    break;
                case 2:
                    System.out.print(" * ");
                    break;
                case 3:
                    System.out.print(" / ");
                    break;
                default:
                    System.out.println("ERROR");
            }
            System.out.println(b + " = ?");
            
            s = input.nextLine();
            if (s.equals("quit")) {
                gameContinue = false;
                break;
            } else {
                c = new Fraction(s);    
            }
            
            switch (operator) {
                case 0:
                    if (Fraction.equals(c, Fraction.add(a, b))){
                        System.out.println("Correct!");
                        wins++;
                    } else {
                        System.out.println("Wrong, the correct answer was " + Fraction.add(a, b));
                        losses++;
                    }
                    break;
                case 1:
                    if (Fraction.equals(c, Fraction.subtract(a, b))) {
                        System.out.println("Correct!");
                        wins++;
                    } else {
                        System.out.println("Wrong, the correct answer was " + Fraction.subtract(a, b)); 
                        losses++;
                    }
                    break;
                case 2:
                    if (Fraction.equals(c, Fraction.multiply(a, b))) {
                        System.out.println("Correct!");
                        wins++;
                    } else {
                        System.out.println("Wrong, the correct answer was " + Fraction.multiply(a, b));
                        losses++;
                    }
                    break;
                case 3:
                    if (Fraction.equals(c, Fraction.divide(a, b))) {
                        System.out.println("Correct!");
                        wins++;
                    } else {
                        System.out.println("Wrong, the correct answer was " + Fraction.divide(a, b));
                        losses++;
                    }
                    break;
                default:
                    System.out.println("ERROR");
            }
            
            
        }
        
        System.out.print("Your win/loss ratio is: " + wins + "/" + losses + ".");
        if (losses != 0) System.out.println(" A score of " + (int)(100*wins/(wins + losses)) + " percent!");
            

    }
    
    
}
