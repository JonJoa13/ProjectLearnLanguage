/**
 * Author: Théodore Pillet and Jonathan Joaquim.
 */
package db.object.object;



public class User {
    private int id;
    private String name;
    private String firstname;
    private String email;
    private String mdp;

    public User(){}

    public User(String name, String firstname, String email, String mdp){
        this.name=name;
        this.firstname=firstname;
        this.email=email;
        this.mdp=mdp;
    }

    public User(int id, String name, String firstname, String email, String mdp ){
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
