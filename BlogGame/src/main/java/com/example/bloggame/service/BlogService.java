package com.example.bloggame.service;

import com.example.bloggame.DAO.BlogDAO;
import com.example.bloggame.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class BlogService implements IBlogService{

    private BlogDAO blogDAO;
    @Autowired
    public void setBlogDAO(BlogDAO blogDAO){
        this.blogDAO = blogDAO;
    }
    @Override
    public List<Blog> showHome() {
        return blogDAO.showHome();
    }

    @Override
    public void addBlog(Blog blog) {
        try {
            blogDAO.insertBlog(blog);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editBlog( Blog blog) {
        blogDAO.updateBlog(blog);
    }
    public Blog findById(int id_post){
        return blogDAO.selectBlog(id_post);
    }

    @Override
    public void deleteBlog(int id_post) throws SQLException {
        blogDAO.deleteBlog(id_post);
    }
    public List<Blog> search(String header1){
        return blogDAO.search(header1);
    }

    public Blog selectBlog(int id_post){
        return blogDAO.selectBlog(id_post);
    }
}
