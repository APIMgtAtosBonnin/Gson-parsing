import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class GsonApp {
    static class MyClass {
        transient int id;
        @Expose(serialize = true, deserialize = true)
        transient String password;
        @Expose(serialize = false, deserialize = false)
        int champ_1;
        @Expose(serialize = false, deserialize = true)
        int champ_2;
        @Expose(serialize = true, deserialize = false)
        static int champ_3;
        static int champ_4;
    }
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.id = 1;
        mc.password = "SPB@A_21";
        mc.champ_1 = 2;
        mc.champ_2 = 3;
        mc.champ_3 = 4;
        mc.champ_4 = 5;
        GsonBuilder gsonb = new GsonBuilder();
        gsonb.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonb.create();
        String json = gson.toJson(mc) ;
        System.out.println(json);
        MyClass mc2 = gson.fromJson(json, MyClass.class);
        System.out.println("id = " + mc2.id);
        System.out.println("Password = " + mc2.id);
        System.out.println("Champ 1 = " + mc2.champ_1);
        System.out.println("Champ 2 = " + mc2.champ_2);
        System.out.println("Champ 3 = " + mc2.champ_3);
        System.out.println("Champ 4 = " + mc2.champ_4);
    }
}