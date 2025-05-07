package lightly.lightly_kiosk.util;

/**
 * Utility class for string operations
 */
public class StringUtils {
    
    /**
     * Checks if a string can be converted to a number
     * 
     * @param str the string to check
     * @return true if the string can be converted to a number, false otherwise
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}