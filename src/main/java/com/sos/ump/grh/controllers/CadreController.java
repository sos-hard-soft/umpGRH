/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Cadre;
import com.sos.ump.grh.services.CadreFacade;
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
public class CadreController implements Serializable {

    @Inject
    private CadreFacade cadreService;
    private Cadre courrant;
    private Cadre nouveau;
    
    private List<Cadre> cadres;
    
    
    /**
     * Creates a new instance of CadreController
     */
    public CadreController() {
    }
    
    public String showList() {
        return "/cadre/list?faces-redirect=true";
    }

    public String showCreate() {
        nouveau = new Cadre();
        return "/cadre/new?faces-redirect=true";
    }

    public String showDetail(Cadre cadre) {
        courrant = cadre;
        return "/cadre/view?faces-redirect=true";
    }
    
    public List<Cadre> getAll() {
        return cadreService.findAll();
    }

    public String doCreate() {
        cadreService.create(nouveau);
        return showList();
    }

    public Cadre getCourrant() {
        return courrant;
    }

    public void setCourrant(Cadre courrant) {
        this.courrant = courrant;
    }

    public Cadre getNouveau() {
        return nouveau;
    }

    public void setNouveau(Cadre nouveau) {
        this.nouveau = nouveau;
    }
    
    public Cadre getCadre(java.lang.Integer id) {
        return cadreService.find(id);
    }
    
     @FacesConverter(forClass = Cadre.class)
    public static class CadreControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CadreController controller = (CadreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cadreController");
            return controller.getCadre(getKey(value));
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
            if (object instanceof Cadre) {
                Cadre o = (Cadre) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Cadre.class.getName());
            }
        }
    
}
}
