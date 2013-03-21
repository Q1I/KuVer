/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kuver.definitions.Comment;
import kuver.definitions.Kunde;
import kuver.definitions.User;

/**
 *
 * @author q1
 */
public class Controller {

    // todo: 
//        daten anpassen +++
//        kommentare -> datum/alles anzeigen +--
//    kunde loeschen  +++
//    menu weg +++
    //bearbeiten kunden --> tabelle aktualisieren +++
    // details felder anpassen +++
    private boolean editMode;
    private Kunde curKunde;
    private List<Comment> curComments;
    private Comment curComment;
    private int curCommentIndex;
    private boolean commentNewMode;
    private boolean commentEditMode;
    // Root
    private String url = "jdbc:mysql://localhost:3306/KuVer";
    private String username = "root";
    private String password = "root";
    // Loggedin User
    private User user;

    public Controller() {
        editMode = false;
    }

    public void test(JTable tabelle) {
        DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
        String str;
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                str = "Herr";
            } else {
                str = "Frau";
            }
            model.addRow(new Object[]{i, str, "Name 3," + i, "Vorname " + i, "11.09.1988", "Strasse" + i, i, "0068" + i, "Ort," + i});
        }
    }

    public boolean addKunde(JTable tabelle, Kunde kunde) {
        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        String akti = "";
        String verl = "";
        String geb = ""; 
        String str="";
        // Add into db
        String sql = "INSERT into Kunden("
                + "Anrede, Name, Vorname, Geburtsdatum, "
                + "Strasse, PLZ, Ort, Netz, "
                + "Vertragsart, Vertragsnummer, IMEI, MSISDN, "
                + "Aktivierungsdatum, Verlaengerbar, Klasse, "
                + "Handy, Handymarke,Handymodell"
                + ") VALUES ("
                + "?,?,?,?,"
                + "?,?,?,?,"
                + "?,?,?,?,"
                + "?,?,?,"
                + "?,?,?)";
        Connection con = getConnection(user.getName(), user.getPass());
        try {
            PreparedStatement pStmt = (PreparedStatement) con.prepareStatement(sql);
            pStmt.setString(1, kunde.getAnrede());//
            pStmt.setString(2, kunde.getName());
            pStmt.setString(3, kunde.getVorname());
            if (kunde.getGebDat() != null) {
                geb = f.format(kunde.getGebDat().getTime());
            }
            pStmt.setString(4, geb);
            
            pStmt.setString(5,kunde.getStrasse());
            pStmt.setString(6, kunde.getPlz());
            pStmt.setString(7, kunde.getOrt());
            pStmt.setString(8, kunde.getNetz());

            pStmt.setString(9, kunde.getVertragsArt());//
            pStmt.setString(10, kunde.getVertragsNr());
            pStmt.setString(11, kunde.getImei());
            pStmt.setString(12, kunde.getMsisdn());
            
            if (kunde.getAktivierung() != null) {//
                akti = f.format(kunde.getAktivierung().getTime());
            }
            pStmt.setString(13, akti);
            if (kunde.getVerlaengerung() != null) {
                verl = f.format(kunde.getVerlaengerung().getTime());
            }
            pStmt.setString(14, verl);
            pStmt.setString(15, kunde.getKlasse());

            pStmt.setString(16, kunde.getRufNr());//
            pStmt.setString(17, kunde.getHandyMarke());
            pStmt.setString(18, kunde.getHandyModell());
            System.out.println("SQL: " + sql);
            int msg = pStmt.executeUpdate();
            System.out.println("Rows affected: " + msg);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Close connection
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Reset table
        clearTable(tabelle);
        DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
//        model.getDataVector().removeAllElements();


        // Add into table
        model.addRow(
                new Object[]{
                    "xxx",
                    kunde.getAnrede(),//
                    kunde.getName(),
                    kunde.getVorname(),
                    geb,
                    kunde.getStrasse(),//
//                    kunde.getStrNr(), // here
                    kunde.getPlz(),
                    kunde.getOrt(),
                    kunde.getRufNr(),//
                    kunde.getHandyMarke(),
                    kunde.getHandyModell(),
                    kunde.getVertragsArt(),//
                    kunde.getVertragsNr(),
                    kunde.getImei(),
                    kunde.getMsisdn(),
                    kunde.getNetz(),
                    akti,//
                    verl,
                    0,
                    kunde.getKlasse()
                });
        return true;
    }

    public boolean isEditMode() {
        return this.editMode;
    }

//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver"); //JDBC Driver
//        } catch (java.lang.ClassNotFoundException e) {
//            System.err.print("ClassNotFoundException: ");
//            System.err.println(e.getMessage());
//        }
//        try {
//            con = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
//            //con = DriverManager.getConnection(this.url);
//            System.out.println("Connected to database");
//        } catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        }
//
//        return con;
//    }
    public Connection getConnection(String user, String pass) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //JDBC Driver
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            con = (Connection) DriverManager.getConnection(this.url, user, pass);
            //con = DriverManager.getConnection(this.url);
            System.out.println("Connected to database");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }

        return con;
    }

    void setEditMode(boolean b) {
        this.editMode = b;
    }

    public boolean updateKunde(JTable tabelle, Kunde kunde) {
        System.out.println("Update Kunde");
        // Update
        boolean ok = false;
        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        String sql = "Update Kunden set "
                + "Anrede = ?, Name =?, Vorname=?, Geburtsdatum=?, "
                + "Strasse = ?, PLZ=?, Ort=?, Netz=?, "
                + "Vertragsart= ?, Handy= ?, IMEI = ?, MSISDN = ?, "
                + "Aktivierungsdatum = ?, Verlaengerbar = ?, Vertragsnummer = ?, Klasse = ?,"
                + "Handymarke = ?,Handymodell =?"
                + " where ID =" + kunde.getId();
        Connection con = null;
        try {
            con = getConnection(user.getName(), user.getPass());

            PreparedStatement pStmt = (PreparedStatement) con.prepareStatement(sql);
            pStmt.setString(1, kunde.getAnrede());
            pStmt.setString(2, kunde.getName());
            pStmt.setString(3, kunde.getVorname());
            pStmt.setString(4, f.format(kunde.getGebDat().getTime()));
            
            pStmt.setString(5, kunde.getStrasse());
            pStmt.setString(6, kunde.getPlz());
            pStmt.setString(7, kunde.getOrt());
            pStmt.setString(8, kunde.getNetz());

            pStmt.setString(9, kunde.getVertragsArt());
            pStmt.setString(10, kunde.getRufNr());
            pStmt.setString(11, kunde.getImei());
            pStmt.setString(12, kunde.getMsisdn());

            pStmt.setString(13, f.format(kunde.getAktivierung().getTime()));
            pStmt.setString(14, f.format(kunde.getVerlaengerung().getTime()));
            pStmt.setString(15, kunde.getVertragsNr());
            pStmt.setString(16, "" + kunde.getKlasse());

            pStmt.setString(17, "" + kunde.getHandyMarke());
            pStmt.setString(18, "" + kunde.getHandyModell());
            System.out.println("SQL: " + sql);

            int rows = pStmt.executeUpdate();
            System.out.println("Update: " + rows + " affected");
            if (rows > 0) {
                ok = true;
            }

            // reset table
            DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
            model.getDataVector().removeAllElements();
            model.addRow(
                    new Object[]{
                        kunde.getId(),
                        kunde.getAnrede(),//
                        kunde.getName(),
                        kunde.getVorname(),
                        f.format(kunde.getGebDat().getTime()),
                        kunde.getStrasse(),//
//                        kunde.getStrNr(),
                        kunde.getPlz(),
                        kunde.getOrt(),
                        kunde.getRufNr(),
                        kunde.getHandyMarke(),
                        kunde.getHandyModell(),
                        kunde.getVertragsArt(),
                        kunde.getVertragsNr(),
                        kunde.getImei(),
                        kunde.getMsisdn(),
                        kunde.getNetz(),//
                        f.format(kunde.getAktivierung().getTime()),//
                        f.format(kunde.getVerlaengerung().getTime()),
                        kunde.getKommentare(),
                        kunde.getKlasse()
                    });
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ok;
        }
    }

    /**
     * @return the curKunde
     */
    public Kunde getCurKunde() {
        return curKunde;
    }

    /**
     * @param curKunde the curKunde to set
     */
    public void setCurKunde(Kunde curKunde) {
        this.curKunde = curKunde;
    }

    public boolean login(User loginUser) {
        System.out.println("Login");
        this.user = loginUser;
        boolean ok = false;
        Connection con = null;
        try {
            con = getConnection(user.getName(), user.getPass());
            String sql = "/* ping */ SELECT 1";
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                ok = true;
                this.user = loginUser;
            } else {
                ok = false;
            }
            System.out.println("Login ok? ==> " + ok);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ok;
        }
    }

    // todo: test whole register process
    public boolean register(User user) {
        System.out.println("Register");
        boolean status = false;
        Connection con = null;
        try {
            con = getConnection(this.username, this.password);
            String sql = "CREATE USER '" + user.getName() + "'@'localhost' IDENTIFIED BY '" + user.getPass() + "'; ";
            System.out.println("SQL: " + sql);
            java.sql.Statement stmt = con.createStatement();
            int msg = stmt.executeUpdate(sql);
            System.out.println("Create User => " + msg + " Rows affected.");

            sql = "GRANT SELECT,INSERT,DELETE,UPDATE ON KuVer.* TO '" + user.getName() + "'@'localhost';";
            msg = stmt.executeUpdate(sql);
            System.out.println("Grant Privileges => " + msg + " Rows affected.");

            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return status;
        }
    }

    public boolean checkUsername(String name) {
        System.out.println("Check Username: " + name);
        boolean ok = false;
        Connection con = null;
        try {
            con = getConnection(this.username, this.password);
            String sql = "select user from mysql.user where user='" + name + "'";
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                ok = false;
            } else {
                ok = true;
            }
            System.out.println("Username ok? ==> " + ok);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ok;
        }
    }

    public String getVerificationCode() {
        System.out.println("Get Verificationcode");
//        String code = null;
//        Connection con = null;
//        try {
//            con = getConnection("kuver","!@#$prtscr");
//            String sql = "select * from KuVer.code";
//            java.sql.Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                code = rs.getString("code");
//            }
//            System.out.println("Code retrieved.");
//        } catch (SQLException ex) {
//            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return code;
//        }
        return "ltt>(,H";
    }

    public void sucheKunde(JTable tabelle, Kunde kunde) {
        // Reset table
        clearTable(tabelle);
        DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
//        model.getDataVector().removeAllElements();


        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        String akti = "";
        String verl = "";
        String geb = "";

        // Create SQL query
        boolean andSetzen = false;
        String sql = "select * from Kunden where ";
        if (kunde.getId() != 0) {
            sql += "ID = " + kunde.getId() + " ";
            andSetzen = true;
        }
        if (!kunde.getName().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "name like '" + kunde.getName() + "%' ";
            andSetzen = true;
        }
        if (!kunde.getVorname().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "vorname like '" + kunde.getVorname() + "%' ";
            andSetzen = true;
        }
        if (kunde.getGebDat() != null) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "Geburtsdatum like '" + f.format(kunde.getGebDat().getTime()) + "%' ";
            andSetzen = true;
        }
        if (!kunde.getStrasse().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "strasse like '" + kunde.getStrasse() + "%' ";
            andSetzen = true;
        }
//        if(kunde.getStrNr()!=0){
//            if(andSetzen)
//                sql+="AND ";
//            sql+="strNr = "+kunde.getStrNr()+" ";
//            andSetzen=true;
//        }
        if (!kunde.getPlz().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "PLZ like '" + kunde.getPlz() + "%' ";
            andSetzen = true;
        }
        if (!kunde.getOrt().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "Ort like '" + kunde.getOrt() + "%' ";
            andSetzen = true;
        }
        // Verl
        if (kunde.getVerlaengerung() != null) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "Verlaengerbar like '" + f.format(kunde.getVerlaengerung().getTime()) + "%' ";
            andSetzen = true;
        }
        if (!kunde.getVertragsNr().isEmpty()) {
            if (andSetzen) {
                sql += "AND ";
            }
            sql += "Vertragsnummer like '" + kunde.getVertragsNr() + "%' ";
            andSetzen = true;
        }
        if (!andSetzen) // keine eingerenzung
        {
            sql += " 1";
        }

        System.out.println("SQL: " + sql);

        // execute query
        Connection con = null;
        Kunde tmp = new Kunde();

        try {
            con = getConnection(user.getName(), user.getPass());
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Kunde
                tmp.reset();
                tmp.setId(rs.getInt("ID"));
                tmp.setKlasse(rs.getString("Klasse"));
                tmp.setAnrede(rs.getString("Anrede"));
                tmp.setName(rs.getString("Name"));
                tmp.setVorname(rs.getString("Vorname"));
                // Bday
                Calendar cal = null;
                if (!rs.getString("Geburtsdatum").isEmpty()) {
                    try {
                        cal=Calendar.getInstance();
                        cal.setTime(f.parse(rs.getString("Geburtsdatum")));
                        geb = rs.getString("Geburtsdatum");
                    } catch (ParseException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    geb = "";
                }
                tmp.setGebDat(cal);
                tmp.setStrasse(rs.getString("Strasse"));
//                tmp.setStrNr(rs.getInt("StrNr"));
                tmp.setPlz(rs.getString("PLZ")); // todo: plz ist string
                tmp.setOrt(rs.getString("Ort"));
                tmp.setRufNr(rs.getString("Handy"));
                tmp.setHandyMarke(rs.getString("Handymarke"));
                tmp.setHandyModell(rs.getString("Handymodell"));
                                System.out.println("#marke: "+rs.getString("Handymarke"));
                             System.out.println("#modell: "+rs.getString("Handymodell"));
                                   

                tmp.setNetz(rs.getString("Netz"));
                tmp.setVertragsArt(rs.getString("Vertragsart"));
                tmp.setVertragsNr(rs.getString("Vertragsnummer"));
                tmp.setImei(rs.getString("IMEI"));
                tmp.setMsisdn(rs.getString("MSISDN"));
                // Aktivierung
                Calendar calAkt = null;
                if (!rs.getString("Aktivierungsdatum").isEmpty()) {
                    try {
                        calAkt = Calendar.getInstance();
                        calAkt.setTime(f.parse(rs.getString("Aktivierungsdatum")));
                        akti = rs.getString("Aktivierungsdatum");
                    } catch (ParseException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    akti = "";
                }
                tmp.setAktivierung(calAkt);

                // Verlaengerbar
                Calendar calVerl = null;
                if (!rs.getString("Verlaengerbar").isEmpty()) {
                    try {
                        calVerl = Calendar.getInstance();
                        calVerl.setTime(f.parse(rs.getString("Verlaengerbar")));
                        verl = rs.getString("Verlaengerbar");
                    } catch (ParseException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    verl = "";
                }
                tmp.setVerlaengerung(calVerl);

                // Query Kommentare
                String sqlCmnt = "SELECT count(*) as anzahl FROM Kunden_comment WHERE id = " + tmp.getId();
                java.sql.Statement stmtCmnt = con.createStatement();
                ResultSet rsCmnt = stmtCmnt.executeQuery(sqlCmnt);
                if (rsCmnt.next()) {
                    tmp.setKommentare(rsCmnt.getInt("anzahl"));
                }

                // add to jtable
                model.addRow(
                        new Object[]{
                            tmp.getId(),
                            tmp.getAnrede(),//
                            tmp.getName(),
                            tmp.getVorname(),
                            geb,
                            tmp.getStrasse(),//
                            tmp.getPlz(),
                            tmp.getOrt(),
                            tmp.getRufNr(),
                            tmp.getHandyMarke(),
                            tmp.getHandyModell(),
                            tmp.getVertragsArt(),
                            tmp.getVertragsNr(),
                            tmp.getImei(),
                            tmp.getMsisdn(),
                            tmp.getNetz(),//
                            akti,//
                            verl,
                            tmp.getKommentare(),
                            tmp.getKlasse()
                        });
            }
            System.out.println("Code retrieved.");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean deleteKunde(JTable tabelle, int id) {
        System.out.println("Delete Kunde");
        boolean ok = false;
        Connection con = null;
        try {
            con = getConnection(user.getName(), user.getPass());
            String sql = "Delete from Kunden where ID='" + id + "'";
            System.out.println("SQL: " + sql);
            java.sql.Statement stmt = con.createStatement();
            int msg = stmt.executeUpdate(sql);
            System.out.println("Delete: " + msg + " rows affected.");
            if (msg > 0) {
                ok = true;
            }

            // reset table
//            DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
//            model.getDataVector().removeAllElements();
//            model.addRow(new Object[]{});
            clearTable(tabelle);
            // reset
            this.curKunde = null;
            this.curComment = null;
            this.curComments = null;

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return ok;
        }

    }

    List<Comment> getComments(int id) {
        // Get all comments of specified id
        List<Comment> list = null;
        Connection con = null;
        String cmt = null;
        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        try {
            con = getConnection(user.getName(), user.getPass());
            String sql = "SELECT Datum,Comment from Kunden_comment where ID = '" + id + "'";
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            list = new ArrayList<Comment>();
            while (rs.next()) {
                Calendar date = Calendar.getInstance();
                try {
                    date.setTime(f.parse(rs.getString("Datum")));
                } catch (ParseException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    date = null;
                }
                cmt = rs.getString("Comment");
                Comment tmp = new Comment(id, date, cmt);
                list.add(tmp);
                System.out.println("id: " + id + "\tdate: " + f.format(date.getTime()) + "\tcmt:" + cmt);
            }
            System.out.println("Comments retrievd");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        if (list.isEmpty()) {
            list = null;
        }

        this.curComments = list;

        return list;
    }

    /**
     * @return the curComments
     */
    public List<Comment> getCurComments() {
        return curComments;
    }

    /**
     * @param curComments the curComments to set
     */
    public void setCurComments(List<Comment> curComments) {
        this.curComments = curComments;
    }

    /**
     * @return the curComment
     */
    public Comment getCurComment() {
        return curComment;
    }

    /**
     * @param curComment the curComment to set
     */
    public void setCurComment(Comment curComment, int index) {
        this.curComment = curComment;
        this.setCurCommentIndex(index);
    }

    public boolean deleteComment(JComboBox box, int index, Comment cmt) {
        System.out.println("Delete Comment");
        boolean ok = false;
        Connection con = null;
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        try {
            con = getConnection(user.getName(), user.getPass());
            String sql = "Delete from Kunden_comment where ID='" + cmt.getId()
                    + "' AND Datum = '" + f.format(cmt.getDate().getTime())
                    + "' AND Comment = '" + cmt.getComment() + "'";
            System.out.println("SQL: " + sql);
            java.sql.Statement stmt = con.createStatement();
            int msg = stmt.executeUpdate(sql);
            System.out.println("Delete: " + msg + " rows affected.");
            if (msg > 0) {
                ok = true;
            }
            // reset cb
            DefaultComboBoxModel model = (DefaultComboBoxModel) box.getModel();
            model.removeElementAt(index);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return ok;
        }

    }

    /**
     * @return the curCommentIndex
     */
    public int getCurCommentIndex() {
        return curCommentIndex;
    }

    /**
     * @param curCommentIndex the curCommentIndex to set
     */
    public void setCurCommentIndex(int curCommentIndex) {
        this.curCommentIndex = curCommentIndex;
    }

    /**
     * @return the commentNewMode
     */
    public boolean isCommentNewMode() {
        return commentNewMode;
    }

    /**
     * @param commentNewMode the commentNewMode to set
     */
    public void setCommentNewMode(boolean commentNewMode) {
        this.commentNewMode = commentNewMode;
    }

    /**
     * @return the commentEditMode
     */
    public boolean isCommentEditMode() {
        return commentEditMode;
    }

    /**
     * @param commentEditMode the commentEditMode to set
     */
    public void setCommentEditMode(boolean commentEditMode) {
        this.commentEditMode = commentEditMode;
    }

    public boolean addComment(Comment cmt) {
        System.out.println("Add Comment");
        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        boolean ok = false;
        // Add into db
        String sql = "INSERT into Kunden_comment("
                + "ID, Datum, Comment"
                + ") VALUES ("
                + "?,?,?)";
        Connection con = getConnection(user.getName(), user.getPass());
        System.out.println("try addComment");
        try {
            PreparedStatement pStmt = (PreparedStatement) con.prepareStatement(sql);
            pStmt.setInt(1, cmt.getId());
            pStmt.setString(2, f.format(cmt.getDate().getTime()));
            pStmt.setString(3, cmt.getComment());

            int msg = pStmt.executeUpdate();
            System.out.println("SQL: " + sql + "\nRows affected: " + msg);
            if (msg > 0) {
                ok = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            // Close connection
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            return ok;
        }
    }

    boolean updateComment(Comment oldCmt, Comment cmt) {
        System.out.println("updateComment");
        // Update
        boolean ok = false;
        // Datum Formatieren
        SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy");
        String sql = "Update Kunden_comment set "
                + "Datum =?, Comment=?"
                + " where ID = ? and Datum = ? and Comment=?";
        Connection con = null;
        System.out.println("try updateComment");
        try {
            con = getConnection(user.getName(), user.getPass());

            PreparedStatement pStmt = (PreparedStatement) con.prepareStatement(sql);
            pStmt.setString(1, f.format(cmt.getDate().getTime()));
            pStmt.setString(2, cmt.getComment());

            pStmt.setInt(3, cmt.getId());
            pStmt.setString(4, f.format(oldCmt.getDate().getTime()));
            pStmt.setString(5, oldCmt.getComment());
            System.out.println("SQL: " + sql);

            int rows = pStmt.executeUpdate();
            System.out.println("Update: " + rows + " affected");
            if (rows > 0) {
                ok = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ok;
        }
    }

    public void clearTable(JTable tabelle) {
        DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
