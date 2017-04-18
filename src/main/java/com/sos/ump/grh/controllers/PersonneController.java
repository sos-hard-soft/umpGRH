/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Personne;
import com.sos.ump.grh.services.PersonneFacade;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author infoFSO5
 */
@Named
@SessionScoped
public class PersonneController implements Serializable {

    @Inject
    private PersonneFacade personneService;

    private Personne nouveau;
    private Personne courant;
    private List<Personne> personnes;

    /**
     * Creates a new instance of PersonneController
     */
    public PersonneController() {
    }

    public String showList() {
        courant = null;
        return "/personne/list?faces-redirect=true";
    }

    public String showCreate() {
        nouveau = new Personne();
        return "/personne/new?faces-redirect=true";
    }

    public String showView(Personne personne) {
        courant = personne;
        return "/personne/view?faces-redirect=true";
    }

    public void showAttestation() throws IOException {
        String nom = courant.getNom();
        String prenom1 = courant.getPrenom1();
        Integer som = courant.getSom();
        
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/umpGRH/reportDispatcher?reportId=attestation.odt&nom="+nom+"&prenom1="+prenom1+"&som="+som+"");
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {

        UploadedFile file = event.getFile();
        /******lkkpkk*****/
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

    public List<Personne> getAll() {
        return personneService.findAll();
    }

    public String doCreate() {
        personneService.create(nouveau);
        return showList();
    }

    public Personne getNouveau() {
        return nouveau;
    }

    public void setNouveau(Personne nouveau) {
        this.nouveau = nouveau;
    }

    public Personne getCourant() {
        return courant;
    }

    public void setCourant(Personne courant) {
        this.courant = courant;
    }

}
