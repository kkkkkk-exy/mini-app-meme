package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.Meme;
import org.elasticsearch.client.license.LicensesStatus;

import java.util.List;

/**
 * @author jennie
 * @create 2021-11-13 22:06
 */
public interface MemeService {
    int addMeme(Meme meme);

    Long idOfSrc(String src);

    List<Meme> allMeme();

    String srcOfId(Long id);
}
