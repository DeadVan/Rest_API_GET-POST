package Utils;

import static Utils.DataReader.readJsonInt;

public final class StringUtil {

    private StringUtil(){}
    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz";

    public static String getString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < readJsonInt("stringLength"); i++) {
            int index = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        return builder.toString();
    }
}
