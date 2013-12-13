/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Diplome;
import com.sos.ump.grh.services.DiplomeFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;



/**
 *
 * @author mab.salhi
 */
@Named
@SessionScoped
public class DiplomeController implements Serializable{
@Inject
    private DiplomeFacade diplomeService;
    private Diplome courrant;
    private Diplome nouveau;
    
    private List<Diplome> diplomes;
    
    
   /**
     * Creates a new instance of DiplomeController
     */
    public DiplomeController() {
    }
    
    public String showList() {
        return "/diplome/list?faces-redirect=true";
    }

    public String showCreate() {
        nouveau = new Diplome();
        return "/diplome/new?faces-redirect=true";
    }

    public String showDetail(Diplome diplome) {
        courrant = diplome;
        return "/diplome/view?faces-redirect=true";
    }
    
    public List<Diplome> getAll() {
        return diplomeService.findAll();
    }

    public String doCreate() {
        diplomeService.create(nouveau);
        return showList();
    }

    public Diplome getCourrant() {
        return courrant;
    }

    public void setCourrant(Diplome courrant) {
        this.courrant = courrant;
    }

    public Diplome getNouveau() {
        return nouveau;
    }

    public void setNouveau(Diplome nouveau) {
        this.nouveau = nouveau;
    }
    
    public Diplome getDiplome(java.lang.Integer id) {
        return diplomeService.find(id);
    }
    
     @FacesConverter(forClass = Diplome.class)
    public static class DiplomeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DiplomeController controller = (DiplomeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "diplomeController");
            return controller.getDiplome(getKey(value));
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
            if (object instanceof Diplome) {
                Diplome o = (Diplome) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Diplome.class.getName());
            }
        }
    
}
    
}
