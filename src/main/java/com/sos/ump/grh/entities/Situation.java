/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author mab.salhi
 */
@Entity
@Table(name = "t_situation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situation.findAll", query = "SELECT s FROM Situation s"),
    @NamedQuery(name = "Situation.findById", query = "SELECT s FROM Situation s WHERE s.id = :id"),
    @NamedQuery(name = "Situation.findByDateEffet", query = "SELECT s FROM Situation s WHERE s.dateEffet = :dateEffet"),
    @NamedQuery(name = "Situation.findByEchelon", query = "SELECT s FROM Situation s WHERE s.echelon = :echelon"),
    @NamedQuery(name = "Situation.findByNumeroIndicatif", query = "SELECT s FROM Situation s WHERE s.numeroIndicatif = :numeroIndicatif"),
    @NamedQuery(name = "Situation.findByRemarques", query = "SELECT s FROM Situation s WHERE s.remarques = :remarques"),
    @NamedQuery(name = "Situation.findByVersion", query = "SELECT s FROM Situation s WHERE s.version = :version")})
public class Situation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "optimistic_lock")
    @Version
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
    @JoinColumn(name = "personne", referencedColumnName = "id")
    @ManyToOne
    private Personne personne;
    @JoinColumn(name = "cadre", referencedColumnName = "id")
    @ManyToOne
    private Cadre cadre;

    public Situation() {
    }

    public Situation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situation)) {
            return false;
        }
        Situation other = (Situation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.grh.entities.Situation[ id=" + id + " ]";
    }
    
}
