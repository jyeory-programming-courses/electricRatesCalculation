import java.util.Scanner;

public class Stage {
  private int quantity;

  public void start() {
    Scanner sc = new Scanner(System.in);
		System.out.println("사용량을 입력하세요.");
		
    quantity = sc.nextInt();

    // code here
    // Calculation 클래스의 인스턴스를 가져옵니다.
    Calculation calculator = Calculation.getCalculation();
    
    int basicFee = calculator.basicFee0(quantity);
    int usageFee = calculator.usageFee0(quantity);
    int environmentalFee = calculator.environmentalFee0(quantity);
    int totalBill = calculator.totalBill0();
    int vat = calculator.vat0();
    int powerFund = calculator.powerFund0();
    calculator.sum();
    
  }
}
