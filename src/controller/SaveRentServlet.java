package controller;

import business.dao.RentDAO;
import business.impl.RentDaoImpl;
import model.TRent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveRentServlet", value = "/SaveRentServlet")
public class SaveRentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TRent rent = new TRent();

        rent.setRentId(Integer.parseInt(request.getParameter("rentId")));
        rent.setCarId(Integer.parseInt(request.getParameter("carId")));
        rent.setRenterid(request.getParameter("renterid"));
        rent.setFromDat(request.getParameter("fromDat"));
        rent.setToDat(request.getParameter("toDat"));
        rent.setStatus(request.getParameter("status"));

        RentDAO cdao = new RentDaoImpl();
        if (cdao.addRent(rent) > 0) {
            System.out.println(rent.getStatus());
            //response.getWriter().write(user.getName()+" successfully added");
        }
    }
}
