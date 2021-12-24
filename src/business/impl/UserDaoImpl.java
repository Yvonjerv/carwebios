package business.impl;

import basic.BaseDAO;
import basic.BaseDaoImpl;
import business.dao.UserDAO;
import model.TRent;
import model.TUser;

import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl implements UserDAO {
    //we need to process Database by data Access layer
    private BaseDAO dao = new BaseDaoImpl();

    @Override
    public TUser login(String userid, String pwd) {

        String sql = "select * from t_user where userid = ? and pwd=?";
        Object[] para = {userid, pwd};
        ResultSet rs = dao.select(sql, para);
        TUser user = new TUser(rs);
        dao.close();
        return user;
    }

    @Override
    public boolean isUseridValid(String userid) {
        String sql = "select * from t_user where userid=?";

        Object[] para = {userid};
        int row = dao.selectCount(sql, para);
        if (row > 0) return false;
        else return true;
    }


    @Override
    public boolean registerUser(TUser user) {
        String sql = "insert into t_user (userid, username,pwd ,mobile,gender, photourl,mail ) " +
                "values(?,?,?,?,?,?,?)";

        Object[] para = { user.getUserid(),  user.getUsername(), user.getPwd(),  user.getMobile(),
                user.getGender(),user.getPhotourl(), user.getMail() };
        int row = dao.insert(sql, para);
        if (row > 0) return true;
        else return false;
    }

    @Override
    public boolean modifyUser(TUser user) {
        String sql = "update t_user set username  =? ,pwd  =? ,mobile =? ," +
                "mail =?  , gender=?, photourl=?" +
                "where userid=?";
        Object[] para = {user.getUsername(), user.getPwd(), user.getMobile(),
                user.getMail(), user.getGender(), user.getPhotourl(),
                user.getUserid()};
        return dao.update(sql, para);

    }

    @Override
    public TUser getTUserById(String userid) {
        String sql = "select * from t_user where userid=? ";
        Object[] para = {userid};
        ResultSet rs = dao.select(sql, para);
        TUser user = new TUser(rs);
        dao.close();
        return user;
    }

    @Override
    public boolean isCarUser(String userid) {
        String sql = "select * from t_car where userid = ?  ";
        Object[] para = {userid};
        int row = dao.selectCount(sql, para);
        if (row > 0) return true;
        else return false;
    }


    public List<TUser> getAllUsers(){
        String sql = "select * from t_user order by userid desc ";

        ResultSet rs = dao.select(sql, null);
        List<TUser> list = TUser.toList(rs);
        dao.close();
        return list;
    }
 }
