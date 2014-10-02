package org.veight.admin.dao;

import org.veight.domain.Song;
import org.veight.bean.Pager;

import org.veight.domain.member.Member;
/**
 * 歌曲 DAO
 * @author Administrator
 * @时间 2014-5-24 下午11:58:36
 * @开发团队  845885222@qq.com
 * @时间 2014-6-30 下午10:45:24 修改 ：添加了获取用户的收藏歌曲
 */

public interface SongDao extends ABaseDao<Song, String> {
	/**
	 * 
	 * @param member
	 * 根据Member、Pager获取收藏歌曲分页对象
	 * @param pager
	 * @return 会员的歌曲收藏分页对象
	 */
	public Pager getFavoriteSongPager(Member member,Pager pager);
}
