public class C4 {
    static public void main(String[] args) {
	java.util.Scanner scan = new java.util.Scanner(System.in);
	java.util.Random rand = new java.util.Random(0); //乱数は実行毎に同じ結果を得るため, 乱数のseed を0 に設定する
	Board b = new Board();
	
	boolean gameEnd = false; // ゲームが終わったか
	boolean hasEmpty = true; // 空きマスがあるか
	while (true) {
	    int x = -1, y = -1;
	    // 先手番（人間）
	    for (int i=0; i<5; i++) {
		for (int j=0; j<5; j++) {
		    switch(b.square[i][j]) {
		    case 0: System.out.print("_"); break;
		    case 1: System.out.print("o"); break;
		    case 2: System.out.print("x"); break;
		    }
		}
		System.out.println();
	    }
	    do {
	    	System.out.print("配置(x, y) を入力してください x(0-4) y(0-4):");
	    	x = scan.nextInt();
	    	y = scan.nextInt();
	    } while (b.square[y][x] != 0);
	    b.square[y][x] = 1;
	    b.turn = 2;
	    System.out.println("先手は " + x + " " + y + " に置きました");
	    
	    // 勝敗判定
	    for (int ny=0; ny<5; ny++) {
		if (gameEnd) break;
		int numx = 0;
		for (int nx=0; nx<5; nx++) {
		    if (b.square[ny][nx] == 1) {
			numx++;
			if (numx == 4) {
			    gameEnd = true;
			    break;
			}
		    } else {
			numx = 0;
		    }
		}
	    }
	    for (int nx=0; nx<5; nx++) {
		if (gameEnd) break;
		int numy = 0;
		for (int ny=0; ny<5; ny++) {
		    if (b.square[ny][nx] == 1) {
			numy++;
			if (numy == 4) {
			    gameEnd = true;
			    break;
			}
		    } else {
			numy = 0;
		    }
		}
	    }
	    if (gameEnd) break;
	    hasEmpty = false;
	    for (int nx=0;nx<5;nx++) {
		if (hasEmpty) break;
		for (int ny=0;ny<5;ny++) {
		    if (b.square[ny][nx] == 0) {
			hasEmpty = true;
			break;
		    }
		}
	    }
	    if (!hasEmpty) break;

	    // 後手番（計算機: ランダム）
	    for (int i=0; i<5; i++) {
		for (int j=0; j<5; j++) {
		    switch(b.square[i][j]) {
		    case 0: System.out.print("_"); break;
		    case 1: System.out.print("o"); break;
		    case 2: System.out.print("x"); break;
		    }
		}
		System.out.println();
	    }

	    do {
	    	x = rand.nextInt(5);
	    	y = rand.nextInt(5);
	    } while (b.square[y][x] != 0);
	    b.square[y][x] = 2;
	    b.turn = 1;
	    System.out.println("後手は " + x + " " + y + " に置きました");

	    for (int ny=0; ny<5; ny++) {
		if (gameEnd) break;
		int numx = 0;
		for (int nx=0; nx<5; nx++) {
		    if (b.square[ny][nx] == 2) {
			numx++;
			if (numx == 4) {
			    gameEnd = true;
			    break;
			}
		    } else {
			numx = 0;
		    }
		}
	    }
	    for (int nx=0; nx<5; nx++) {
		if (gameEnd) break;
		int numy = 0;
		for (int ny=0; ny<5; ny++) {
		    if (b.square[ny][nx] == 2) {
			numy++;
			if (numy == 4) {
			    gameEnd = true;
			    break;
			}
		    } else {
			numy = 0;
		    }
		}
	    }
	    if (gameEnd) break;
	    hasEmpty = false;
	    for (int nx=0;nx<5;nx++) {
		if (hasEmpty) break;
		for (int ny=0;ny<5;ny++) {
		    if (b.square[ny][nx] == 0) {
			hasEmpty = true;
			break;
		    }
		}
	    }
	    if (!hasEmpty) break;

	}
	for (int i=0; i<5; i++) {
	    for (int j=0; j<5; j++) {
		switch(b.square[i][j]) {
		case 0: System.out.print("_"); break;
		case 1: System.out.print("o"); break;
		case 2: System.out.print("x"); break;
		}
	    }
	    System.out.println();
	}

	if (!hasEmpty) {
	    System.out.println("引き分けです");
	} else if (b.turn == 1) {
	    System.out.println("後手が勝ちました");
	} else {
	    System.out.println("先手が勝ちました");
	}
    }
}
