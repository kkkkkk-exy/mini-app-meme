package com.kkkkkk.miniappmeme.dto;

/**
 * @author jennie
 * @create 2021-10-30 22:48
 */
public class SearchParam {
    private String keyword;
    private Integer pageNum;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
