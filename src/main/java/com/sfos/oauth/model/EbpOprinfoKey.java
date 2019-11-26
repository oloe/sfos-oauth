package com.sfos.oauth.model;

public class EbpOprinfoKey {
    private String eoiCstno;

    private String eoiCredtype;

    private String eoiCredno;

    public String getEoiCstno() {
        return eoiCstno;
    }

    public void setEoiCstno(String eoiCstno) {
        this.eoiCstno = eoiCstno == null ? null : eoiCstno.trim();
    }

    public String getEoiCredtype() {
        return eoiCredtype;
    }

    public void setEoiCredtype(String eoiCredtype) {
        this.eoiCredtype = eoiCredtype == null ? null : eoiCredtype.trim();
    }

    public String getEoiCredno() {
        return eoiCredno;
    }

    public void setEoiCredno(String eoiCredno) {
        this.eoiCredno = eoiCredno == null ? null : eoiCredno.trim();
    }
}