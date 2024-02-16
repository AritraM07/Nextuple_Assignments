//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            ArrayList<Integer> nums = new ArrayList<>();
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();

            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                nums.add(sc.nextInt());
            }

            System.out.println("Array elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(nums.get(i) + " ");
            }
            System.out.print("\n");
            int flag = 0;
            if (nums.get(0) % 2 != 0)
                flag = 1;

            int i = 0;
            for (i = 1; i < size; i++)
            {
                if ((flag == 0 && nums.get(i) % 2 != 0) || (flag != 0 && nums.get(i) % 2 == 0)) {
                    System.out.println("Mixed elements");
                    break;
                }

            }
            if (i == size) System.out.println("Uniform Elements");
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Input only integers");
        }
        finally
        {
            sc.close();
        }
    }
}
