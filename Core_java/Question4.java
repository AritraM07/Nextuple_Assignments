import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ArrayList<Integer> nums = new ArrayList<>();
            System.out.print("Enter the size of the array: ");
            int size = sc.nextInt();

            System.out.println("Enter array elements: ");
            for (int i = 0; i < size; i++) {
                nums.add(sc.nextInt());
            }
            Collections.sort(nums);
            System.out.println("Sorted array elements: " + nums);

            System.out.println("Enter the number you want to search for: ");
            int target = sc.nextInt();

            int index = bsearch(nums, target);
            if (index == -1) {
                System.out.println("Number not found.");
            } else {
                System.out.println("Number found at index: " + index);
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input: Please enter only integers.");
        } finally {
            sc.close();
        }
    }

    static int bsearch(ArrayList<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = nums.get(mid);

            if (x == target) {
                return mid;
            } else if (x > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
