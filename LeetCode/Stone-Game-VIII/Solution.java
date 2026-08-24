// Swift
func stoneGameVIII(_ stones: [Int]) -> Int {
    let n = stones.count
    var sum = stones.reduce(0, +)
    var currMax = sum
    for i in (1 ..< n - 1).reversed() {
        sum -= stones[i + 1]
        currMax = max(currMax, sum - currMax)
    }

    return currMax
}