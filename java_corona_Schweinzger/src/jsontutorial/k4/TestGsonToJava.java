/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial.k4;

import com.google.gson.Gson;
import jsontutorial.k1_1.Employee;

/**
 *
 * @author Christoph-PC
 */
public class TestGsonToJava {
    
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.fromJson("{'id':1,'firstName':'Christoph','lastName':'Maier','roles':['Admin','Chef']}", Employee.class));
    }
    
}
