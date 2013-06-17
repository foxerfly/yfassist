/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edwin.my.Cost;

import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.PropertySupport;

/**
 *
 * @author Administrator
 */
public class PropertyReadWrite extends PropertySupport.ReadWrite{

    public PropertyReadWrite(String name, Class type, String displayName, String shortDescription) {
        super(name, type, displayName, shortDescription);
    }

    @Override
    public Object getValue() throws IllegalAccessException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(Object val) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
