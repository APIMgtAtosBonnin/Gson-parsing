import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GJsonExample {
    public static void main(String[] args) {
        //Parsing JSON Into Java Objects
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting(); //Json pretty print
        builder.serializeNulls(); //Serialize null fields
        builder.excludeFieldsWithoutExposeAnnotation(); //Get Gson to react to @Expose
        Gson gson = builder.create();
        String json = "{'brand':'Jeep', " +
                "'doors': 3, " +
                "'colour': 'Orange', " +
                "'HP': '1000', " +
                "'type': 'Family'}";
        Car car = gson.fromJson(json, Car.class); //parse JSON string into Car object (deserialize)
        System.out.println("Car brand: " + car.brand
                + "\nn# of doors: " + car.doors
                + "\nColour: " + car.colour
                + "\nHP: " + car.HP
                + "\ntype: " + car.type);

        //Generating JSON From Java Objects (serialize)
        car.brand = "Rover";
        car.doors = 5;
        car.colour  = "Red";
        car.HP = 1200;
        car.type = null;
        json = gson.toJson(car);
        System.out.println(json);


    }
}

