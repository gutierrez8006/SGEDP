package sgdep.dominio;

import com.acme.pe.persistencia.dao.Caption;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gutie026
 */
@Entity
@Table(name = "seguromedico")
public class SeguroMedico implements Serializable {

    @Id
    @Column(name = "idSeguroMedico")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "sec_idseguro")
    @SequenceGenerator(name="sec_idseguro", sequenceName = "SEC_NEWREGISTRO")
    private int idSeguro;
    @Column(name = "nif")
    @NotNull
    @NotBlank
    private String nif;
    @Column(name = "nombre")
    @NotNull
    @NotBlank
    private String nombre;
    @Column(name = "ape1")
    @NotNull
    @NotBlank
    @Caption("apellido")
    private String ape1;
    @Column(name = "edad")
    @NotNull
    private int edad;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Sexo sexo;
    @Column(name = "casado")
    @NotNull
    private boolean casado;
    @Column(name = "numhijos")
    @NotNull
    @Caption("numero de hijos")
    private int numHijos;
    @Column(name = "embarazada")
    @NotNull
    private boolean embarazada;
    @Embedded
    @Valid
    private Coberturas coberturas;
    @Embedded
    @Valid
    private Enfermedades enfermedades;

    public SeguroMedico() {
    }

    public SeguroMedico(String nif, String nombre, String ape1, int edad, Sexo sexo, boolean casado, int numHijos, boolean embarazada, Coberturas coberturas, Enfermedades enfermedades) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.edad = edad;
        this.sexo = sexo;
        this.casado = casado;
        this.numHijos = numHijos;
        this.embarazada = embarazada;
        this.coberturas = coberturas;
        this.enfermedades = enfermedades;
    }

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    public Coberturas getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(Coberturas coberturas) {
        this.coberturas = coberturas;
    }

    public Enfermedades getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Enfermedades enfermedades) {
        this.enfermedades = enfermedades;
    }

    @Override
    public String toString() {
        return getIdSeguro() + ": " + getNombre() + " " + getApe1();
    }
}
