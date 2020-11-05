class Solution {
    public int findString(String[] words, String s) {
        if (words == null || words.length == 0) {
            return -1;
        }
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = mid;

            while (mid <= right && words[mid].equals("")) {
                mid++;
            }
            if (mid == right + 1) {
                right = tmp - 1;
                continue;
            }

            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}