package com.example.loginregister;

public class Information {
    private  String email;
    private  String passW;

    public  Information(){

    }
    public Information(String email,String PassWord){
        this.email= email;
        this.passW=PassWord;

    }

    public String getEmail() {
        return email;
    }

    public String getPassW() {
        return passW;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassW(String passW) {
        this.passW = passW;
    }
}
