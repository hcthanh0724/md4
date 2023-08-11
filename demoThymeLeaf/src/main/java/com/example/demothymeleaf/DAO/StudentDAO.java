package com.example.demothymeleaf.DAO;

import com.example.demothymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO{
    private String URL = "jdbc:mysql://localhost:3306/sinhvien?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
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
    public void insertStudent(Student student){
        String sql = "INSERT INTO `sinhvien`.`student` (`name`, `age`, `country`, `img`, `id_class`) VALUES (?,?,?,?,?)";
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getCountry());
            preparedStatement.setString(4,student.getImg());
            preparedStatement.setInt(5,student.getId_class());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public List<Student> showHome() {
        String sql = "SELECT id,name,age,country,img,student.id_class,name_class FROM student JOIN class on student.id_class = class.id_class";
        List<Student> students = new ArrayList<>();
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String country = rs.getString("country");
                String img = rs.getString("img");
                int id_class = rs.getInt("id_class");
                String name_class = rs.getString("name_class");
                students.add(new Student(id,name,age,country,img,id_class,name_class));
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return students;
    }

    @Override
    public Student selectStudent(int id) {
        String sql = "SELECT id,name,age,country,img,student.id_class,name_class FROM student JOIN class on student.id_class = class.id_class where id = ?";
        Student student= null;
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String country = rs.getString("country");
                String img = rs.getString("img");
                int id_class = rs.getInt("id_class");
                String name_class = rs.getString("name_class");
                student = new Student(id,name,age,country,img,id_class,name_class);
            }
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return student;
    }

    @Override
    public boolean editStudent( Student student) {
        boolean rowUpdate = false;
        String sql = "UPDATE `sinhvien`.`student` SET name = ?, age = ?, country = ?, img = ?, id_class = ? WHERE id =? ";
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.setString(3,student.getCountry());
            preparedStatement.setString(4,student.getImg());
            preparedStatement.setInt(5,student.getId_class());
            preparedStatement.setInt(6,student.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        String sql = "DELETE from `student` WHERE id = ?";
        try(Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e){
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<Student> search(String name) {
        return null;
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
