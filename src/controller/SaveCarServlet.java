package controller;

import business.dao.CarDAO;
import business.dao.UserDAO;
import business.impl.CarDaoImpl;
import business.impl.UserDaoImpl;
import model.TCar;
import model.TUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveCarServlet", value = "/SaveCar")
public class SaveCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TCar car = new TCar();

        //   car.setCarId(Integer.parseInt(request.getParameter("carId")));
        car.setCarPlat(request.getParameter("carPlat"));
        car.setCarBrand(request.getParameter("carBrand"));
        car.setCarModel(request.getParameter("carModel"));
        car.setDescription(request.getParameter("carDesc"));
        car.setEngine(request.getParameter("engine"));
        car.setPhotourl(request.getParameter("photourl"));
        car.setPrice(Integer.getInteger(request.getParameter("price")));
        car.setLocation(request.getParameter("location"));
        car.setUserid(request.getParameter("userid"));

        CarDAO cdao = new CarDaoImpl();
        if (cdao.addCar(car) > 0) {
            System.out.println(car.getCarBrand());
            //response.getWriter().write(user.getName()+" successfully added");
        }
    }
}
