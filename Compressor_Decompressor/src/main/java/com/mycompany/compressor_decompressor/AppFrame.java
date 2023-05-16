/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compressor_decompressor;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author teja
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 250, 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(300, 100, 250, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.lightGray);
        this.setVisible(true);
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
//                System.out.println(file);
                try {
                    Compressor.method(file);
                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        
        if (ae.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
//                System.out.println(file);
                try {
                    Decompressor.method(file);
                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
