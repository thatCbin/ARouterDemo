package com.cbin.arouterdemo.model.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.cbin.arouterdemo.R
import com.cbin.arouterdemo.bean.TestBean
import com.cbin.arouterdemo.router.RouterConstant
import java.lang.Exception

@Route(path = RouterConstant.PATH_Main)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show()
    }

    fun viewOnClick(v: View) {

        Toast.makeText(this, v.id.toString(), Toast.LENGTH_SHORT).show()
        when (v.id) {
            R.id.btn_1 -> {
                ARouter.getInstance().build(RouterConstant.PATH_Hot).navigation()
            }

            R.id.btn_2 -> {
                var data = TestBean("name", 10)
                ARouter.getInstance().build(RouterConstant.PATH_Data)
                    .withString("KEY1", "KEY1")
                    .withInt("KEY2", 1)
                    .withBoolean("KEY3", true)
                    .withObject("KEY4", data)
                    .navigation()
            }
            else -> null

        }


    }
}