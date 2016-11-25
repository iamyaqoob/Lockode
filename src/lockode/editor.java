package lockode;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class editor extends javax.swing.JFrame {
    
    private static JFileChooser fileChooser = new JFileChooser();
    public char []password = null;
    String TEXT = "";
    JPasswordField pass = null;
    public login LOGIN;
    public lockode_about LOCKODE_ABOUT;
    public editor() {
        
        initComponents();
        
        this.addWindowListener(listener);
        
        this.setIconImage(new ImageIcon(getClass().getResource("LOCKICON.png")).getImage());
        this.setTitle(("Lockode Editor"));
        this.setVisible(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        open_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        lock_btn = new javax.swing.JButton();
        lockode_about_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        open_btn.setBackground(new java.awt.Color(196, 196, 51));
        open_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        open_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lockode/open.png"))); // NOI18N
        open_btn.setText("open");
        open_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_btnActionPerformed(evt);
            }
        });

        save_btn.setBackground(new java.awt.Color(38, 63, 114));
        save_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        save_btn.setForeground(new java.awt.Color(254, 254, 254));
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lockode/save.png"))); // NOI18N
        save_btn.setText("save");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textArea.setInheritsPopupMenu(true);
        textArea.setSelectionColor(new java.awt.Color(255, 153, 204));
        jScrollPane1.setViewportView(textArea);

        lock_btn.setBackground(new java.awt.Color(254, 254, 254));
        lock_btn.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lock_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lockode/lock.png"))); // NOI18N
        lock_btn.setText("Lock!");
        lock_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lock_btnActionPerformed(evt);
            }
        });

        lockode_about_btn.setBackground(new java.awt.Color(23, 228, 59));
        lockode_about_btn.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lockode_about_btn.setText("Lockode");
        lockode_about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockode_about_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(open_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lockode_about_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(lock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lock_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockode_about_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(open_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     //-##########################################################################
    private void open_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_btnActionPerformed
        open();
    }//GEN-LAST:event_open_btnActionPerformed
   
    public void open() {
		fileChooser.setDialogTitle("Choose your File to Open");
		//fileChooser.setMultiSelectionEnabled(true);
		
		if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			openFile(fileChooser.getSelectedFile().getAbsolutePath());
			
		}
    }
    
    public void openFile(String fileName){
        FileReader fr;
        try{
            fr = new FileReader(fileName);
            textArea.read(fr, null);
            fr.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        saveFile();
    }//GEN-LAST:event_save_btnActionPerformed
    
    public void saveFile(){
        fileChooser.setSelectedFile(new File("code" + ".txt"));
        fileChooser.setDialogTitle("Save the File with an extension");
        
        int signal = fileChooser.showSaveDialog(null);
        
        if(signal  == JFileChooser.APPROVE_OPTION){
            FileWriter fw;
            try{
                fw = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath());
                textArea.write(fw);
                fw.close();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (signal == JFileChooser.CANCEL_OPTION) {
            // User has pressed cancel button
        }
    }
        
    private void lock_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lock_btnActionPerformed
        if(password == null){
            passwordOption("clickedOnLock");
        }
        if(password != null){
            this.setState(Frame.ICONIFIED);
        }
    }//GEN-LAST:event_lock_btnActionPerformed

    private void lockode_about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockode_about_btnActionPerformed
        LOCKODE_ABOUT = new lockode_about();
    }//GEN-LAST:event_lockode_about_btnActionPerformed
    
    //-##########################################################################

    WindowListener listener = new WindowAdapter() {
         public void windowDeiconified(WindowEvent e) {
             //System.out.println("going up");
        
             if(password != null){
                 textArea.setText("");
                 //System.out.println("calling passwordOption");
                 passwordOption("windowDeiconified");
             }
        }
        public void windowClosing(WindowEvent e) { 
            String[] options = new String[]{" Yes ", " No "};
            int signal = JOptionPane.showOptionDialog(null, "Save your work?", "Checkpoint", 
                                                       JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
                                                       options, null);
            if(signal != 0){
                System.exit(0);
            }
            else{
                saveFile();
            }
        }
    };

    //----------------------------------------------------------------------------------------

   
    public void passwordOption(String s){
     
        JPanel panel;
        JLabel label;
        //JLabel label2;
        String temp = "";
        
        int signal = -1;
        boolean flag = false;
        if(s.equals("clickedOnLock")){
            
            while(flag == false){
                panel = new JPanel();
                label = new JLabel("Enter a new password:");
                pass = new JPasswordField(10);
                panel.add(label);
                panel.add(pass);
            
                String[] options = new String[]{" Set ", "Cancel"};
                signal = JOptionPane.showOptionDialog(null, panel, "You do not have a Password yet",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, null);
            
                if(signal == 0){ // pressing OK button
                    
                    temp = new String(pass.getPassword());
                    if(!temp.equals("")){
                        password = pass.getPassword();
                        TEXT = textArea.getText();
                       
                        flag = true;
                    }
                }
                else{
                    flag = true;
                }
                
                //System.out.println("Your password is: " + new String(password));
                //return signal;
            }
        }
        else{
            /*LOGIN = new login();
            while(flag == false){
                String PASS_TO_SEND = new String(password);
                boolean incomingSignalFromLogin = LOGIN.loginView(PASS_TO_SEND);
                if( incomingSignalFromLogin == true){
                    textArea.setText(TEXT);
                    flag = true;
                }
            //}
            */
             while(flag == false){
             panel = new JPanel();
             
             //panel.setPreferredSize(new Dimension(450, 250));
             label = new JLabel("Enter Your Password ");
             
             //label2 = new JLabel("Lockode");
             //label2.setFont(new Font("Calibri", Font.BOLD, 36));
             
             pass = new JPasswordField(10);
             
             //panel.add(label2);
             panel.add(label);
             panel.add(pass);
             
             
             
             String[] options = new String[]{"   Press Me!   "};
             signal = JOptionPane.showOptionDialog(null, panel, "Lockode: Unlock your code!",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, null);
             
             if(signal == 0){ // pressing OK button
                char tempPassword[] = pass.getPassword();
                
                //System.out.println("saved password is: " + new String(password));
                //System.out.println("tempPassword is: " + new String(tempPassword));
                
                String p1 = new String(password);
                String p2 = new String(tempPassword);
                
                if(p1.equals(p2)){
                    textArea.setText(TEXT);
                    flag = true;
                    //break;
                }
                
            }
             
            }
             //return signal;
             
        }
    }
   
    //----------------------------------------------------------------------------------------
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) {
        
        //new editor();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lock_btn;
    private javax.swing.JButton lockode_about_btn;
    private javax.swing.JButton open_btn;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
