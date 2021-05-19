package com.dev04.client.viewObject;

import retrofit2.Callback;

public class ArticleVO {
    private int no;
    private String title;
    private String writerId;
    private String writerName;
    private String content;
    private String regDate;
    private int readCnt;

    public ArticleVO(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getWriterId() {
        return writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getContent() {
        return content;
    }

    public String getRegDate() {
        return regDate;
    }

    public int getReadCnt() {
        return readCnt;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setReadCnt(int readCnt) {
        this.readCnt = readCnt;
    }
}
