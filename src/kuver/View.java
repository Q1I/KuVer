/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.PlainDocument;
import kuver.definitions.Comment;
import kuver.definitions.Kunde;
import kuver.definitions.User;
import kuver.components.About;
import kuver.components.Backup;
import kuver.components.Register;
import kuver.tweaks.ContextMenuMouse;

/**
 *
 * @author q1
 */
public class View extends javax.swing.JFrame {

    Controller controller;

    /**
     * Creates new form View
     */
    public View(Controller controller) {
        this.controller = controller;
        initComponents();

        // Eigene Einstellungen
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        this.setExtendedState(this.MAXIMIZED_BOTH);

        // StrNr
        kuver.tweaks.TextLengthDocFilter filterStrNr = new kuver.tweaks.TextLengthDocFilter(5, 0);
        PlainDocument doc = (PlainDocument) neuStrNrTf.getDocument();
        doc.setDocumentFilter(filterStrNr);
        PlainDocument doc2 = (PlainDocument) sucheStrNrTf.getDocument();
        doc2.setDocumentFilter(filterStrNr);
        PlainDocument doc3 = (PlainDocument) detailsStrNrTf.getDocument();
        doc3.setDocumentFilter(filterStrNr);
        // PLZ
        kuver.tweaks.TextLengthDocFilter filterPLZ = new kuver.tweaks.TextLengthDocFilter(5, 0);
        PlainDocument doc4 = (PlainDocument) neuPlzTf.getDocument();
        doc4.setDocumentFilter(filterPLZ);
        PlainDocument doc5 = (PlainDocument) suchePlzTf.getDocument();
        doc5.setDocumentFilter(filterPLZ);
        PlainDocument doc6 = (PlainDocument) detailsPlzTf.getDocument();
        doc6.setDocumentFilter(filterPLZ);
        // IMEI
        kuver.tweaks.TextLengthDocFilter filterImei = new kuver.tweaks.TextLengthDocFilter(15, 0);
        PlainDocument doc7 = (PlainDocument) neuImeiTf.getDocument();
        doc7.setDocumentFilter(filterImei);
//        PlainDocument doc8 = (PlainDocument) sucheImeiTf.getDocument();
//        doc8.setDocumentFilter(filterPLZ);
        PlainDocument doc9 = (PlainDocument) detailsImeiTf.getDocument();
        doc9.setDocumentFilter(filterImei);
        // MSISDN
        kuver.tweaks.TextLengthDocFilter filterMsisdn = new kuver.tweaks.TextLengthDocFilter(18, 0);
        PlainDocument doc10 = (PlainDocument) neuMsisdnTf.getDocument();
        doc10.setDocumentFilter(filterMsisdn);
//        PlainDocument doc11 = (PlainDocument) sucheMsisdnTf.getDocument();
//        doc11.setDocumentFilter(filterMsisdn);
        PlainDocument doc12 = (PlainDocument) detailsMsisdnTf.getDocument();
        doc12.setDocumentFilter(filterMsisdn);
        // Handy
        kuver.tweaks.TextLengthDocFilter filterHandy = new kuver.tweaks.TextLengthDocFilter(15, 0);
        PlainDocument doc13 = (PlainDocument) neuRufNrTf.getDocument();
        doc13.setDocumentFilter(filterHandy);
//        PlainDocument doc14 = (PlainDocument) sucheHandyTf.getDocument();
//        doc5.setDocumentFilter(filterHandy);
        PlainDocument doc15 = (PlainDocument) detailsRufNrTf.getDocument();
        doc15.setDocumentFilter(filterHandy);
        // Klasse
        kuver.tweaks.TextLengthDocFilter filterKlasse = new kuver.tweaks.TextLengthDocFilter(3, 0);
        PlainDocument doc16 = (PlainDocument) neuKlasseTf.getDocument();
        doc16.setDocumentFilter(filterKlasse);
//        PlainDocument doc17 = (PlainDocument) sucheKlasseTf.getDocument();
//        doc17.setDocumentFilter(filterKlasse);
        PlainDocument doc18 = (PlainDocument) detailsKlasseTf.getDocument();
        doc18.setDocumentFilter(filterKlasse);

        // context menu on right click for all textfields
        initContextMenuRightClick();

        // Enter listener
        initEnterBinding();

        // TabPanel
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        tabPanel.setEnabledAt(3, false);
        tabPanel.setEnabledAt(4, false);

        tabellePanel.setVisible(false);

        loginUserTf.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabellePanel = new javax.swing.JScrollPane();
        tabelle = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        optNeuBtn = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        startPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        loginUserTf = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        loginPassPf = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        neuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        neuNameTf = new javax.swing.JTextField();
        neuVornameTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        neuStrasseTf = new javax.swing.JTextField();
        neuPlzTf = new javax.swing.JTextField();
        neuOrtTf = new javax.swing.JTextField();
        neuAnredeCB = new javax.swing.JComboBox();
        neuAddBtn = new javax.swing.JButton();
        neuStrNrTf = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        neuRufNrTf = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        neuVerArtTf = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        neuImeiTf = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        neuMsisdnTf = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        neuVerNrTf = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        neuVerlaengerbarDP = new com.toedter.calendar.JDateChooser();
        neuGebDP = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        neuNetzTf = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        neuAktiviertDP = new com.toedter.calendar.JDateChooser();
        jLabel48 = new javax.swing.JLabel();
        neuKlasseTf = new javax.swing.JTextField();
        neuVerArtCB = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        neuHandyMarkeTf = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        neuHandyModellTf = new javax.swing.JTextField();
        suchePanel = new javax.swing.JPanel();
        sucheSuchenBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        sucheNameTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        sucheVornameTf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        suchePlzTf = new javax.swing.JTextField();
        sucheStrasseTf = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        sucheStrNrTf = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sucheIdTf = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        sucheOrtTf = new javax.swing.JTextField();
        sucheGebDP = new com.toedter.calendar.JDateChooser();
        jLabel50 = new javax.swing.JLabel();
        sucheVerlaengerbarDP = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        sucheVerNrTf = new javax.swing.JTextField();
        sucheResetBtn = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        sucheRufNrTf = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        sucheVerArtCB = new javax.swing.JComboBox();
        detailsPanel = new javax.swing.JPanel();
        detailsSaveBtn = new javax.swing.JButton();
        detailsEditBtn = new javax.swing.JButton();
        detailsCancelBtn = new javax.swing.JButton();
        detailsGebDP = new com.toedter.calendar.JDateChooser();
        detailsVerlaengerbarDP = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        detailsStrNrTf = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        detailsNameTf = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        detailsCommentNrTf = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        detailsMsisdnTf = new javax.swing.JTextField();
        detailsImeiTf = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        detailsVerArtTf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        detailsRufNrTf = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        detailsVornameTf = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        detailsNetzTf = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        detailsStrasseTf = new javax.swing.JTextField();
        detailsPlzTf = new javax.swing.JTextField();
        detailsOrtTf = new javax.swing.JTextField();
        detailsAnredeCB = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        detailsIdTf = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        detailsAktiviertDP = new com.toedter.calendar.JDateChooser();
        detailsDeleteBtn = new javax.swing.JButton();
        detailsCommentBtn = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        detailsVerNrTf = new javax.swing.JTextField();
        detailsKlasseTf = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        detailsVerArtCB = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        detailsHandyModellTf = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        detailsHandyMarkeTf = new javax.swing.JTextField();
        commentPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        commentIdTf = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        commentVornameTf = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        commentCommentCB = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentCommentTA = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        commentDatumDP = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        commentNameTf = new javax.swing.JTextField();
        commentEditBtn = new javax.swing.JButton();
        commentAddBtn = new javax.swing.JButton();
        commentDeleteBtn = new javax.swing.JButton();
        commentSaveBtn = new javax.swing.JButton();
        commentCancelBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        optSuchenBtn = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        menuBackup = new javax.swing.JMenuItem();
        menuBeenden = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuAboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KuVer");
        setBackground(java.awt.Color.lightGray);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                beendenActionPerformed(evt);
            }
        });

        tabelle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Anrede", "Name", "Vorname", "Geburtsdatum", "Strasse", "PLZ", "Ort", "RufNr", "H-Marke", "H-Modell", "V-Art", "V-Nr", "IMEI", "MSISDN", "Netz", "Aktivierung", "Verlängerbar", "Kommentare", "Klasse"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelle.setColumnSelectionAllowed(true);
        tabelle.getTableHeader().setReorderingAllowed(false);
        tabelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showKunde(evt);
            }
        });
        tabellePanel.setViewportView(tabelle);
        tabelle.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelle.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabelle.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelle.getColumnModel().getColumn(15).setPreferredWidth(55);
        tabelle.getColumnModel().getColumn(18).setPreferredWidth(40);
        tabelle.getColumnModel().getColumn(19).setPreferredWidth(40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Neuen Kunden anlegen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        optNeuBtn.setText("Neu");
        optNeuBtn.setEnabled(false);
        optNeuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNeuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(optNeuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(optNeuBtn)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        tabPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanelStateChanged(evt);
            }
        });
        tabPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabPanelKeyPressed(evt);
            }
        });

        startPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                startPanelKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel21.setText("Willkommen!");

        jLabel29.setText("Melden Sie sich mit Ihrem KuVer-Konto an, um auf das System zuzugreifen.");

        jLabel30.setText("Nutzer");

        loginUserTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserTfActionPerformed(evt);
            }
        });

        jLabel31.setText("Passwort");

        loginPassPf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPassPfActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });

        registerBtn.setText("Registrieren");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 832, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(startPanelLayout.createSequentialGroup()
                            .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel31)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loginUserTf, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(loginPassPf)))))
                .addGap(36, 36, 36)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(startPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(registerBtn))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(loginUserTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(loginPassPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginBtn)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        tabPanel.addTab("Start", startPanel);

        jLabel1.setText("Name*");

        jLabel2.setText("Vorname*");

        jLabel3.setText("Anrede*");

        neuNameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuNameTfActionPerformed(evt);
            }
        });

        jLabel4.setText("Geburtsdatum");

        jLabel5.setText("Strasse/Nr");

        jLabel6.setText("PLZ/Ort");

        jLabel7.setText("/");

        neuPlzTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuPlzTfActionPerformed(evt);
            }
        });

        neuAnredeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Herr", "Frau" }));
        neuAnredeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuAnredeCBActionPerformed(evt);
            }
        });

        neuAddBtn.setText("Hinzufügen");
        neuAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuAddBtnActionPerformed(evt);
            }
        });

        neuStrNrTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                neuStrNrTfActionPerformed(evt);
            }
        });

        jLabel22.setText("/");

        jLabel32.setText("Rufnummer");

        jLabel33.setText("Vertragsnummer");

        jLabel34.setText("Vertragsart : Notiz");

        jLabel35.setText("IMEI");

        jLabel36.setText("MSISDN");

        jLabel37.setText("Aktivierungsdatum");

        neuVerlaengerbarDP.setDateFormatString("dd.MM.yyyy");
        neuVerlaengerbarDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                neuVerlaengerbarDPMouseClicked(evt);
            }
        });

        neuGebDP.setDateFormatString("dd.MM.yyyy");

        jLabel13.setText("Handymarke : Modell");

        jLabel43.setText("Verlängerbar ab");

        neuAktiviertDP.setDateFormatString("dd.MM.yyyy");
        neuAktiviertDP.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                neuAktiviertDPInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel48.setText("Klasse");

        neuVerArtCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "DSL", "EWP", "Haussteuerung", "Mobilfunk", "Prepaid", "Strom", "Sonstiges" }));

        jLabel52.setText(":");

        jLabel61.setText("Netz");

        jLabel62.setText(":");

        javax.swing.GroupLayout neuPanelLayout = new javax.swing.GroupLayout(neuPanel);
        neuPanel.setLayout(neuPanelLayout);
        neuPanelLayout.setHorizontalGroup(
            neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(neuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(neuPanelLayout.createSequentialGroup()
                        .addComponent(neuVerlaengerbarDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 708, Short.MAX_VALUE)
                        .addComponent(neuAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(neuPanelLayout.createSequentialGroup()
                        .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(neuGebDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(neuAktiviertDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(neuPanelLayout.createSequentialGroup()
                                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(neuMsisdnTf, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(neuImeiTf, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(neuRufNrTf, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, neuPanelLayout.createSequentialGroup()
                                            .addComponent(neuStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(neuStrNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(neuNameTf, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(neuVerNrTf, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(neuAnredeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(neuNetzTf, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(neuPanelLayout.createSequentialGroup()
                                            .addComponent(neuPlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(neuOrtTf))
                                        .addComponent(neuKlasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(neuVornameTf)
                                        .addGroup(neuPanelLayout.createSequentialGroup()
                                            .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(neuVerArtCB, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(neuHandyMarkeTf, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(4, 4, 4)
                                            .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(neuPanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel62)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(neuHandyModellTf))
                                                .addGroup(neuPanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel52)
                                                    .addGap(4, 4, 4)
                                                    .addComponent(neuVerArtTf, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 168, Short.MAX_VALUE)))
                .addContainerGap())
        );
        neuPanelLayout.setVerticalGroup(
            neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, neuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(neuAnredeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(neuKlasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(neuVornameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(neuNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(neuGebDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(neuStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuStrNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(neuPlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuOrtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(neuRufNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(neuHandyMarkeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(neuHandyModellTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(neuVerNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuVerArtCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuVerArtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neuImeiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel61)
                    .addComponent(neuNetzTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(neuMsisdnTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuAktiviertDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(neuVerlaengerbarDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, neuPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(neuAddBtn)
                .addContainerGap())
        );

        tabPanel.addTab("Neu", neuPanel);

        sucheSuchenBtn.setText("Suchen");
        sucheSuchenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheSuchenBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Name");

        jLabel9.setText("Vorname");

        jLabel10.setText("Geburtsdatum");

        jLabel11.setText("PLZ/Ort");

        jLabel23.setText("Strasse/Nr");

        jLabel24.setText("/");

        jLabel17.setText("ID");

        jLabel28.setText("/");

        sucheGebDP.setDateFormatString("dd.MM.yyyy");

        jLabel50.setText("Verlängerbar ab");

        sucheVerlaengerbarDP.setDateFormatString("dd.MM.yyyy");

        jLabel12.setText("Vertragsnummer");

        sucheResetBtn.setText("Reset");
        sucheResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheResetBtnActionPerformed(evt);
            }
        });

        jLabel63.setText("Rufnummer");

        jLabel64.setText("Vertragsart");

        sucheVerArtCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "DSL", "EWP", "Haussteuerung", "Mobilfunk", "Prepaid", "Strom", "Sonstiges" }));

        javax.swing.GroupLayout suchePanelLayout = new javax.swing.GroupLayout(suchePanel);
        suchePanel.setLayout(suchePanelLayout);
        suchePanelLayout.setHorizontalGroup(
            suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suchePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suchePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sucheResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sucheSuchenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(suchePanelLayout.createSequentialGroup()
                        .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel23)
                            .addComponent(jLabel17)
                            .addComponent(jLabel12)
                            .addComponent(jLabel50)
                            .addComponent(jLabel63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sucheIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sucheGebDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(suchePanelLayout.createSequentialGroup()
                                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sucheRufNrTf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(suchePanelLayout.createSequentialGroup()
                                        .addComponent(sucheStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sucheStrNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(sucheNameTf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sucheVerlaengerbarDP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sucheVerNrTf, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(60, 60, 60)
                                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel64))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(suchePanelLayout.createSequentialGroup()
                                        .addComponent(suchePlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sucheOrtTf))
                                    .addComponent(sucheVornameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sucheVerArtCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 259, Short.MAX_VALUE)))
                .addContainerGap())
        );
        suchePanelLayout.setVerticalGroup(
            suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suchePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(sucheIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sucheNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(sucheVornameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sucheGebDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sucheStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(sucheStrNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel11)
                    .addComponent(suchePlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(sucheOrtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(sucheRufNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sucheVerNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(sucheVerArtCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sucheVerlaengerbarDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(suchePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sucheSuchenBtn)
                    .addComponent(sucheResetBtn))
                .addContainerGap())
        );

        tabPanel.addTab("Suche", suchePanel);

        detailsSaveBtn.setText("Speichern");
        detailsSaveBtn.setEnabled(false);
        detailsSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsSaveBtnActionPerformed(evt);
            }
        });

        detailsEditBtn.setText("Bearbeiten");
        detailsEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsEditBtnActionPerformed(evt);
            }
        });

        detailsCancelBtn.setText("Abbruch");
        detailsCancelBtn.setEnabled(false);
        detailsCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCancelBtnActionPerformed(evt);
            }
        });

        detailsGebDP.setDateFormatString("dd.MM.yyyy");
        detailsGebDP.setEnabled(false);
        detailsGebDP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsVerlaengerbarDP.setDateFormatString("dd.MM.yyyy");
        detailsVerlaengerbarDP.setEnabled(false);
        detailsVerlaengerbarDP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel14.setText("Vorname*");

        detailsStrNrTf.setEditable(false);
        detailsStrNrTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsStrNrTfActionPerformed(evt);
            }
        });
        detailsStrNrTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel25.setText("/");

        jLabel15.setText("Name*");

        detailsNameTf.setEditable(false);
        detailsNameTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsNameTfActionPerformed(evt);
            }
        });
        detailsNameTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel16.setText("Anrede*");

        jLabel53.setText("Aktivierungsdatum");

        detailsCommentNrTf.setEditable(false);

        jLabel54.setText("IMEI");

        jLabel55.setText("MSISDN");

        detailsMsisdnTf.setEditable(false);
        detailsMsisdnTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsImeiTf.setEditable(false);
        detailsImeiTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel56.setText("Vertragsart : Notiz");

        detailsVerArtTf.setEditable(false);
        detailsVerArtTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel18.setText("Handymarke : Modell");

        jLabel57.setText("Vertragsnummer");

        detailsRufNrTf.setEditable(false);
        detailsRufNrTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel58.setText("Rufnummer");

        detailsVornameTf.setEditable(false);
        detailsVornameTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel19.setText("Geburtsdatum");

        jLabel20.setText("Strasse/Nr");

        jLabel26.setText("PLZ/Ort");

        detailsNetzTf.setEditable(false);
        detailsNetzTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel27.setText("/");

        detailsStrasseTf.setEditable(false);
        detailsStrasseTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsPlzTf.setEditable(false);
        detailsPlzTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsPlzTfActionPerformed(evt);
            }
        });
        detailsPlzTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsOrtTf.setEditable(false);
        detailsOrtTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsAnredeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Herr", "Frau" }));
        detailsAnredeCB.setEnabled(false);
        detailsAnredeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsAnredeCBActionPerformed(evt);
            }
        });

        jLabel38.setText("Klasse");

        detailsIdTf.setEditable(false);

        jLabel39.setText("Verlängerbar ab");

        detailsAktiviertDP.setDateFormatString("dd.MM.yyyy");
        detailsAktiviertDP.setEnabled(false);
        detailsAktiviertDP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsDeleteBtn.setText("Löschen");
        detailsDeleteBtn.setEnabled(false);
        detailsDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsDeleteBtnActionPerformed(evt);
            }
        });

        detailsCommentBtn.setText("Kommentare anzeigen");
        detailsCommentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsCommentBtnActionPerformed(evt);
            }
        });

        jLabel49.setText("Netz");

        detailsVerNrTf.setEditable(false);
        detailsVerNrTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        detailsKlasseTf.setEditable(false);
        detailsKlasseTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel45.setText("ID");

        detailsVerArtCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "DSL", "EWP", "Haussteuerung", "Mobilfunk", "Prepaid", "Strom", "Sonstiges" }));
        detailsVerArtCB.setEnabled(false);

        jLabel51.setText(":");

        jLabel59.setText(":");

        detailsHandyModellTf.setEditable(false);
        detailsHandyModellTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        jLabel60.setText("Kommenatranzahl");

        detailsHandyMarkeTf.setEditable(false);
        detailsHandyMarkeTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel58)
                    .addComponent(jLabel57)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(jLabel53)
                    .addComponent(jLabel39)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(detailsIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailsEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(detailsVerlaengerbarDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(detailsSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailsAktiviertDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(detailsPanelLayout.createSequentialGroup()
                                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(detailsMsisdnTf, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(detailsImeiTf, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(detailsRufNrTf, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detailsPanelLayout.createSequentialGroup()
                                                        .addComponent(detailsStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(detailsStrNrTf))
                                                    .addComponent(detailsNameTf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(detailsVerNrTf, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(60, 60, 60))
                                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                                .addComponent(detailsAnredeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(292, 292, 292)))
                                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel56)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel38)
                                            .addComponent(jLabel49)
                                            .addComponent(jLabel60)))
                                    .addComponent(detailsGebDP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(detailsVornameTf)
                                    .addGroup(detailsPanelLayout.createSequentialGroup()
                                        .addComponent(detailsPlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detailsOrtTf, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                                    .addComponent(detailsKlasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(detailsPanelLayout.createSequentialGroup()
                                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(detailsVerArtCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(detailsHandyMarkeTf))
                                        .addGap(4, 4, 4)
                                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel51)
                                                .addGap(4, 4, 4)
                                                .addComponent(detailsVerArtTf))
                                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel59)
                                                .addGap(4, 4, 4)
                                                .addComponent(detailsHandyModellTf))))
                                    .addGroup(detailsPanelLayout.createSequentialGroup()
                                        .addComponent(detailsCommentNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detailsCommentBtn))
                                    .addComponent(detailsNetzTf))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailsCancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailsDeleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(detailsIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsEditBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(detailsAnredeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(detailsKlasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsDeleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(detailsVornameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(detailsNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(detailsGebDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(detailsStrasseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsStrNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(detailsPlzTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsOrtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(detailsRufNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel59)
                    .addComponent(detailsHandyModellTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsHandyMarkeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jLabel56)
                    .addComponent(detailsVerArtCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsVerNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsVerArtTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(detailsPanelLayout.createSequentialGroup()
                                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(detailsImeiTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel49)
                                    .addComponent(detailsNetzTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(detailsMsisdnTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel60)
                                    .addComponent(detailsCommentNrTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(detailsCommentBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(detailsAktiviertDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailsVerlaengerbarDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(detailsCancelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detailsSaveBtn)
                .addContainerGap())
        );

        tabPanel.addTab("Details", detailsPanel);

        jLabel40.setText("ID");

        commentIdTf.setEditable(false);

        jLabel41.setText("Vorname");

        commentVornameTf.setEditable(false);

        jLabel42.setText("Kommentar auswählen");

        commentCommentCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                commentCommentSelected(evt);
            }
        });

        jLabel44.setText("Kommentar*");

        commentCommentTA.setEditable(false);
        commentCommentTA.setColumns(20);
        commentCommentTA.setRows(5);
        commentCommentTA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                focusGainedSelectAll(evt);
            }
        });
        jScrollPane1.setViewportView(commentCommentTA);

        jLabel46.setText("Datum*");

        commentDatumDP.setDateFormatString("dd.MM.yyyy");
        commentDatumDP.setEnabled(false);

        jLabel47.setText("Name");

        commentNameTf.setEditable(false);

        commentEditBtn.setText("Bearbeiten");
        commentEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentEditBtnActionPerformed(evt);
            }
        });

        commentAddBtn.setText("Hinzufügen");
        commentAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentAddBtnActionPerformed(evt);
            }
        });

        commentDeleteBtn.setText("Löschen");
        commentDeleteBtn.setEnabled(false);
        commentDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentDeleteBtnActionPerformed(evt);
            }
        });

        commentSaveBtn.setText("Speichern");
        commentSaveBtn.setEnabled(false);
        commentSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentSaveBtnActionPerformed(evt);
            }
        });

        commentCancelBtn.setText("Abbruch");
        commentCancelBtn.setEnabled(false);
        commentCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentCancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(commentPanel);
        commentPanel.setLayout(commentPanelLayout);
        commentPanelLayout.setHorizontalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commentPanelLayout.createSequentialGroup()
                        .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addGap(34, 34, 34)
                        .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(commentPanelLayout.createSequentialGroup()
                                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(commentNameTf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(commentVornameTf, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(commentAddBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(commentDeleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(commentPanelLayout.createSequentialGroup()
                                .addComponent(commentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245)
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(commentCommentCB, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(commentEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(commentPanelLayout.createSequentialGroup()
                        .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(commentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(commentCancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(commentSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                            .addGroup(commentPanelLayout.createSequentialGroup()
                                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(commentDatumDP, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        commentPanelLayout.setVerticalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(commentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(commentCommentCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentEditBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(commentNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentAddBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(commentVornameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentDeleteBtn))
                .addGap(40, 40, 40)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commentPanelLayout.createSequentialGroup()
                        .addComponent(commentDatumDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(commentCancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commentSaveBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabPanel.addTab("Kommentare", commentPanel);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kunden suchen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        optSuchenBtn.setText("Suchen");
        optSuchenBtn.setEnabled(false);
        optSuchenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSuchenBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(optSuchenBtn)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(optSuchenBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar2.setBackground(new java.awt.Color(149, 147, 137));

        jMenu3.setText("Optionen");

        menuBackup.setText("Datensicherung");
        menuBackup.setEnabled(false);
        menuBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBackupActionPerformed(evt);
            }
        });
        jMenu3.add(menuBackup);

        menuBeenden.setText("Beenden");
        menuBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBeendenActionPerformed(evt);
            }
        });
        jMenu3.add(menuBeenden);

        jMenuBar2.add(jMenu3);

        jMenu1.setText("?");

        menuAboutItem.setText("About KuVer");
        menuAboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutItemActionPerformed(evt);
            }
        });
        jMenu1.add(menuAboutItem);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabellePanel)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(tabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabellePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void neuNameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuNameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neuNameTfActionPerformed

    private void neuPlzTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuPlzTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neuPlzTfActionPerformed

    private void neuAnredeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuAnredeCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neuAnredeCBActionPerformed

    private void optSuchenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSuchenBtnActionPerformed
        tabPanel.setEnabledAt(2, true);
        tabPanel.setSelectedIndex(2);
        // Test: generiere Kunden in Tabelle
//        controller.test(tabelle);
    }//GEN-LAST:event_optSuchenBtnActionPerformed

    private void neuAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuAddBtnActionPerformed
        // Check input
        String error = checkInput();
        if (error != null) {
            JOptionPane.showMessageDialog(tabPanel,
                    "Fehler bei der Eingabe: " + error,
                    "Falsche Eingabe",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Msg
        final JOptionPane optionPane = new JOptionPane(
                "Wollen Sie den Kunden wirklich hinzufügen?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);

        final JDialog dialog = new JDialog(this,
                "Kunden hinzufügen",
                true);
        dialog.setContentPane(optionPane);
        //        dialog.setDefaultCloseOperation(
        //                JDialog.DO_NOTHING_ON_CLOSE);
        //        dialog.addWindowListener(new WindowAdapter() {
        //            public void windowClosing(WindowEvent we) {
        //                setLabel("Thwarted user attempt to close window.");
        //            }
        //        });
        optionPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                                && (e.getSource() == optionPane)
                                && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            //If you were going to check something
                            //before closing the window, you'd do
                            //it here.
                            dialog.setVisible(false);
                        }
                    }
                });
        dialog.pack();
        dialog.setLocationRelativeTo(detailsPanel);
        dialog.setVisible(true);

        int value = ((Integer) optionPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) { // Save
            // Add
            if (controller.addKunde(tabelle, getNeuKunde())) {
                JOptionPane.showMessageDialog(tabPanel,
                        "Der Kunde wurde erfolgreich hinzugefügt!",
                        "Kunde hinzugefügt",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(tabPanel,
                        "Fehler beim Hinzufügen des Kunden " + error,
                        "Kunde hinzufügen fehlgeschlagen",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else {
            return;
        }
    }//GEN-LAST:event_neuAddBtnActionPerformed

    private void optNeuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNeuBtnActionPerformed
        tabPanel.setEnabledAt(1, true);
        tabPanel.setSelectedIndex(1);
//        if(tab.getTabCount()>2)
//        tab.remove(neuPanel);
//        else
//        tab.addTab("Neu", neuPanel);

        // Set Aktivierierungdat
        Calendar cal = Calendar.getInstance();
        neuAktiviertDP.setCalendar(cal);
        Calendar calVerl = Calendar.getInstance();
        calVerl.add(Calendar.MONTH, 16);
        neuVerlaengerbarDP.setCalendar(calVerl);

    }//GEN-LAST:event_optNeuBtnActionPerformed

    private void showKunde(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showKunde
        // Check if EditMode
        if (controller.isEditMode()) {
            return;
        }

        if (tabelle.getModel().getValueAt(tabelle.rowAtPoint(evt.getPoint()), 0) == null) {
            return;
        }
        if (tabelle.getModel().getValueAt(tabelle.rowAtPoint(evt.getPoint()), 0).toString().equals("xxx")) {
            return;
        }

        tabPanel.setEnabledAt(3, true);
        // Switch to details tab
        if (tabPanel.getSelectedIndex() != 3) {
            tabPanel.setSelectedIndex(3);
        }

        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        String akti = null;
        String verl = null;
        String bday = null;
        // Get clicked Kunde
        int row = tabelle.rowAtPoint(evt.getPoint());
        int col = tabelle.columnAtPoint(evt.getPoint());
        Kunde kunde = new Kunde();
        kunde.setId((Integer) tabelle.getModel().getValueAt(row, 0));
        kunde.setAnrede((String) tabelle.getModel().getValueAt(row, 1));
        kunde.setName((String) tabelle.getModel().getValueAt(row, 2));
        kunde.setVorname((String) tabelle.getModel().getValueAt(row, 3));
        // Bday
        Calendar cal = null;
        bday = (String) tabelle.getModel().getValueAt(row, 4);
        if (!bday.isEmpty()) {
            try {
                cal = Calendar.getInstance();
                cal.setTime(f.parse((String) tabelle.getModel().getValueAt(row, 4)));
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        kunde.setGebDat(cal);
        kunde.setStrasse((String) tabelle.getModel().getValueAt(row, 5));
//        kunde.setStrNr((String) tabelle.getModel().getValueAt(row, 6));
        kunde.setPlz((String) tabelle.getModel().getValueAt(row, 6));
        kunde.setOrt((String) tabelle.getModel().getValueAt(row, 7));
        kunde.setRufNr((String) tabelle.getModel().getValueAt(row, 8));
        kunde.setHandyMarke((String) tabelle.getModel().getValueAt(row, 9));
        kunde.setHandyModell((String) tabelle.getModel().getValueAt(row, 10));

        kunde.setVertragsArt((String) tabelle.getModel().getValueAt(row, 11));
        kunde.setVertragsNr((String) tabelle.getModel().getValueAt(row, 12));
        kunde.setImei((String) tabelle.getModel().getValueAt(row, 13));
        kunde.setMsisdn((String) tabelle.getModel().getValueAt(row, 14));
        kunde.setNetz((String) tabelle.getModel().getValueAt(row, 15));
        // Aktivierung
        Calendar calAkt = null;
        akti = (String) tabelle.getModel().getValueAt(row, 16);
        if (!akti.isEmpty()) {
            try {
                calAkt = Calendar.getInstance();
                calAkt.setTime(f.parse((String) tabelle.getModel().getValueAt(row, 16)));
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        kunde.setAktivierung(calAkt);
        // Verlaengerung
        Calendar calVerl = null;
        verl = (String) tabelle.getModel().getValueAt(row, 17);
        if (!verl.isEmpty()) {
            try {
                calVerl = Calendar.getInstance();
                calVerl.setTime(f.parse((String) tabelle.getModel().getValueAt(row, 17)));
            } catch (ParseException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        kunde.setVerlaengerung(calVerl);
        // Kommentaranzahl
        kunde.setKommentare((Integer) tabelle.getModel().getValueAt(row, 18));
        kunde.setKlasse((String) tabelle.getModel().getValueAt(row, 19));

        controller.setCurKunde(kunde);

        // Details
        fillDetails(kunde);
    }//GEN-LAST:event_showKunde

    private void menuBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBeendenActionPerformed
        beendenActionPerformed(null);
    }//GEN-LAST:event_menuBeendenActionPerformed

    private void beendenActionPerformed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_beendenActionPerformed
        // TODO add your handling code here:

        if (!controller.isEditMode()) {
            System.exit(0);
        }

        JOptionPane.showMessageDialog(tabPanel,
                "Sie haben noch ungespeicherte Daten.\nSpeichern oder Verwerfen Sie diese zuerst.",
                "Achtung! Geänderte Daten!",
                JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_beendenActionPerformed

    private void neuStrNrTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_neuStrNrTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_neuStrNrTfActionPerformed

    private void loginPassPfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPassPfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPassPfActionPerformed

    private void loginUserTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserTfActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // Check login input
//        if (loginUserTf.getText().length() < 3) {
//            JOptionPane.showMessageDialog(tabPanel,
//                    "Fehler: Nutzer muss aus mehr als 2 Buchstaben bestehen!",
//                    "Ungueltiger Nutzer",
//                    JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if (loginPassPf.getPassword().length < 7) {
//            JOptionPane.showMessageDialog(tabPanel,
//                    "Fehler: Passwort muss aus mehr als 6 Buchstaben bestehen!",
//                    "Ungueltiges Passwort",
//                    JOptionPane.WARNING_MESSAGE);
//            return;
//        }
        User user = new User(loginUserTf.getText(), String.valueOf(loginPassPf.getPassword()));

        System.out.println("user: " + user.getName() + " " + user.getPass());
        // Lookup in db
        if (controller.login(user)) {
            userVerified();
        } else {
            JOptionPane.showMessageDialog(tabPanel,
                    "Ihre Anmeldung schlug fehl. Bitte ueberpruefen Sie Ihre Eingabe.\nWenn Sie noch kein KuVer-Konto besitzen, registrieren Sie sich bitte.",
                    "Login fehlgeschlagen",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_loginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        Register register = new Register(controller, this, true);
        register.pack();
        register.setLocationRelativeTo(detailsPanel);
        register.setVisible(true);
    }//GEN-LAST:event_registerBtnActionPerformed

    private void sucheSuchenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheSuchenBtnActionPerformed
        // suchen
        controller.sucheKunde(tabelle, getSucheKunde());
    }//GEN-LAST:event_sucheSuchenBtnActionPerformed

    private void detailsEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsEditBtnActionPerformed
        // Enable EditMode
        enableEditMode();

        // set Focus
        tabPanel.setEnabledAt(0, false);
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        tabPanel.setEnabledAt(3, true);
        tabPanel.setEnabledAt(4, false);
        optNeuBtn.setEnabled(false);
        optSuchenBtn.setEnabled(false);


    }//GEN-LAST:event_detailsEditBtnActionPerformed

    private void detailsSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsSaveBtnActionPerformed
        detailsSave();
    }//GEN-LAST:event_detailsSaveBtnActionPerformed

    private void detailsCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCancelBtnActionPerformed
        // Reset changes
        detailsReset();
        // cancel
        disableEditMode();
    }//GEN-LAST:event_detailsCancelBtnActionPerformed

    private void detailsStrNrTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsStrNrTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsStrNrTfActionPerformed

    private void detailsNameTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsNameTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsNameTfActionPerformed

    private void detailsPlzTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsPlzTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsPlzTfActionPerformed

    private void detailsAnredeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsAnredeCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailsAnredeCBActionPerformed

    private void detailsDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsDeleteBtnActionPerformed
        // Delete
        detailsDelete();
    }//GEN-LAST:event_detailsDeleteBtnActionPerformed

    private void detailsCommentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsCommentBtnActionPerformed
        if (controller.getCurKunde() == null) {
            return;
        }

        // Show Cmnts
        tabPanel.setEnabledAt(4, true);
        tabPanel.setSelectedIndex(4);

        // Fill cmnts
        Kunde curKunde = controller.getCurKunde();
        fillComments(curKunde, controller.getComments(curKunde.getId()));
    }//GEN-LAST:event_detailsCommentBtnActionPerformed

    private void commentCommentSelected(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_commentCommentSelected
        System.out.println("ccSelected");

        System.out.println("DEBUG: curComm " + controller.getCurComments());
        System.out.println("DEBUG: commentCommentCB selectedIndex" + commentCommentCB.getSelectedIndex());
        System.out.println("DEBUG: commentCommentCB itemcount " + commentCommentCB.getItemCount());


        // fill Comments
        if (controller.getCurComments() == null || commentCommentCB.getSelectedIndex() == -1) {
            System.out.println("DEBUG: null");
            // set blank
            commentDatumDP.setCalendar(null);
            commentCommentTA.setText("");
            return;
        }
        if (commentCommentCB.getItemCount() != 0 && !commentCommentCB.getItemAt(0).equals("<Neuer Kommentar>")) {
            System.out.println("DEBUG: not null index : " + commentCommentCB.getSelectedIndex());
            Comment cmt = controller.getCurComments().get(commentCommentCB.getSelectedIndex());
            commentCommentTA.setText(cmt.getComment());
            commentDatumDP.setCalendar(cmt.getDate());

            controller.setCurComment(cmt, commentCommentCB.getSelectedIndex());
        }
    }//GEN-LAST:event_commentCommentSelected

    private void neuAktiviertDPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_neuAktiviertDPInputMethodTextChanged
        // TODO add your handling code here:
        System.out.println("IC");
        // Focus lost
        Calendar akt = neuAktiviertDP.getCalendar();

        // Berechne
        akt.add(Calendar.MONTH, 16);

        neuVerlaengerbarDP.setCalendar(akt);
        System.out.println("akt:" + akt);
    }//GEN-LAST:event_neuAktiviertDPInputMethodTextChanged

    private void neuVerlaengerbarDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_neuVerlaengerbarDPMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        System.out.println("MC");
        // Focus lost
        Calendar akt = neuAktiviertDP.getCalendar();

        // Berechne
        akt.add(Calendar.MONTH, 16);

        neuVerlaengerbarDP.setCalendar(akt);
        System.out.println("akt:" + akt);
    }//GEN-LAST:event_neuVerlaengerbarDPMouseClicked

    private void commentEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentEditBtnActionPerformed
        enableCommentEditMode();
    }//GEN-LAST:event_commentEditBtnActionPerformed

    private void commentAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentAddBtnActionPerformed
        addComment();
    }//GEN-LAST:event_commentAddBtnActionPerformed

    private void commentDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentDeleteBtnActionPerformed
        deleteComment();
    }//GEN-LAST:event_commentDeleteBtnActionPerformed

    private void commentCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentCancelBtnActionPerformed
        cancelComment();
    }//GEN-LAST:event_commentCancelBtnActionPerformed

    private void commentSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentSaveBtnActionPerformed
        saveComment();
    }//GEN-LAST:event_commentSaveBtnActionPerformed

    private void tabPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanelStateChanged
        System.out.println("Tabpanel state changed");
        System.out.println("curKUnde: " + controller.getCurKunde());
        if (controller.getCurKunde() != null) //            System.out.println("comments: "+controller.getComments(controller.getCurKunde().getId()));
        {
            if (controller.getComments(controller.getCurKunde().getId()) != null) {
                System.out.println("comments Size: " + (controller.getComments(controller.getCurKunde().getId()).size()));
            }
        }

        // if comments selected, fillComents with selected user
        if (tabPanel.getSelectedIndex() == 4) {
            if (controller.getCurKunde() == null) {
                System.out.println("null user--------------------------");
                fillComments(null, null);
                return;
            }

            // refill
            Kunde curKunde = controller.getCurKunde();
            fillComments(curKunde, controller.getComments(curKunde.getId()));
        }
    }//GEN-LAST:event_tabPanelStateChanged

    private void sucheResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheResetBtnActionPerformed
        // reset formular
        resetSuche();

        // switch focus
        sucheIdTf.requestFocus();
    }//GEN-LAST:event_sucheResetBtnActionPerformed

    private void menuAboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutItemActionPerformed
        // show about
        About about = new About(this, false);
        about.pack();
        about.setLocationRelativeTo(detailsPanel);
        about.setVisible(true);
    }//GEN-LAST:event_menuAboutItemActionPerformed

    private void focusGainedSelectAll(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_focusGainedSelectAll
        // TODO add your handling code here:
        if (evt.getComponent() instanceof JTextField) {
            JTextField comp = (JTextField) evt.getComponent();
            comp.selectAll();
        }
    }//GEN-LAST:event_focusGainedSelectAll

    private void tabPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabPanelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPanelKeyPressed

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
//        // Enter
//        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
//            loginBtnActionPerformed(null);
//        }
    }//GEN-LAST:event_loginBtnKeyPressed

    private void startPanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startPanelKeyReleased
        // Enter
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            loginBtnActionPerformed(null);
        }
    }//GEN-LAST:event_startPanelKeyReleased

    private void menuBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBackupActionPerformed
        // TODO add your handling code here:
        Backup backup = new Backup(this.controller, this, true);
        backup.pack();
        backup.setLocationRelativeTo(detailsPanel);
        backup.setVisible(true);
    }//GEN-LAST:event_menuBackupActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View(new Controller()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton commentAddBtn;
    private javax.swing.JButton commentCancelBtn;
    private javax.swing.JComboBox commentCommentCB;
    private javax.swing.JTextArea commentCommentTA;
    private com.toedter.calendar.JDateChooser commentDatumDP;
    private javax.swing.JButton commentDeleteBtn;
    private javax.swing.JButton commentEditBtn;
    private javax.swing.JTextField commentIdTf;
    private javax.swing.JTextField commentNameTf;
    private javax.swing.JPanel commentPanel;
    private javax.swing.JButton commentSaveBtn;
    private javax.swing.JTextField commentVornameTf;
    private com.toedter.calendar.JDateChooser detailsAktiviertDP;
    private javax.swing.JComboBox detailsAnredeCB;
    private javax.swing.JButton detailsCancelBtn;
    private javax.swing.JButton detailsCommentBtn;
    private javax.swing.JTextField detailsCommentNrTf;
    private javax.swing.JButton detailsDeleteBtn;
    private javax.swing.JButton detailsEditBtn;
    private com.toedter.calendar.JDateChooser detailsGebDP;
    private javax.swing.JTextField detailsHandyMarkeTf;
    private javax.swing.JTextField detailsHandyModellTf;
    private javax.swing.JTextField detailsIdTf;
    private javax.swing.JTextField detailsImeiTf;
    private javax.swing.JTextField detailsKlasseTf;
    private javax.swing.JTextField detailsMsisdnTf;
    private javax.swing.JTextField detailsNameTf;
    private javax.swing.JTextField detailsNetzTf;
    private javax.swing.JTextField detailsOrtTf;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JTextField detailsPlzTf;
    private javax.swing.JTextField detailsRufNrTf;
    private javax.swing.JButton detailsSaveBtn;
    private javax.swing.JTextField detailsStrNrTf;
    private javax.swing.JTextField detailsStrasseTf;
    private javax.swing.JComboBox detailsVerArtCB;
    private javax.swing.JTextField detailsVerArtTf;
    private javax.swing.JTextField detailsVerNrTf;
    private com.toedter.calendar.JDateChooser detailsVerlaengerbarDP;
    private javax.swing.JTextField detailsVornameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField loginPassPf;
    private javax.swing.JTextField loginUserTf;
    private javax.swing.JMenuItem menuAboutItem;
    private javax.swing.JMenuItem menuBackup;
    private javax.swing.JMenuItem menuBeenden;
    private javax.swing.JButton neuAddBtn;
    private com.toedter.calendar.JDateChooser neuAktiviertDP;
    private javax.swing.JComboBox neuAnredeCB;
    private com.toedter.calendar.JDateChooser neuGebDP;
    private javax.swing.JTextField neuHandyMarkeTf;
    private javax.swing.JTextField neuHandyModellTf;
    private javax.swing.JTextField neuImeiTf;
    private javax.swing.JTextField neuKlasseTf;
    private javax.swing.JTextField neuMsisdnTf;
    private javax.swing.JTextField neuNameTf;
    private javax.swing.JTextField neuNetzTf;
    private javax.swing.JTextField neuOrtTf;
    private javax.swing.JPanel neuPanel;
    private javax.swing.JTextField neuPlzTf;
    private javax.swing.JTextField neuRufNrTf;
    private javax.swing.JTextField neuStrNrTf;
    private javax.swing.JTextField neuStrasseTf;
    private javax.swing.JComboBox neuVerArtCB;
    private javax.swing.JTextField neuVerArtTf;
    private javax.swing.JTextField neuVerNrTf;
    private com.toedter.calendar.JDateChooser neuVerlaengerbarDP;
    private javax.swing.JTextField neuVornameTf;
    private javax.swing.JButton optNeuBtn;
    private javax.swing.JButton optSuchenBtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel startPanel;
    private com.toedter.calendar.JDateChooser sucheGebDP;
    private javax.swing.JTextField sucheIdTf;
    private javax.swing.JTextField sucheNameTf;
    private javax.swing.JTextField sucheOrtTf;
    private javax.swing.JPanel suchePanel;
    private javax.swing.JTextField suchePlzTf;
    private javax.swing.JButton sucheResetBtn;
    private javax.swing.JTextField sucheRufNrTf;
    private javax.swing.JTextField sucheStrNrTf;
    private javax.swing.JTextField sucheStrasseTf;
    private javax.swing.JButton sucheSuchenBtn;
    private javax.swing.JComboBox sucheVerArtCB;
    private javax.swing.JTextField sucheVerNrTf;
    private com.toedter.calendar.JDateChooser sucheVerlaengerbarDP;
    private javax.swing.JTextField sucheVornameTf;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable tabelle;
    private javax.swing.JScrollPane tabellePanel;
    // End of variables declaration//GEN-END:variables

    private void fillDetails(Kunde kunde) {
        if (kunde == null) {
            detailsIdTf.setText(""); // todo
            detailsKlasseTf.setText(""); //here--
            detailsAnredeCB.setSelectedItem("");
            detailsNameTf.setText("");
            detailsVornameTf.setText("");
            detailsGebDP.setCalendar(null);
            detailsStrasseTf.setText("");
            detailsStrNrTf.setText("");
            detailsPlzTf.setText("");
            detailsOrtTf.setText("");
            detailsRufNrTf.setText("");
            detailsHandyMarkeTf.setText("");
            detailsHandyModellTf.setText("");
            detailsNetzTf.setText("");
            detailsVerArtTf.setText("");
            detailsVerArtCB.setSelectedItem("");
            detailsVerNrTf.setText("");
            detailsImeiTf.setText("");
            detailsMsisdnTf.setText("");
            detailsAktiviertDP.setCalendar(null);
            detailsVerlaengerbarDP.setCalendar(null);
            detailsCommentNrTf.setText("");
            // set all null
            controller.setCurKunde(null);
            controller.setCurComment(null, 0);
            controller.setCurComments(null);
            return;
        }
        detailsIdTf.setText("" + kunde.getId()); // todo
        detailsKlasseTf.setText("" + kunde.getKlasse()); //here--
        detailsAnredeCB.setSelectedItem(kunde.getAnrede());
        detailsNameTf.setText(kunde.getName());
        detailsVornameTf.setText(kunde.getVorname());
        // Bday
        detailsGebDP.setCalendar(kunde.getGebDat());
        // Strasse
        detailsStrasseTf.setText(kunde.getStrasseOhneNr());
        detailsStrNrTf.setText(kunde.getStrNr());
        detailsPlzTf.setText(kunde.getPlz());
        detailsOrtTf.setText(kunde.getOrt());
        detailsRufNrTf.setText(kunde.getRufNr());
        detailsHandyMarkeTf.setText(kunde.getHandyMarke());
        detailsHandyModellTf.setText(kunde.getHandyModell());
        detailsNetzTf.setText(kunde.getNetz());
        // parse vArt
        detailsVerArtCB.setSelectedItem(kunde.getVertragsArtCB());
        detailsVerArtTf.setText(kunde.getVertragsArtTf());
        detailsVerNrTf.setText(kunde.getVertragsNr());
        detailsImeiTf.setText(kunde.getImei());
        detailsMsisdnTf.setText(kunde.getMsisdn());
        detailsAktiviertDP.setCalendar(kunde.getAktivierung());
        detailsVerlaengerbarDP.setCalendar(kunde.getVerlaengerung());
        detailsCommentNrTf.setText("" + kunde.getKommentare());
    }

    /**
     * Check input
     *
     * @return
     */
    private String checkInput() {
        String error = null;
        // Anrede
        if (neuAnredeCB.getSelectedIndex() == 0) {
            error = "'Anrede' ist leer! ";
            return error;
        }
        System.out.println("anrede: " + neuAnredeCB.getSelectedItem().toString());
//        // Klasse
//        if (neuKlasseTf.getText().isEmpty()) {
//            error = "'Klasse' ist leer! ";
//            return error;
//        }
        // Name
        if (neuNameTf.getText().isEmpty()) {
            error = "'Name' ist leer! ";
            return error;
        }
        System.out.println("name: " + neuNameTf.getText());
        if (!(neuNameTf.getText()).matches("[a-zA-Z-]+")) {
            error = "'Name' darf keine Sonderzeichen oder Zahlen enthalten! ";
            return error;
        }
        // Vorname
        if (neuVornameTf.getText().isEmpty()) {
            error = "'Vorname' ist leer! ";
            return error;
        }
        System.out.println("vorname: " + neuVornameTf.getText());
        if (!(neuVornameTf.getText()).matches("[a-zA-Z-]+")) {
            error = "'Vorname' darf keine Sonderzeichen oder Zahlen enthalten! ";
            return error;
        }
//        // GebDat
//        if (neuGebDP.getCalendar() == null) {
//            error = "'Geburtstagsdatum' ist leer! ";
//            return error;
//        }
        // Strasse + StrNr
        if (!neuStrasseTf.getText().isEmpty() && neuStrNrTf.getText().isEmpty()) {
            error = "Bitte geben Sie die Nummer der Strasse ein!";
            return error;
        }
        if (neuStrasseTf.getText().isEmpty() && !neuStrNrTf.getText().isEmpty()) {
            error = "'Strasse' ist leer!";
            return error;
        }
//        // StrasseNr
//        if (neuStrNrTf.getText().isEmpty()) {
//            error = "'Strassen Nummer' ist leer! ";
//            return error;
//        }
//        // PLZ
//        if (neuPlzTf.getText().isEmpty()) {
//            error = "'PLZ' ist leer! ";
//            return error;
//        }
//        // Ort
//        if (neuOrtTf.getText().isEmpty()) {
//            error = "'Ort' ist leer! ";
//            return error;
//        }
        // Handy
//        if (neuHandyTf.getText().isEmpty()) {
//            error = "'Handy' ist leer! ";
//            return error;
//        }
//        // Netz
//        if (neuNetzTf.getText().isEmpty()) {
//            error = "'Netz' ist leer! ";
//            return error;
//        }
        // Vertragsart
        if (neuVerArtCB.getSelectedIndex() == 0 && !neuVerArtTf.getText().isEmpty()) {
            error = "'Vertragsart' ist leer! ";
            return error;
        }
//        // VertragsNr
//        if (neuVerNrTf.getText().isEmpty()) {
//            error = "'Vertragsnummer' ist leer! ";
//            return error;
//        }
//        // Imei
//        if (neuImeiTf.getText().isEmpty()) {
//            error = "'IMEI' ist leer! ";
//            return error;
//        }
//        // MSISDN
//        if (neuMsisdnTf.getText().isEmpty()) {
//            error = "'MSISDN' ist leer! ";
//            return error;
//        }
//        // Aktiv
//        if (neuAktiviertDP.getCalendar() == null) {
//            error = "'Aktivierungsdatum' ist leer! ";
//            return error;
//        }
//        // Verl
//        if (neuVerlaengerbarDP.getCalendar() == null) {
//            error = "'Verlängerungsdatum' ist leer! ";
//            return error;
//        }
//        System.out.println("Strasse: " + neuStrasseTf.getText());
//        if (!(neuStrasseTf.getText()).matches("^[A-Za-z-]*[a-z]+$")) {
//            error = "'Strasse' darf keine Zahlen oder Sonderzeichen enthalten! Bindestriche koennen nur innerhalb eines Wortes auftauchen.";
//            return error;
//        }
        return error;
    }

    /**
     * Get 'Neuer' Kunde
     *
     * @return Kunde
     *
     */
    private Kunde getNeuKunde() {
        Kunde kunde = new kuver.definitions.Kunde();
        kunde.setKlasse(neuKlasseTf.getText());//here--
        kunde.setAnrede(neuAnredeCB.getSelectedItem().toString());
        kunde.setName(neuNameTf.getText());
        kunde.setVorname(neuVornameTf.getText());
        kunde.setGebDat(neuGebDP.getCalendar());
        // Strasse
        String str = neuStrasseTf.getText();
        if (!str.isEmpty()) {
            str = neuStrasseTf.getText() + "." + neuStrNrTf.getText();
        }
        kunde.setStrasse(str);
        kunde.setPlz(neuPlzTf.getText());
        kunde.setOrt(neuOrtTf.getText());
        // Handy
//        kunde.setHandy(extractHandy());
        kunde.setHandyMarke(neuHandyMarkeTf.getText());
        kunde.setHandyModell(neuHandyModellTf.getText());
        kunde.setRufNr(neuRufNrTf.getText());
        // Vertragsart
        String ver = null;
        int verIndex = neuVerArtCB.getSelectedIndex();
        if (verIndex != 0) {
            ver = neuVerArtCB.getSelectedItem().toString();
            if (!neuVerArtTf.getText().isEmpty()) {
                ver += " : " + neuVerArtTf.getText();
            }
        }
        kunde.setVertragsArt(ver);
        kunde.setVertragsNr(neuVerNrTf.getText());
        kunde.setImei(neuImeiTf.getText());
        kunde.setMsisdn(neuMsisdnTf.getText());
        kunde.setNetz(neuNetzTf.getText());
        kunde.setAktivierung(neuAktiviertDP.getCalendar());
        kunde.setVerlaengerung(neuVerlaengerbarDP.getCalendar());
//        System.out.println("CAL: "+kunde.getVerlaengerung());
        return kunde;
    }

    private Kunde getDetailsKunde() {
        Kunde kunde = new kuver.definitions.Kunde();
        kunde.setAnrede(detailsAnredeCB.getSelectedItem().toString());
        kunde.setId(Integer.parseInt(detailsIdTf.getText()));
        kunde.setKlasse(detailsKlasseTf.getText());
        kunde.setName(detailsNameTf.getText());
        kunde.setVorname(detailsVornameTf.getText());
        kunde.setGebDat(detailsGebDP.getCalendar());
        String str = detailsStrasseTf.getText();
        if (!str.isEmpty()) {
            str = detailsStrasseTf.getText() + "." + detailsStrNrTf.getText();
        }
        kunde.setStrasse(str);
        kunde.setPlz(detailsPlzTf.getText());
        kunde.setOrt(detailsOrtTf.getText());
        kunde.setRufNr(detailsRufNrTf.getText());
        kunde.setHandyMarke(detailsHandyMarkeTf.getText());
        kunde.setHandyModell(detailsHandyModellTf.getText());
        kunde.setNetz(detailsNetzTf.getText());
        // verArt
        String verArt = null;
        if (detailsVerArtCB.getSelectedItem() != null) {
            verArt = detailsVerArtCB.getSelectedItem().toString();
            if (!detailsVerArtTf.getText().isEmpty()) {
                verArt += " : " + detailsVerArtTf.getText();
            }
        }
        kunde.setVertragsArt(verArt);
        kunde.setVertragsNr(detailsVerNrTf.getText());
        kunde.setImei(detailsImeiTf.getText());
        kunde.setMsisdn(detailsMsisdnTf.getText());
        kunde.setAktivierung(detailsAktiviertDP.getCalendar());
        kunde.setVerlaengerung(detailsVerlaengerbarDP.getCalendar());
        kunde.setKommentare(Integer.parseInt(detailsCommentNrTf.getText()));

        return kunde;
    }

    private Kunde getSucheKunde() {
        Kunde kunde = new kuver.definitions.Kunde();
        if (!sucheIdTf.getText().isEmpty()) {
            kunde.setId(Integer.parseInt(sucheIdTf.getText()));
        }
        kunde.setName(sucheNameTf.getText());
        kunde.setVorname(sucheVornameTf.getText());
        kunde.setStrasse(sucheStrasseTf.getText());
        // Bday
        kunde.setGebDat(sucheGebDP.getCalendar());
        kunde.setPlz(suchePlzTf.getText());
        kunde.setOrt(sucheOrtTf.getText());
        kunde.setVertragsNr(sucheVerNrTf.getText());
        if (sucheVerArtCB.getSelectedItem() != null) {
            kunde.setVertragsArt(sucheVerArtCB.getSelectedItem().toString());
        }

        kunde.setRufNr(sucheRufNrTf.getText());
        // Verl
        kunde.setVerlaengerung(sucheVerlaengerbarDP.getCalendar());

        return kunde;
    }

    private void detailsReset() {
        fillDetails(controller.getCurKunde());
    }

    private void disableEditMode() {
        controller.setEditMode(false);
        detailsPanel.setBackground(suchePanel.getBackground());
        detailsEditBtn.setEnabled(true);
        detailsSaveBtn.setEnabled(false);
        detailsCancelBtn.setEnabled(false);
        detailsDeleteBtn.setEnabled(false);
        detailsCommentBtn.setEnabled(true);

        // Disable edit
        detailsAnredeCB.setEnabled(false);
        detailsKlasseTf.setEditable(false);
        detailsNameTf.setEditable(false);
        detailsVornameTf.setEditable(false);
        detailsGebDP.setEnabled(false);
        detailsStrasseTf.setEditable(false);
        detailsStrNrTf.setEditable(false);
        detailsPlzTf.setEditable(false);
        detailsOrtTf.setEditable(false);
        detailsRufNrTf.setEditable(false);
        detailsHandyMarkeTf.setEditable(false);
        detailsHandyModellTf.setEditable(false);
        detailsVerArtTf.setEditable(false);
        detailsVerArtCB.setEnabled(false);
        detailsVerNrTf.setEditable(false);
        detailsImeiTf.setEditable(false);
        detailsMsisdnTf.setEditable(false);
        detailsNetzTf.setEditable(false);
        detailsVerlaengerbarDP.setEnabled(false);
        detailsAktiviertDP.setEnabled(false);

        // set Focus
        tabPanel.setEnabledAt(0, true);
        tabPanel.setEnabledAt(1, true);
        tabPanel.setEnabledAt(2, true);
        tabPanel.setEnabledAt(3, true);
        tabPanel.setEnabledAt(4, true);
        optNeuBtn.setEnabled(true);
        optSuchenBtn.setEnabled(true);
    }

    private void enableEditMode() {
        controller.setEditMode(true);
        detailsPanel.setBackground(Color.lightGray);
        detailsEditBtn.setEnabled(false);
        detailsSaveBtn.setEnabled(true);
        detailsCancelBtn.setEnabled(true);
        detailsDeleteBtn.setEnabled(true);
        detailsCommentBtn.setEnabled(false);

        // Enable Edit
        detailsAnredeCB.setEnabled(true);
        detailsKlasseTf.setEditable(true);
        detailsNameTf.setEditable(true);
        detailsVornameTf.setEditable(true);
        detailsGebDP.setEnabled(true);
        detailsStrasseTf.setEditable(true);
        detailsStrNrTf.setEditable(true);
        detailsPlzTf.setEditable(true);
        detailsOrtTf.setEditable(true);
        detailsRufNrTf.setEditable(true);
        detailsHandyMarkeTf.setEditable(true);
        detailsHandyModellTf.setEditable(true);
        detailsVerArtTf.setEditable(true);
        detailsVerArtCB.setEnabled(true);
        detailsVerNrTf.setEditable(true);
        detailsImeiTf.setEditable(true);
        detailsMsisdnTf.setEditable(true);
        detailsNetzTf.setEditable(true);
        detailsVerlaengerbarDP.setEnabled(true);
        detailsAktiviertDP.setEnabled(true);
    }

    private Calendar stringToCalendar(String str) {
        String[] split = str.split("\\.");
        System.out.println("str: " + str + " size: " + split.length);
        if (split.length != 3) {
            throw new IllegalArgumentException("String '" + str + "' not in correct format");
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));

        return cal;
    }

    private Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    private void userVerified() {
        // disable login
        loginBtn.setEnabled(false);
        loginUserTf.setEnabled(false);
        loginPassPf.setEnabled(false);
        optNeuBtn.setEnabled(true);
        optSuchenBtn.setEnabled(true);
        tabellePanel.setVisible(true);

        // enable backup
        menuBackup.setEnabled(true);

        // msg
        JOptionPane.showMessageDialog(tabPanel,
                "Sie haben sich erfolgreich angemeldet!",
                "Login erfolgreich",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void detailsSave() {
        // Check input
        String error = checkDetailsInput();
        if (error != null) {
            JOptionPane.showMessageDialog(tabPanel,
                    "Fehler bei der Eingabe: " + error,
                    "Falsche Eingabe",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Dialog
        final JOptionPane optionPane = new JOptionPane(
                "Wollen sie die Änderungen uebernehmen?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_CANCEL_OPTION);

        final JDialog dialog = new JDialog(this,
                "Änderungen speichern",
                true);
        dialog.setContentPane(optionPane);
        //        dialog.setDefaultCloseOperation(
        //                JDialog.DO_NOTHING_ON_CLOSE);
        //        dialog.addWindowListener(new WindowAdapter() {
        //            public void windowClosing(WindowEvent we) {
        //                setLabel("Thwarted user attempt to close window.");
        //            }
        //        });
        optionPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                                && (e.getSource() == optionPane)
                                && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            //If you were going to check something
                            //before closing the window, you'd do
                            //it here.
                            dialog.setVisible(false);
                        }
                    }
                });
        dialog.pack();
        dialog.setLocationRelativeTo(detailsPanel);
        dialog.setVisible(true);

        int value = ((Integer) optionPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) { // Save
            if (controller.updateKunde(tabelle, getDetailsKunde())) {
                // msg
                JOptionPane.showMessageDialog(tabPanel,
                        "Kundeninformationen wurden erfolgreich gespeichert.",
                        "Speicherung erfolgreich",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(tabPanel,
                        "Fehler bei der Speicherung der Kundeninformationen.",
                        "Speicherung fehlgeschlagen",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else if (value == JOptionPane.NO_OPTION) {
            detailsReset();
        } else if (value == JOptionPane.CANCEL_OPTION) {
            return;
        }

        // Exit EditMode
        disableEditMode();
    }

    private void detailsDelete() {
        // Dialog
        final JOptionPane optionPane = new JOptionPane(
                "Wollen sie den Kunden wirklich löschen?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);

        final JDialog dialog = new JDialog(this,
                "Kunden löschen",
                true);
        dialog.setContentPane(optionPane);
        //        dialog.setDefaultCloseOperation(
        //                JDialog.DO_NOTHING_ON_CLOSE);
        //        dialog.addWindowListener(new WindowAdapter() {
        //            public void windowClosing(WindowEvent we) {
        //                setLabel("Thwarted user attempt to close window.");
        //            }
        //        });
        optionPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                                && (e.getSource() == optionPane)
                                && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            //If you were going to check something
                            //before closing the window, you'd do
                            //it here.
                            dialog.setVisible(false);
                        }
                    }
                });
        dialog.pack();
        dialog.setLocationRelativeTo(detailsPanel);
        dialog.setVisible(true);

        int value = ((Integer) optionPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) { // Save
            if (controller.deleteKunde(tabelle, Integer.parseInt(detailsIdTf.getText()))) {
                // clear details
                fillDetails(null);

                //msg
                JOptionPane.showMessageDialog(tabPanel,
                        "Kunde wurde erfolgreich entfernt.",
                        "Löschen erfolgreich",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(tabPanel,
                        "Fehler, der Kunde konnte nicht entfernt werden.",
                        "Löschen fehlgeschlagen",
                        JOptionPane.WARNING_MESSAGE);
            }
            disableEditMode();

        } else if (value == JOptionPane.NO_OPTION) {
            disableEditMode();
            return;
        }
    }

    private void fillComments(Kunde kunde, List<Comment> comments) {
        if (controller.getCurKunde() == null) {
            commentIdTf.setText("");
            commentNameTf.setText("");
            commentVornameTf.setText("");
            // remove
            DefaultComboBoxModel model = (DefaultComboBoxModel) commentCommentCB.getModel();
            model.removeAllElements();
            commentDatumDP.setCalendar(null);
            commentCommentTA.setText("");

            commentEditBtn.setEnabled(false);
            commentAddBtn.setEnabled(false);
            return;
        }
        System.out.println("fillComments");
        System.out.println("comments = " + comments);

        commentIdTf.setText("" + kunde.getId());
        commentNameTf.setText(kunde.getName());
        commentVornameTf.setText(kunde.getVorname());

        // remove
        DefaultComboBoxModel model = (DefaultComboBoxModel) commentCommentCB.getModel();
        model.removeAllElements();

        // Cmnts
        if (comments != null) {
            commentEditBtn.setEnabled(true);
            SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
            Comment tmp;
            int range;
            for (int i = 0; i < comments.size(); i++) {
                tmp = comments.get(i);
                if (tmp.getComment().length() < 30) {
                    range = tmp.getComment().length();
                } else {
                    range = 30;
                }
                commentCommentCB.addItem(f.format(tmp.getDate().getTime()) + " <=> " + tmp.getComment().substring(0, range) + "..");
                System.out.println(i + "CMNT: " + f.format(tmp.getDate().getTime()) + " <=> " + tmp.getComment().substring(0, range) + "..");
            }
        } else {
            commentCommentTA.setText("");
            commentDatumDP.setCalendar(null);
            commentEditBtn.setEnabled(false);
        }
    }

    private void enableCommentEditMode() {
        controller.setEditMode(true);
        controller.setCommentEditMode(true);
        detailsCommentBtn.setEnabled(false);
        commentCommentCB.setEnabled(true);
        commentPanel.setBackground(Color.lightGray);
        commentAddBtn.setEnabled(false);
        commentEditBtn.setEnabled(false);
        commentDeleteBtn.setEnabled(true);
        commentCancelBtn.setEnabled(true);
        commentSaveBtn.setEnabled(true);

        commentCommentTA.setEditable(true);
        commentDatumDP.setEnabled(true);

        tabPanel.setEnabledAt(0, false);
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        tabPanel.setEnabledAt(3, false);
        tabPanel.setEnabledAt(4, true);
        optNeuBtn.setEnabled(false);
        optSuchenBtn.setEnabled(false);

    }

    private void disableCommentEditMode() {
        controller.setEditMode(false);
        controller.setCommentEditMode(false);
        detailsCommentBtn.setEnabled(true);
        commentCommentCB.setEnabled(true);
        commentPanel.setBackground(suchePanel.getBackground());
        commentAddBtn.setEnabled(true);
        commentEditBtn.setEnabled(true);
        commentDeleteBtn.setEnabled(false);
        commentCancelBtn.setEnabled(false);
        commentSaveBtn.setEnabled(false);

        commentCommentTA.setEditable(false);
        commentDatumDP.setEnabled(false);

        // set Focus
        tabPanel.setEnabledAt(0, true);
        tabPanel.setEnabledAt(1, true);
        tabPanel.setEnabledAt(2, true);
        tabPanel.setEnabledAt(3, true);
        tabPanel.setEnabledAt(4, true);
        optNeuBtn.setEnabled(true);
        optSuchenBtn.setEnabled(true);

        tabPanelStateChanged(null);
    }

    private void enableCommentNewMode() {
        controller.setEditMode(true);
        controller.setCommentNewMode(true);
        detailsCommentBtn.setEnabled(false);
        commentCommentCB.setEnabled(false);
        commentPanel.setBackground(Color.lightGray);
        commentAddBtn.setEnabled(false);
        commentEditBtn.setEnabled(false);
        commentDeleteBtn.setEnabled(false);
        commentCancelBtn.setEnabled(true);
        commentSaveBtn.setEnabled(true);

        commentCommentTA.setEditable(true);
        commentDatumDP.setEnabled(true);

        tabPanel.setEnabledAt(0, false);
        tabPanel.setEnabledAt(1, false);
        tabPanel.setEnabledAt(2, false);
        tabPanel.setEnabledAt(3, false);
        tabPanel.setEnabledAt(4, true);
        optNeuBtn.setEnabled(false);
        optSuchenBtn.setEnabled(false);
    }

    private void disableCommentNewMode() {
        controller.setEditMode(false);
        controller.setCommentNewMode(false);
        detailsCommentBtn.setEnabled(true);
        commentCommentCB.setEnabled(true);
        commentPanel.setBackground(suchePanel.getBackground());
        commentAddBtn.setEnabled(true);
        commentEditBtn.setEnabled(true);
        commentDeleteBtn.setEnabled(false);
        commentCancelBtn.setEnabled(false);
        commentSaveBtn.setEnabled(false);

        commentCommentTA.setEditable(false);
        commentDatumDP.setEnabled(false);

        // set Focus
        tabPanel.setEnabledAt(0, true);
        tabPanel.setEnabledAt(1, true);
        tabPanel.setEnabledAt(2, true);
        tabPanel.setEnabledAt(3, true);
        tabPanel.setEnabledAt(4, true);
        optNeuBtn.setEnabled(true);
        optSuchenBtn.setEnabled(true);
    }

    private void addComment() {
        // CmtNewMode
        enableCommentNewMode();

        // leeres Cmt einfuegen
        DefaultComboBoxModel model = (DefaultComboBoxModel) commentCommentCB.getModel();
        model.removeAllElements();
        commentCommentCB.addItem("<Neuer Kommentar>");

        // clear
        commentCommentTA.setText("");
        commentDatumDP.setCalendar(Calendar.getInstance());
    }

    private void deleteComment() {
        final JOptionPane optionPane = new JOptionPane(
                "Wollen Sie den Kommentar wirklich löschen?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);

        final JDialog dialog = new JDialog(this,
                "Kommentar löschen",
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
        dialog.setLocationRelativeTo(detailsPanel);
        dialog.setVisible(true);

        int value = ((Integer) optionPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) {
            // Get cur comment
            Comment cmt = new Comment();
            cmt.setComment(commentCommentTA.getText());
            cmt.setDate(commentDatumDP.getCalendar());
            cmt.setId(Integer.parseInt(commentIdTf.getText()));

            // comment loeshcen
            if (controller.deleteComment(commentCommentCB, cmt)) {
                JOptionPane.showMessageDialog(tabPanel,
                        "Kommentar wurde erfolgreich entfernt.",
                        "Löschung erfolgreich",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(tabPanel,
                        "Fehler: Kommentar konnte nicht entfernt werden.",
                        "Löschung fehlgeschlagen",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else if (value == JOptionPane.NO_OPTION) {
        }

        // return to normal
        disableCommentEditMode();
    }

    private void cancelComment() {
        // new
        if (controller.isCommentNewMode()) {
            disableCommentNewMode();
        }
        // update
        if (controller.isCommentEditMode()) {
            disableCommentEditMode();
        }
        // refill
        Kunde curKunde = controller.getCurKunde();
        fillComments(curKunde, controller.getComments(curKunde.getId()));
    }

    private void saveComment() {
        // Check felder
        if (commentCommentTA.getText().isEmpty() || commentDatumDP.getCalendar() == null) {
            JOptionPane.showMessageDialog(tabPanel,
                    "Fehler: Die Felder 'Kommentar' und 'Datum' müssen ausgefüllt werden!",
                    "Fehlenmde Informationen",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Msg
        final JOptionPane optionPane = new JOptionPane(
                "Wollen Sie den geänderten Kommentar speichern?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_CANCEL_OPTION);

        final JDialog dialog = new JDialog(this,
                "Kommentar speichern",
                true);
        dialog.setContentPane(optionPane);
        optionPane.addPropertyChangeListener(
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent e) {
                        String prop = e.getPropertyName();

                        if (dialog.isVisible()
                                && (e.getSource() == optionPane)
                                && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
                            //If you were going to check something
                            //before closing the window, you'd do
                            //it here.
                            dialog.setVisible(false);
                        }
                    }
                });
        dialog.pack();
        dialog.setLocationRelativeTo(detailsPanel);
        dialog.setVisible(true);

        // get Comment
        Comment cmt = new Comment(controller.getCurKunde().getId(), commentDatumDP.getCalendar(), commentCommentTA.getText());
        System.out.println("getComment: " + controller.getCurKunde().getId() + "\t" + commentDatumDP.getCalendar() + "\t" + commentCommentTA.getText());
        int value = ((Integer) optionPane.getValue()).intValue();
        if (value == JOptionPane.YES_OPTION) {
            // new
            if (controller.isCommentNewMode()) {
                disableCommentNewMode();
                if (controller.addComment(cmt)) {
                    //msg
                    JOptionPane.showMessageDialog(tabPanel,
                            "Kommentar wurde erfolgreich hinzugefügt.",
                            "Kommentar Hinzufügen erfolgreich",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(tabPanel,
                            "Fehler: Kommentar konnte nicht hinzugefügt werden.",
                            "Kommentar Hinzufügen fehlgeschlagen",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            // update
            if (controller.isCommentEditMode()) {
                disableCommentEditMode();
                if (controller.updateComment(controller.getCurComment(), cmt)) { //old , new

                    JOptionPane.showMessageDialog(tabPanel,
                            "Änderungen am Kommentar wurden erfolgreich gespeichert.",
                            "Änderung erfolgreich",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(tabPanel,
                            "Fehler: Kommentar konnte nicht geändert werden.",
                            "Änderung fehlgeschlagen",
                            JOptionPane.WARNING_MESSAGE);
                }
            }


        } else if (value == JOptionPane.NO_OPTION) {
            // reset
            disableCommentEditMode();
            disableCommentNewMode();
        } else if (value == JOptionPane.CANCEL_OPTION) {
            // reset
            return;
        }
        // Reload cmnts
        Kunde curKunde = controller.getCurKunde();
        fillComments(curKunde, controller.getComments(curKunde.getId()));
    }

    private void resetSuche() {
        sucheIdTf.setText(""); // todo
        sucheNameTf.setText("");
        sucheVornameTf.setText("");
        sucheStrasseTf.setText("");
        sucheGebDP.setCalendar(null);
        sucheStrNrTf.setText("");
        suchePlzTf.setText("");
        sucheOrtTf.setText("");
        sucheVerNrTf.setText("");
        sucheVerArtCB.setSelectedIndex(0);
//            sucheImeiTf.setText("");
//            sucheMsisdnTf.setText("");
//            sucheAktiviertDP.setCalendar(null);
        sucheVerlaengerbarDP.setCalendar(null);
    }
//    private String extractHandy() {
//        String handy = neuHandyMarkeTf.getText();
//        if (!neuHandyModellTf.getText().isEmpty()) {
//            if (!neuHandyMarkeTf.getText().isEmpty()) {
//                handy += " : ";
//            }
//            handy += neuHandyModellTf.getText();
//        }
//        return handy;
//    }

    private String extractVerArt(String vertragsArt) {
        throw new UnsupportedOperationException("Not yet implemented");//
    }

    private void initContextMenuRightClick() {
        ContextMenuMouse menu = new ContextMenuMouse();
        Component[] panels = tabPanel.getComponents();
        System.out.println("panels size: " + panels.length);
        for (Component comp : panels) {
            Component[] comps = ((JPanel) comp).getComponents();
            System.out.println("comps size: " + panels.length);
            for (Component fields : comps) {
                if (fields instanceof JTextField) {
                    ((JTextField) fields).addMouseListener(menu);
                }
            }
        }
    }

    private void initEnterBinding() {
        String keyStrokeAndKey = "ENTER";
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);

        // StartPanel
        Action actionLogin = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loginBtnActionPerformed(null);
            }
        };
        loginUserTf.getInputMap(JComponent.WHEN_FOCUSED).put(keyStroke, keyStrokeAndKey);
        loginUserTf.getActionMap().put(keyStrokeAndKey, actionLogin);
        loginPassPf.getInputMap(JComponent.WHEN_FOCUSED).put(keyStroke, keyStrokeAndKey);
        loginPassPf.getActionMap().put(keyStrokeAndKey, actionLogin);

        // SuchePanel
        Action actionSuche = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tabPanel.getSelectedIndex() == 2) {
                    controller.sucheKunde(tabelle, getSucheKunde());
                }
            }
        };
        suchePanel.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(keyStroke, keyStrokeAndKey);
        suchePanel.getRootPane().getActionMap().put(keyStrokeAndKey, actionSuche);

    }

    private String checkDetailsInput() {
        String error = null;
        // Anrede
        if (detailsAnredeCB.getSelectedIndex() == 0) {
            error = "'Anrede' ist leer! ";
            return error;
        }
        // Name
        if (detailsNameTf.getText().isEmpty()) {
            error = "'Name' ist leer! ";
            return error;
        }
        if (!(detailsNameTf.getText()).matches("[a-zA-Z-]+")) {
            error = "'Name' darf keine Sonderzeichen oder Zahlen enthalten! ";
            return error;
        }
        // Vorname
        if (detailsVornameTf.getText().isEmpty()) {
            error = "'Vorname' ist leer! ";
            return error;
        }
        System.out.println("vorname: " + detailsVornameTf.getText());
        if (!(detailsVornameTf.getText()).matches("[a-zA-Z-]+")) {
            error = "'Vorname' darf keine Sonderzeichen oder Zahlen enthalten! ";
            return error;
        }
        // Strasse + StrNr
        if (!detailsStrasseTf.getText().isEmpty() && detailsStrNrTf.getText().isEmpty()) {
            error = "Bitte geben Sie die Nummer der Strasse ein!";
            return error;
        }
        if (detailsStrasseTf.getText().isEmpty() && !detailsStrNrTf.getText().isEmpty()) {
            error = "'Strasse' ist leer!";
            return error;
        }
        // Vertragsart
        if ((detailsVerArtCB.getSelectedItem() == null || detailsVerArtCB.getSelectedIndex() == 0) && !detailsVerArtTf.getText().isEmpty()) {
            error = "'Vertragsart' ist leer! ";
            return error;
        }
        return error;
    }
}
