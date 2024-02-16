import java.util.*;
public class Question3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try {

            String test1, test2;
            System.out.println("Enter First String: ");
            test1 = sc.nextLine();

            System.out.println("Enter Second String: ");
            test2 = sc.nextLine();

            if(test1.length() != test2.length())
            {
                System.out.println("Not Anagrams");
                System.exit(0);
            }


            if(test1.trim().isEmpty() || test2.trim().isEmpty())
                throw new IllegalArgumentException("Input string is null or empty.");
            HashMap<Character, Integer> dict1 = new HashMap<>();
            HashMap<Character, Integer> dict2 = new HashMap<>();

            int val = 0;
            int new_val = 0;
            for (int i = 0; i < test1.length(); i++) {

                char curr = test1.charAt(i);
                if (dict1.containsKey(curr)) {
                    val = dict1.get(curr);
                    new_val = val + 1;
                    dict1.put(curr, new_val);
                } else {
                    dict1.put(curr, 1);
                }
            }

            val = new_val = 0;
            for (int i = 0; i < test2.length(); i++) {
                char curr = test2.charAt(i);
                if (dict2.containsKey(curr)) {
                    val = dict2.get(curr);
                    new_val = val + 1;
                    dict2.put(curr, new_val);
                } else {
                    dict2.put(curr, 1);
                }
            }
        /*
            for (char key : dict1.keySet()) {
                if (dict2.containsKey(key)) {
                    if (!Objects.equals(dict2.get(key), dict1.get(key))) {
                        System.out.println("Not anagrams");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Not anagrams");
                    System.exit(0);
                }

            }
            System.out.println("Strings are anagrams.");
        */
            if (dict1.equals(dict2)) {
                System.out.println("Strings are anagrams.");
            } else {
                System.out.println("Not anagrams");
            }
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
