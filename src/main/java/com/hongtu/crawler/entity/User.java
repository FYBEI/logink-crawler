package com.hongtu.crawler.entity;

public class User {

    private String username;
    private String passward;
    private String secret_code;

    public enum LOGIN_USER_TYPE{
        NOCCUSER("noccuser", "01"),
        ADMIN("admin", "02");

        private String key;
        private String value;

        LOGIN_USER_TYPE(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey(){return this.key;}

        public String getValue(){return this.value;}
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getSecret_code() {
        return secret_code;
    }

    public void setSecret_code(String secret_code) {
        this.secret_code = secret_code;
    }

}
