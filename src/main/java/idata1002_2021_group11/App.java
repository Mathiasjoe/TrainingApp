package idata1002_2021_group11;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static idata1002_2021_group11.JsonWriteTest.writeJsonSimpleDemo;

class App {
    /**
     * Writing to the file example
     */
    public static void main(String[] args) throws Exception {
        // test to write to file
        writeJsonSimpleDemo("example2.json");
    }


    /**
     * Reading from the file example
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        JSONArray jsonArray = (JSONArray) readJsonSimpleDemo("example2.json");
//
//        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
//
//        System.out.println(jsonObject);
//    }
//
//    public static Object readJsonSimpleDemo(String filename) throws Exception {
//        FileReader reader = new FileReader(filename);
//        JSONParser jsonParser = new JSONParser();
//        return jsonParser.parse(reader);
//    }
}