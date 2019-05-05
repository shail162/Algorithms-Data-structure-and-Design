package strings;

/**
 * Reverse words in a given string
 * Given a String of length S, reverse the whole string without reversing the individual words in it.
 * Words are separated by space.
 *
 * i like this program very much
 * much very program this like i
 *
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s[]="i like this program very much".split(" ");
        StringBuilder builder = new StringBuilder();

        for(int i = s.length - 1; i >= 0; i--) {
            builder.append(s[i]).append(" ");
        }

        //remove last space character
        builder.deleteCharAt(builder.length()-1);

        System.out.println(builder.toString());

    }

}
