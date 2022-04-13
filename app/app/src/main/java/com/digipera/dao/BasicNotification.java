package com.digipera.dao;

public class BasicNotification {

    private final long uid;
    private final String forUser;
    private final String line1Left;
    private final String line1Right;
    private final String line2Left;
    private final String line2Right;
    private final String createdOn;
    private final String type;

    public BasicNotification(long uid, String forUser, String line1Left, String line1Right, String line2Left,
                             String line2Right, String createdOn, String type) {
        this.uid = uid;
        this.forUser = forUser;
        this.line1Left = line1Left;
        this.line1Right = line1Right;
        this.line2Left = line2Left;
        this.line2Right = line2Right;
        this.createdOn = createdOn;
        this.type = type;
    }

    public long getUid() {
        return uid;
    }

    public String getForUser() {
        return forUser;
    }

    public String getLine1Left() {
        return line1Left;
    }

    public String getLine1Right() {
        return line1Right;
    }

    public String getLine2Left() {
        return line2Left;
    }

    public String getLine2Right() {
        return line2Right;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return "BasicNotification{" +
                "uid=" + uid +
                ", forUser='" + forUser + '\'' +
                ", line1Left='" + line1Left + '\'' +
                ", line1Right='" + line1Right + '\'' +
                ", line2Left='" + line2Left + '\'' +
                ", line2Right='" + line2Right + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
