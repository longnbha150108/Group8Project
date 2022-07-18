/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trana
 */
public class Teacher {
    String id;
    String name;
    String gender;
    String image;
    String dob;
    String Intro;
    int favors;
    int comments;
    double rate;
    String subId;
    String subject;

    public Teacher(String id, String name, String gender,String image, String dob, String Intro, int favors, int comments, double rate,String subId, String subject) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.image = image;
        this.dob = dob;
        this.Intro = Intro;
        this.favors = favors;
        this.comments = comments;
        this.rate = rate;
        this.subId=subId;
        this.subject = subject;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public Teacher() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIntro() {
        return Intro;
    }

    public void setIntro(String Intro) {
        this.Intro = Intro;
    }

    public int getFavors() {
        return favors;
    }

    public void setFavors(int favors) {
        this.favors = favors;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

   
}
