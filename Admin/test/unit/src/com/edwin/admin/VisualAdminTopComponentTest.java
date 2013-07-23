/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.admin;

import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EDWIN
 */
public class VisualAdminTopComponentTest {
    
    public VisualAdminTopComponentTest() {
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
     * Test of componentOpened method, of class VisualAdminTopComponent.
     */
    @Test
    public void testComponentOpened() {
        System.out.println("componentOpened");
        VisualAdminTopComponent instance = new VisualAdminTopComponent();
        instance.componentOpened();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of componentClosed method, of class VisualAdminTopComponent.
     */
    @Test
    public void testComponentClosed() {
        System.out.println("componentClosed");
        VisualAdminTopComponent instance = new VisualAdminTopComponent();
        instance.componentClosed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeProperties method, of class VisualAdminTopComponent.
     */
    @Test
    public void testWriteProperties() {
        System.out.println("writeProperties");
        Properties p = null;
        VisualAdminTopComponent instance = new VisualAdminTopComponent();
        instance.writeProperties(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readProperties method, of class VisualAdminTopComponent.
     */
    @Test
    public void testReadProperties() {
        System.out.println("readProperties");
        Properties p = null;
        VisualAdminTopComponent instance = new VisualAdminTopComponent();
        instance.readProperties(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
