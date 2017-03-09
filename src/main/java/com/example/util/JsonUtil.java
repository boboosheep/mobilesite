package com.example.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by WeiZheng on 2015/9/25.
 */
public class JsonUtil {
    private final static ObjectMapper objectMapper;
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    static {
        objectMapper = new ObjectMapper();
        //去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //设置时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        //空值不序列化
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        //序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //单引号处理
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    private JsonUtil() {
    }


    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * JSON串转换为Java泛型对象，可以是各种类型，此方法最为强大。用法看测试用例。
     *
     * @param <T>
     * @param jsonString JSON字符串
     * @param tr         TypeReference,例如: new TypeReference< List<FamousUser> >(){}
     * @return List对象列表
     */
    @SuppressWarnings("unchecked")
    public static <T> T jsonToGenericObject(String jsonString,
                                            TypeReference<T> tr) {

        if (jsonString == null || "".equals(jsonString)) {
            return null;
        } else {
            try {
                return (T) objectMapper.readValue(jsonString, tr);
            } catch (Exception e) {
                log.error("json error:" + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Java对象转Json字符串
     */
    public static String toJson(Object object) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.warn("json error:" + e.getMessage());
        }
        return jsonString;

    }

    /**
     * Json字符串转Java对象
     */
    public static <T> T jsonToObject(String jsonString, Class<T> c) {

        if (jsonString == null || "".equals(jsonString)) {
            return null;
        } else {
            try {
                return objectMapper.readValue(jsonString, c);
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }

        }
        return null;
    }

    public static final class IosDateTimeJsonSerializer extends JsonSerializer<Date> {

        @Override
        public void serialize(Date value, JsonGenerator paramJsonGenerator, SerializerProvider provider) throws IOException {
            if (value != null) {
                paramJsonGenerator.writeString(FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss").format(value));
            }
        }

    }

}
