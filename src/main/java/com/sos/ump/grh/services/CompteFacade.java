/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.services;

import com.sos.ump.grh.entities.Compte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author abdel
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> {
    @PersistenceContext(unitName = "com.sos.ump_grhApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade() {
        super(Compte.class);
    }
    
    public Compte find(String login, String password) {
        List<Compte> found = em.createNamedQuery("Compte.findByLoginAndPassword", Compte.class)
            .setParameter("username", login)
            .setParameter("password", password)
            .getResultList();
        return found.isEmpty() ? null : found.get(0);
    }
    
}
