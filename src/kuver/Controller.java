/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kuver.definitions.Kunde;
import kuver.definitions.User;

/**
 *
 * @author q1
 */
public class Controller {

    private boolean editMode;
    private Kunde curKunde;
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
            model.addRow(new Object[]{i, str, "Name 3," + i, "Vorname " + i, "11.09.1988", "Strasse" + i, i, "0068" + i, "Column 3," + i});
        }
    }

    public void addKunde(JTable tabelle, Kunde kunde) {
        // Add into db
        String sql = "INSERT into new_table(Name, Vorname, Strasse, PLZ, Ort ) VALUES (?,?,?,?,?)";
        Connection con = getConnection();
        try {
            PreparedStatement pStmt = (PreparedStatement) con.prepareStatement(sql);
            pStmt.setString(1, kunde.getName());
            pStmt.setString(2, kunde.getVorname());
            pStmt.setString(3, kunde.getStrasse());
            pStmt.setString(4, kunde.getPlz());
            pStmt.setString(5, kunde.getOrt());
            int msg = pStmt.executeUpdate();
            System.out.println("SQL: " + sql + "\nRows affected: " + msg);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close connection
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Add into table
        DefaultTableModel model = (DefaultTableModel) tabelle.getModel();
        model.addRow(
                new Object[]{
                    kunde.getId(),
                    kunde.getName(),
                    kunde.getVorname(),
                    kunde.getStrasse(),
                    kunde.getPlz(),
                    kunde.getOrt(),});

    }

    public boolean isEditMode() {
        return this.editMode;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/KuVer";
        String user = "root";
        String pass = "root";

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //JDBC Driver
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);
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

    void updateKunde(Kunde kunde) {
        // Update
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

    public boolean login() {
        boolean verified = true;
        return verified;
    }

    // todo: test whole register process
    public boolean register(User user) {
        System.out.println("Register");
        boolean status = false;
        Connection con = null;
        try {
            con = getConnection();
            String sql = "Insert into user (name,password) values ('" + user.getName() + "','" + user.getPass() + "')";
            java.sql.Statement stmt = con.createStatement();
            int msg = stmt.executeUpdate(sql);
            status = true;
            System.out.println(msg + " Rows affected.");
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
        System.out.println("Check Username: "+name);
        boolean ok = false;
        Connection con = null;
        try {
            con = getConnection();
            String sql = "select * from user where name = '"+name+"'";
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                ok = false;
            else 
                ok = true;
            System.out.println("Username ok? ==> "+ok);
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
        String code = null;
        Connection con = null;
        try {
            con = getConnection();
            String sql = "select * from code";
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
                code = rs.getString("code");
            System.out.println("Code retrieved.");
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            return code;
        }
    }
}
