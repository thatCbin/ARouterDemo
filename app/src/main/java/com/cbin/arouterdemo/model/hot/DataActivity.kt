package com.cbin.arouterdemo.model.hot

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.cbin.arouterdemo.R
import com.cbin.arouterdemo.bean.TestBean
import com.cbin.arouterdemo.router.RouterConstant
import java.util.*


@Route(path = RouterConstant.PATH_Data)
class DataActivity : AppCompatActivity() {
    @Autowired
    @JvmField
    var KEY1: String? = null

    @Autowired
    @JvmField
    var KEY2: Int = 0

    @Autowired
    @JvmField
    var KEY3: Boolean = false

    @Autowired
    @JvmField
    var KEY4: TestBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)  // Start auto inject.
        super.onCreate(savedInstanceState)

        var transferData = "KEY1 =$KEY1  KEY2=$KEY2   KEY3=$KEY3  KEY4=${KEY4.toString()}"

        setContentView(R.layout.activity_data)
        Toast.makeText(this, transferData, Toast.LENGTH_SHORT).show()
        Log.e("TAG", transferData)

    }

}