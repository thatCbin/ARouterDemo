package com.cbin.arouterdemo.base

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter


class MyApplication : Application() {
    companion object {
        val TAG = MyApplication::class.simpleName
        lateinit var instance: MyApplication


    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        instance = this

        initARouter()
    }

    private fun initARouter() {
        //DEBUG模式
        if (DeBug.isDeBug()) {
            Log.d("TAG", "ARouter DeBug TRUE")
            // 打印日志,默认关闭
            ARouter.openLog()
            // 开启调试模式，默认关闭(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
            // 打印日志的时候打印线程堆栈
            ARouter.printStackTrace()
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this)
        Log.d("TAG", "ARouter INIT OVER")
    }


    protected override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //MultiDex
        MultiDex.install(this)
    }

    fun getInstance(): MyApplication? {
        return instance
    }

    fun getAppContext(): Context? {
        return instance.applicationContext
    }

}