package coinChange

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0

        val candidates = arrayListOf(amount)
        val bucket = ArrayList<Int>()
        var count = 0
        val retRecord = intArrayOf()
        coins.sortDescending()
        while (candidates.isNotEmpty()) {
            val candidate = candidates.removeAt(0)
            count++
            coins.forEach {coin->
                val theRest = candidate - coin
                if (theRest == 0) return count
                else if (theRest > 0) {
                    bucket.add(theRest)
                }
            }

            bucket.forEach {
                if (!candidates.contains(it)) {
                    candidates.add(it)
                }
            }
            bucket.clear()
            candidates.sortDescending()
        }
        return -1
    }
}