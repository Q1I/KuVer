/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.definitions;

/**
 *
 * @author q1
 */
public class User {
    private String name;
    private String pass;
    
    public User(String name, String pass){
        this.name=name;
        this.pass=pass;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
