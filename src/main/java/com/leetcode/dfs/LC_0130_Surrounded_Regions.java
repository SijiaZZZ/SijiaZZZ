package com.leetcode.dfs;

/**
 * Time Complexity: O(N) N is the grid size
 * <p>
 * Space Complexity: O(M) - N is grid size
 * <p>
 * Hints:
 * <p> 1. Same idea as the 1254 but instead of counting the numbers, we need to flip the cell
 * <p> 2. So the idea is to first use do dfs for 4 boundary to find those no surrounded regions
 * <p> 3. the go through the board to clean
 */

public class LC_0130_Surrounded_Regions {
    // start from border to flip mark the board as "#"
    // then scan the entire board find any o to flip
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = '#'; // mark visited;
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
