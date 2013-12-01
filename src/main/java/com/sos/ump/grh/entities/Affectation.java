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
@Table(name = "t_affectation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a"),
    @NamedQuery(name = "Affectation.findByIdAffectation", query = "SELECT a FROM Affectation a WHERE a.idAffectation = :idAffectation"),
    @NamedQuery(name = "Affectation.findByDateAffectation", query = "SELECT a FROM Affectation a WHERE a.dateAffectation = :dateAffectation"),
    @NamedQuery(name = "Affectation.findByDateDetachement", query = "SELECT a FROM Affectation a WHERE a.dateDetachement = :dateDetachement"),
    @NamedQuery(name = "Affectation.findByPoste", query = "SELECT a FROM Affectation a WHERE a.poste = :poste"),
    @NamedQuery(name = "Affectation.findByRemarques", query = "SELECT a FROM Affectation a WHERE a.remarques = :remarques")})
public class Affectation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_affectation")
    private Integer idAffectation;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "date_affectation")
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    @Column(name = "date_detachement")
    @Temporal(TemporalType.DATE)
    private Date dateDetachement;
    @Size(max = 255)
    @Column(name = "poste")
    private String poste;
    @Size(max = 255)
    @Column(name = "remarques")
    private String remarques;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @ManyToOne
    private Service service;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne
    private Personne personne;

    public Affectation() {
    }

    public Affectation(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public Integer getIdAffectation() {
        return idAffectation;
    }

    public void setIdAffectation(Integer idAffectation) {
        this.idAffectation = idAffectation;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public Date getDateDetachement() {
        return dateDetachement;
    }

    public void setDateDetachement(Date dateDetachement) {
        this.dateDetachement = dateDetachement;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAffectation != null ? idAffectation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        if ((this.idAffectation == null && other.idAffectation != null) || (this.idAffectation != null && !this.idAffectation.equals(other.idAffectation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.grhfso.model.Affectation[ idAffectation=" + idAffectation + " ]";
    }
    
}