package lotto;

import java.util.*;

public class Manager {
    public enum Hi {
        THREE("3개 일치 (5,000원)"),
        FOUR("4개 일치 (50,000원)"),
        FIVE("5개 일치 (1,500,000원)"),
        BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
        SIX("6개 일치 (2,000,000,000원)");

        final private String hi;

        private String getHi() {
            return hi;
        }

        Hi(String hi) {
            this.hi = hi;
        }
    }

    public enum Bye {
        ONE(5000),
        TWO(50000),
        THREE(1500000),
        FOUR(30000000),
        FIVE(2000000000);

        final private int bye;

        private int getBye() {
            return bye;
        }

        Bye(int bye) {
            this.bye = bye;
        }
    }

    private int myMoney = 0;


    public void inputWinNumbers(List<List<Integer>> numbers, List<Integer> winNumber, int bonusBall) {
        int count = 0;
        myMoney = numbers.size(); // 내가 입력한 금액 ( 8000 )
        Map<String, Integer> winner = new LinkedHashMap<>();
        List<Integer> mapValue = new ArrayList<>();
        Map<String, Integer> mapTest = new LinkedHashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (numbers.get(i).contains(winNumber.get(j))) {
//                    System.out.println("numbers.get(i) = " + numbers.get(i));
                    winner.put(numbers.get(i).toString(), winner.getOrDefault(numbers.get(i).toString(), count) + 1);
                }
            }
        } // 랜덤 로또값이랑 내가 입력한 번호랑 몇 개가 같은지 구하는 Map
        
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i).contains(bonusBall)) {
                System.out.println("bonus = " + numbers.get(i));
            }
        }
        
        for (String s : winner.keySet()) {
            System.out.print("s = " + s + " ");
            System.out.print("/ winner = " + winner.get(s) + "개 일치");
            System.out.println();
            if (winner.get(s) >= 3) {
                mapValue.add(winner.get(s));
            }
        } // 3개 이상 맞 춘 것만 따로 모오는 과정
        Collections.sort(mapValue);
        if (mapValue.size() == 0) {
            mapTest.put("3", 0);
        }



        for (Integer integer : mapValue) {
            mapTest.put("" + integer, mapTest.getOrDefault("" + integer, 0) + 1);
        } // 3개 이상 맞춘 것만 정렬해서 출력후 몇 장인지 구하는 과정
        System.out.println("********************************");
        for (String s : mapTest.keySet()) {
            System.out.println("s는 몇 개 일치해 ? : "+s);
            System.out.println("s일치하는 것 중 총 갯수는 몇 개야? : "+mapTest.get(s));
        } 
        List<Integer> moneyTest = new ArrayList<>(); // enum을 이용해서 차례대로 출력하는 것을 비교해서 뒤에 -개수 붙임
        for (Hi value : Hi.values()) {
            System.out.print(value.getHi());
            for (String s : mapTest.keySet()) {
                if (value.getHi().substring(0, 1).equals(s)) {
                    System.out.print(" - " + mapTest.get(s) + "개");
                    moneyTest.add(mapTest.get(s));
                } else if (!(value.getHi().substring(0, 1).equals(s))) {
                    System.out.print(" - 0개");
                    moneyTest.add(0);
                }
            }
            System.out.println();
        }
        System.out.println("***********수익률 구하기**************");
//        for (Integer integer : moneyTest) {
//            System.out.println("moneyTest " + integer);
//        }
        calculateMoney(myMoney, moneyTest);
    }

    public void calculateMoney(int myMoney, List<Integer> winMoney) {
        myMoney = myMoney * 1000;
        System.out.println("myMoney = " + myMoney);
        Map<String, Integer> mapMoney = new LinkedHashMap<>();

        int count = 0;
        int total = 0;
        for (Bye value : Bye.values()) {
            System.out.println("value.getBye() = " + value.getBye());
            for (int i = count; i < winMoney.size(); i++) {
                System.out.println("winMoney = " + winMoney.get(i));
                count++;
                total += value.getBye() * winMoney.get(i);
                break;
            }
        }
        System.out.println("total = " + total);
        double add = ((double) total / myMoney * 100);
        System.out.println("총 수익률은 " + add + "%입니다.");
    }

    public void inputBonusNumber() {

    }
}
