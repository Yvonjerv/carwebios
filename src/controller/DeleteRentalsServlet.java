package controller;


import business.dao.RentDAO;
import business.impl.RentDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteRentalsServlet", value = "/DeleteRental")
public class DeleteRentalsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rentId = request.getParameter("rentId");

        RentDAO adao = new RentDaoImpl();

        if (adao.deleteRent(Integer.parseInt(rentId))) {
            response.getWriter().write("delete success");

            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
