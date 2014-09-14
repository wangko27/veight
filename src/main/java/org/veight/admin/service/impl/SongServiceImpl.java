package org.veight.admin.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.veight.admin.dao.SongDao;
import org.veight.admin.domain.Song;
import org.veight.admin.service.SongService;
import org.veight.bean.Pager;
import org.veight.member.domain.Member;

/**
 * 歌曲Servie 实现
 * @author Administrator
 * @author Administrator
 * @开发团队  845885222@qq.com
 */
@Service
public class SongServiceImpl extends ABaseServiceImpl<Song, String> implements SongService {

	@Resource
	SongDao songDao;
	
	@Resource
	public void setBaseDao(SongDao songDao) {
		super.setBaseDao(songDao);
	}

	public Pager getFavoriteSongPager(Member member, Pager pager) {
		return songDao.getFavoriteSongPager(member,pager);
	}
}
