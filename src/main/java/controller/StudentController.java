package controller;

import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private final StudentService service = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "students":
                showSearchStudent(request,response);
                break;
            case "create":
                showFormAdd(request,response);
                break;
            case "remove":
                remove(request,response);
                break;
            case "edit" :
                showFormEdit(request,response);
                break;

        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = service.findAll();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/students.jsp");
        request.setAttribute("studentList",studentList);
        requestDispatcher.forward(request,response);
    }
    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void  add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String classroomId = request.getParameter("classroomId");
        Student student = new Student(name,email,birthday,address,phonenumber,classroomId);
        service.add(student);
        response.sendRedirect("/student?action=students");
    }
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.remove(id);
        response.sendRedirect("student?action=sutdents");
    }
    private void showSearchStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("q");
      if (name == null) {
          name = "";
      }
   List<Student> students  = service.findByName(name);
        System.out.println(students);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/students.jsp");
      request.setAttribute("studentList",students);
      requestDispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("student",service.findById(id));
        request.getRequestDispatcher("student/edit.jsp").forward(request,response);
    }

    private void  editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String classroomId = request.getParameter("classroomId");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = new Student(name,birthday,email,address,phonenumber,classroomId);
        service.edit(id,student);
        response.sendRedirect("/student?action=students");

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create" :
                add(request,response);
                break;
            case "edit" :
                editStudent(request,response);
                break;
        }
    }
}