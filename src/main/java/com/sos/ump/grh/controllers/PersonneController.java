/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Affectation;
import com.sos.ump.grh.entities.Personne;
import com.sos.ump.grh.entities.Qualification;
import com.sos.ump.grh.entities.Situation;
import com.sos.ump.grh.services.AffectationFacade;
import com.sos.ump.grh.services.PersonneFacade;
import com.sos.ump.grh.services.QualificationFacade;
import com.sos.ump.grh.services.SituationFacade;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mab.salhi
 */
@Named
@SessionScoped
public class PersonneController implements Serializable {

    private static final Logger logger = Logger.getLogger(PersonneController.class.getName());
    
    @Inject
    private PersonneFacade personneService;
    private Personne courrant;
    private Personne nouveau;
    private List<Personne> personnes;
    
    
    @Inject
    private QualificationFacade qualificationService;
    private Qualification newQualification;
    
    @Inject
    private AffectationFacade affectationService;
    private Affectation newAffectation;
    
    @Inject
    private SituationFacade situationService;
    private Situation newSituation;
    
    /**
     * Creates a new instance of PersonneController
     */
    public PersonneController() {
    }

    public String showList() {
        return "/personne/list?faces-redirect=true";
    }

    public String showCreate() {
        nouveau = new Personne();
        return "/personne/new?faces-redirect=true";
    }

    public String showDetail(Personne personne) {
        courrant = personne;
        return "/personne/view?faces-redirect=true";
    }

    public String showAddQualification() {
        newQualification = new Qualification();
        return "/personne/addQualification?faces-redirect=true";
    }

public String showAddAffectation() {
        newAffectation = new Affectation();
        return "/personne/addAffectation?faces-redirect=true";
    }

public String showAddSituation() {
        newSituation = new Situation();
        return "/personne/addSituation?faces-redirect=true";
    }

    public void showAttestation() throws IOException, FacesException {
        
        String diplome = courrant.getQualificationList().get(1).getMension();
        
        System.out.println(courrant.getNom());
        FacesContext.getCurrentInstance().getExternalContext()
                .redirect("/grhApp/reportDispatcher/?reportId=attestation.odt&nom=" + courrant.getNom() 
                        + "&prenom1=" + courrant.getPrenom1() 
                        + "&som=" + courrant.getSom() 
                        + "&diplome=" + diplome
                        + "");
    }

    public List<Personne> getAll() {
        personneService.clearCache();
        return personneService.findAll();
    }

    public String doCreate() {
        personneService.create(nouveau);
        return showList();
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {

        UploadedFile file = event.getFile();
        System.out.println(file.getFileName());

        byte[] foto = IOUtils.toByteArray(file.getInputstream());
        System.out.println(foto);

        nouveau.setPhoto(foto);
 //application code
    }

    public DefaultStreamedContent byteToImage(byte[] imgBytes) throws IOException {
        ByteArrayInputStream img = new ByteArrayInputStream(imgBytes);
        return new DefaultStreamedContent(img, "image/jpg");
    }

    public String doAddQualification(){
        logger.log(Level.INFO, "Debut de la procedure d'ajout de diplome !!");
        if (courrant != null) {
            newQualification.setPerson(courrant);

            try {
                qualificationService.create(newQualification);
                courrant.getQualificationList().add(newQualification);
                personneService.clearCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.log(Level.SEVERE, "Erreur de donnee the current entity is null !!");
        }
        return "view?faces-redirect=true";
    }
    
    
    public String doAddAffectation(){
        logger.log(Level.INFO, "Debut de la procedure d'ajout d'affectation !!");
        if (courrant != null) {
            newAffectation.setPerson(courrant);

            try {
                affectationService.create(newAffectation);
                courrant.getAffectationList().add(newAffectation);
                personneService.clearCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.log(Level.SEVERE, "Erreur de donnee the current entity is null !!");
        }
        return "view?faces-redirect=true";
    }
    
    public String doAddSituation(){
        logger.log(Level.INFO, "Debut de la procedure d'ajout de situation !!");
        if (courrant != null) {
            newSituation.setPerson(courrant);

            try {
                situationService.create(newSituation);
                courrant.getSituationList().add(newSituation);
                personneService.clearCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.log(Level.SEVERE, "Erreur de donnee the current entity is null !!");
        }
        return "view?faces-redirect=true";
    }
    
    public Personne getCourrant() {
        return courrant;
    }

    public void setCourrant(Personne courrant) {
        this.courrant = courrant;
    }

    public Personne getNouveau() {
        return nouveau;
    }

    public void setNouveau(Personne nouveau) {
        this.nouveau = nouveau;
    }

    public Qualification getNewQualification() {
        return newQualification;
    }

    public void setNewQualification(Qualification newQualification) {
        this.newQualification = newQualification;
    }

    public Affectation getNewAffectation() {
        return newAffectation;
    }

    public void setNewAffectation(Affectation newAffectation) {
        this.newAffectation = newAffectation;
    }

    public Situation getNewSituation() {
        return newSituation;
    }

    public void setNewSituation(Situation newSituation) {
        this.newSituation = newSituation;
    }
    
        
    
    public Personne getPersonne(java.lang.Integer id) {
        return personneService.find(id);
    }
    
     @FacesConverter(forClass = Personne.class)
    public static class PersonneControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonneController controller = (PersonneController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personneController");
            return controller.getPersonne(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Personne) {
                Personne o = (Personne) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Personne.class.getName());
            }
        }
    
}
    
}
