package controller;

import business.dao.RentDAO;
import business.impl.RentDaoImpl;
import com.google.gson.Gson;
import model.TRent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllRentsServlet", value = "/GetAllRentsServlet")
public class GetAllRentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RentDAO sdao = new RentDaoImpl();
        List<TRent> list = sdao.getRentListByCondition(null,null);

        Gson gson = new Gson();
        String json = gson.toJson(list);

        response.getWriter().write(json);
    }
}
