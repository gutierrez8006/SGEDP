package sgdep.dominio;

import com.acme.pe.persistencia.dao.Caption;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
/**
 *
 * @author gutie026
 */
@Embeddable
public class Coberturas implements Serializable {

    @Column(name = "coberturaoftalmologica")
    @NotNull
    private boolean oftalmologia;
    @Column(name = "coberturadental")
    @NotNull
    @Caption("cobertura dental")
    private boolean dental;
    @Column(name = "coberturafecundacioninvitro")
    @NotNull
    @Caption("cobertura fecundacion invitro")
    private boolean fecundacionInVitro;

    public Coberturas() {
    }

    public Coberturas(boolean oftalmologia, boolean dental, boolean fecundacionInVitro) {
        this.oftalmologia = oftalmologia;
        this.dental = dental;
        this.fecundacionInVitro = fecundacionInVitro;
    }

    public boolean isOftalmologia() {
        return oftalmologia;
    }

    public void setOftalmologia(boolean oftalmologia) {
        this.oftalmologia = oftalmologia;
    }

    public boolean isDental() {
        return dental;
    }

    public void setDental(boolean dental) {
        this.dental = dental;
    }

    public boolean isFecundacionInVitro() {
        return fecundacionInVitro;
    }

    public void setFecundacionInVitro(boolean fecundacionInVitro) {
        this.fecundacionInVitro = fecundacionInVitro;
    }

}
