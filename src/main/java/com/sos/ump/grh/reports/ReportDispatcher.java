/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.reports;

import fr.opensagres.xdocreport.document.dispatcher.BasicXDocReportDispatcher;
import fr.opensagres.xdocreport.document.web.dispatcher.IXDocReportWEBController;

/**
 *
 * @author mab.salhi
 */
public class ReportDispatcher extends BasicXDocReportDispatcher<IXDocReportWEBController> {

  public ReportDispatcher() {
    register(ReportController.REPORT_ID, new ReportController());
    // register another controller....to manage another report
  }
}
