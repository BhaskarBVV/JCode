static void solve() {
        long n = sc.nextLong(), x, y = 1, k = sc.nextLong(), a, b, cnt = 0, tcnt;
        HashMap<Long, Long> mp = new HashMap<>();
        for (long i = 0; i < n; i++) {
            x = sc.nextLong();
            if (mp.containsKey(x % k)) {
                long value = mp.get(x % k);
                mp.put(x % k, value + 1);
            } else
                mp.put(x % k, y);
        }
        y = 0;
        if (mp.containsKey(y) == true)
            cnt += (mp.get(y) / 2) * 2;
        Map.Entry<Long, Long> temp;
        Iterator<Map.Entry<Long, Long>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            temp = it.next();
            a = temp.getValue();
            if (mp.containsKey(k - temp.getKey()) == false || temp.getKey() == 0)
                continue;
            if (k - temp.getKey() == temp.getKey()) {
                cnt += (temp.getValue() / 2) * 2;
                mp.put(temp.getKey(), y);
                continue;
            }
            b = mp.get(k - temp.getKey());
            tcnt = Math.min(a, b);
            cnt += tcnt * 2;
            mp.put(temp.getKey(), y);
            mp.put(k - temp.getKey(), y);
        }
        System.out.println(cnt);
    }
