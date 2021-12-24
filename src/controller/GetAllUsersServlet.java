package controller;

import business.dao.UserDAO;
import business.impl.UserDaoImpl;
import com.google.gson.Gson;
import model.TUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllUsersServlet", value = "/GetAllUsersServlet")
public class GetAllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO sdao = new UserDaoImpl();
        List<TUser> list = sdao.getAllUsers();

        Gson gson = new Gson();
        String json = gson.toJson(list);

        response.getWriter().write(json);
    }
}
