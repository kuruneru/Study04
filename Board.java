public class Board {
    public int[][] square;
    public int turn;
    
    Board() {
	square = new int[5][5];
	for (int i=0; i<5; i++) {
	    for (int j=0; j<5; j++) {
		square[i][j] = 0;
	    }
	}
	turn = 1;
    }

    // x,y に置くことができるか
    public boolean isLegal(int x, int y) {
	return false;
    }
    // ゲームの終了判定 : 置ける場所がない（勝敗がついた時とは別）
    public boolean isEnd() {
	return false;
    }
    // 最後に着手したプレイヤが勝った（4目並べた）か判定
    public boolean isWinning() {
	return false;
    }
    
    // 盤面表示
    public void showBoard() {
    }
}
