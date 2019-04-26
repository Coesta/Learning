package com.leocoesta.chatbaea.model

data class User (val name: String, val bio: String, val profilePicturePatch: String?){
    constructor(): this("", "", null)
}
