class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;

        // First pass: find minimum difference
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Second pass: collect pairs with min difference
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}