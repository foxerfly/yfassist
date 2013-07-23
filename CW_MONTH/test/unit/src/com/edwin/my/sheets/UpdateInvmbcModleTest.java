/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.my.sheets;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class UpdateInvmbcModleTest {
    
    public UpdateInvmbcModleTest() {
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
     * Test of getMaterialPrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testGetMaterialPrice() {
        System.out.println("getMaterialPrice");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        BigDecimal expResult = null;
        BigDecimal result = instance.getMaterialPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterialPrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testSetMaterialPrice() {
        System.out.println("setMaterialPrice");
        BigDecimal materialPrice = null;
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        instance.setMaterialPrice(materialPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLaborePrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testGetLaborePrice() {
        System.out.println("getLaborePrice");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        BigDecimal expResult = null;
        BigDecimal result = instance.getLaborePrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLaborePrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testSetLaborePrice() {
        System.out.println("setLaborePrice");
        BigDecimal laborePrice = null;
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        instance.setLaborePrice(laborePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMadePrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testGetMadePrice() {
        System.out.println("getMadePrice");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        BigDecimal expResult = null;
        BigDecimal result = instance.getMadePrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMadePrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testSetMadePrice() {
        System.out.println("setMadePrice");
        BigDecimal madePrice = null;
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        instance.setMadePrice(madePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCooperationPrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testGetCooperationPrice() {
        System.out.println("getCooperationPrice");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        BigDecimal expResult = null;
        BigDecimal result = instance.getCooperationPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCooperationPrice method, of class UpdateInvmbcModle.
     */
    @Test
    public void testSetCooperationPrice() {
        System.out.println("setCooperationPrice");
        BigDecimal cooperationPrice = null;
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        instance.setCooperationPrice(cooperationPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPh method, of class UpdateInvmbcModle.
     */
    @Test
    public void testGetPh() {
        System.out.println("getPh");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        String expResult = "";
        String result = instance.getPh();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         System.out.println(result);
    }

    /**
     * Test of setPh method, of class UpdateInvmbcModle.
     */
    @Test
    public void testSetPh() {
        System.out.println("setPh");
        String ph = "BBBBBBB";
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        instance.setPh(ph);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of insertOrUpdate method, of class UpdateInvmbcModle.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        UpdateInvmbcModle instance = new UpdateInvmbcModle();
        boolean expResult = false;
        boolean result = instance.insertOrUpdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
