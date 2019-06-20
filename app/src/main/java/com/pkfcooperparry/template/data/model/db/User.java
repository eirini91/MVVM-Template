package com.pkfcooperparry.template.data.model.db;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Eirini Televantou on 10/19/2018.
 * televantou91@gmail.com
 */
public class User extends RealmObject {
    @PrimaryKey
    @SerializedName("ID")
    long ID;
    @SerializedName("Name")
    String Name;
    @SerializedName("Surname")
    String Surname;
    @SerializedName("Email")
    String Email;
    @SerializedName("Password")
    String Password;
    @SerializedName("Avatar")
    String Avatar;
    @SerializedName("Gender")
    int Gender;
    @SerializedName("Age")
    int Age;
    @SerializedName("Phone")
    String Phone;
    @SerializedName("MainTeam")
    int MainTeam;
    @SerializedName("HomeTown")
    String HomeTown;
    @SerializedName("UsualPosition")
    int UsualPosition;
    @SerializedName("Error")
    String Error;
    @SerializedName("dob")
    String Dob;

    public User() {

    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHomeTown() {
        return HomeTown;
    }

    public void setHomeTown(String homeTown) {
        HomeTown = homeTown;
    }

    public int getUsualPosition() {
        return UsualPosition;
    }

    public void setUsualPosition(int usualPosition) {
        UsualPosition = usualPosition;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public int getMainTeam() {
        return MainTeam;
    }

    public void setMainTeam(int mainTeam) {
        MainTeam = mainTeam;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
