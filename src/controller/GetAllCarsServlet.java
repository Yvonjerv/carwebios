package controller;

import business.dao.CarDAO;
import business.impl.CarDaoImpl;
import com.google.gson.Gson;
import model.TCar;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllCarsServlet", value = "/GetAllCarsServlet")
public class GetAllCarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDAO sdao = new CarDaoImpl();
        List<TCar> list = sdao.getCarListByCondition(null,null);

        Gson gson = new Gson();
        String json = gson.toJson(list);
System.out.println("ok");
        response.getWriter().write(json);
    }
}
