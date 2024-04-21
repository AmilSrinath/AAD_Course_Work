package lk.ijse.gdse.util;

import java.util.Base64;
import java.util.UUID;

/**
 * @author Amil Srinath
 */
public class UtilMatters {
    public static String convertBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}
