package com.cbin.arouterdemo.model.hot

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.cbin.arouterdemo.R
import com.cbin.arouterdemo.router.RouterConstant


@Route(path = RouterConstant.PATH_Hot)
class HotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot)
        Toast.makeText(this, "HotActivity", Toast.LENGTH_SHORT).show()
    }

    fun viewOnClick(v: View) {
        ARouter.getInstance().build(RouterConstant.PATH_User).navigation()
    }
}