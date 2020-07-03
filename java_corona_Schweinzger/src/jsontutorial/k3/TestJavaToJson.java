/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial.k3;

import com.google.gson.Gson;
import java.util.Arrays;
import jsontutorial.k1_1.Employee;



/**
 *
 * @author Christoph-PC
 */
public class TestJavaToJson {
    public static void main(String[] args) {
        Employee testEmployee = new Employee();
        testEmployee.setId(1);
        testEmployee.setFirstName("Christoph");
        testEmployee.setLastName("Maier");
        testEmployee.setRoles(Arrays.asList("Admin", "Chef"));
        
        Gson gson = new Gson();
        String jsonEmployee = gson.toJson(testEmployee);
        System.out.println(jsonEmployee); 
    }
    
}
