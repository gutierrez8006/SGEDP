package sgdep.persistencia.dao.impl;

import com.acme.pe.persistencia.dao.BussinessException;
import com.acme.pe.persistencia.dao.impl.GenericDAOImplHibernate;
import com.acme.pe.persistencia.util.AliasToEntityLinkedMapBasicTransformerAdapter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sgdep.dominio.CustomerDetail;
import sgdep.persistencia.dao.CustomerDetailDAO;

/**
 *
 * @author gutie026
 */
public class CustomerDetailDAOImplHibernate extends GenericDAOImplHibernate<CustomerDetail, Long> implements CustomerDetailDAO{
    @Autowired
    SessionFactory sessionFactory;

    public CustomerDetailDAOImplHibernate() {
    }
    
    private final static Logger LOGGER = Logger.getLogger(GenericDAOImplHibernate.class.getName());
    
    @Override
    public List<Map<String, Object>> findXCustomer(Long idCustomer) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            String sql = "select idcustomer, iddetail, descripcion from customerdetail where idcustomer = ? order by iddetail";
            Query query = session.createSQLQuery(sql);
            query.setResultTransformer(new AliasToEntityLinkedMapBasicTransformerAdapter());
            query.setLong(0, idCustomer);
            List<Map<String, Object>> entities = query.list();
            session.getTransaction().commit();
            return entities;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                LOGGER.log(Level.WARNING, "Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }

    }
    
}
