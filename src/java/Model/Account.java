/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trana
 */
public class Account {
    String username;
    String password;
     
    String image;
    String name;
    boolean isStudent;
    boolean isStaff;

    public Account() {
    }

    public Account(String username, String password, String image, String name, boolean isStudent, boolean isStaff) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.name = name;
        this.isStudent = isStudent;
        this.isStaff = isStaff;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    public boolean isIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

   


    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", image=" + image + ", name=" + name + ", isStudent=" + isStudent + ", isStaff=" + isStaff + '}';
    }

    

}
