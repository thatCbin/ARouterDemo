#Kotlin 实现的 阿里路由Domo

##使用这个 withObject 传递自定 Object 之前一定要配置 JsonServiceImpl
    
    var data = TestBean("name", 10)
    ARouter.getInstance().build(RouterConstant.PATH_Data)
    	.withString("KEY1", "KEY1")
    	.withInt("KEY2", 1)
    	.withBoolean("KEY3", true)
    	.withObject("KEY4", data)
    	.navigation()

##不配置的就传递自定义Object类型的话 就会提示错误

    Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.example.admin.aroute.Student.getName()' on a null object reference

## 注意修改点 object类数据 举起参考TestBean类

1、java的话 将用到的属性都从private改成public(kotlin就没这烦恼)；

2、没有默认构造的都加上默认构造；

3、如果要传递object类数据里面还包含了其他对象，其他对象也按照Student类的标准；

##JsonServiceImpl 配置

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
