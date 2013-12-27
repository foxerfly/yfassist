/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edwin.my;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edwin
 */
public class InstallerTest {
    
    public InstallerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of restored method, of class Installer.
     */
    @Test
    public void testRestored() {
        System.out.println("restored");
        Installer instance = new Installer();
        instance.restored();
    }

    /**
     * Test of actionPerformed method, of class Installer.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        Installer instance = new Installer();
        instance.actionPerformed(e);
    }
    
}
