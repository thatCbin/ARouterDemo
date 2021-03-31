package com.cbin.arouterdemo.model.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.cbin.arouterdemo.R
import com.cbin.arouterdemo.router.RouterConstant

@Route(path = RouterConstant.PATH_User)
class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        Toast.makeText(this, "UserActivity", Toast.LENGTH_SHORT).show()
    }

    fun viewOnClick(v: View) {
        Toast.makeText(this, "BBBBBBBBBBB", Toast.LENGTH_SHORT).show()
    }
}