
package jsontutorial;

import com.google.gson.Gson;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
      Employee employee = new Employee();
    
        employee.setId(1);
        employee.setFirstName("Martin");
        employee.setLastName("Schweinzger");
        employee.setRoles(Arrays.asList("Chef"));

        Gson gson = new Gson();
        System.out.println(gson.toJson(employee));  
    }  
}
