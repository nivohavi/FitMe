package com.colman.fitme.model;

public class FriendsResponse {

    public String name;
    public String image;
    public String title;
    public String company;

    public FriendsResponse() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public FriendsResponse(String username, String email) {
        this.name = name;
        this.image = image;
        this.title = title;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
