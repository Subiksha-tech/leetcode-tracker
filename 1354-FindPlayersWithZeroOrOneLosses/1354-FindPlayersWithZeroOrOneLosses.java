// Last updated: 09/07/2026, 10:06:35
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {

        Map<Integer, Integer> lossCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lossCount.putIfAbsent(winner, 0);
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : lossCount.keySet()) {
            int losses = lossCount.get(player);

            if (losses == 0)
                zeroLoss.add(player);
            else if (losses == 1)
                oneLoss.add(player);
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLoss);
        ans.add(oneLoss);

        return ans;
    }
}