package sgdep.persistencia.dao.impl;

import com.acme.pe.persistencia.dao.impl.GenericDAOImplHibernate;
import sgdep.dominio.Customer;
import sgdep.persistencia.dao.CustomerDAO;

/**
 *
 * @author gutie026
 */
public class CustomerDAOImplHibernate extends GenericDAOImplHibernate<Customer, Long> implements CustomerDAO{
    
}
