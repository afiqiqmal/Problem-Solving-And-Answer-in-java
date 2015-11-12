//http://programmingcode4life.blogspot.my/2015/09/html-tag-checker-kictm-uitm-jasin-2015.html

import java.util.*;

@SuppressWarnings("unchecked")

public class Q3 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        String nextTag, lastTag;
        Vector stackTag;
        Vector stackList;

        String in = scan.next();
        while ( in .charAt(0) != '#') {
            while (! in .endsWith("#")) 
               in = in +scan.next();
            
            stackList = getTags(in.toUpperCase());

            stackTag = new Vector();
            while (!stackList.isEmpty()) {
                nextTag = (String) stackList.remove(0);

                // Final tag
                if (nextTag.equals("#")) {
                    break;
                }

                // Open tag
                if (nextTag.length() == 1) {
                    stackTag.add(nextTag);
                    continue;
                }

                // Close tag
                if (stackTag.isEmpty()) {
                    stackList.add(0, nextTag);
                    break;
                }

                // Validating open close is match or not?
                lastTag = (String) stackTag.remove(stackTag.size() - 1);
                if (lastTag.charAt(0) != nextTag.charAt(1)) {
                    stackTag.add(lastTag);
                    stackList.add(0, nextTag);
                    break;
                }
            }

            if (stackTag.isEmpty() && stackList.isEmpty()) {
                System.out.println("Correctly tagged paragraph");
            } else if (stackTag.isEmpty()) {
                System.out.println("Expected # found <" + stackList.get(0) + ">");
            } else if (stackList.isEmpty()) {
                System.out.println("Expected </" + stackTag.get(stackTag.size() - 1) + "> found #");
            } else {
                System.out.println("Expected </" + stackTag.get(stackTag.size() - 1) + "> found <" + stackList.get(0) + ">");
            }

            in = scan.next();
         }
    }
    public static Vector getTags(String str) {
        int x;
        Vector tags = new Vector();
        for (x = 0; x < str.length(); x++) {
            // End-of-paragraph
            if (str.charAt(x) == '#') {
                tags.add("#");
            }

            // Open-tag <A>
            if ((str.charAt(x) == '<') && (x + 2 < str.length()) && (str.charAt(x + 1) >= 'A') && (str.charAt(x + 1) <= 'Z') && (str.charAt(x + 2) == '>')) {
                tags.add("" + str.charAt(x + 1));
            }

            // Close-tag </A>
            if ((str.charAt(x) == '<') && (x + 3 < str.length()) && (str.charAt(x + 1) == '/') && (str.charAt(x + 2) >= 'A') && (str.charAt(x + 2) <= 'Z') && (str.charAt(x + 3) == '>')) {
                tags.add("/" + str.charAt(x + 2));
            }
        }
        return tags;
    }
}