
class Result {

    public static int getMinIterations(List<Integer> arr) {
        int n = arr.size();
        List<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int it = Collections.binarySearch(lis, arr.get(i));
            if (it < 0) {
                it = -(it + 1);
            }
            
            if (it == lis.size()) {
                lis.add(arr.get(i));
            } else {
                lis.set(it, arr.get(i));
            }
        }
        
        return (n - lis.size() + 1) / 2;
    }
}




from bisect import bisect_right

def getMinIterations(arr):
    n = len(arr)
    lis = []
    for i in range(n):
        it = bisect_right(lis, arr[i])
        if it == len(lis):
            lis.append(arr[i])
        else:
            lis[it] = arr[i]
    return (n - len(lis) + 1) // 2
