package business.dao;
 
import model.TRent;
import java.util.List;

public interface RentDAO {
    /**
     * Registered Rents (including hotel administrators and ordinary members)
     * @param rent TRent object containing Rent registration information
     * @return boolean,True is returned for successful and false for failed
     */
    public int addRent(TRent rent);

    /**
     * Modify Rent information
     * @param rent TRentobject containing Rent modification information
     * @return boolean,Return true for success and false for failure
     */
    public boolean modifyRent(TRent rent);

    /**
     *
     * @param rentId
     * @return
     */
    public boolean deleteRent(int rentId);
    /**
     *
     * @param rentId
     * @return
     */
    public TRent getRentById(int rentId);

    /**
     * Returns a list of objects for all hotel information
     * @return List<TRent>
     */
    public List<TRent> getRentListByCondition(String position, String rentPlat);

    public List<TRent> getRentListByUserId(String userId);
}
