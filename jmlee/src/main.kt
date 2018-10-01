import coinChange.Solution

fun main(args: Array<String>) {
    val coins = intArrayOf(186, 419, 83, 408)
    val amount = 6249
    val coinChanger = Solution()
    print("count : ${coinChanger.coinChange(coins, amount)}")
}

