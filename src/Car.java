import com.google.gson.annotations.Expose;

public class Car {
    @Expose()
    public String brand = null;
    @Expose(serialize = true)
    public static int    doors = 0;
    @Expose()
    public transient String colour = "Grey"; //Exclude from Gson serialization & deserialization
    @Expose(serialize = false, deserialize = true) //Exclude from Gson serialization
    public int HP = 0;
    @Expose(serialize = true, deserialize = false) //Exclude from Gson deserialization
    public String type = null;
    }
