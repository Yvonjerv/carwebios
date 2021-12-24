package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TCar {
    private int carId;
    private String carPlat;
    private String carBrand;
    private String carModel;
    private int price;
    private String location;
    private String engine;
    private String photourl;
    private String carDesc;
    private String userid;

    public TCar() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarPlat() {
        return carPlat;
    }

    public void setCarPlat(String carPlat) {
        this.carPlat = carPlat;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getDescription() {
        return carDesc;
    }

    public void setDescription(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    //exchange single user data from table to TCar bean
    public TCar(ResultSet rs) {
        try {
            if (rs != null && rs.next()) {
                this.setCarId(rs.getInt("carId"));
                this.setCarPlat(rs.getString("carPlat"));
                this.setCarBrand(rs.getString("username"));
                this.setCarModel(rs.getString("carModel"));
                this.setDescription(rs.getString("description"));
                this.setEngine(rs.getString("engine"));
                this.setPhotourl(rs.getString("photourl"));
                this.setPrice(rs.getInt("price"));
                this.setLocation(rs.getString("location"));
                this.setUserid(rs.getString("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //exchange multiple user data from table to TCar bean
    public static ArrayList<TCar> toList(ResultSet rs) {
        ArrayList<TCar> list = new ArrayList<TCar>();
        try {
            while (rs != null && rs.next()) {
                TCar car = new TCar();
                car.setCarId(rs.getInt("carId"));
                car.setCarPlat(rs.getString("carPlat"));
                car.setCarBrand(rs.getString("carBrand"));
                car.setCarModel(rs.getString("carModel"));
                car.setDescription(rs.getString("description"));
                car.setEngine(rs.getString("engine"));
                car.setPhotourl(rs.getString("photourl"));
                car.setPrice(rs.getInt("price"));
                car.setLocation(rs.getString("location"));
                car.setUserid(rs.getString("userid"));
                list.add(car);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
