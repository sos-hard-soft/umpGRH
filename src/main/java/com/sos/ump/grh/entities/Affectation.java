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
@Table(name = "t_affectation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a"),
    @NamedQuery(name = "Affectation.findById", query = "SELECT a FROM Affectation a WHERE a.id = :id"),
    @NamedQuery(name = "Affectation.findByDateAffectation", query = "SELECT a FROM Affectation a WHERE a.dateAffectation = :dateAffectation"),
    @NamedQuery(name = "Affectation.findByDateDetachement", query = "SELECT a FROM Affectation a WHERE a.dateDetachement = :dateDetachement"),
    @NamedQuery(name = "Affectation.findByPoste", query = "SELECT a FROM Affectation a WHERE a.poste = :poste"),
    @NamedQuery(name = "Affectation.findByRemarques", query = "SELECT a FROM Affectation a WHERE a.remarques = :remarques"),
    @NamedQuery(name = "Affectation.findByVersion", query = "SELECT a FROM Affectation a WHERE a.version = :version")})
public class Affectation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "optimistic_lock")
    @Version
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
    @JoinColumn(name = "service", referencedColumnName = "id")
    @ManyToOne
    private Service service;
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne
    private Personne person;

    public Affectation() {
    }

    public Affectation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Personne getPerson() {
        return person;
    }

    public void setPerson(Personne person) {
        this.person = person;
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
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.grh.entities.Affectation[ id=" + id + " ]";
    }
    
}
