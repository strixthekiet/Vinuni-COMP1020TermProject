package com.sportsinventory.DTO;

public class UserDTO {
    private int userID;
    private String userName, name, email, password, regDate, cohort, major;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) { this.regDate = regDate; }
    
    public String getCohort() {
        return cohort;
    }
    
    public void setCohort(String cohort) {this.cohort = cohort;}
    
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {this.major = major;}
}