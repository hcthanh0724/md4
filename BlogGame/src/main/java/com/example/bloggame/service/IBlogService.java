package com.example.bloggame.service;

import com.example.bloggame.model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogService {
    public List<Blog> showHome();
//    public List<Blog> showDetail();
    public void addBlog(Blog blog);
    public void editBlog(Blog blog);
    public void deleteBlog(int id_post) throws SQLException;
}
