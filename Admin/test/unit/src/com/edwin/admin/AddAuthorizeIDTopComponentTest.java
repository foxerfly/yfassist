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
 * @author edwin
 */
public class AddAuthorizeIDTopComponentTest {

    public AddAuthorizeIDTopComponentTest() {
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
     * Test of componentOpened method, of class AddAuthorizeIDTopComponent.
     */
    @Test
    public void testComponentOpened() {
        System.out.println("componentOpened");
        AddAuthorizeIDTopComponent instance = new AddAuthorizeIDTopComponent();
        instance.componentOpened();
    }

    /**
     * Test of componentClosed method, of class AddAuthorizeIDTopComponent.
     */
    @Test
    public void testComponentClosed() {
        System.out.println("componentClosed");
        AddAuthorizeIDTopComponent instance = new AddAuthorizeIDTopComponent();
        instance.componentClosed();
    }

    /**
     * Test of writeProperties method, of class AddAuthorizeIDTopComponent.
     */
    @Test
    public void testWriteProperties() {
        System.out.println("writeProperties");
        Properties p = null;
        AddAuthorizeIDTopComponent instance = new AddAuthorizeIDTopComponent();
        instance.writeProperties(p);
    }

    /**
     * Test of readProperties method, of class AddAuthorizeIDTopComponent.
     */
    @Test
    public void testReadProperties() {
        System.out.println("readProperties");
        Properties p = null;
        AddAuthorizeIDTopComponent instance = new AddAuthorizeIDTopComponent();
        instance.readProperties(p);
    }

}
