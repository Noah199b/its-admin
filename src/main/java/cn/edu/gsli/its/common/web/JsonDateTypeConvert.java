package cn.edu.gsli.its.common.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
/**springmvc 在将日期对象转换为字符串�?,
 * �?般默认会转换为长整型,假如我们�?要自�?
 * 定义格式,通常会写�?个类继承JsonSerializer,\
 * 假如在对象中�?要将日期转换为我们需要的格式
 * 可以在对应的实体对象的get方法中使�?
 * @JsonSerializer(using=
 * JsonDateTypeConvert.class)
 * */
public class JsonDateTypeConvert 
     extends JsonSerializer<Date>{
	/**
	 * @param value 是要转换的日�?
	 * @param gen 为一个json对象生成�?
	 * */
	@Override
	public void serialize(Date value,
			JsonGenerator gen, 
			SerializerProvider serializers)
			throws IOException, 
			JsonProcessingException {
		//定义日期字符串转换对�?
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy/MM/dd");
		//将日期转换为指定格式字符�?
		String dateStr=sdf.format(value);
		//将此字符串写入到json对象�?
		gen.writeString(dateStr);
	}//alt+/
}//
