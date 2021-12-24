package controller;

import business.dao.UserDAO;
import business.impl.UserDaoImpl;
import model.TUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletOutputStream.*;

@WebServlet(name = "ServletSaveUser", value = "/SaveUser")
public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TUser user = new TUser();

        user.setUserid(request.getParameter("userid"));
        user.setUsername(request.getParameter("username"));
        user.setGender( request.getParameter("gender"));
        user.setMail(request.getParameter("mail"));
        user.setMobile(request.getParameter("mobile"));
        user.setPwd(request.getParameter("pwd"));
        user.setPhotourl(request.getParameter("photourl"));

        UserDAO udao = new UserDaoImpl();
        System.out.println("user");
        if(udao.registerUser(user)){
            System.out.println(user.getUsername());
            //response.getWriter().write(user.getMail()+" successfully added");
            //response.getWriter().print("success");
            response.getWriter().write("upload success");
           // out.print("success");
        }
    }
}
