package Search2DMatrix

class Solution {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        matrix.forEach {
            if (it.promising(target) && it.contains(target)) return true
        }
        return false
    }

}

fun IntArray.promising(target: Int): Boolean {
    if (isEmpty()) return false
    return target in first() .. last()
}

fun IntArray.contains(target: Int): Boolean {
    if (isEmpty()) return false
    forEach {
        if (target == it) return true
    }
    return false
}
