巨坑，照着官方文档的写的我，一度让我怀疑人生
使用这个 withObject 传递自定  Object 之前一定要配置    JsonServiceImpl

  var data = TestBean("name", 10)
                ARouter.getInstance().build(RouterConstant.PATH_Data)
                    .withString("KEY1", "KEY1")
                    .withInt("KEY2", 1)
                    .withBoolean("KEY3", true)
                    .withObject("KEY4", data)
                    .navigation()
                    
不配置的就传递自定义Object类型的话 就会提示错误

Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.example.admin.aroute.Student.getName()' on a null object reference


//JsonServiceImpl 配置
@Route(path = RouterConstant.SERVICE_Json)
class JsonServiceImpl : SerializationService {
    lateinit var mGson: Gson

    override fun init(context: Context?) {
        mGson = Gson()
    }


    override fun <T : Any?> json2Object(input: String?, clazz: Class<T>?): T {
        checkJson()
        return mGson.fromJson(input, clazz)
    }

    override fun object2Json(instance: Any?): String {
        checkJson();
        return mGson.toJson(instance)
    }


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
