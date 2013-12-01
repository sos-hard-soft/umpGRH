/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.services;

import com.sos.ump.grh.entities.Diplome;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author infoFSO5
 */
@Stateless
public class DiplomeFacade extends AbstractFacade<Diplome> {
    @PersistenceContext(unitName = "grhPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiplomeFacade() {
        super(Diplome.class);
    }
    
}
