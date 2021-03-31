package com.cbin.arouterdemo.bean

/**
 * @author Cbin
 * @CreateDate 2021/3/30
 * @describe
 */

class TestBean {
    var name: String = ""
    var age = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "TestBean(name='$name', age=$age)"
    }


}