public class Board {
    public int[][] square;
    public int turn;
    java.util.Random rand = new java.util.Random(0); //乱数は実行毎に同じ結果を得るため, 乱数のseed を0 に設定する
    
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
        /* 置く場所があるまで値を変え続ける */
        do {
            x = rand.nextInt(5);
            y = rand.nextInt(5);
        } while (this.square[y][x] != 0);

        /* もし無いのならfalseを返す */
        if (this.isEnd()) {
            return isEnd();
        }
        
        /* 置ける場所があるのでその場所にそのターンのときのプレイヤーがコマを置く */
        if (this.turn == 1) {
            this.square[y][x] = 1;
            System.out.println("先手は " + x + " " + y + " に置きました");
            this.turn = 2;
            return true;
        } else {
            this.square[y][x] = 2;
            this.turn = 1;
            System.out.println("後手は " + x + " " + y + " に置きました");
            return true;
        }
    }
    // ゲームの終了判定 : 置ける場所がない（勝敗がついた時とは別）
    public boolean isEnd() {

        for (int nx=0; nx<5; nx++) {
            for (int ny=0; ny<5; ny++) {
                /* 置ける場所があるのならfalseを返す */
                if (this.square[ny][nx] == 0) {
                    return false;
                }
            }
        }

        /* すべて探索した後，置ける場所が無いのでtrueが返る */
	    return true;
    }
    // 最後に着手したプレイヤが勝った（4目並べた）か判定
    public boolean isWinning() {

        for (int ny=0; ny<5; ny++) {
            int numx = 0;
            for (int nx=0; nx<5; nx++) {
                if (this.square[ny][nx] == 1) {
                    numx++;
                    /* 4つ並んでいる状態なのでtrueが返る */
                    if (numx == 4) {
                        return true;
                    }
                } else {
                    numx = 0;
                }
            }
        }

        for (int nx=0; nx<5; nx++) {
            int numy = 0;
            for (int ny=0; ny<5; ny++) {
                if (this.square[ny][nx] == 1) {
                    numy++;
                    if (numy == 4) {
                        return true;
                    }
                } else numy = 0;
            }
        }

        /* まだ終わっていないのでfalseを返す */
	    return false;
    }
    
    // 盤面表示
    public void showBoard() {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                switch(this.square[i][j]) {
                case 0: System.out.print("_"); break;
                case 1: System.out.print("o"); break;
                case 2: System.out.print("x"); break;
                }
            }

            System.out.println();
		}
    }
}
