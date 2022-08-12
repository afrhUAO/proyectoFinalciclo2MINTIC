/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author frank
 */
public class App {
    public static void main(String[] args) {
        
        var report = new ReportesView();
     report.setLayout(new FlowLayout());
     report.setSize(600, 400);
     report.setVisible(true);
     report.setResizable(false);
     report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     report.setLocationRelativeTo(null);
     
        
    }
    
    
}
