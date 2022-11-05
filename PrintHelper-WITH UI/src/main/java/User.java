package src.main.java;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;
import java.io.File;

public class User{

   JFileChooser chooser;

   JFrame frameMain;
   
   JPanel panelExtensions, panelActions;
   
   JLabel labelChosenDir;
   JTextField fieldExt;
   JButton buttonAdd, buttonDir, buttonPrint;
   
   JLabel[] labelExts;
   int numExt;
   
   int ExtListY, ExtListX, ExtListYInc;

   public User() {
      ExtListY = 100;
      ExtListX = 100;
      ExtListYInc = 50;
      labelExts = new JLabel[5];
      
         
      initWindow(); 
      
   }
   
   private void initWindow() {
      frameMain = new JFrame("Print Helper");
      
      
      addElements();
       
      frameMain.pack();
      frameMain.setVisible(true);

      frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
   }
   
   private void addElements() {     
            
     // ADD LIST OF EXTENSIONS TO LEFT SIDE
      panelActions = new JPanel();
      panelActions.setLayout(new BoxLayout(panelActions, BoxLayout.Y_AXIS));
      frameMain.add(panelActions, BorderLayout.WEST);
      
      panelActions.add(createDirLabel());
      panelActions.add(createDirButton());
      panelActions.add(createPrintButton());
      
      
      // ADD LIST OF ACTIONS TO RIGHT SIDE
      panelExtensions = new JPanel();
      panelExtensions.setLayout(new BoxLayout(panelExtensions, BoxLayout.Y_AXIS));
      frameMain.add(panelExtensions, BorderLayout.EAST);
  
      panelExtensions.add(createTextField());
      panelExtensions.add(createAddButton());
      // CREATE EMPTY LIST OF EXTENSIONS THAT MAX OUT AT FIVE
      for (int i = 0; i < 5; i++) {
         panelExtensions.add(createExtLabel(i,  ExtListX, ExtListY));
         ExtListY += ExtListYInc;
      }
   }
   
   private JLabel createExtLabel(int i, int x, int y) {
      labelExts[i] = new JLabel("Empty");
   //   extensions[i].setBounds(x, y, 100, 50);
      return labelExts[i];
   }
   
   private JLabel createDirLabel() {
      labelChosenDir = new JLabel("chosen directory");
  //    labelChosenDir.setBounds(100, 50, 100, 50);
      return labelChosenDir;
   }
   
   private JTextField createTextField() {
      fieldExt = new JTextField("FIELD");
  //    fieldExt.setBounds(10, 10, 150, 50);
      return fieldExt;
   }

   
   private JButton createAddButton() {
      buttonAdd = new JButton("+");
   //   buttonAdd.setBounds(0, 0, 128, 128);
      buttonAdd.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            actionAddExtension();
         }
      });
      return buttonAdd;
   }
    
   private JButton createDirButton() {
      buttonDir = new JButton("Choose Directory");
   //   buttonDir.setBounds(100, 100, 100, 100);
      buttonDir.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            actionChooseDir();
         }
      });
      return buttonDir;
   }
   
   private JButton createPrintButton() {
      buttonPrint = new JButton("Print");
   //   buttonPrint.setBounds(100, 200, 100, 100);
      buttonPrint.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            actionPrint();
         }
      });

      return buttonPrint;
   }
   
   private void actionPrint() {
   
      System.out.println("PRINT");
      
      ///////////////////////////////////////////////////    YOUR CODE
      ///////////////////////////////////////////////////
   
      FilePrinter filePrinter = new FilePrinter();
      FileLoader fileLoader = new FileLoader(labelChosenDir.getText(), getExtensions()[0]);  //// FOR NOW IT ONLY PRINTS THE FIRST EXTENSION YOU'VE ADDED
      List<File> filesToPrint = fileLoader.getFiles();
      filePrinter.printFiles(filesToPrint);
      
      ///////////////////////////////////////////////////
      ///////////////////////////////////////////////////

   }
   
   private void actionChooseDir() {
   
      System.out.println("DIRECTORY");
      
      ////////////////////////////////////////////////// CHOOSE DIRECTORY CODE
      chooser = new JFileChooser();
      chooser.setCurrentDirectory(new java.io.File("."));
      chooser.setDialogTitle("Choose Directory");
      chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      if (chooser.showOpenDialog(panelActions) == JFileChooser.APPROVE_OPTION) { 
         labelChosenDir.setText(""+chooser.getCurrentDirectory());
      }
      else {
        
      }
      //////////////////////////////////////////////////////
  
   }
   
   private void actionAddExtension() {

      System.out.println("ADDED  EXTENSION");
      
      /////////////////////////////////////////////// ADD EXTENSION TO LIST OF EXTENSIONS TO PRINT
      
      labelExts[numExt].setText(fieldExt.getText());
      numExt++;
      frameMain.pack();
   }
   
   public String[] getExtensions() {
   
      /////////////////////////////////////////////// REPACKAGE THE LABELS AS JUST STRINGS OF HOW MANY YOU'VE ADDED
      String[] res = new String[numExt];
      for (int i = 0; i < 5; i++) {
         res[i] = labelExts[i].getText();
      }
      return res;
   }
   
}