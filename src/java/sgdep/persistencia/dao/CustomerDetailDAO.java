package sgdep.persistencia.dao;

import com.acme.pe.persistencia.dao.BussinessException;
import com.acme.pe.persistencia.dao.GenericDAO;
import java.util.List;
import java.util.Map;
import sgdep.dominio.CustomerDetail;

/**
 *
 * @author gutie026
 */
public interface CustomerDetailDAO extends GenericDAO<CustomerDetail, Long>{
    List<Map<String, Object>> findXCustomer(Long idCustomer) throws BussinessException;
}
