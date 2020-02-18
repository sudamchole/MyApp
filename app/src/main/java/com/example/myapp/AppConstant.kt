package com.example.myapp

interface AppConstant {
    object BASE_URL {
        val BASE_URL: String
        get() = "http://192.168.0.44:8089/api/"  //local
    }
};
