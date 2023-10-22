package baseball.model;

import baseball.NumberLimits;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final List<Integer> userNumberList;

    public User(String userNumber) {
        userNumberList = new ArrayList<>();
        String[] userNumberArray = userNumber.split("");
        for (String str : userNumberArray) {
            try {
                userNumberList.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                // 예외 처리: 유효하지 않은 숫자 형식의 문자열일 경우
                throw new IllegalArgumentException("[ERROR] : 잘못된 값이 입력되었습니다.");
            }
        }
        validateInput();
    }

    private void validateInput() {
        //set을 이용한 중복검사
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(userNumberList);
        if (userNumberList.size() > NumberLimits.NUM_LIST_LENGTH.getValue()
                || userNumberList.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] : 숫자를 3개 입력해 주세요.");
        }
        for (Integer num : userNumberList) {
            if (num < NumberLimits.MIN_VALUE.getValue() || num > NumberLimits.MAX_VALUE.getValue()) {
                throw new IllegalArgumentException("[ERROR] : 1에서 9 사이의 숫자만 입력해주세요.");
            }
        }
        if (set.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] : 중복되지 않은 숫자를 입력해주세요.");
        }
    }

    public List<Integer> getUserNumberList() {
        return userNumberList;
    }

}
