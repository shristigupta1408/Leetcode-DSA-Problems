class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int index = stack.pop();
                int currentHeight = heights[index];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, 
                    currentHeight * currentWidth);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, 
                    currentHeight * currentWidth);
        }

        return maxArea;
    }
}