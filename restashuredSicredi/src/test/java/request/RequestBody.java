package request;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestBody {

    public String jsonMetodoPostAuth(String userName, String pass){
        String jsonBody = "{\n" +
                "    \"username\": " + "\"" + userName + "\"" + "," +
                "    \"password\": " + "\"" + pass + "\"" +
                "}";
        return jsonBody;
    }

    public String jsonMetodoPath(String name, String job){
        String jsonBody = "{\n" +
                "    \"name\":" + "\"" + name + "\"" + "," +
                "    \"job\":" + "\"" + job + "\"" +
                "}";
        return jsonBody;
    }

    public static Map<String, Object> jsonMetodoPostProductAdd(
            String title,
            String description,
            double price,
            double discountPercentage,
            double rating,
            int stock,
            String brand,
            String category) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("title", title);
        body.put("description", description);
        body.put("price", price);
        body.put("discountPercentage", discountPercentage);
        body.put("rating", rating);
        body.put("stock", stock);
        body.put("brand", brand);
        body.put("category", category);
        body.put("thumbnail", "https://i.dummyjson.com/data/products/11/thumbnail.jpg");

        return body;
    }
}
