/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findById", query = "SELECT p FROM Personne p WHERE p.id = :id"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personne.findByCin", query = "SELECT p FROM Personne p WHERE p.cin = :cin"),
    @NamedQuery(name = "Personne.findByDateNaissance", query = "SELECT p FROM Personne p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Personne.findByDateRecrutement", query = "SELECT p FROM Personne p WHERE p.dateRecrutement = :dateRecrutement"),
    @NamedQuery(name = "Personne.findByEtatMatrimonial", query = "SELECT p FROM Personne p WHERE p.etatMatrimonial = :etatMatrimonial"),
    @NamedQuery(name = "Personne.findByLieuNaissance", query = "SELECT p FROM Personne p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Personne.findByNbEnfants", query = "SELECT p FROM Personne p WHERE p.nbEnfants = :nbEnfants"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByNomAr", query = "SELECT p FROM Personne p WHERE p.nomAr = :nomAr"),
    @NamedQuery(name = "Personne.findByPosteBudgetaire", query = "SELECT p FROM Personne p WHERE p.posteBudgetaire = :posteBudgetaire"),
    @NamedQuery(name = "Personne.findByPrenom1", query = "SELECT p FROM Personne p WHERE p.prenom1 = :prenom1"),
    @NamedQuery(name = "Personne.findByPrenom2", query = "SELECT p FROM Personne p WHERE p.prenom2 = :prenom2"),
    @NamedQuery(name = "Personne.findByPrenomAr", query = "SELECT p FROM Personne p WHERE p.prenomAr = :prenomAr"),
    @NamedQuery(name = "Personne.findBySom", query = "SELECT p FROM Personne p WHERE p.som = :som"),
    @NamedQuery(name = "Personne.findByTelephonne", query = "SELECT p FROM Personne p WHERE p.telephonne = :telephonne")})
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 255)
    @Column(name = "cin")
    private String cin;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "date_recrutement")
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    @Column(name = "etat_matrimonial")
    private Boolean etatMatrimonial;
    @Size(max = 255)
    @Column(name = "lieu_naissance")
    private String lieuNaissance;
    @Column(name = "nb_enfants")
    private Integer nbEnfants;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "nom_ar")
    private String nomAr;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "poste_budgetaire")
    private Integer posteBudgetaire;
    @Size(max = 255)
    @Column(name = "prenom1")
    private String prenom1;
    @Size(max = 255)
    @Column(name = "prenom2")
    private String prenom2;
    @Size(max = 255)
    @Column(name = "prenom_ar")
    private String prenomAr;
    @Column(name = "som")
    private Integer som;
    @Column(name = "telephonne")
    private Integer telephonne;
    @OneToMany(mappedBy = "person")
    private List<Qualification> qualificationList;
    @OneToMany(mappedBy = "person")
    private List<Affectation> affectationList;
    @OneToMany(mappedBy = "person")
    private List<Situation> situationList;

    public Personne() {
    }

    public Personne(String nom, String prenom1, Integer som) {
        this.nom = nom;
        this.prenom1 = prenom1;
        this.som = som;
    }
    

    public Personne(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Boolean getEtatMatrimonial() {
        return etatMatrimonial;
    }

    public void setEtatMatrimonial(Boolean etatMatrimonial) {
        this.etatMatrimonial = etatMatrimonial;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Integer getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(Integer nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getPosteBudgetaire() {
        return posteBudgetaire;
    }

    public void setPosteBudgetaire(Integer posteBudgetaire) {
        this.posteBudgetaire = posteBudgetaire;
    }

    public String getPrenom1() {
        return prenom1;
    }

    public void setPrenom1(String prenom1) {
        this.prenom1 = prenom1;
    }

    public String getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(String prenom2) {
        this.prenom2 = prenom2;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public Integer getSom() {
        return som;
    }

    public void setSom(Integer som) {
        this.som = som;
    }

    public Integer getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(Integer telephonne) {
        this.telephonne = telephonne;
    }

    @XmlTransient
    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @XmlTransient
    public List<Affectation> getAffectationList() {
        return affectationList;
    }

    public void setAffectationList(List<Affectation> affectationList) {
        this.affectationList = affectationList;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.ump.grh.entities.Personne[ id=" + id + " ]";
    }
    
}
