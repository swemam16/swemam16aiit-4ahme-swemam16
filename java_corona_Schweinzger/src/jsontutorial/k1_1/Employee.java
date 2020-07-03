/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial.k1_1;

import java.util.List;

/**
 *
 * @author Christoph-PC
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private List<String> roles;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName) {
        if(id <= 0) {
            throw new IllegalArgumentException("ungueltiger Wert fuer ID");
        }
        
        if(firstName.isEmpty() || firstName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer firstname");
        }
        
        if(lastName.isEmpty() || lastName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer lastname");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("ungueltiger Wert fuer ID");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.isEmpty() || firstName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer firstname");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty() || lastName == null) {
            throw new IllegalArgumentException("ungueltiger Wert fuer lastname");
        }
        this.lastName = lastName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
   @Override
   public String toString() {
      return "Employee [id=" + id + ", firstName=" + firstName + ", " +
            "lastName=" + lastName + ", roles=" + roles + "]";
   }
}
