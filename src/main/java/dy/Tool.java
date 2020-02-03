package dy;

public class Tool {
    public static String charArrayToString(char[] rnas) {
        StringBuilder result = new StringBuilder();
        for (char c : rnas) {
            result.append(c);
        }
        return result.toString();
    }

}
