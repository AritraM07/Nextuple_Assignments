import java.util.*;
public class Question5
{
    public static void main(String[] args)
    {
        try
        {
            int val, new_val = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string: ");
            String test1 = sc.nextLine();
            String test = test1.replace(" ", "");
            if(test.trim().isEmpty())
                throw new IllegalArgumentException("Input string is null or empty.");


            HashMap<Character, Integer> dict = new HashMap<>();
            for (int i = 0; i < test.length(); i++) {
                char curr = test.charAt(i);
                if (dict.containsKey(curr)) {
                    val = dict.get(curr);
                    new_val = val + 1;
                    dict.put(curr, new_val);
                } else {
                    dict.put(curr, 1);
                }
            }

            for (char key : dict.keySet())
            {
                if (dict.get(key) > 1)
                    System.out.println(key + "," + dict.get(key));
            }
        }

        catch(RuntimeException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
