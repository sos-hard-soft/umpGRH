/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Personne;
import com.sos.ump.grh.services.PersonneFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author infoFSO5
 */
@Named
@SessionScoped
public class PersonneController implements Serializable{

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
    
    public String showList(){
        return "/personne/list?faces-redirect=true";
    }
    
    public String showCreate(){
        courant = new Personne();
        return "/personne/new?faces-redirect=true";
    }
    
    public String showView(Personne personne){
        courant = personne;
        return "/personne/view?faces-redirect=true";
    }
    
    public List<Personne> getAll(){
        return personneService.findAll();
    }
    
    public String doCreate(){
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
