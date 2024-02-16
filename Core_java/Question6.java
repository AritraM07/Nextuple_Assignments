import java.util.*;


class SwapException extends Exception
{
    public SwapException(String message)
    {
        super(message);
    }
}
interface Swap
{
    void swap(int x, int y) throws SwapException;
}

class Variable implements Swap
{
    int temp = 0;

    public void swap(int x, int y) throws SwapException
    {
        if (x == y) throw new SwapException("Swapping not allowed when both the numbers are same.");
        temp = x;
        x = y;
        y = temp;

        System.out.println("Swapped values using third variable: ");
        System.out.println("Value of x: " + x);
        System.out.println("Value of y: " + y);
    }

}

class Novariable implements Swap
{
    @Override
    public void swap(int x, int y) throws SwapException
    {
        if (x == y)
        {
            throw new SwapException("Swapping not allowed when both the numbers are same.");
        }
        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("Swapped values using third variable: ");
        System.out.println("Value of x: " + x);
        System.out.println("Value of y: " + y);
    }
}


public class Question6
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;

        try {
            System.out.println("Enter the value of a: ");
            a = sc.nextInt();
            System.out.println("Enter the value of b: ");
            b = sc.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input: Please enter integer values only.");
            return; // Exit the program or handle the error accordingly
        }

        Swap obj = new Novariable();
        try {
            obj.swap(a, b);
        } catch (SwapException e) {
            System.out.println("Swap operation failed: " + e.getMessage());
        }

        System.out.println("----------------");

        obj = new Variable();
        try {
            obj.swap(a, b);
        } catch (SwapException e) {
            System.out.println("Swap operation failed: " + e.getMessage());
        }
    }
}
