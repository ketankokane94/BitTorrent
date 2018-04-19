
package gui;

import atktorrent.TorrentParser;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class mainScreen extends javax.swing.JFrame {

    public mainScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        newdownload = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        createTorrent = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATKTorrent");

        jMenu.setText("File");

        newdownload.setText("Add new torrent");
        newdownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newdownloadActionPerformed(evt);
            }
        });
        jMenu.add(newdownload);
        jMenu.add(jSeparator2);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu.add(exit);

        jMenuBar1.add(jMenu);

        jMenu2.setText("Edit");

        jMenuItem3.setText("Resume");
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator3);

        jMenuItem4.setText("Pause");
        jMenu2.add(jMenuItem4);
        jMenu2.add(jSeparator4);

        jMenuItem5.setText("Stop");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tools");

        createTorrent.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        createTorrent.setText("Create torrent");
        createTorrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTorrentActionPerformed(evt);
            }
        });
        jMenu3.add(createTorrent);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Advance");

        jMenuItem7.setText("Tracker URL");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Peer List");
        jMenu4.add(jMenuItem8);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(463, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void createTorrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTorrentActionPerformed
       
        createtorrent ct= new createtorrent();
        ct.setVisible(true);
        
    }//GEN-LAST:event_createTorrentActionPerformed

    private void newdownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newdownloadActionPerformed
       
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
         "Torrents file", ".crce");
        jFileChooser1.addChoosableFileFilter(filter);
        jFileChooser1.showOpenDialog(this) ;
        int returnVal =0;
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        System.out.println("You chose to open this file: " +
        jFileChooser1.getSelectedFile().getPath());
        TorrentParser tp = new TorrentParser(jFileChooser1.getSelectedFile().getPath());
//        tp.TorrentParser();
}
   
    }//GEN-LAST:event_newdownloadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new mainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem createTorrent;
    private javax.swing.JMenuItem exit;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem newdownload;
    // End of variables declaration//GEN-END:variables
}
