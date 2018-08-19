/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.ui;

import javax.swing.JTextField;

/**
 *
 * @author Patsf
 */
class SwingValidator {

    private String lineEnd;
    
    public SwingValidator() { 
        this.lineEnd = "\n";  
    }
    public SwingValidator(String lineEnd) {
        this.lineEnd = lineEnd;
    }
    
    public String isPresent(String value, String name) {
        String msg = "";
        if (value.isEmpty()) {
            msg = name + " is required." + lineEnd;
        }
        return msg;
    }

    public String isDouble(String value, String name) {
        String msg = "";
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            msg = name + " must be a valid number." + lineEnd;
        }
        return msg;
    }
}
