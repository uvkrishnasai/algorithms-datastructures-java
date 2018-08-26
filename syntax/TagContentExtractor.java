package syntax;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Link: https://www.hackerrank.com/challenges/tag-content-extractor/problem
 *
 * In a tag-based language like XML or HTML,
 * contents are enclosed between a start tag and an end tag like <tag>contents</tag>.
 * Note that the corresponding end tag starts with a /.
 *
 * Given a string of text in a tag-based language,
 * parse this text and retrieve the contents enclosed
 * within sequences of well-organized tags meeting the following criterion:
 *
 * The name of the start and end tags must be same.
 * The HTML code <h1>Hello World</h2> is not valid,
 * because the text starts with an h1 tag and ends with a non-matching h2 tag.
 *
 * Tags can be nested,
 * but content between nested tags is considered not valid.
 * For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
 *
 * Tags can consist of any printable characters.
 *
 * Sample Input
 * 4
 * <h1>Nayeem loves counseling</h1>
 * <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
 * <Amee>safat codes like a ninja</amee>
 * <SA premium>Imtiaz has a secret crush</SA premium>
 *
 * Sample Output
 * Nayeem loves counseling
 * Sanjay has no watch
 * So wait for a while
 * None
 * Imtiaz has a secret crush
 */
public class TagContentExtractor {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        IntStream.rangeClosed(1, Integer.parseInt(in.nextLine()))
                .mapToObj(i -> in.nextLine())
                .forEach(i -> {
                    Matcher m = r.matcher(i);
                    boolean found = false;
                    while (m.find()) {
                        System.out.println(m.group(2));
                        found = true;
                    }

                    if (!found) {
                        System.out.println("None");
                    }
                });
    }
}
