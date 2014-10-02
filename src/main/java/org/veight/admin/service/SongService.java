package org.veight.admin.service;

import org.veight.domain.Song;
import org.veight.bean.Pager;
import org.veight.domain.member.Member;

/**
 * 接口 歌曲Service
 * @author Administrator
 * @时间 2014-5-24 下午11:54:57
 * @开发团队  845885222@qq.com
 */
public interface SongService extends ABaseService<Song, String> {
	/**
	 * 根据Member、Pager获取收藏歌曲分页对象
	 * @param member
	 * 			会员实例
	 * @param pager
	 * 			分页
	 * @return 收藏歌曲分页对象
	 */
	public Pager getFavoriteSongPager(Member member,Pager pager);
}
