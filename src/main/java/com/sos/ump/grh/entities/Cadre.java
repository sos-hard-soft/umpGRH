/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_cadre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadre.findAll", query = "SELECT c FROM Cadre c"),
    @NamedQuery(name = "Cadre.findById", query = "SELECT c FROM Cadre c WHERE c.id = :id"),
    @NamedQuery(name = "Cadre.findByDescription", query = "SELECT c FROM Cadre c WHERE c.description = :description"),
    @NamedQuery(name = "Cadre.findByEchelle", query = "SELECT c FROM Cadre c WHERE c.echelle = :echelle"),
    @NamedQuery(name = "Cadre.findByIntitule", query = "SELECT c FROM Cadre c WHERE c.intitule = :intitule"),
    @NamedQuery(name = "Cadre.findByVersion", query = "SELECT c FROM Cadre c WHERE c.version = :version")})
public class Cadre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "echelle")
    private Integer echelle;
    @Size(max = 255)
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "version")
    private Integer version;
    @OneToMany(mappedBy = "cadre")
    private List<Situation> situationList;

    public Cadre() {
    }

    public Cadre(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEchelle() {
        return echelle;
    }

    public void setEchelle(Integer echelle) {
        this.echelle = echelle;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @XmlTransient
    public List<Situation> getSituationList() {
        return situationList;
    }

    public void setSituationList(List<Situation> situationList) {
        this.situationList = situationList;
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
        if (!(object instanceof Cadre)) {
            return false;
        }
        Cadre other = (Cadre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return intitule;
    }
    
}
