package org.veight.admin.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.veight.admin.dao.SongDao;
import org.veight.domain.Song;
import org.veight.bean.Pager;
import org.veight.domain.member.Member;
/**
 * 歌曲 DAO实现
 * @author Administrator
 * @时间 2014-5-25 上午12:00:53
 * @开发团队  845885222@qq.com
 */
@Repository
public class SongDaoImpl extends ABaseDaoImpl<Song, String> implements SongDao{

	public Pager getFavoriteSongPager(Member member, Pager pager) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Song.class);
		detachedCriteria.createAlias("favoriteMemberSet", "favoriteMemberSet");
		detachedCriteria.add(Restrictions.eq("favoriteMemberSet.id", member.getId()));
		detachedCriteria.addOrder(Order.desc("name"));
		return findByPager(pager, detachedCriteria);
	}
	
	
}
