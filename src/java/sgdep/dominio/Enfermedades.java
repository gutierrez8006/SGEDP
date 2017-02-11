package sgdep.dominio;

import com.acme.pe.persistencia.dao.Caption;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gutie026
 */
@Embeddable
public class Enfermedades implements Serializable {

    @Column(name = "enfermedadcorazon")
    @NotNull
    @Caption("enfermedad corazon")
    private boolean corazon;
    @Column(name = "enfermedadestomacal")
    @NotNull
    @Caption("enfermedad estomacal")
    private boolean estomacal;
    @Column(name = "enfermedadrinyones")
    @NotNull
    @Caption("enfermedad rinyones")
    private boolean rinyones;
    @Column(name = "enfermedadalergia")
    @NotNull
    private boolean alergia;
    @Column(name = "nombrealergia")
    @NotNull
    @Caption("nombre alergia")
    private String nombreAlergia;

    public Enfermedades() {
    }

    public Enfermedades(boolean corazon, boolean estomacal, boolean rinyones, boolean alergia, String nombreAlergia) {
        this.corazon = corazon;
        this.estomacal = estomacal;
        this.rinyones = rinyones;
        this.alergia = alergia;
        this.nombreAlergia = nombreAlergia;
    }

    public boolean isCorazon() {
        return corazon;
    }

    public void setCorazon(boolean corazon) {
        this.corazon = corazon;
    }

    public boolean isEstomacal() {
        return estomacal;
    }

    public void setEstomacal(boolean estomacal) {
        this.estomacal = estomacal;
    }

    public boolean isRinyones() {
        return rinyones;
    }

    public void setRinyones(boolean rinyones) {
        this.rinyones = rinyones;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    public String getNombreAlergia() {
        return nombreAlergia;
    }

    public void setNombreAlergia(String nombreAlergia) {
        this.nombreAlergia = nombreAlergia;
    }

}
