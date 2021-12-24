package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TRent {
    private int rentId;
    private String renterid;
    private String fromDat;
    private String toDat;
    private int carId;
    private String status;
    private String createtime;

    public TRent() {
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public String getRenterid() {
        return renterid;
    }

    public void setRenterid(String renterid) {
        this.renterid = renterid;
    }

    public String getFromDat() {
        return fromDat;
    }

    public void setFromDat(String fromDat) {
        this.fromDat = fromDat;
    }

    public String getToDat() {
        return toDat;
    }

    public void setToDat(String toDat) {
        this.toDat = toDat;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    //exchange single user data from table to TRent bean
    public TRent(ResultSet rs) {
        try {
            if (rs != null && rs.next()) {
                this.setCarId(rs.getInt("carId"));
                this.setRenterid(rs.getString("renterid"));
                this.setRentId(rs.getInt("rentId"));
                this.setFromDat(rs.getString("fromDat"));
                this.setToDat(rs.getString("toDat"));
                this.setStatus(rs.getString("status"));
                this.setCreatetime(rs.getString("createtime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //exchange multiple user data from table to TRent bean
    public static ArrayList<TRent> toList(ResultSet rs) {
        ArrayList<TRent> list = new ArrayList<TRent>();
        try {
            while (rs != null && rs.next()) {
                TRent rent = new TRent();
                rent.setCarId(rs.getInt("carId"));
                rent.setRenterid(rs.getString("renterid"));
                rent.setRentId(rs.getInt("rentId"));
                rent.setFromDat(rs.getString("fromDat"));
                rent.setToDat(rs.getString("toDat"));
                rent.setStatus(rs.getString("status"));
                rent.setCreatetime(rs.getString("createtime"));
                list.add(rent);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
