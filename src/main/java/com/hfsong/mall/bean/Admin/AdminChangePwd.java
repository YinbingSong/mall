package com.hfsong.mall.bean.Admin;

public class AdminChangePwd {
    private String token;
    private String oldPwd;
    private String newPwd;
    private String confirmPwd;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminChangePwd{");
        sb.append("token='").append(token).append('\'');
        sb.append(", oldPwd='").append(oldPwd).append('\'');
        sb.append(", newPwd='").append(newPwd).append('\'');
        sb.append(", confirmPwd='").append(confirmPwd).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
