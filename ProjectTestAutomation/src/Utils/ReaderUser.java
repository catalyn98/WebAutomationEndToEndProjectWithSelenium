package Utils;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import TestData.User;

public class ReaderUser {
    public static List<User> readUsers(String fileName) {
        String jsonPath = System.getProperty("user.dir") + "\\src\\TestDataFiles\\" + fileName + ".json";
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(jsonPath)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("users");
            for (Object obj : jsonArray) {
                JSONObject userJson = (JSONObject) obj;
                String username = (String) userJson.get("username");
                String password = (String) userJson.get("password");
                User user = new User(username, password);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
