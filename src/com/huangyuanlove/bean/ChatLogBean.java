package com.huangyuanlove.bean;

/**
 * Created by huangyuan on 16-2-13.
 */
public class ChatLogBean {

    private String UUID;
    private String content;

    public String getUserid() {
        return UUID;
    }

    public void setUserid(String UUID) {
        this.UUID = UUID;
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
                "UUID='" + UUID + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
