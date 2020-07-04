package leetcode.problems.array.easy

import java.lang.StringBuilder

class DefangingAnIp {
    fun defangIPaddr(address: String): String {
        val sb = StringBuilder()
        address.forEach {
            if (it == '.') {
                sb.append("[.]")
            } else {
                sb.append(it)
            }
        }
        return sb.toString()
    }

    fun defangIPaddr2(address: String): String {
        return address.replace(".", "[.]")
    }
}