package woowacourseTest.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCar {
    static private List<ArrayList<String>> listOfLists = new ArrayList<>();
    static private int NumberOfTime;
    static private String input;

    //1. 문자열을 입력 받는 기능
    //2. 문자열이 잘 들어왔는지 확인하는 기능 ( ,로 구분하지 않은 경우와 이름이 5자를 초과한 경우)
    public void run() throws IOException {
        input = inputParticipant();
        validateInput(input);
        NumberOfTime = inputNumberOfTime();
        divideParticipant(input);
        outputParticipant();
    }

    public String inputParticipant() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public int inputNumberOfTime() throws IOException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public boolean validateInput(String input) {
        String regex = "^\\w{1,5}(,\\w{1,5})*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어있습니다.");
        }
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 형식입니다. 쉼표로 구분된 1-5자의 단어만 허용됩니다.");
        }
        return true;
    }

    public void divideParticipant(String input) {
        for (String item : input.split(",")) {
            ArrayList<String> singleList = new ArrayList<>();
            singleList.add(item.trim()); // 공백 제거 후 개별 ArrayList에 추가
            singleList.add(" : ");//형식 맞추기
            listOfLists.add(singleList); // 리스트에 ArrayList 추가
        }
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(0, 9);
    }

    public void move() {
        for (ArrayList<String> list : listOfLists) {
            if (randomNumber() >= 4) {
                list.add("-");
            }
        }
    }

    private void printParticipant(ArrayList<String> list) { //현재 진행상황을 알려주는 메소드
        if (list.size() - 2 < NumberOfTime) {
            for (String item : list) {
                System.out.print(item);
            }
            System.out.println();
        } else {
            System.out.print(list.get(0));
        }
    }

    public void outputParticipant() {
        for (int i = 0; i < NumberOfTime; i++) {  // 시도 횟수만큼 반복
            move();
            for (ArrayList<String> list : listOfLists) {
                printParticipant(list);
            }
            System.out.println();  // 각 라운드 사이에 빈 줄 추가
        }
        printWinner();  // 선택적: 최종 우승자 출력
    }

    private void printWinner() {
        StringBuilder winner = new StringBuilder();
        int maxSize = 0;
        for (ArrayList<String> list : listOfLists) {
            if (list.size() > maxSize) {
                maxSize = list.size();
            }
        }
        for (ArrayList<String> list : listOfLists) {
            if (list.size() == maxSize) {
                if (winner.isEmpty()) {
                    winner.append(list.get(0));
                } else {
                    winner.append("," + list.get(0));
                }
            }
        }
        System.out.println("최종 우승자 : " + winner);
    }


}
