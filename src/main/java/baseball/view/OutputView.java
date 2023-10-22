package baseball.view;

import baseball.model.ScoreBoard;

public class OutputView {
    public static void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder();
        if (scoreBoard.isNothing()) {
            stringBuilder.append("낫싱");
        }
        if (scoreBoard.countBall() > 0) {
            stringBuilder.append(scoreBoard.countBall()).append("볼 ");
        }
        if (scoreBoard.countStrike() > 0) {
            stringBuilder.append(scoreBoard.countStrike()).append("스트라이크");
        }
        System.out.println(stringBuilder);
    }

    public static void gameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

