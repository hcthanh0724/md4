package com.example.bloggame.DAO;

import com.example.bloggame.model.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO {
    private String URL = "jdbc:mysql://localhost:3306/blog?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
//    List<Blog> blogs;
//    public BlogDAO() {
//        blogs = new ArrayList<>();
//    }
    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,jdbcUsername,jdbcPassword);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException c){
            c.printStackTrace();
        }
        return connection;
    }
    public void insertBlog(Blog blog) throws SQLException{
        String sql = "INSERT INTO `blog`.`blog` (`img`, `background_img`, `header`, `role`, `biography`) VALUES (?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,blog.getImg());
            preparedStatement.setString(2,blog.getBackground_img());
            preparedStatement.setString(3,blog.getHeader());
            preparedStatement.setString(4,blog.getRole());
            preparedStatement.setString(5,blog.getBiography());
            preparedStatement.executeUpdate();
        }
    }
    public Blog selectBlog(int id_post){
        String sql = "SELECT * FROM `blog`.`blog` WHERE id_post = ?";
        Blog blog = null;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_post);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String img = rs.getString("img");
                String background_img = rs.getString("background_img");
                String header = rs.getString("header");
                String role = rs.getString("role");
                String biography = rs.getString("biography");
                blog = new Blog(id_post,img,background_img,header,role,biography);
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return blog;
    }
    public List<Blog> showHome(){
        String sql = "SELECT `id_post`,`img`,`header` from `blog`";
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_post = rs.getInt("id_post");
                String img = rs.getString("img");
                String header = rs.getString("header");
                blogs.add(new Blog(id_post,img,header));
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return blogs;
    }
    public List<Blog> showDetail(){
        String sql = "SELECT * FROM `blog`";
        List<Blog> blogs = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_post = rs.getInt("id_post");
                String img = rs.getString("img");
                String background_img = rs.getString("background_img");
                String header = rs.getString("header");
                String role = rs.getString("role");
                String biography = rs.getString("biography");
                blogs.add(new Blog(id_post,img,background_img,header,role,biography));
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return blogs;
    }
    public boolean deleteBlog(int id_post){
        String sql = "DELETE from `blog` WHERE id_post = ?";
        boolean rowDeleted = false;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_post);

             rowDeleted = preparedStatement.executeUpdate() >0;
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return rowDeleted;
    }
    public  boolean updateBlog(Blog blog) {
        String sql = "UPDATE `blog` SET img = ?, background_img = ?, header =?, role =?, biography =? where id_post =? ";
        boolean rowUpdate = false;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,blog.getImg());
            preparedStatement.setString(2,blog.getBackground_img());
            preparedStatement.setString(3,blog.getHeader());
            preparedStatement.setString(4,blog.getRole());
            preparedStatement.setString(5,blog.getBiography());
            preparedStatement.setInt(6,blog.getId_post());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return rowUpdate;
    }
    public List<Blog> search(String header1){
        String sql = "SELECT blog.* FROM blog WHERE `blog`.`header` LIKE ?";
        List <Blog> blogList = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"%" + header1 + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id_post = rs.getInt("id_post");
                String img = rs.getString("img");
                String background_img = rs.getString("background_img");
                String header = rs.getString("header");
                String role = rs.getString("role");
                String biography = rs.getString("biography");
                blogList.add(new Blog(id_post,img,background_img,header,role,biography));
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return blogList;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
