/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.components;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import kuver.Controller;

/**
 *
 * @author q1
 */
public class Backup extends javax.swing.JDialog {

    private Controller controller;

    /**
     * Creates new form Backup
     */
    public Backup(Controller controller, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chooseBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        filePathTf = new javax.swing.JTextField();
        restoreBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFile(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Datensicherung");

        jLabel2.setText("Sichern Sie Ihre Daten");

        createBtn.setText("Backup erstellen");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Daten Wiederherstellen aus einem altem Backup");

        chooseBtn.setText("Backup-Datei auswählen");
        chooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Ausgewählte Datei:");

        filePathTf.setText("...");

        restoreBtn.setText("Backup einspielen");
        restoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restoreBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filePathTf, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(chooseBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filePathTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restoreBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        createBackup();
    }//GEN-LAST:event_createBtnActionPerformed

    private void chooseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBtnActionPerformed
        fileChooser.showOpenDialog(this);

    }//GEN-LAST:event_chooseBtnActionPerformed

    private void restoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBtnActionPerformed
        if (fileChooser.getSelectedFile() != null) {
            final JOptionPane optionPane = new JOptionPane(
                    "Achtung: Ihre alten Daten werden nun wiederhergestellt. "
                    + "\nBeachten Sie, dass Ihre aktuellen Daten dadurch "
                    + "\nüberschrieben werden und verloren gehen. "
                    + "\nWollen Sie den Vorgang trotzdem fortsetzen?\n",
                    JOptionPane.QUESTION_MESSAGE,
                    JOptionPane.YES_NO_OPTION);

            final JDialog dialog = new JDialog(this,
                    "Änderungen speichern",
                    true);
            dialog.setContentPane(optionPane);
            optionPane.addPropertyChangeListener(
                    new PropertyChangeListener() {
                        public void propertyChange(PropertyChangeEvent e) {
                            String prop = e.getPropertyName();

                            if (dialog.isVisible()
                                    && (e.getSource() == optionPane)
                                    && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                                dialog.setVisible(false);
                            }
                        }
                    });
            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

            int value = ((Integer) optionPane.getValue()).intValue();
            if (value == JOptionPane.YES_OPTION) { // Save

                if (restoreBackup() == 0) {
                   JOptionPane.showMessageDialog(this,
                    "Daten wurden erfolgreich wiederhergestellt! " + fileChooser.getSelectedFile().toString(),
                    "Backup eingepsielt",
                    JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Fehler bei der Wiederherstellung der alten Daten.",
                            "Datenwiederherstellung fehlgeschlagen",
                            JOptionPane.WARNING_MESSAGE);
                }

            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Wählen Sie zuerst eine Datei aus!",
                    "Backup auswählen",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_restoreBtnActionPerformed

    private void openFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFile
        if (fileChooser.getSelectedFile() != null) {
            filePathTf.setText(fileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_openFile

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
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Backup dialog = new Backup(null, new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseBtn;
    private javax.swing.JButton createBtn;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField filePathTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton restoreBtn;
    // End of variables declaration//GEN-END:variables

    private void createBackup() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String name = controller.getUser().getName();
        String pass = controller.getUser().getPass();
        String fileName = new SimpleDateFormat("yyyy-MM-dd_hh-mm'.sql'").format(new Date());
        String dir = "backup\\";
        String sql = "mysqldump -u" + name + " -p" + pass + " KuVer >  " + dir + fileName;
        System.out.println(sql);
        if (controller.executeShellCmd(sql) == 0) {
            JOptionPane.showMessageDialog(this,
                    "Sicherheitskopie wurde erstellt: " + dir + fileName,
                    "Backup erstellt",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Sicherheitskopie konnte nicht erstellt werden!",
                    "Backup fehlgeschlagen",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private int restoreBackup() {
        System.out.println("Restore DB");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String name = controller.getRootName();
        String pass = controller.getRootPass();
        String file = fileChooser.getSelectedFile().toString();
        String sql = "mysql -u" + name + " -p" + pass + " KuVer <  " + file;
        int msg = controller.executeShellCmd(sql);
        return msg;
    }
}
