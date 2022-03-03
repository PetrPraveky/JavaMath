package lib.java;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import lib.java.numbers.BigDecimalMath;

/**
 * <h3>Class for accesing files in number database</h3>
 * Support class for accesing files with saved values and than working with them.
 * <p>
 * I'm wiriting answer and reading them from .json files thanks to JSON-simple module.
 */
public class dbAcc {
    /**
     * <h3>Basic sections in .json
     */
    private static final String input = "in";
    private static final String answer = "ans";
    /**
     * <h3>Acces BigDecimal database files</h3>
     */
    public static boolean db_access(String pathToDB, BigDecimal in) {
        File saveFile = new File(pathToDB);
        // If file does not exists, create it and return false
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
                System.out.println("... File created");
            } catch(IOException io) {
                System.out.println(io);
            }
            return true;
        }
        // Locates if nubmer exists in database
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToDB));
            if (br.readLine() != null) {
                FileReader reader = new FileReader(pathToDB);
                JSONParser parser = new JSONParser();
                JSONArray ans = (JSONArray) parser.parse(reader);
                // System.out.println(ans.get(input));
                for (Object o : ans) {
                    JSONObject ret = (JSONObject) o;
                    if ((ret.get(input)).equals(in.toString())) {
                        return false;
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Err while searching through file");
            System.out.println(e);
            return true;
        }

        System.out.println(saveFile.getPath());
        return true;
    }
    /**
     * <h3>Save BigDecimal to database</h3>
     */
    public static void db_save(String pathToDB, BigDecimal in, BigDecimal out) {
        try {
            HashMap<String, Object> save = new HashMap<String, Object>();
            save.put(input, in.toString());
            save.put(answer, out.toString());
            JSONObject numberSave = new JSONObject(save);
            // Saving to .json file
            JSONArray array = new JSONArray();
            // Loading previous json
            try {
                BufferedReader br = new BufferedReader(new FileReader(pathToDB));
                if (br.readLine() != null) {
                    br.close();
                    JSONParser parser = new JSONParser();
                    JSONArray prevArray = (JSONArray) parser.parse(new FileReader(pathToDB));
                    for (Object o : prevArray) {
                        JSONObject prevO = (JSONObject) o;
                        array.add(prevO);
                    }
                }
                br.close();
            } catch (Exception e) { 
                System.out.println("Err while loading file data");
                System.out.println(e);
                return;
            }
            array.add(numberSave);
            Files.write(Paths.get(pathToDB), array.toJSONString().getBytes());
            return;
        } catch (IOException e) {
            System.out.println("Err while saving file");
            System.out.println(e);
            return;
        }
    }
    /**
     * <h3>Load number from database</h3>
     */
    public static BigDecimal db_load(String pathToDB, BigDecimal in, String type) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray loadArray = (JSONArray) parser.parse(new FileReader(pathToDB));
            for (Object o : loadArray) {
                JSONObject loadO = (JSONObject) o;
                if ((loadO.get(input)).equals(in.toString())) {
                    return new BigDecimal((loadO.get(answer)).toString());
                }
            }
            return db_newVal(in, type);
        } catch (Exception e) {
            System.out.println("Err while loading file");
            System.out.println(e);
            return db_newVal(in, type);
        }
    }
    /**
     * <h3>Catch for errors - return value newly computed</h3>
     */
    private static BigDecimal db_newVal(BigDecimal in, String type) {
        if (type.equals("sin")) {
            return BigDecimalMath.sin(in, false);
        } else {
            return BigDecimal.ZERO;
        }
    }
}