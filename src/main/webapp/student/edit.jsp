<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 07/11/2023
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <style>
    h2  {
      color: cadetblue;
    }
    input   {
      height: 30px;
      width: 300px;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    tr , td {
      width: 100%;
    }
    button {
      height: 30px;
    }
  </style>
</head>
<body>
<center>
  <h2>FORM ADD STUDENT</h2>

  <form action="http://localhost:8080/student?action=edit" method="post">
    <table>

      <tr>
        <td><input type="text" value="${student.name}" name="name" placeholder="Name"></td>
      </tr>
      <tr>
        <td><input type="text" value="${student.getBirthDay()}"  name="birthday" placeholder="Birth Day"></td>
      </tr>
      <tr>
        <td><input type="text" value="${student.email}"  name="email" placeholder="Email"></td>
      </tr>
      <tr>
        <td><input type="text" value="${student.address}" name="address" placeholder="Address"></td>
      </tr>
      <tr>
        <td><input type="text" value="${student.getPhoneNumber()}" name="phonenumber" placeholder="Phone Number"></td>
      </tr>
      <tr>
        <td><input type="text" value="${student.getClassRoomId()}" name="classroomId" placeholder="Class"></td>
      </tr>
      <tr><td><input type="hidden" value="${student.getId()}" name="id"></td></tr>
      <tr>
        <td>
          <button>Submit</button>
        </td>
      </tr>
    </table>
  </form>
</center>
</body>
</html>
