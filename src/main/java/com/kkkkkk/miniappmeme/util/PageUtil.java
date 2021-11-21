package com.kkkkkk.miniappmeme.util;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-12 15:50
 */
public class PageUtil {
    // pageNum页码
    // pageSize每页多少条数据
    public static List startPage(List list, Integer pageNum, Integer pageSize){
        if (list == null){
            return null;
        }
        if (list.size() == 0){
            return null;
        }

        Integer totalCount = list.size(); //记录总数
        Integer pageCount = 0;            //总页数
        if (totalCount % pageSize == 0){
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }

        int fromIndex = 0;  //开始索引
        int toIndex = 0;

        if (pageNum > pageCount){
            pageNum = pageCount;
        }
        fromIndex = (pageNum - 1) * pageSize;
        if (!pageNum.equals(pageCount)){
            toIndex = fromIndex + pageSize;
        } else {
            toIndex = totalCount;
        }

        List pageList = list.subList(fromIndex, toIndex);

        return pageList;
    }
}
