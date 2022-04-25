package com.kkkkkk.miniappmeme.service;

import com.kkkkkk.miniappmeme.entity.Avatar;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author jennie
 * @create 2021-09-02 1:06
 */
public interface AvatarService {
    List<Avatar> allAvatar();

    int addAvatar(Avatar avatar);

    Long avatarOfSrc(String src);

    String srcOfId(Long id);

    List<Avatar> avatarOfCategory(Long id);
}
