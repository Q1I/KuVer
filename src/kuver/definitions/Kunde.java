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
    private Calendar gebDat = null;
    
    private String strasse;
    private int strNr;
    private String ort;
    private String plz;
    private String netz;
    
    private String vertrag;
    private String handy;
    private String imei;
    private String aktivierung;
    
    private String msisdn;
    private Calendar verlaengerung = null;

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
        this.setId(0);
        this.setAnrede(null);
        this.setName(null);
        this.setVorname(null);
        this.setStrasse(null);
        this.setStrNr(0);
        this.setOrt(null);
        this.setPlz(null);
        // todo: rest
    }

    /**
     * @return the netz
     */
    public String getNetz() {
        return netz;
    }

    /**
     * @param netz the netz to set
     */
    public void setNetz(String netz) {
        this.netz = netz;
    }

    /**
     * @return the vertrag
     */
    public String getVertrag() {
        return vertrag;
    }

    /**
     * @param vertrag the vertrag to set
     */
    public void setVertrag(String vertrag) {
        this.vertrag = vertrag;
    }

    /**
     * @return the handy
     */
    public String getHandy() {
        return handy;
    }

    /**
     * @param handy the handy to set
     */
    public void setHandy(String handy) {
        this.handy = handy;
    }

    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return the aktivierung
     */
    public String getAktivierung() {
        return aktivierung;
    }

    /**
     * @param aktivierung the aktivierung to set
     */
    public void setAktivierung(String aktivierung) {
        this.aktivierung = aktivierung;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @return the verlaengerung
     */
    public Calendar getVerlaengerung() {
        return verlaengerung;
    }

    /**
     * @param verlaengerung the verlaengerung to set
     */
    public void setVerlaengerung(Calendar verlaengerung) {
        this.verlaengerung = verlaengerung;
    }
}
