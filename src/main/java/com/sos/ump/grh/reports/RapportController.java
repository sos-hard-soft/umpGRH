/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.reports;

import com.sos.ump.grh.controllers.PersonneController;
import com.sos.ump.grh.entities.Personne;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.web.dispatcher.AbstractXDocReportWEBController;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import java.io.InputStream;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author abdel
 */
public class RapportController extends
                AbstractXDocReportWEBController {

   public static final String REPORT_ID = "attestation.odt";

  public RapportController() {
    super(TemplateEngineKind.Velocity, DocumentKind.ODT);
    
  }

  @Override
  public InputStream getSourceStream() {
    return RapportController.class.getResourceAsStream("attestation.odt");
  }

  @Override
  protected FieldsMetadata createFieldsMetadata() {
    return null;
  }

  @Override
  public void populateContext(IContext context, IXDocReport report, HttpServletRequest request) {
   String nom = request.getParameter("nom");
   String prenom = request.getParameter("prenom");
   String som = request.getParameter("som");
   Integer leSom = Integer.parseInt(som);
   Personne personne = new Personne(leSom, nom, prenom);
      System.out.println("la personne : ");
      
   context.put("person", personne);
  }

    
  
  
}