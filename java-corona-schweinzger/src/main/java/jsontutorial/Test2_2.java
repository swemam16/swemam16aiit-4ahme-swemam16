
package jsontutorial;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test2_2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().serializeNulls().create();
    }
  
}
