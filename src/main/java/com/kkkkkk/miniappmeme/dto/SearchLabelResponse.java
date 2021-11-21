package com.kkkkkk.miniappmeme.dto;

import com.kkkkkk.miniappmeme.entity.LabelEsModel;

import java.util.List;

/**
 * @author jennie
 * @create 2021-10-30 23:02
 */
public class SearchLabelResponse {
    private List<LabelEsModel> labelList;

    // private Integer pageNum;

    private Long total;

    // private Integer totalPages;

    public List<LabelEsModel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<LabelEsModel> labelList) {
        this.labelList = labelList;
    }

    // public Integer getPageNum() {
    //     return pageNum;
    // }
    //
    // public void setPageNum(Integer pageNum) {
    //     this.pageNum = pageNum;
    // }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    // public Integer getTotalPages() {
    //     return totalPages;
    // }
    //
    // public void setTotalPages(Integer totalPages) {
    //     this.totalPages = totalPages;
    // }
}
