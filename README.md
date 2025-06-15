# Study04のプログラムと課題レポート

## それぞれのファイルの構成はいかに示す

- Board.java: 盤のクラス
    - Board(): コンストラクタ
    - isLeagal(): 設置判定
    - isEnd(): 置ける場所がなくなった際の処理
    - isWinning(): どちらかが勝利した際の処理
    - showBoard(): 盤の出力  
- C4.java(): mainクラス
    - ターンによって先手後手を決定し，その他処理はBoard.javaのメソッドに依存している  
- Study04_problem.pdf
    - 問題について記されたPDFファイル  
- out.txt
    - 正解答の出力がここに記させれている
- myout.txt
    - 自身の解答をここに出力している