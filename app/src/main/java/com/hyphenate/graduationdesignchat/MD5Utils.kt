package com.hyphenate.graduationdesignchat

import java.security.MessageDigest

/**
 * Created by Scus on 2018/3/16.
 */
class MD5Utils {
    companion object {
        var stringBuffer: StringBuffer = StringBuffer()
        fun md5Password(password: String): String {
            val instance = MessageDigest.getInstance("MD5")
            val digest = instance.digest(password.toByteArray())
            for (b in digest) {
                val i = b.toInt() and 0xff
                var hexString = Integer.toHexString(i)
                if (hexString.length < 2) {
                    hexString = "0" + hexString
                }
                stringBuffer.append(hexString)
            }
            return stringBuffer.toString()
        }
    }
}