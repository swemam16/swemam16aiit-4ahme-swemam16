package jsontutorial;

import com.google.gson.Gson;

public class Test4 {
    public static void main(String[] args) {
        Gson gson = new Gson();
 
        System.out.println(
            gson.fromJson("{'id':1,'firstName':'Christoph','lastName':'Gupta','roles':['ADMIN','MANAGER']}", Employee.class));
    }
}
