package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static String amount;
    private static String[] basket;
    private static List<Integer> winNumber;
    private static int bonusBall;
    private static List<List<Integer>> randomLottoNumbers;

    public LottoGame() {
        amount = "";
        basket = new String[6];
        winNumber = new ArrayList<>();
        bonusBall = 0;
        randomLottoNumbers = new ArrayList<>();
    }

    public void startGame() {
        try {
            buyLotto();
            createNumbers();
            compareLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 로또를 얼마나 살 건지?
    private void buyLotto() {
        payMoney();
        createLotto(amount);
        for (List<Integer> randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber); // 함수화 시키자
        }
    }
    
    // 몇 천원어치 살 꺼야?
    private void payMoney() {
        Message.printMoneyMessage();
        amount = Console.readLine();
        PurchaseException.validatePurchaseAmount(amount);
//        if (amount.length() != 4) {
//            throw new IllegalArgumentException("[ERROR]");
//        } // 클래스 만들어서 리팩토링 해야 됨
        int lottoCount = Integer.parseInt(amount) / 1000;
        Message.printPurchaseMessage(lottoCount);
    }
    
    // 내가 입력한 금액에 맞게 로또 생성
    private void createLotto(String amount) {
        LottoRandomNumbers lottoRandomNumbers = new LottoRandomNumbers(amount); // 구입 금액을 기반으로 ~장 생성
        randomLottoNumbers = lottoRandomNumbers.getNumbers(); // 생선된 랜덤 로또값들을 List<List<Integer>>에 get을 이용해 저장
    }
    ////////////////////////////////////////////////////////////////////////

    // 승리, 보너스 숫자를 입력하는 메서드
    private void createNumbers() {
        createWinNumber();
        createBonusNumber();
    }

    // 승리 숫자가 입력하는 메서드,
    private void createWinNumber() {
        Message.printWinNumber();
        basket = Console.readLine().split(",");
        for (int i = 0; i < basket.length; i++) {
            winNumber.add(Integer.parseInt(basket[i]));
        }
        Lotto lotto = new Lotto(winNumber); // Exception 체큰
    }

    // 보너스 번호 입력하는 메서드
    private void createBonusNumber() {
        Message.printBonusNumber();
        bonusBall = Integer.parseInt(Console.readLine());
        Lotto lotto = new Lotto(winNumber);
        lotto.validateBonusNumber(winNumber, bonusBall);
    }

    // 로또 번호, 승리 숫자를 비교하는 메서드
    private void compareLottoNumber() {
        LottoNumberCheck lottoNumberCheck = new LottoNumberCheck();
        lottoNumberCheck.compareWinNumberWithMyLotto(randomLottoNumbers, winNumber, bonusBall);
        lottoNumberCheck.comparePrizeMoneyWithMyPrizeLotto();
    }
}
