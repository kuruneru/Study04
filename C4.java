public class C4 {
    static public void main(String[] args) {
		Board b = new Board();

		/* ターンが1であれば先手判定，ターンが2であれば後手判定 */
		while (true) {
			int x = -1, y = -1;
			b.showBoard();

			/* おけるかどうか */
			b.isLegal(x, y);
			
			// 勝敗判定
			if (b.isWinning()) break;
			// 空白判定
			if (b.isEnd()) break;

		}

		b.showBoard();

		/* 最終結果発表 */
		if (b.isEnd()) {
			System.out.println("引き分けです");
		} else if (b.getTurn() == 1) {
			System.out.println("後手が勝ちました");
		} else {
			System.out.println("先手が勝ちました");
		}
	}
}
