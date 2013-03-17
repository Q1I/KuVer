/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.definitions;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author q1
 */
public class Kunde {
    private int id;
    private String anrede;
    private String name;
    private String vorname;
    private String strasse;
    private int strNr;
    private String ort;
    private String plz;
    private String vertragsNr;
    private String handy;
    private Calendar gebDat = null;
    private Calendar verlAb = null;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @param vorname the vorname to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * @return the strasse
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * @param strasse the strasse to set
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    /**
     * @return the ort
     */
    public String getOrt() {
        return ort;
    }

    /**
     * @param ort the ort to set
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    /**
     * @return the plz
     */
    public String getPlz() {
        return plz;
    }

    /**
     * @param plz the plz to set
     */
    public void setPlz(String plz) {
        this.plz = plz;
    }

    /**
     * @return the vertragsNr
     */
    public String getVertragsNr() {
        return vertragsNr;
    }

    /**
     * @param vertragsNr the vertragsNr to set
     */
    public void setVertragsNr(String vertragsNr) {
        this.vertragsNr = vertragsNr;
    }

    /**
     * @return the gebDat
     */
    public Calendar getGebDat() {
        return gebDat;
    }

    /**
     * @param gebDat the gebDat to set
     */
    public void setGebDat(Calendar gebDat) {
        this.gebDat = gebDat;
    }

    /**
     * @return the verlAb
     */
    public Calendar getVerlAb() {
        return verlAb;
    }

    /**
     * @param verlAb the verlAb to set
     */
    public void setVerlAb(Calendar verlAb) {
        this.verlAb = verlAb;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the anrede
     */
    public String getAnrede() {
        return anrede;
    }

    /**
     * @param anrede the anrede to set
     */
    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    /**
     * @return the strNr
     */
    public int getStrNr() {
        return strNr;
    }

    /**
     * @param strNr the strNr to set
     */
    public void setStrNr(int strNr) {
        this.strNr = strNr;
    }

    public void reset() {
        this.id=0;
        this.anrede=null;
        this.name=null;
        this.vorname=null;
        this.strasse=null;
        this.strNr=0;
        this.ort=null;
        this.plz=null;
        // todo: rest
    }
}
