package service;

import connect.DatabaseConnection;
import model.Clazz;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudent<Student>{
    Connection connection = DatabaseConnection.getConnection();

    public StudentService() {
    }

    @Override
    public void add(Student student) {
        String sql = "insert into student(name, email, birthday, address, phonenumber, classroomId) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1,student.getId());
            statement.setString(1,student.getName());
            statement.setString(2,student.getEmail());
            statement.setString(3,student.getBirthDay());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhoneNumber());
            statement.setString(6,student.getClassRoomId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Student findById(int id) {
       String sql = "select * from student where id = ? and deleteflag = 0;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                String classId = resultSet.getString("classroomId");
                return new Student(id,name,email,birthday,address,phonenumber,classId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Student student) {
        String sql = "update student set name = ? , email = ? ,birthday = ? , address = ?, phonenumber = ? , classroomId = ? where  id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setString(3,student.getBirthDay());
            preparedStatement.setString(4,student.getAddress());
            preparedStatement.setString(5,student.getPhoneNumber());
            preparedStatement.setString(6,student.getClassRoomId());
            preparedStatement.setInt(7,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        String sql = "update student set deleteflag = 1 where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select s.id,s.name,s.birthday,s.email,s.address,s.phonenumber,c.id,c.name as classname from student s join class c on c.id = s.classroomId\n" +
                "where s.deleteflag = 0;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                String classId = resultSet.getString("c.id");
                String classname = resultSet.getString("classname");
                Clazz clazz = new Clazz(classId,classname);
                Student student = new Student(id,name,email,birthday,address,phonenumber,clazz);
                students.add(student);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }

    @Override
    public Student findByStringId(String id) {
        return null;
    }


    public List<Student> findByName(String nameOut){
        List<Student> students = new ArrayList<>();
        String sql = "select s.id,s.name,s.birthday,s.email,s.address,s.phonenumber,c.id,c.name as classname from student s join class c on c.id = s.classroomId\n" +
                "where s.name like ? and s.deleteflag = 0;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,'%' + nameOut + '%');
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                String phonenumber = resultSet.getString("phonenumber");
                String classId = resultSet.getString("c.id");
                String classname = resultSet.getString("classname");
                Clazz clazz = new Clazz(classId,classname);
                Student student = new Student(id,name,email,birthday,address,phonenumber,clazz);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;


    }
}
