package syntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * A string containing only parentheses is balanced if the following is true:
 * 1. if it is an empty string
 * 2. if A and B are correct, AB is correct,
 * 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 *
 * Given a string, determine if it is balanced or not.
 *
 *  Input Format
 * There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.
 * The part of the code that handles input operation is already provided in the editor.
 *
 * Output Format
 * For each case, print 'true' if the string is balanced, 'false' otherwise.
 *
 * Sample Input
 * {}()
 * ({()})
 * {}(
 * []
 *
 * Sample Output
 * true
 * true
 * false
 * true
 */
class StackX{

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");

        while (sc.hasNext()) {
            String input=sc.next();

            Stack stack = new Stack();
            boolean result = true;
            for(char i : input.toCharArray()) {
                String charac = Character.toString(i);
                if(map.containsKey(charac)) {
                    if (stack.empty() || !stack.pop().equals(map.get(charac))) {
                        result = false;
                        break;
                    }
                }  else {
                    stack.push(charac);
                }
            }

            System.out.println(result && stack.empty());
        }

    }
}



