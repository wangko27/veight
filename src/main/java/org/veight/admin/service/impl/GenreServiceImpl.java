package org.veight.admin.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.veight.admin.dao.GenreDao;
import org.veight.domain.Genre;
import org.veight.admin.service.GenreService;

/**
 * 歌曲分类 Servie 实现
 * @author Administrator
 * @时间 2014-6-1 上午10:57:01
 * @开发团队  845885222@qq.com
 */
@Service
public class GenreServiceImpl extends ABaseServiceImpl<Genre, String> implements GenreService {

	@Resource
	GenreDao genreDao;
	
	@Resource
	public void setBaseDao(GenreDao genreDao) {
		super.setBaseDao(genreDao);
	}
}
