package org.veight.utils;

import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.veight.admin.domain.SongMetaData;
/**
 * 获取MP3的元数据信息
 * @author Administrator
 * @时间 2014-5-24 下午6:57:55
 * @开发团队  845885222@qq.com
 */
public class Mp3Util {
	
	public static void main(String[] args) {
		File mp3File=new File("C:\\BEYOND - 真的爱你.mp3");
		getSongMetaData(mp3File);
	}
	public static SongMetaData getSongMetaData(File mp3File){
		SongMetaData songMetaData=new SongMetaData();
			try {
				AudioFile audioFile = AudioFileIO.read(mp3File);
				AudioHeader audioHeader = audioFile.getAudioHeader();
				
				songMetaData.setPath(mp3File.getPath());
				//头信息
				songMetaData.setMediaType(audioHeader.getEncodingType());
				songMetaData.setFormat(audioHeader.getFormat());
				songMetaData.setBitRate(audioHeader.getBitRateAsNumber());
				songMetaData.setVariableBitRate(audioHeader.isVariableBitRate());
				
				songMetaData.setSize(audioHeader.getTrackLength());
				
				//把时间音轨长度装换成时间显示 ,
				//secs 获取秒
				int secs = audioHeader.getTrackLength() % 60;
				String secondLabel = "" + secs;
				if (secs < 10) {
					secondLabel = "0" + secs;
				}
				//拼接成 3：:54或者3:04秒格式
				String duration = audioHeader.getTrackLength() / 60 + ":" + secondLabel;
				songMetaData.setDuration(duration);
				//TAG信息
				Tag tag = audioFile.getTag();
				//参与创作的艺术家
				String artist = tag.getFirst(FieldKey.ARTIST);
				String artist_sort = tag.getFirst(FieldKey.ARTIST_SORT);
				//唱片集
				String album = tag.getFirst(FieldKey.ALBUM);
				String album_artist = tag.getFirst(FieldKey.ALBUM_ARTIST);
				String album_sort = tag.getFirst(FieldKey.ALBUM_SORT);
				//歌曲名字
				String title = tag.getFirst(FieldKey.TITLE);
				String year = tag.getFirst(FieldKey.YEAR);
				String composer = tag.getFirst(FieldKey.COMPOSER);
				String genre = tag.getFirst(FieldKey.GENRE);
				
				songMetaData.setTitle(new String(title.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setArtist(new String(artist.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setArtistSort(artist_sort);
				songMetaData.setAlbum(new String(album.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setAlbumArtist(new String(album_artist.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setAlbumArtistSort(album_sort);
				songMetaData.setComposer(new String(composer.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setGenre(new String(genre.getBytes("ISO-8859-1"),"gbk"));
				songMetaData.setYear(year.isEmpty()?0:Short.parseShort(year));
				
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return songMetaData;
	}
}
