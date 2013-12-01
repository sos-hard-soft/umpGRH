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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infoFSO5
 */
@Entity
@Table(name = "t_qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q"),
    @NamedQuery(name = "Qualification.findByIdQualification", query = "SELECT q FROM Qualification q WHERE q.idQualification = :idQualification"),
    @NamedQuery(name = "Qualification.findByDateObtention", query = "SELECT q FROM Qualification q WHERE q.dateObtention = :dateObtention"),
    @NamedQuery(name = "Qualification.findByMension", query = "SELECT q FROM Qualification q WHERE q.mension = :mension"),
    @NamedQuery(name = "Qualification.findByPartieDelivrante", query = "SELECT q FROM Qualification q WHERE q.partieDelivrante = :partieDelivrante"),
    @NamedQuery(name = "Qualification.findByRemarques", query = "SELECT q FROM Qualification q WHERE q.remarques = :remarques")})
public class Qualification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_qualification")
    private Integer idQualification;
    @Version
    @Column(name = "version")
    private Integer version;
    @Column(name = "dateObtention")
    @Temporal(TemporalType.DATE)
    private Date dateObtention;
    @Size(max = 255)
    @Column(name = "mension")
    private String mension;
    @Size(max = 255)
    @Column(name = "partie_delivrante")
    private String partieDelivrante;
    @Size(max = 255)
    @Column(name = "remarques")
    private String remarques;
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    @ManyToOne
    private Personne personne;
    @JoinColumn(name = "id_diplome", referencedColumnName = "id_diplome")
    @ManyToOne
    private Diplome diplome;

    public Qualification() {
    }

       
    public Qualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateObtention() {
        return dateObtention;
    }

    public void setDateObtention(Date dateObtention) {
        this.dateObtention = dateObtention;
    }

    public String getMension() {
        return mension;
    }

    public void setMension(String mension) {
        this.mension = mension;
    }

    public String getPartieDelivrante() {
        return partieDelivrante;
    }

    public void setPartieDelivrante(String partieDelivrante) {
        this.partieDelivrante = partieDelivrante;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQualification != null ? idQualification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.idQualification == null && other.idQualification != null) || (this.idQualification != null && !this.idQualification.equals(other.idQualification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.grhfso.model.Qualification[ idQualification=" + idQualification + " ]";
    }
    
}