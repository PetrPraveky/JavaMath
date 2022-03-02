package lib.java;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * <h3>Class for accesing files in number database</h3>
 * Support class for accesing files with saved values and than working with them.
 */
public class dbAcc {
    /**
     * <h3>Acces BigDecimal database files</h3>
     */
    public static boolean db_access(String pathToDB) {
        File saveFile = new File(pathToDB);
        // If file does not exists, create it and return false
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
                System.out.println("... File created");
            } catch(IOException io) {
                System.out.println(io);
            }
            return false;
        }
        System.out.println(saveFile.getPath());
        return false;
    }
    /**
     * <h3>Save BigDecimal to database</h3>
     */
    public static void db_save(String pathToDB, BigDecimal in, BigDecimal out) {
        
    }

}
