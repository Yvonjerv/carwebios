package business.impl;

import basic.BaseDAO;
import basic.BaseDaoImpl;
import business.dao.RentDAO;
import model.TRent;

import java.sql.ResultSet;
import java.util.List;

public class RentDaoImpl implements RentDAO {
    //we need to process Database by data Access layer
    private BaseDAO dao = new BaseDaoImpl();

    @Override
    public int addRent(TRent rent) {

        String sql = "insert into t_rent( renterid, fromDat, toDat, carId, status) " +
                " values(?,?,?,?,?)";
        Object[] para = {rent.getRenterid(), rent.getFromDat(), rent.getToDat(), rent.getCarId(), rent.getStatus()};
        int row = dao.insert(sql, para);
        if (row > 0) return row;
        else return -1;
    }

    @Override
    public boolean modifyRent(TRent rent) {
        String sql = "update t_rent set renterid=?, fromDat=?, toDat=?, carId=?, status=?, "+
                " where rentId=?";
        Object[] para = {rent.getRenterid(), rent.getFromDat(), rent.getToDat(), rent.getCarId(), rent.getStatus(),
                rent.getRentId()};
        return dao.update(sql, para);
    }

    @Override
    public TRent getRentById(int rentId) {
        String sql = "select * from t_rent where rentId=?";
        Object[] para = {rentId};
        ResultSet rs = dao.select(sql, para);
        TRent rent = new TRent(rs);
        dao.close();
        return rent;
    }

    @Override
    public List<TRent> getRentListByCondition(String position, String rentBrand) {
        if (position == null && rentBrand == null) {
            String sql = "select * from t_rent order by rentid desc ";

            ResultSet rs = dao.select(sql, null);
            List<TRent> list = TRent.toList(rs);
            dao.close();
            return list;
        } else {
            String sql = "select * from t_rent where ";
            String whereString = "";
            if (position != null) {
                whereString += "(userid like '%" + position + "%' " +
                        "or engine like '%" + position + "%')";
            }
            if (rentBrand != null) {
                if (whereString.equals("")) {
                    whereString += "rentBrand like '%" + rentBrand + "%'";
                } else {
                    whereString += "and rentBrand like '%" + rentBrand + "%'";
                }
            }
            sql += whereString;
            ResultSet rs = dao.select(sql, null);
            List<TRent> list = TRent.toList(rs);
            dao.close();
            return list;
        }
    }

    @Override
    public boolean deleteRent(int rentId) {

        String sql = "delete from t_rent where rentid=? ";
        Object[] para = {rentId};
        return dao.delete(sql, para);
    }

    @Override
    public List<TRent> getRentListByUserId(String userId) {
        String userid = userId;
        String sql = "select * from t_rent " +
                "where renterid like '%" + userid +"%' " +" order by rentid desc ";

        ResultSet rs = dao.select(sql, null);
        List<TRent> list = TRent.toList(rs);
        dao.close();
        return list;
    }
}
