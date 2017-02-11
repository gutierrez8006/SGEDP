package sgdep.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author gutie026
 */
@Entity
@Table(name = "customerdetail")
@IdClass(value = CustomerDetailPk.class)
public class CustomerDetail implements Serializable {

    private Long id_Customer;

    private Long idDetail;
    
    private String descripcion;
    
    private Customer customer;

    public CustomerDetail() {
    }

    @Id
    @Column(name = "idCustomer")
    public Long getId_Customer() {
        return id_Customer;
    }

    @SuppressWarnings("unused")
    public void setId_Customer(Long id_Customer) {
        this.id_Customer = id_Customer;
    }

    @Id
    @Column(name = "idDetail")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_idcustdet")
    @SequenceGenerator(name = "sec_idcustdet", sequenceName = "SQ_CUSTOMERDETAIL")
    public Long getIdDetail() {
        return idDetail;
    }

    @SuppressWarnings("unused")
    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" + "idCustomer=" + id_Customer + ", idDetail=" + idDetail + '}';
    }

    @ManyToOne
    @ForeignKey(name = "FK_CUS_CUSD")
    @JoinColumn(name = "idCustomer", insertable = false, updatable = false)
    public Customer getCustomer() {
        return customer;
    }

    @SuppressWarnings("unused")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }
    @SuppressWarnings("unused")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
