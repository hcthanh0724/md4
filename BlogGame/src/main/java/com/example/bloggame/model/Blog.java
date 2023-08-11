package com.example.bloggame.model;

public class Blog {
   private int id_post;
   private String img;
   private String background_img;
   private String header;
   private String role;
   private String biography;

    public Blog() {
    }

    public Blog(int id_post, String img, String background_img, String header, String role, String biography) {
        this.id_post = id_post;
        this.img = img;
        this.background_img = background_img;
        this.header = header;
        this.role = role;
        this.biography = biography;
    }

    public Blog(int id_post,String img, String header) {
        this.id_post = id_post;
        this.img = img;
        this.header = header;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBackground_img() {
        return background_img;
    }

    public void setBackground_img(String background_img) {
        this.background_img = background_img;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
