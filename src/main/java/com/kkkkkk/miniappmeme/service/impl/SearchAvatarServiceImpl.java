package com.kkkkkk.miniappmeme.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.kkkkkk.miniappmeme.config.EsConstant;
import com.kkkkkk.miniappmeme.dto.SearchLabelResponse;
import com.kkkkkk.miniappmeme.dto.SearchParam;
import com.kkkkkk.miniappmeme.entity.LabelEsModel;
import com.kkkkkk.miniappmeme.service.SearchAvatarService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jennie
 * @create 2021-10-30 23:08
 */
@Service
public class SearchAvatarServiceImpl implements SearchAvatarService {
    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    @Override
    public SearchLabelResponse searchAvatar(SearchParam param){
        SearchLabelResponse labelResponse = new SearchLabelResponse();
        SearchResponse searchResponse = null;

        //动态构建出查询需要的DSL的语句

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (!StringUtil.isEmpty(param.getKeyword())){
            boolQuery.must(QueryBuilders.matchQuery("value", param.getKeyword() ));
        }

        sourceBuilder.query(boolQuery);

        //分页
        // sourceBuilder.from((param.getPageNum() - 1) * EsConstant.PAGE_SIZE);
        // sourceBuilder.size(EsConstant.PAGE_SIZE);

        SearchRequest request = new SearchRequest(new String[] {EsConstant.QUESTION_INDEX}, sourceBuilder);

        try {
        //    执行检索
            searchResponse = client.search(request, RequestOptions.DEFAULT);

        //    分析结果
            System.out.println(searchResponse.toString());
        //    获取查到的数据
            SearchHits hits = searchResponse.getHits();
        //    获取真正命中的结果
            SearchHit[] searchHits = hits.getHits();
        //    遍历命中结果
            List<LabelEsModel> labelEsModelList = new ArrayList<>();
            if (hits.getHits() != null && hits.getHits().length > 0){
                for(SearchHit hit: searchHits) {
                    String hitStr = hit.getSourceAsString();
                    LabelEsModel labelEsModel = JSON.parseObject(hitStr, LabelEsModel.class);
                    System.out.println(labelEsModel);
                    labelEsModelList.add(labelEsModel);
                }
                labelResponse.setLabelList(labelEsModelList);

                long total = hits.getTotalHits().value;
                labelResponse.setTotal(total);
                // labelResponse.setPageNum(param.getPageNum());
                // int totalPages = (int) total % EsConstant.PAGE_SIZE == 0 ? (int) total / EsConstant.PAGE_SIZE : (int) (total / EsConstant.PAGE_SIZE + 1);
                // labelResponse.setTotalPages(totalPages);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return labelResponse;
    }
}
