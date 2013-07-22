/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.javafx;

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
public class LineChartJFXPanelTest {
    
    public LineChartJFXPanelTest() {
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
     * Test of updateXY method, of class LineChartJFXPanel.
     */
    @Test
    public void testUpdateXY() {
        System.out.println("updateXY");
        String seriesTitle = "";
        Double[] xArray = null;
        Double[] yArray = null;
        LineChartJFXPanel instance = new LineChartJFXPanel();
        instance.updateXY(seriesTitle, xArray, yArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
