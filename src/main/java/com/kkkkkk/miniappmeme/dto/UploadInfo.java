package com.kkkkkk.miniappmeme.dto;

/**
 * @author jennie
 * @create 2021-09-28 22:03
 */
public class UploadInfo {
    Long categoryId;
    String[] imageList;
    Long[] labels;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getImageList() {
        return imageList;
    }

    public void setImageList(String[] imageList) {
        this.imageList = imageList;
    }

    public Long[] getLabels() {
        return labels;
    }

    public void setLabels(Long[] labels) {
        this.labels = labels;
    }
}
