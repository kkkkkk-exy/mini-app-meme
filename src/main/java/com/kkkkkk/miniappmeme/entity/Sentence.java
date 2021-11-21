package com.kkkkkk.miniappmeme.entity;

import java.util.Date;

public class Sentence {
    private Long id;

    private Date time;

    private Integer countCopy;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCountCopy() {
        return countCopy;
    }

    public void setCountCopy(Integer countCopy) {
        this.countCopy = countCopy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}