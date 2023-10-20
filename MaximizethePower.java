package com.cg.havherrank;

public static int getMaximumPower(List<Integer> arr, List<Integer> power) {
    int n = arr.size();
    int k = power.size();
    int[] powerArray = new int[k];
    for (int i = 0; i < k; i++) {
        powerArray[i] = power.get(i);
    }

    int maxPower = 0;
    int mod = 1_000_000_007;

    for (int i = 0; i < k / 2; i++) {
        int p1 = powerArray[i];
        int p2 = powerArray[k - i - 1];
        if (p1 > p2) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        int sum = 0;
        for (int j = p1; j <= p2; j++) {
            sum += arr.get(j);
        }
        maxPower = (maxPower + sum) % mod;
    }

    return maxPower;
}

}




def getMaximumPower(arr, power):
    power.sort()
    n = len(arr)
    for i in range(1, n):
        arr[i] += arr[i - 1]
    ans = 0
    for i in range(len(power) // 2):
        ans += arr[power[len(power) - i - 1]]
        if power[i] > 0:
            ans -= arr[power[i] - 1]
    return ans % (10 ** 9 + 7)