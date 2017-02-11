package sgdep.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import org.hibernate.Hibernate;

public class CustomerDetailPk implements Serializable {
    
    private Long id_Customer;
   
    private Long idDetail;

    public CustomerDetailPk() {
    }

    @Column(name = "idCustomer")
    public Long getId_Customer() {
        return id_Customer;
    }

    public void setId_Customer(Long id_Customer) {
        this.id_Customer = id_Customer;
    }

     @Column(name = "idDetail")
    public Long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        //hash = 61 * hash + Objects.hashCode(this.idCustomer);
        hash = 61 * hash + (int) (getId_Customer() ^ (getId_Customer() >>> 32));
        hash = 61 * hash + (int) (getIdDetail() ^ (getIdDetail() >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }
        final CustomerDetailPk other = (CustomerDetailPk) obj;

        if (getId_Customer() == null) {
            if (other.getId_Customer() != null) {
                return false;
            }
        } else if (!getId_Customer().equals(other.getId_Customer())) {
            return false;
        }
        if (getIdDetail() == null) {
            if (other.getIdDetail() != null) {
                return false;
            }
        } else if (!getIdDetail().equals(other.getIdDetail())) {
            return false;
        }

        return true;
    }

}
