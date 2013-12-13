/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.controllers;

import com.sos.ump.grh.entities.Service;
import com.sos.ump.grh.services.ServiceFacade;
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
public class ServiceController implements Serializable{

    @Inject
    private ServiceFacade serviceService;
    private Service courrant;
    private Service nouveau;
    
    private List<Service> services;
    /**
     * Creates a new instance of ServiceController
     */
    public ServiceController() {
    }
    public String showList() {
        return "/service/list?faces-redirect=true";
    }

    public String showCreate() {
        nouveau = new Service();
        return "/service/new?faces-redirect=true";
    }

    public String showDetail(Service service) {
        courrant = service;
        return "/service/view?faces-redirect=true";
    }
    
    public List<Service> getAll() {
        return serviceService.findAll();
    }

    public String doCreate() {
        serviceService.create(nouveau);
        return showList();
    }

    public Service getCourrant() {
        return courrant;
    }

    public void setCourrant(Service courrant) {
        this.courrant = courrant;
    }

    public Service getNouveau() {
        return nouveau;
    }

    public void setNouveau(Service nouveau) {
        this.nouveau = nouveau;
    }
    
    public Service getService(java.lang.Integer id) {
        return serviceService.find(id);
    }
    
     @FacesConverter(forClass = Service.class)
    public static class ServiceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ServiceController controller = (ServiceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "serviceController");
            return controller.getService(getKey(value));
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
            if (object instanceof Service) {
                Service o = (Service) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Service.class.getName());
            }
        }
    
}
}
