package business.impl;

import basic.BaseDAO;
import basic.BaseDaoImpl;
import business.dao.CarDAO;
import model.TCar;

import java.sql.ResultSet;
import java.util.List;

public class CarDaoImpl implements CarDAO {
    //we need to process Database by data Access layer
    private BaseDAO dao = new BaseDaoImpl();

    @Override
    public int addCar(TCar car) {

        String sql = "insert into t_car( carPlat, carBrand, carModel, price, location, engine, photourl, description, userid) " +
                " values(?,?,?,?,?,?,?,?,?)";
        Object[] para = {car.getCarPlat(), car.getCarBrand(), car.getCarModel(), car.getPrice(), car.getLocation(),
                car.getEngine(), car.getPhotourl(), car.getDescription(), car.getUserid()};
        int row = dao.insert(sql, para);
        if (row > 0) return row;
        else return -1;
    }

    @Override
    public boolean modifyCar(TCar car) {
        String sql = "update t_car set carPlat=?, carBrand=?, carModel=?, price=?, location=?, " +
                "engine=?,  photourl=?, description=?, userid=? " +
                " where carId=?";
        Object[] para = {car.getCarPlat(), car.getCarBrand(), car.getCarModel(), car.getPrice(), car.getLocation(),
                car.getEngine(), car.getPhotourl(), car.getDescription(), car.getUserid(), car.getCarId()};
        return dao.update(sql, para);
    }

    @Override
    public TCar getCarById(int carId) {
        String sql = "select * from t_car where carId=?";
        Object[] para = {carId};
        ResultSet rs = dao.select(sql, para);
        TCar car = new TCar(rs);
        dao.close();
        return car;
    }

    @Override
    public List<TCar> getCarListByCondition(String position, String carBrand) {
        if (position == null && carBrand == null) {
            String sql = "select * from t_car order by carid desc ";

            ResultSet rs = dao.select(sql, null);
            List<TCar> list = TCar.toList(rs);
            dao.close();
            return list;
        } else {
            String sql = "select * from t_car where ";
            String whereString = "";
            if (position != null) {
                whereString += "(userid like '%" + position + "%' " +
                        "or engine like '%" + position + "%')";
            }
            if (carBrand != null) {
                if (whereString.equals("")) {
                    whereString += "carBrand like '%" + carBrand + "%'";
                } else {
                    whereString += "and carBrand like '%" + carBrand + "%'";
                }
            }
            sql += whereString;
            ResultSet rs = dao.select(sql, null);
            List<TCar> list = TCar.toList(rs);
            dao.close();
            return list;
        }
    }

    @Override
    public List<TCar> getCarListByUserId(String userId) {
        String userid = userId;
        String sql = "select * from t_car " +
                "where userid like '%" + userid +"%' " +" order by carid desc ";

        ResultSet rs = dao.select(sql, null);
        List<TCar> list = TCar.toList(rs);
        dao.close();
        return list;
    }
}
