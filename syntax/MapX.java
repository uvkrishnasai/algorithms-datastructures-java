package syntax;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given a phone book that consists of people's names and their phone number.
 * After that you will be given some person's name as query.
 * For each query, print the phone number of that person.
 *
 * Input Format
 * The first line will have an integer n denoting the number of entries in the phone book.
 * Each entry consists of two lines: a name and the corresponding phone number.
 *
 * After these, there will be some queries.
 * Each query will contain a person's name.
 * Read the queries until end-of-file.
 *
 * Constraints:
 * A person's name consists of only lower-case English letters
 * and it may be in the format 'first-name last-name' or in the format 'first-name'.
 * Each phone number has exactly 8 digits without any leading zeros.
 *
 * Output Format
 * For each case, print "Not found" if the person has no entry in the phone book.
 * Otherwise, print the person's name and phone number.
 * See sample output for the exact format.
 *
 * To make the problem easier, we provided a portion of the code in the editor.
 * You can either complete that code or write completely on your own.
 *
 * Sample Input
 * 3
 * uncle sam
 * 99912222
 * tom
 * 11122222
 * harry
 * 12299933
 * uncle sam
 * uncle tom
 * harry
 *
 * Sample Output
 * uncle sam=99912222
 * Not found
 * harry=12299933
 */
class MapX{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        class Contact {
            String name;
            int ph;
            Contact(String name, int ph, String newLineFeed) {
                this.name = name;
                this.ph = ph;
            }
            public String getName() {
                return this.name;
            }
            public Integer getPh() {
                return new Integer(this.ph);
            }
        }

        Map<String, Integer> map =
                IntStream
                        .range(0, n)
                        .mapToObj(i -> new Contact(in.nextLine(), in.nextInt(), in.nextLine()))
                        .collect(Collectors.toMap(Contact::getName, Contact::getPh));

        while(in.hasNext()) {
            String s=in.nextLine();
            System.out.println(
                    map.get(s) != null ? s + "=" + map.get(s) : "Not found"
            );
        }
    }
}




