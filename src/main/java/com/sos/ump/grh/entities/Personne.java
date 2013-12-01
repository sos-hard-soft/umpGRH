/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.ump.grh.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author infoFSO5
 */
@Entity
@Table(name = "t_personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIdPersonne", query = "SELECT p FROM Personne p WHERE p.idPersonne = :idPersonne"),
    @NamedQuery(name = "Personne.findBySom", query = "SELECT p FROM Personne p WHERE p.som = :som"),
    @NamedQuery(name = "Personne.findByDateRecrutement", query = "SELECT p FROM Personne p WHERE p.dateRecrutement = :dateRecrutement"),
    @NamedQuery(name = "Personne.findByPosteBudgetaire", query = "SELECT p FROM Personne p WHERE p.posteBudgetaire = :posteBudgetaire"),
    @NamedQuery(name = "Personne.findByCin", query = "SELECT p FROM Personne p WHERE p.cin = :cin"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom1 = :prenom1"),
    @NamedQuery(name = "Personne.findByNomAr", query = "SELECT p FROM Personne p WHERE p.nomAr = :nomAr"),
    @NamedQuery(name = "Personne.findByPrenomAr", query = "SELECT p FROM Personne p WHERE p.prenomAr = :prenomAr"),
    @NamedQuery(name = "Personne.findByDateNaissance", query = "SELECT p FROM Personne p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Personne.findByLieuNaissance", query = "SELECT p FROM Personne p WHERE p.lieuNaissance = :lieuNaissance"),
    @NamedQuery(name = "Personne.findByTelephonne", query = "SELECT p FROM Personne p WHERE p.telephonne = :telephonne"),
    @NamedQuery(name = "Personne.findByAdresse", query = "SELECT p FROM Personne p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personne.findByEtatMatrimonial", query = "SELECT p FROM Personne p WHERE p.etatMatrimonial = :etatMatrimonial"),
    @NamedQuery(name = "Personne.findByNbEnfants", query = "SELECT p FROM Personne p WHERE p.nbEnfants = :nbEnfants")
    })
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_personne")
    private Integer idPersonne;
    @Version
    @Column(name = "version")    
    private Integer version;
    
    @Column(name = "som")
    private Integer som;
    @Column(name = "date_recrutement", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;
    @Column(name = "poste_budgetaire")
    private Integer posteBudgetaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cin")
    private String cin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prenom1")
    private String prenom1;
    @Column(name = "prenom2", nullable = true)
    private String prenom2;
    @Size(max = 255)
    @Column(name = "nom_ar", nullable = true)
    private String nomAr;
    @Size(max = 255)
    @Column(name = "prenom_ar", nullable = true)
    private String prenomAr;
    @Column(name = "date_naissance", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 255)
    @Column(name = "lieu_naissance", nullable = true)
    private String lieuNaissance;
    @Size(max = 255)
    @Column(name = "telephonne", nullable = true)
    private String telephonne;
    @Size(max = 255)
    @Column(name = "adresse", nullable = true)
    private String adresse;
    @Size(max = 255)
    @Column(name = "etat_matrimonial", nullable = true)
    private String etatMatrimonial;
    @Column(name = "nb_enfants", nullable = true)
    private Integer nbEnfants;
    @Lob
    @Column(name = "photo", nullable = true)
    private byte[] photo;
    @OneToMany(mappedBy = "personne")
    private List<Qualification> qualificationList;
    @OneToMany(mappedBy = "personne")
    private List<Affectation> affectationList;
    @OneToMany(mappedBy = "personne", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Situation> situationList = new LinkedList<Situation>();

    public Personne() {
    }

    public Personne(String cin, String nom, String prenom1, Date dateNaissance, Integer som, Date dateRecrutement) {
        this.cin = cin;
        this.nom = nom;
        this.prenom1 = prenom1;
        this.dateNaissance = dateNaissance;
        this.som = som;
        this.dateRecrutement = dateRecrutement;
    }

    public Personne(Integer som, String nom, String prenom1) {
        this.som = som;
        this.nom = nom;
        this.prenom1 = prenom1;
    }
    
    
    
    public void addSituation(Situation situation){
        situation.setPersonne(this);
        situationList.add(situation);
    }
    
    public void remove(Situation situation) {
        situationList.remove(situation);
    }
    
    
    public Personne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Personne(Integer idPersonne, String cin, String nom, String prenom1) {
        this.idPersonne = idPersonne;
        this.cin = cin;
        this.nom = nom;
        this.prenom1 = prenom1;
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getNomAr() {
        return nomAr;
    }

    public void setNomAr(String nomAr) {
        this.nomAr = nomAr;
    }

    public String getPrenomAr() {
        return prenomAr;
    }

    public void setPrenomAr(String prenomAr) {
        this.prenomAr = prenomAr;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getTelephonne() {
        return telephonne;
    }

    public void setTelephonne(String telephonne) {
        this.telephonne = telephonne;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEtatMatrimonial() {
        return etatMatrimonial;
    }

    public void setEtatMatrimonial(String etatMatrimonial) {
        this.etatMatrimonial = etatMatrimonial;
    }

    public Integer getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(Integer nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Integer getSom() {
        return som;
    }

    public void setSom(Integer som) {
        this.som = som;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public Integer getPosteBudgetaire() {
        return posteBudgetaire;
    }

    public void setPosteBudgetaire(Integer posteBudgetaire) {
        this.posteBudgetaire = posteBudgetaire;
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
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.grhfso.model.Personne[ idPersonne=" + idPersonne + " ]";
    }
    
}