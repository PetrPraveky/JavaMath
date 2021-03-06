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
import lib.java.numbers.ComplexNumber;

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
    private static final String r_in = "r_in"; private static final String i_in = "i_in";
    private static final String r_ans = "r_ans"; private static final String i_ans = "i_ans";
    /**
     * <h3>Acces BigDecimal database files</h3>
     */
    public static boolean db_access(String pathToDB, BigDecimal... in) {
        File saveFile = new File(pathToDB);
        // If file does not exists, create it and return true
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
                br.close();
                FileReader reader = new FileReader(pathToDB);
                JSONParser parser = new JSONParser();
                JSONArray ans = (JSONArray) parser.parse(reader);
                int e = 0;
                for (Object o : ans) {
                    JSONObject ret = (JSONObject) o;
                    if ((ret.get(input)).toString().contains("[")) {
                        JSONArray multiA = (JSONArray) ret.get(input);
                        int i = 0; e = 0;
                        for (Object p : multiA) {
                            if((p.toString()).equals(in[i].toString())) {
                                e++;
                            } else {
                                e--;
                            }
                            i++;
                        }
                    }
                    if ((ret.get(input)).equals(in.toString())) {
                        return false;
                    }
                    if (e == in.length) {
                        return false;
                    }
                }
                br.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Err while searching through file");
            System.out.println(e);
            return true;
        }

        // System.out.println(saveFile.getPath());
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
     * <h3>Save for more input values</h3>
     */
    public static void db_multi_save(String pathToDB, BigDecimal out, BigDecimal... in) {
        try {
            JSONArray inputAr = new JSONArray();
            for (int i = 0; i<in.length; i++) {
                inputAr.add(in[i].toString());
            }
            HashMap<String, Object> save = new HashMap<String, Object>();
            save.put(input, inputAr);
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
     * <h3>Load for more input values</h3>
     */
    public static BigDecimal db_multi_load(String pathToDB, String type, BigDecimal... in) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray loadArray = (JSONArray) parser.parse(new FileReader(pathToDB));
            boolean load = true; int e = 0;
            JSONObject loadO = new JSONObject();
            for (Object o : loadArray) {
                loadO = (JSONObject) o;
                JSONArray array = (JSONArray) loadO.get(input);
                int i = 0; e = 0;
                for (Object p : array) {
                    if (p.toString().equals(in[i].toString())) {
                        e++;
                    } else {
                        e--;
                    }
                    i++;
                }
                if (e == 2) {
                    load = true;
                    break;
                }
            }
            if (load) {
                return new BigDecimal((loadO.get(answer)).toString());
            } else {
                return db_multi_newVal(type, in);
            }
        } catch (Exception e) {
            System.out.println("Err while loading file");
            System.out.println(e);
            return db_multi_newVal(type, in);
        }
    }
    /**
     * <h3>Catch for errors - return value newly computed</h3>
     */
    private static BigDecimal db_newVal(BigDecimal in, String type) {
        // Trigonometric
        if (type.equals("sin")) {
            return BigDecimalMath.sin(in, false);
        }
        else if (type.equals("cos")) {
            return BigDecimalMath.cos(in, false);
        }
        // Inverse trigonometric
        if (type.equals("atan")) {
            return BigDecimalMath.arctan(in, false);
        }
        // Hyperbolic
        if (type.equals("sinh")) {
            return BigDecimalMath.sinh(in, false);
        }
        else if (type.equals("cosh")) {
            return BigDecimalMath.cosh(in, false);
        }
        // Exponential
        if (type.equals("exp")) {
            return BigDecimalMath.exp(in, false);
        }
        // Natural logarithm
        if (type.equals("ln")) {
            return BigDecimalMath.log(in, false);
        }
        // Factorial
        if (type.equals("fact")) {
            return BigDecimalMath.factorial(in, false);
        }
        return BigDecimal.ZERO;
    }
    /**
     * <h3>Multivalued return function</h3>1
     */
    private static BigDecimal db_multi_newVal(String type, BigDecimal... in) {
        // Power function
        if (type.equals("pow")) {
            return BigDecimalMath.pow(in[0], in[1], false);
        }
        return BigDecimal.ZERO;
    }
    /**
     * <h3>Accesing data from complex number database</h3>
     */
    public static boolean db_complex_acces(String path, ComplexNumber... in) {
        File saveFile = new File(path);
        // If file does not exists, create it and return true
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
                System.out.println("... File created");
            } catch (IOException io) {
                System.out.println(io);
            }
            return true;
        }
        // locates if number existrs in database
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            if (br.readLine() != null) {
                br.close();
                FileReader reader = new FileReader(path);
                JSONParser parser = new JSONParser();
                JSONArray ans = (JSONArray) parser.parse(reader);
                int e = 0; int f = 0;
                for (Object o : ans) {
                    JSONObject ret = (JSONObject) o;
                    if ((ret.get(r_in)).toString().contains("[")) {
                        JSONArray r_in_a = (JSONArray) ret.get(r_in);
                        JSONArray i_in_a = (JSONArray) ret.get(i_in);
                        int i = 0; int j = 0;
                        e = 0; f = 0;
                        for (Object re : r_in_a) {
                            if(re.toString().equals((in[i]).REAL.toString())) {
                                e++;
                            } else {
                                e--;
                            }
                            i++;
                        }
                        for (Object im : i_in_a) {
                            if(im.toString().equals((in[j]).IMG.toString())) {
                                f++;
                            } else {
                                f--;
                            }
                            j++;
                        }
                    }
                    if ((ret.get(r_in).toString().equals(in[0].REAL.toString())) && (ret.get(i_in).toString().equals(in[0].IMG.toString()))) {
                        return false;
                    }
                    if (e == in.length && f == in.length) {
                        return false;
                    }
                }
            } else {
                br.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Err while searching through file - complex");
            System.out.println(e);
            return true;
        }
        return true;
    }
    /**
     * <h3>Complex Number save</h3>
     */
    public static void db_complex_save(String path, ComplexNumber in, ComplexNumber out) {
        try {
            HashMap<String, Object> inp = new HashMap<String, Object>();
            // Input
            inp.put(r_in, in.REAL.toString()); inp.put(i_in, in.IMG.toString());
            // Output
            inp.put(r_ans, out.REAL.toString()); inp.put(i_ans, out.IMG.toString());
            JSONObject numberSave = new JSONObject(inp);
            // Saving to .json file
            JSONArray array = new JSONArray();
            // Try loading previous json
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                if (br.readLine() != null) {
                    br.close();
                    JSONParser parser = new JSONParser();
                    JSONArray prevArray = (JSONArray) parser.parse(new FileReader(path));
                    for (Object o : prevArray) {
                        JSONObject prevO = (JSONObject) o;
                        array.add(prevO);
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Err while loading file data - complex");
                System.out.println(e);
                return;
            }
            array.add(numberSave);
            Files.write(Paths.get(path), array.toJSONString().getBytes());
            return;
        } catch (IOException e) {
            System.out.println("Err while saving file - complex");
            System.out.println(e);
            return;
        }
    }
    /**
     * <h3>Save multi complex inputs</h3>
    */
    public static void db_complex_multi_save(String path, ComplexNumber out, ComplexNumber... in) {
        try {
            JSONArray inputArR = new JSONArray();
            JSONArray inputArI = new JSONArray();
            for (int i = 0; i<in.length; i++) {
                inputArR.add(in[i].REAL.toString());
                inputArI.add(in[i].IMG.toString());
            }
            HashMap<String, Object> save = new HashMap<String, Object>();
            // Input
            save.put(r_in, inputArR); save.put(i_in, inputArI);
            // Output
            save.put(r_ans, out.REAL.toString()); save.put(i_ans, out.IMG.toString());
            JSONObject numberSave = new JSONObject(save);
            // Saving to .json file
            JSONArray array = new JSONArray();
            // Try loading previous json
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                if (br.readLine() != null) {
                    br.close();
                    JSONParser parser = new JSONParser();
                    JSONArray prevArray = (JSONArray) parser.parse(new FileReader(path));
                    for (Object o : prevArray) {
                        JSONObject prevO = (JSONObject) o;
                        array.add(prevO);
                    }
                }
                br.close();
            } catch (Exception e) {
                System.out.println("Err while loading file data - complex");
                System.out.println(e);
                return;
            }
            array.add(numberSave);
            Files.write(Paths.get(path), array.toJSONString().getBytes());
            return;
        } catch (IOException e) {
            System.out.println("Err while saving file - complex");
            System.out.println(e);
            return;
        }
    }
    /**
     * <h3>Load complex number from database</h3>
     */
    public static ComplexNumber db_complex_load(String path, ComplexNumber in, String type) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray loadArray = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : loadArray) {
                JSONObject loadO = (JSONObject) o;
                if ((loadO.get(r_in).toString()).equals(in.REAL.toString()) && (loadO.get(i_in).toString()).equals(in.IMG.toString())) {
                    return new ComplexNumber(new BigDecimal((loadO.get(r_ans)).toString()), new BigDecimal((loadO.get(i_ans)).toString()));
                }
            }
            return db_complex_newVal(in, type);
        } catch (Exception e) {
            System.out.println("Err while loading file - complex");
            System.out.println(e);
            return db_complex_newVal(in, type);
        }
    }
    /**
     * <h3>Complex number nulti load</h3>
     */
    public static ComplexNumber db_complex_multi_load(String path, String type, ComplexNumber... in) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray loadArray = (JSONArray) parser.parse(new FileReader(path));
            boolean load = true;
            int e = 0; int f = 0;
            JSONObject loadO = new JSONObject();
            for (Object o : loadArray) {
                loadO = (JSONObject) o;
                JSONArray r_in_a = (JSONArray) loadO.get(r_in);
                JSONArray i_in_a = (JSONArray) loadO.get(i_in);
                e = 0; f = 0;
                int i = 0; int j = 0;
                for (Object re : r_in_a) {
                    if (re.toString().equals(in[i].REAL.toString())) {
                        e++;
                    } else {
                        e--;
                    }
                    i++;
                }
                for (Object im : i_in_a) {
                    if (im.toString().equals(in[j].IMG.toString())) {
                        f++;
                    } else {
                        f--;
                    }
                    j++;
                }
                if (e == in.length && f == in.length) {
                    load = true;
                    break;
                }
            }
            if (load) {
                return new ComplexNumber(new BigDecimal(loadO.get(r_ans).toString()), new BigDecimal(loadO.get(i_ans).toString()));
            } else {
                return db_complex_multi_newVal(type, in);
            }
        } catch (Exception e) {
            System.out.println("Err while loading file - complex");
            System.out.println(e);
            return db_complex_multi_newVal(type, in);
        }
    }
    /**
     * <h3>Catch errors - returns newly created value</h3>
     */
    private static ComplexNumber db_complex_newVal(ComplexNumber in, String type) {
        // Square
        if (type.equals("sq")) {
            return ComplexNumber.square(in, false);
        }
        // Square root
        if (type.equals("sqrt")) {
            return ComplexNumber.sqrt(in, false);
        }
        // Exponential
        if (type.equals("exp")) {
            return ComplexNumber.exp(in, false);
        }
        // Natural logarithm
        if (type.equals("log")) {
            return ComplexNumber.log(in, false);
        }
        return ComplexNumber.ZERO;
    }
    /**
     * <h3>Catch errors - for multi complex numbers</h3>
     */
    private static ComplexNumber db_complex_multi_newVal(String type, ComplexNumber... in) {
        return ComplexNumber.ZERO;
    }
}
