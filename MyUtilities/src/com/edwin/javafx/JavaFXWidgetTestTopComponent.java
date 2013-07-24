/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwin.javafx;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.api.visual.vmd.VMDGraphScene;
import org.netbeans.api.visual.vmd.VMDNodeWidget;
import org.netbeans.api.visual.widget.ComponentWidget;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.edwin.javafx//JavaFXWidgetTest//EN",
        autostore = false
        )
@TopComponent.Description(
        preferredID = "JavaFXWidgetTestTopComponent",
        iconBase = "ICONS/navigator.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
        )
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "系统管理", id = "com.edwin.javafx.JavaFXWidgetTestTopComponent")
@ActionReference(path = "Menu/系统管理" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_JavaFXWidgetTestAction",
        preferredID = "JavaFXWidgetTestTopComponent"
        )
@Messages({
    "CTL_JavaFXWidgetTestAction=JavaFXWidgetTest",
    "CTL_JavaFXWidgetTestTopComponent=JavaFXWidgetTest Window",
    "HINT_JavaFXWidgetTestTopComponent=This is a JavaFXWidgetTest window"
})
public final class JavaFXWidgetTestTopComponent extends TopComponent {

    private VMDGraphScene scene;
    private JScrollPane scrollPane = new JScrollPane();
    public LineChartJFXPanel lineChartPanel;

    public JavaFXWidgetTestTopComponent() {
        initComponents();
        setName(Bundle.CTL_JavaFXWidgetTestTopComponent());
        setToolTipText(Bundle.HINT_JavaFXWidgetTestTopComponent());

//        setLayout(new BorderLayout());
//        add(scrollPane, BorderLayout.CENTER);
        //Setup visual library scene
//        scene = new VMDGraphScene();
//        scrollPane.setViewportView(scene.createView());
//        //Initialize and add JavaFX chart widget
//        //Line chart
//        lineChartPanel = new LineChartJFXPanel();
//        //create our new node in the scene 
//        VMDNodeWidget widget = (VMDNodeWidget) scene.addNode("JavaFX Chart");
//        //Add our JavaFX panel to a ComponentWidget which is adept at embedding Swing components
//        ComponentWidget componentWidget = new ComponentWidget(scene, lineChartPanel);
//        //The JavaFX chart component is now a child of this node and can be found as such
//        widget.addChild(componentWidget);
//
//        scene.getSceneAnimator().animatePreferredLocation(widget, getMousePosition(true));
//        scene.validate(); //Make sure you validate the scene so that everything renders nicely
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yController1 = new fi.mmm.yhteinen.swing.core.YController();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fi.mmm.yhteinen.swing.core.YController yController1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}