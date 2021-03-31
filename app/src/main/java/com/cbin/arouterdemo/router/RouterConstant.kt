package com.cbin.arouterdemo.router

/**
 * @author Cbin
 * @CreateDate 2021/3/30
 * @describe 路由路径
 */
object RouterConstant {
    private const val PATH_PACKAGE = "/model"

    const val PATH_Main = "$PATH_PACKAGE/ui/MainActivity"
    const val PATH_User = "$PATH_PACKAGE/ui/UserActivity"
    const val PATH_Hot = "$PATH_PACKAGE/hot/HotActivity"
    const val PATH_Data = "$PATH_PACKAGE/hot/DataActivity"


    /**
     *    Service
     */
    const val SERVICE_Json = "/service/json"
}