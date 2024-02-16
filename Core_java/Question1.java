//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Enter two numbers: ");
            double x1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double sum = x1 + x2;
            System.out.println("Sum: " + sum);
        } catch (InputMismatchException ime)
        {
            // Catching specific exception for input mismatch
            System.out.println("Input was not a valid number.");
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage() != null ? ex.getMessage() : "An unknown error occurred.");
        } finally
        {
            sc.close();
        }
    }
}
