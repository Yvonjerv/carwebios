package business.dao;

import model.TUser;

import java.util.List;

/**
 * User business class interface written by teachers
 * @author peter
 */
public interface UserDAO {

    /**
     * User login service method
     * @param userid   user account for login
     * @param pwd   password for login
     * @return  TUser   successful return user object, otherwise return null
     */
    public TUser login(String userid, String pwd);

    /**
     * Check whether the user account is available
     * @param userid
     * @return boolean,If available, return true; if unavailable, return false
     */
    public boolean isUseridValid(String userid);

    /**
     * Registered users (including hotel administrators and ordinary members)
     * @param user TUser object containing user registration information
     * @return boolean,True is returned for successful and false for failed
     */
    public boolean registerUser(TUser user);

    /**
     * Modify user information
     * @param user TUser object containing user modification information
     * @return boolean,Return true for success and false for failure
     */
    public boolean modifyUser(TUser user);

    /**
     * Returns the user object of the specified userid
     * @param userid  Userid to query
     * @return  The tuser object is returned successfully,
     * and null is returned in case of failure
     */
    public TUser getTUserById(String userid);


    /**
     * Query whether the user is a hotel member
     * @param userid
     * @return boolean, The hotel member returns true, not false
     */
    public boolean isCarUser(String userid);

    /**
     *
     * @return
     */
    public List<TUser> getAllUsers();
}
