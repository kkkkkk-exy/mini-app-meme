package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.dto.SearchLabelResponse;
import com.kkkkkk.miniappmeme.dto.SearchParam;

/**
 * @author jennie
 * @create 2021-10-30 22:51
 */
public interface SearchAvatarService {
    SearchLabelResponse searchAvatar(SearchParam param);
}
