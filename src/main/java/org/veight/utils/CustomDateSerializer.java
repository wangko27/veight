package org.veight.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
/**
 * 过滤json中的时间
 * @author Administrator
 * 时间 ：2014-7-29 下午11:38:14
 */
public class CustomDateSerializer extends JsonSerializer<Date>{
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			String formattedDate = formatter.format(value);
			jgen.writeString(formattedDate); 
		}
}  