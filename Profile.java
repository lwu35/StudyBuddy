package com.example.faraz.studybuddy;

public class Profile {
    private String name;
    private String birthday;
    private String imgURL;

    public Profile(String name, String birthday, String imgURL) {
        this.birthday = birthday;
        this.name = name;
        this.imgURL = imgURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
