package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
//        System.out.println(Manager.Hi.valueOf("THREE").getHi());
//        Manager.Hi[] hi = Manager.Hi.values();
//        for (Manager.Hi hi1 : hi) {
//            System.out.println(hi1.name());
//        }
        int count = Integer.parseInt(Console.readLine());
        System.out.println((count/1000)+"개를 구매했습니다.");
//        test t = new test(count);
//        List<Integer> zz = t.getNumbers();
//        Collections.sort(zz);
//        System.out.println(zz);
//        System.out.println(zz);
//        System.out.println("[8, 21, 23, 41, 42, 43]");
//        System.out.println("[3, 5, 11, 16, 32, 38]");
//        System.out.println("[7, 11, 16, 35, 36, 44]");
//        System.out.println("[1, 8, 11, 31, 41, 42]");
//        System.out.println("[13, 14, 16, 38, 42, 45]");
//        System.out.println("[7, 11, 30, 40, 42, 43]");
//        System.out.println("[2, 13, 22, 32, 38, 45]");
//        System.out.println("[1, 3, 5, 14, 22, 45]");
//        System.out.println("3개 일치 (5,000원) - 1개");
//        System.out.println("4개 일치 (50,000원) - 0개");
//        System.out.println("5개 일치 (1,500,000원) - 0개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
//        System.out.println("6개 일치 (2,000,000,000원) - 0개");
//        System.out.println("총 수익률은 62.5%입니다.");


        LottoNumbers lottoNumbers = new LottoNumbers(count);

        List<List<Integer>> test = lottoNumbers.getNumbers();
        for (List<Integer> integers : test) {
            System.out.println("integers = " + integers);
        }


//
//
        System.out.println("당첨 번호를 입력해주세요.");
        String[] str = new String[6];
        str = Console.readLine().split(",");
        List<Integer> basket = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            basket.add(Integer.parseInt(str[i]));
        }
        Lotto lotto = new Lotto(basket);
        System.out.println("보너스 번호를 입력해주세요.");
        int num2 = Integer.parseInt(Console.readLine());


        Manager manager = new Manager();
        manager.inputWinNumbers(test, basket);
    } ///
//    private enum Hi {
//        ONE("1개일치"),
//        THREE("3개일치"),
//        FOUR("4개일치"),
//        FIVE("5개일치");
//
//        private String hi;
//
//
//        Hi(String hi) {
//            this.hi = hi;
//        }
//
//        public String getHi() {
//            return hi;
//        }
//    }
}
