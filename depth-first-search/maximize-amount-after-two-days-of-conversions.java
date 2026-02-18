class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        
        Map<String, Double> dist1 = bfs(initialCurrency, pairs1, rates1);//Currency, rate
        Map<String, Double> dist2 = bfs(initialCurrency, pairs2, rates2);
        double res = 1.0;
        for (String currency : dist1.keySet()) {//EUR：1  USD：2  JPY：6  
            if (dist2.containsKey(currency)) {//EUR:1, CHF:1/6  usd: 1/30 JPY:1/120
                double rate1 = dist1.get(currency);
                double rate2 = dist2.get(currency);
                res = Math.max(res, rate1* (1/rate2));
            }
        }
        return res;
    }

    private Map<String, Double> bfs(String initialCurrency, List<List<String>> pairs, double[] rates){
        Map<String, List<Object[]>> map = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String start = pairs.get(i).get(0);
            String target = pairs.get(i).get(1);
            double rate = rates[i];
            map.computeIfAbsent(start, x -> new ArrayList<>()).add(new Object[]{target, rate});
            map.computeIfAbsent(target, x -> new ArrayList<>()).add(new Object[]{start, 1.0/rate});
        }
        // BFS 遍历，dist 同时充当访问标记
        Map<String, Double> dist = new HashMap<>();//currency,   maximum amount of initialCurrency
        dist.put(initialCurrency, 1.0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(initialCurrency);//重点！

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (Object[] edge : map.getOrDefault(cur, List.of())){
                String next = (String) edge[0];
                double rate = (double) edge[1];
                if (!dist.containsKey(next)) {
                    dist.put(next, dist.get(cur) * rate);
                    queue.offer(next);
                }
            }
        }
        return dist;
    }
}

