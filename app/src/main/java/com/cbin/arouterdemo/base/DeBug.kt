package com.cbin.arouterdemo.base

import com.cbin.arouterdemo.BuildConfig


/**
 * @author Cbin
 * @CreateDate 2021/3/30
 * @describe 统一DeBug
 */
object DeBug {

    fun isDeBug(): Boolean {
        return BuildConfig.DEBUG
    }

}