/*
* File: MainWindow.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
*
*/
package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public JButton startBtn = new JButton("Start");
    public JButton stopBtn = new JButton("Stop");
    public JButton nextBtn = new JButton("Következő");
    public JPanel tablePanel = new JPanel();
    public JButton flop1Btn = new JButton("");
    public JButton flop2Btn = new JButton("");
    public JButton flop3Btn = new JButton("");
    public JPanel handPanel = new JPanel();
    public JButton humanCard1Btn = new JButton();
    public JButton humanCard2Btn = new JButton();
    public JPanel buttonPanel = new JPanel();
    public JButton turnButton = new JButton();
    public JButton riverButton = new JButton();

    public MainWindow() {
        this.tablePanel.setSize(100, 100);
        this.tablePanel.setBackground(Color.LIGHT_GRAY);
        this.tablePanel.add(flop1Btn);
        this.tablePanel.add(flop2Btn);
        this.tablePanel.add(flop3Btn);
        /* A flop-nak nem kell megjelennie flop előtti állapotban */
        this.flop1Btn.setVisible(false);
        this.flop2Btn.setVisible(false);
        this.flop3Btn.setVisible(false);
        this.handPanel.add(this.humanCard1Btn);
        this.handPanel.add(this.humanCard2Btn);

        this.buttonPanel.add(startBtn);
        this.buttonPanel.add(nextBtn);
        this.buttonPanel.add(stopBtn);
        this.tablePanel.add(turnButton);
        this.tablePanel.add(riverButton);
        this.turnButton.setVisible(false);
        this.riverButton.setVisible(false);

        this.setLayout(new BoxLayout(
                this.getContentPane(),
                BoxLayout.PAGE_AXIS));

        this.add(buttonPanel);
        this.add(tablePanel);
        this.add(handPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
    }

}
