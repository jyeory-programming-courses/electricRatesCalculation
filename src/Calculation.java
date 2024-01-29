import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {
	
  // code here
  private static Calculation singleton = new Calculation(); 
	
  //기본 생성자
  private Calculation() {} // private 생성자로 외부에서 인스턴스를 직접 생성하지 못하도록 합니다
  
  int basic = 0;
  int usage = 0;
  int en = 0;
  double totalBill = 0;
  double vat = 0;
  double power = 0;
  
  public static Calculation getCalculation() {
	  return singleton;
  }
  
  // 기본요금 계산 메서드
  public int basicFee0(int quantity) {
      // code here
	  if(quantity <= 200) {
		  basic = 910;
	  }else if(quantity <= 400) {
		  basic = 1600;
	  }else {
		  basic = 7300;
	  }
	  System.out.printf("기본요금 : %,d원%n", basic);
	  return basic;
  }

  // 전력량 요금 계산 메서드
  public int usageFee0(int quantity) {
      // code here
	  if(quantity <= 200) {
		  usage = (int)(quantity * 120.0);
	  }else if(quantity <= 400) {
		  usage = (int)(200 * 120.0);
		  usage += (int)((quantity-200) * 214.6);
	  }else {
		  usage = (int)(200 * 120.0);
		  usage += (int)(200 * 214.6);
		  usage += (int)((quantity-400) * 307.3);
	  }
	  System.out.printf("전력량 요금 : %,d원%n", usage);
	  return usage;
  }

  // 기후환경 요금 계산 메서드
  public int environmentalFee0(int quantity) {
      // code here
	  en = (quantity * 9);
	  System.out.printf("기후환경 요금 : %,d원%n", en);
	  return en;
  }

  // 전기요금계 계산 메서드
  public int totalBill0() {
      // code here
	  totalBill = basic + usage + en;
	  System.out.printf("전기요금계 요금 : %,d원 (10원미만 반올림)%n", (int)(totalBill));
	  return (int)totalBill;
  }

  // 부가가치세 계산 메서드
  public int vat0() {
      // code here
	  vat = totalBill / 10;
	  System.out.printf("부가가치세  : %,d원 (10원미만절사)%n", (int) Math.round(vat));
	  return (int)vat;
  }

  // 전력기반기금 계산 메서드
  public int powerFund0() {
      // code here
	  power = totalBill * 0.037;
	  System.out.printf("전력기반기금 : %,d원 (10원미만절사)%n", ((int)power/10)*10);
	  return (int)power;
  }
  public void sum() {
	  totalBill = (int)totalBill; 
	  vat = (int) Math.round(vat);
	  power = ((int)power/10)*10;
	  System.out.printf("청구금액 : %,d원 (10원미만절사)%n", ((int)(totalBill+vat+power)/10)*10);
  }

}
