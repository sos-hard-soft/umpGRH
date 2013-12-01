/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.ump.grh.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infoFSO5
 */
@Entity
@Table(name = "t_situation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situation.findAll", query = "SELECT s FROM Situation s"),
    @NamedQuery(name = "Situation.findByIdSituation", query = "SELECT s FROM Situation s WHERE s.idSituation = :idSituation"),
    @NamedQuery(name = "Situation.findByDateEffet", query = "SELECT s FROM Situation s WHERE s.dateEffet = :dateEffet"),
    @NamedQuery(name = "Situation.findByEchelon", query = "SELECT s FROM Situation s WHERE s.echelon = :echelon"),
    @NamedQuery(name = "Situation.findByNumeroIndicatif", query = "SELECT s FROM Situation s WHERE s.numeroIndicatif = :numeroIndicatif"),
    @NamedQuery(name = "Situation.findByRemarques", query = "SELECT s FROM Situation s WHERE s.remarques = :remarques"),
    @NamedQuery(name = "Situation.findBySalaireEstimatif", query = "SELECT s FROM Situation s WHERE s.salaireEstimatif = :salaireEstimatif")})
public class Situation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_situation")
    private Integer idSituation;
   @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "date_effet")
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Column(name = "echelon")
    private Integer echelon;
    @Column(name = "numero_indicatif")
    private Integer numeroIndicatif;
    @Size(max = 255)
    @Column(name = "remarques")
    private String remarques;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salaire_estimatif")
    private Float salaireEstimatif;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne
    private Personne personne;
    @JoinColumn(name = "id_cadre", referencedColumnName = "id_cadre")
    @ManyToOne
    private Cadre cadre;

    public Situation() {
    }

    public Situation(Cadre cadre, Date dateEffet, Integer echelon, Integer numeroIndicatif, String remarques, Float salaireEstimatif) {
        this.dateEffet = dateEffet;
        this.echelon = echelon;
        this.numeroIndicatif = numeroIndicatif;
        this.remarques = remarques;
        this.salaireEstimatif = salaireEstimatif;
        this.cadre = cadre;
    }
    
    

    public Situation(Integer idSituation) {
        this.idSituation = idSituation;
    }

    public Integer getIdSituation() {
        return idSituation;
    }

    public void setIdSituation(Integer idSituation) {
        this.idSituation = idSituation;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Integer getEchelon() {
        return echelon;
    }

    public void setEchelon(Integer echelon) {
        this.echelon = echelon;
    }

    public Integer getNumeroIndicatif() {
        return numeroIndicatif;
    }

    public void setNumeroIndicatif(Integer numeroIndicatif) {
        this.numeroIndicatif = numeroIndicatif;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Float getSalaireEstimatif() {
        return salaireEstimatif;
    }

    public void setSalaireEstimatif(Float salaireEstimatif) {
        this.salaireEstimatif = salaireEstimatif;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSituation != null ? idSituation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situation)) {
            return false;
        }
        Situation other = (Situation) object;
        if ((this.idSituation == null && other.idSituation != null) || (this.idSituation != null && !this.idSituation.equals(other.idSituation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.grhfso.model.Situation[ idSituation=" + idSituation + " ]";
    }
    
}