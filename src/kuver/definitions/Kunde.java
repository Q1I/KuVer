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
    private String klasse;
    private String anrede;
    private String name;
    private String vorname;
    private Calendar gebDat = null;
    private String strasse;
    private String ort;
    private String plz;
    private String vertragsNr;
    private String vertragsArt;
    private String rufNr;
    private String handyMarke;
    private String handyModell;
    private String imei;
    private String msisdn;
    private String netz;
    private Calendar aktivierung = null;
    private Calendar verlaengerung = null;
    private int kommentare = 0;

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
        return this.strasse;
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
    public String getStrNr() {
        if (strasse == null) {
            return null;
        }else{
            return strasse.substring(strasse.indexOf('.')+1,strasse.length());
        }
    }

    public void reset() {
        this.setId(0);
        this.setAnrede(null);
        this.setName(null);
        this.setVorname(null);
        this.setStrasse(null);
        this.setOrt(null);
        this.setPlz(null);
        this.vertragsArt = null;
        this.vertragsNr = null;
        this.rufNr = null;
        this.imei = null;
        this.aktivierung = null;
        this.msisdn = null;
        this.verlaengerung = null;
        this.kommentare = 0;
        this.klasse = null;
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
     * @return the rufNr
     */
    public String getRufNr() {
        return rufNr;
    }

    /**
     * @param rufNr the rufNr to set
     */
    public void setRufNr(String rufNr) {
        this.rufNr = rufNr;
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
    public Calendar getAktivierung() {
        return aktivierung;
    }

    /**
     * @param aktivierung the aktivierung to set
     */
    public void setAktivierung(Calendar aktivierung) {
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

    /**
     * @return the klasse
     */
    public String getKlasse() {
        return klasse;
    }

    /**
     * @param klasse the klasse to set
     */
    public void setKlasse(String klasse) {
        this.klasse = klasse;
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
     * @return the vertragsArt
     */
    public String getVertragsArt() {
        return vertragsArt;
    }

    /**
     * @param vertragsArt the vertragsArt to set
     */
    public void setVertragsArt(String vertragsArt) {
        this.vertragsArt = vertragsArt;
    }

    /**
     * @return the kommentare
     */
    public int getKommentare() {
        return kommentare;
    }

    /**
     * @param kommentare the kommentare to set
     */
    public void setKommentare(int kommentare) {
        this.kommentare = kommentare;
    }

    /**
     * @return the handyMarke
     */
    public String getHandyMarke() {
        return handyMarke;
    }

    /**
     * @param handyMarke the handyMarke to set
     */
    public void setHandyMarke(String handyMarke) {
        this.handyMarke = handyMarke;
    }

    /**
     * @return the handyModell
     */
    public String getHandyModell() {
        return handyModell;
    }

    /**
     * @param handyModell the handyModell to set
     */
    public void setHandyModell(String handyModell) {
        this.handyModell = handyModell;
    }

    public String getVertragsArtCB() {
        if(vertragsArt==null)
            return null;
        if (vertragsArt.contains(":")) {
            return vertragsArt.substring(0, vertragsArt.indexOf(':')-1); // -1 because of space => 'DSL : Notiz'
        } else {
            return vertragsArt;
        }
    }
    
    public String getVertragsArtTf() {
        if(vertragsArt==null)
            return null;
        if (vertragsArt.contains(":")) {
            return vertragsArt.substring(vertragsArt.indexOf(':')+2,vertragsArt.length());
        } else {
            return null;
        }
    }

    public String getStrasseOhneNr() {
        if (strasse == null) {
            return null;
        }
        if (strasse.contains(".")) {
            return strasse.substring(0, strasse.indexOf('.'));
        } else {
            return strasse;
        }
    }
}
