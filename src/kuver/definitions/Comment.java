/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kuver.definitions;

import java.util.Calendar;

/**
 *
 * @author q1
 */
public class Comment {
    private int id;
    private Calendar date;
    private String comment;
    
    public Comment(){}

    public Comment(int id, Calendar date, String cmt) {
        this.id=id;
        this.date=date;
        this.comment=cmt;
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
     * @return the date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
