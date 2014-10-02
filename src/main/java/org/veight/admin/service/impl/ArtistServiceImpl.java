package org.veight.admin.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.veight.admin.dao.ArtistDao;
import org.veight.domain.Artist;
import org.veight.admin.service.ArtistService;
/**
 * service实现 歌手(乐队)
 * @author Administrator
 * @时间 2014-5-25 下午7:14:34
 * @开发团队  845885222@qq.com
 */
@Service
public class ArtistServiceImpl extends ABaseServiceImpl<Artist, String> implements ArtistService {
	@Resource
	private ArtistDao artistDao;
	
	@Resource
	public void setBaseDao(ArtistDao artistDao) {
		super.setBaseDao(artistDao);
	}
}
