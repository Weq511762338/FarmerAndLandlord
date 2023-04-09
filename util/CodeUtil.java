package util;

import java.util.Random;

public class CodeUtil {
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for(int i = 0; i < 6; i++){
            code += random.nextInt(10);
        }
        return code;
    }
}
