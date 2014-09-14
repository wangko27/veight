package org.veight.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * 歌曲播放列表 普通bean
 * @author Administrator
 * @时间 2014-6-23 下午11:09:08
 * @开发团队  845885222@qq.com
 */
public class Mp3Player{
	static Logger logger = Logger.getLogger(Mp3Player.class.getName());
	public final static String PLAYER_LIST_SESSION_ID="payler_list_session_id";
	private List<String> playerList;
	
	public Mp3Player() {
		playerList = new ArrayList<String>();
	}
	//添加
	public void put (String id) {
		//没有包含此id的歌曲 才添加
		if(!contains(id)){
			playerList.add(id);
		}
	}

	//移除
	public void remove (String id) {
		for (String key : playerList) {
			if (key.equalsIgnoreCase(id)) {
				playerList.remove(key);
			}
		}
	}
	//判断是否已添加
	public boolean contains (String id) {
		for (String key : playerList) {
			if (key.equalsIgnoreCase(id)) {
				//下面的消息将被输出
				logger.info("已添加了[id:"+id+"]该歌曲到播放列表");
				return true;
			}
		}
		return false;
	}
	//清空播放列表
	public void clear () {
		logger.info("清空播放列表");
		playerList.clear();
	}
	//播放列表歌曲数
	public int size() {
		return playerList.size();
	}

	//setter adn getter
	public List<String> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<String> playerList) {
		this.playerList = playerList;
	}

}
