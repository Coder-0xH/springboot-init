package com.zero.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sonata
 * gson工具类
 */
public class GsonUtil implements JsonSerializer<String>, JsonDeserializer<String> {
    static GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }

    public static <T> T jsonStrToObject(String json, Class<T> cls) {
        return getGson().fromJson(json, cls);
    }

    /**
     * 字符串转多选
     *
     * @param json json字符串
     * @param type 泛型
     * @return
     * @param <T>
     */
    public static <T> T jsonStrToObject(String json, Type type) {
        return getGson().fromJson(json, type);
    }

    /**
     * 对象转json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String toJsonStr(Object object) {
        return getGson().toJson(object);
    }

    /**
     * 字符串转JsonObject
     *
     * @param jsonStr 字符串
     * @return JsonObject
     */
    public static JsonObject toJsonObject(String jsonStr){
        return getGson().fromJson(jsonStr, JsonElement.class).getAsJsonObject();
    }

    /**
     * json字符串转list
     *
     * @param gsonString 字符串
     * @param cls 对象类型
     * @return
     * @param <T>
     */
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
            //根据泛型返回解析指定的类型,TypeToken<List<T>>{}.getType()获取返回类型
            list = getGson().fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        return list;
    }

    /**
     * @param json
     * @param clazz
     * @return
     */
    public static <T> List<T> jsonToArrayList(String json, Class<T> clazz) {
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new GsonUtil());
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        List<JsonObject> jsonObjects = gb.create().fromJson(json, type);
        List<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.getAsJsonPrimitive().getAsString();
    }

    @Override
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src);
        }
    }
}
