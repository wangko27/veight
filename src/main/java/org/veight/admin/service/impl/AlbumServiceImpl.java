package org.veight.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.veight.admin.dao.AlbumDao;
import org.veight.domain.Album;
import org.veight.admin.service.AlbumService;
/**
 * 专辑 服务实现
 * @author Administrator
 * 时间 ：2014-8-19 下午07:55:29
 */
@Service
public class AlbumServiceImpl extends ABaseServiceImpl<Album, String> implements AlbumService {
	@Resource
	AlbumDao albumDao;
	
	@Resource
	public void setBaseDao(AlbumDao albumDao) {
		super.setBaseDao(albumDao);
	}
}
