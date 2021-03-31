package com.cbin.arouterdemo.router.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.cbin.arouterdemo.router.RouterConstant
import com.google.gson.Gson
import java.lang.reflect.Type

/**
 * @author Cbin
 * @CreateDate 2021/3/31
 * @describe  想要路由传递自定义的Object 必须配置
 */

//Gson
@Route(path = RouterConstant.SERVICE_Json)
class JsonServiceImpl : SerializationService {
    lateinit var mGson: Gson

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    override fun init(context: Context?) {
        mGson = Gson()
    }

    /**
     * Parse json to object
     *
     * USE @parseObject PLEASE
     *
     * @param input json string
     * @param clazz object type
     * @return instance of object
     */
    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        checkJson()
        return mGson.fromJson(input, clazz)
    }

    /**
     * Object to json
     *
     * @param instance obj
     * @return json string
     */
    override fun object2Json(instance: Any?): String {
        checkJson();
        return mGson.toJson(instance)
    }

    /**
     * Parse json to object
     *
     * @param input json string
     * @param clazz object type
     * @return instance of object
     */
    override fun <T : Any?> parseObject(input: String?, clazz: Type?): T {
        checkJson()
        return mGson.fromJson(input, clazz)
    }

    private fun checkJson() {
        if (mGson == null) {
            mGson = Gson()
        }
    }
}


//fastjson
/*
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {
    @Override
    public void init(Context context) {

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return JSON.toJSONString(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return JSON.parseObject(input, clazz);
    }
}
*/