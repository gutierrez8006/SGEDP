package sgdep.dominio;

import com.acme.pe.persistencia.dao.Caption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gutie026
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    private long idCustomer;
    @NotNull
    @NotBlank
    @Caption("nombre")
    private String name;

    private List<CustomerDetail> customerDetails;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "idCustomer")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sec_idcustomer")
    @SequenceGenerator(name = "sec_idcustomer", sequenceName = "SQ_CUSTOMER")
    public long getIdCustomer() {
        return idCustomer;
    }

    @SuppressWarnings("unused")
    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

//    @JoinColumn(name = "idCustomer", referencedColumnName = "idCustomer")
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JsonIgnore
    public List<CustomerDetail> getCustomerDetails() {
        return customerDetails;
    }

    @SuppressWarnings("unused")
    public void setCustomerDetails(List<CustomerDetail> customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getName());
        //System.out.println( "CUSTOMER: " + customerDetails.size());
        if (customerDetails != null) {
            for (CustomerDetail customerDetail : customerDetails) {
                hcb.append(customerDetail);
            }
        }

        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        try {
            final Customer other = (Customer) obj;
            final EqualsBuilder eqb = new EqualsBuilder();
            eqb.append(getName(), other.getName());

            if (getCustomerDetails().size() != other.getCustomerDetails().size()) {
                return false;
            }
            for (int i = 0; i < customerDetails.size(); i++) {
                eqb.append(customerDetails.get(i), other.getCustomerDetails().get(i));
            }
            isEquals = eqb.isEquals();
        } catch (Exception e) {
            isEquals = false;
        }
        return isEquals;
    }
}
