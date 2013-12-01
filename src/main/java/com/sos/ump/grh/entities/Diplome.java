/*
 * To change this template, choose Tools | Templates
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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author infoFSO5
 */
@Entity
@Table(name = "t_diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diplome.findAll", query = "SELECT d FROM Diplome d"),
    @NamedQuery(name = "Diplome.findByIdDiplome", query = "SELECT d FROM Diplome d WHERE d.idDiplome = :idDiplome"),
    @NamedQuery(name = "Diplome.findByDescription", query = "SELECT d FROM Diplome d WHERE d.description = :description"),
    @NamedQuery(name = "Diplome.findByIntitule", query = "SELECT d FROM Diplome d WHERE d.intitule = :intitule"),
    @NamedQuery(name = "Diplome.findByType", query = "SELECT d FROM Diplome d WHERE d.type = :type")})
public class Diplome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diplome")
    private Integer idDiplome;
    @Version
    @Column(name = "version")
    private Integer version;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "intitule")
    private String intitule;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "diplome")
    private List<Qualification> qualificationList;

    public Diplome() {
    }

    public Diplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Integer getIdDiplome() {
        return idDiplome;
    }

    public void setIdDiplome(Integer idDiplome) {
        this.idDiplome = idDiplome;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiplome != null ? idDiplome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diplome)) {
            return false;
        }
        Diplome other = (Diplome) object;
        if ((this.idDiplome == null && other.idDiplome != null) || (this.idDiplome != null && !this.idDiplome.equals(other.idDiplome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.mabs.grhfso.model.Diplome[ idDiplome=" + idDiplome + " ]";
    }
    
}