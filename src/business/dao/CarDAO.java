package business.dao;

import model.TCar;

import java.util.List;

public interface CarDAO {
    /**
     * Registered cars (including hotel administrators and ordinary members)
     * @param car TCar object containing car registration information
     * @return boolean,True is returned for successful and false for failed
     */
    public int addCar(TCar car);

    /**
     * Modify car information
     * @param car TCar object containing car modification information
     * @return boolean,Return true for success and false for failure
     */
    public boolean modifyCar(TCar car);


    public TCar getCarById(int carId);

    /**
     * Returns a list of objects for all hotel information
     * @return List<TCar>
     */
    public List<TCar> getCarListByCondition(String position, String carPlat);

    public List<TCar> getCarListByUserId(String userId);
}
