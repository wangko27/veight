package org.veight.home.member.service;

import org.veight.admin.service.ABaseService;
import org.veight.domain.member.MemberRank;

/**
 * Service - 会员等级
 */
public interface MemberRankService extends ABaseService<MemberRank, String> {

    /**
     * 判断名称是否存在
     *
     * @param name 名称(忽略大小写)
     * @return 名称是否存在
     */
    public boolean nameExists(String name);

    /**
     * 判断名称是否唯一
     *
     * @param previousName 修改前名称(忽略大小写)
     * @param currentName 当前名称(忽略大小写)
     * @return 名称是否唯一
     */
    public boolean nameUnique(String previousName, String currentName);

    /**
     * 查找默认会员等级
     *
     * @return 默认会员等级，若不存在则返回null
     */
    public MemberRank findDefault();
}
