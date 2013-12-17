/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abdel
 */
@Entity
@Table(name = "t_mission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mission.findAll", query = "SELECT m FROM Mission m"),
    @NamedQuery(name = "Mission.findById", query = "SELECT m FROM Mission m WHERE m.id = :id"),
    @NamedQuery(name = "Mission.findByDestination", query = "SELECT m FROM Mission m WHERE m.destination = :destination"),
    @NamedQuery(name = "Mission.findByEtatTraitement", query = "SELECT m FROM Mission m WHERE m.etatTraitement = :etatTraitement"),
    @NamedQuery(name = "Mission.findByOctroye", query = "SELECT m FROM Mission m WHERE m.octroye = :octroye")})

public class Mission implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "optimistic_lock")
    @Version
    private Integer version;
    @Size(max = 255)
    @Column(name = "destination")
    private String destination;
    @Size(max = 255)
    @Column(name = "ville")
    private String ville;
    @Size(max = 255)
    @Column(name = "pays")
    private String pays;
    @Future
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Future
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Size(max = 255)
    @Column(name = "detail")
    private String detail;
    @Column(name = "etat_traitement")
    private Boolean etatTraitement;
    @Column(name = "octroye")
    private Boolean octroye;
    @ManyToOne
    private Personne personne;

    public Mission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean isEtatTraitement() {
        return etatTraitement;
    }

    public void setEtatTraitement(Boolean etatTraitement) {
        this.etatTraitement = etatTraitement;
    }

    public Boolean isOctroye() {
        return octroye;
    }

    public void setOctroye(Boolean octroye) {
        this.octroye = octroye;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.version);
        hash = 97 * hash + Objects.hashCode(this.destination);
        hash = 97 * hash + Objects.hashCode(this.ville);
        hash = 97 * hash + Objects.hashCode(this.pays);
        hash = 97 * hash + Objects.hashCode(this.dateDebut);
        hash = 97 * hash + Objects.hashCode(this.dateFin);
        hash = 97 * hash + Objects.hashCode(this.detail);
        hash = 97 * hash + Objects.hashCode(this.personne);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mission other = (Mission) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.pays, other.pays)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.detail, other.detail)) {
            return false;
        }
        if (!Objects.equals(this.personne, other.personne)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mission a : " + ville + ", " + pays + ", de " + personne.getNom() + " " + personne.getPrenom1();
    }

    
}
