import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonJsonParser {

    static String json = "{ \"f1\":\"Hello\",\"f2\":{\"f3\":\"World\"}}";

    public static void main(String[] args) {
        JsonElement jsonTree = JsonParser.parseString(json);

        if(jsonTree.isJsonObject()){
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            JsonElement f1 = jsonObject.get("f1");
            System.out.println(f1);

            JsonElement f2 = jsonObject.get("f2");
            System.out.println(f2);

            if(f2.isJsonObject()){
                JsonObject f2Obj = f2.getAsJsonObject();

                JsonElement f3 = f2Obj.get("f3");
                System.out.println(f3);
            }

        }
    }


}
