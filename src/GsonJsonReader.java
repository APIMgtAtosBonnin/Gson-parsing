import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

public class GsonJsonReader {

    static String json = "{\"brand\" : \"Toyota\", \"doors\" : 5}";
    static JsonReader jsonReader = new JsonReader(new StringReader(json));

    public static void main(String[] args) {
        try {
            while(jsonReader.hasNext()){
                JsonToken nextToken = jsonReader.peek();
                System.out.println(nextToken);

                if(JsonToken.BEGIN_OBJECT.equals(nextToken)){

                    jsonReader.beginObject();

                } else if(JsonToken.NAME.equals(nextToken)){

                    String name  =  jsonReader.nextName();
                    System.out.println(name);

                } else if(JsonToken.STRING.equals(nextToken)){

                    String value =  jsonReader.nextString();
                    System.out.println(value);

                } else if(JsonToken.NUMBER.equals(nextToken)){

                    long value =  jsonReader.nextLong();
                    System.out.println(value);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
