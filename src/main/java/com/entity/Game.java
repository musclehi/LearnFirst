package com.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Game {
    private int id;
    private int type;
    private String icon;
    private String name;
    private String developer;
    private int state;
    private int autoUpdate;
    private int isOfficial;
    private Timestamp operateTime;
    private Timestamp dateIssued;
    private Timestamp updateTime;
    private int activeComment;
    private int downloadNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(int autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public int getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(int isOfficial) {
        this.isOfficial = isOfficial;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Timestamp operateTime) {
        this.operateTime = operateTime;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Timestamp dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getActiveComment() {
        return activeComment;
    }

    public void setActiveComment(int activeComment) {
        this.activeComment = activeComment;
    }

    public int getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(int downloadNum) {
        this.downloadNum = downloadNum;
    }
}
