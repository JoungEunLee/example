package com.amy.dto;

import java.util.Date;

public class ReplyVO {
	
	private int rno;
	private int bno;           
    private String replytext;      
    private String replyer; 
    private Date regdate;      
    private Date updatedate;       
    
    
    // Getter/Setter
    public int getRno() {
        return rno;
    }
    public void setRno(int rno) {
        this.rno = rno;
    }
    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getReplytext() {
        return replytext;
    }
    public void getReplytext(String replytext) {
        this.replytext = replytext;
    }
    public String getReplyer() {
        return replyer;
    }
    public void getReplyer(String replyer) {
        this.replyer = replyer;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Date getUpdatedate() {
        return updatedate;
    }
    public void getUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
    
    // toString()
    @Override
    public String toString() {
    	return "ReplyVO [rno = " + rno + ", bno = " + bno + ", replyText = "+ replytext + ", replyer = " + replyer + 
    			", regdate =" + regdate + ", updatedate = "+ updatedate + "]";

    }
 
}