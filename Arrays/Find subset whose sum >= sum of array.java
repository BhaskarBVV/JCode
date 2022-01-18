public static Boolean check(long s, long e, long[] a, long sum) {
        long end = s, start = s, tsum = 0;
        while (end < e && tsum < sum) {
            tsum += a[(int) end];
            end += 1;
        }
        if (tsum >= sum) {
            return true;
        }
        while (start < e && tsum < sum) {
            tsum -= a[(int) start];
            start += 1;
        }
        if (tsum >= sum) {
            return true;
        }
        return false;
    }


// sum is the sum of entire array.
// tsum will be the sum of subset array..
