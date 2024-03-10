package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import TestData.Product;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReaderProduct {
    public static List<Product> readProducts(String fileName) {
        String jsonPath = System.getProperty("user.dir") + "\\src\\TestDataFiles\\" + fileName + ".json";
        List<Product> products = new ArrayList<>();
        try (FileReader reader = new FileReader(jsonPath)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("products");
            for (Object obj : jsonArray) {
                JSONObject productJson = (JSONObject) obj;
                String name = (String) productJson.get("name");
                String description = (String) productJson.get("description");
                String price = (String) productJson.get("price");
                Product product = new Product(name, description, price);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
