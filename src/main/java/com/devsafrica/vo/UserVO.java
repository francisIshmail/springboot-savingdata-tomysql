package com.devsafrica.vo;

public class UserVO {

    private long userIdx;
    private String fullName;
    private String userName;

    public long getUserId() {
        return userIdx;
    }

    public void setUserId(long userId) {
        this.userIdx = userIdx;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
