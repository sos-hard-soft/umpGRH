/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sos.ump.grh.exceptions;

import javax.ejb.ApplicationException;

/**
 *
 * @author mab.salhi
 */
@ApplicationException(rollback = true)
public class ValidationException extends RuntimeException{
    
    // ======================================
    // = Constructors =
    // ======================================    
    
    public ValidationException(String message){
        super(message);
    }
}