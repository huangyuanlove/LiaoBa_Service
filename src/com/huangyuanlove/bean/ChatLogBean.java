package com.huangyuanlove.bean;

/**
 * Created by huangyuan on 16-2-13.
 */
public class ChatLogBean {

    private String userid;
    private String content;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "ChatLogBean{" +
                "userid='" + userid + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
