package util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        String result = "";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            result = result + c;
        }

        int number = r.nextInt(10);

        result = result + number;
        char[] chars = result.toCharArray();//[A,B,C,D,5]
        int index = r.nextInt(chars.length);
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;
        String code = new String(chars);
        return code;
    }
}
