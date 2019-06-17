import java.math.BigDecimal;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ExtendTest -> Class
 * @Package CommonUtils -> PACKAGE_NAME
 * @Description
 * @date 2019/6/17 11:30 
 */
public class ExtendTest extends Ext {
	private int c = 3;
	private String name = "lisi";
	private BigDecimal money = new BigDecimal("230");

	public int getC() {
		return c;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public BigDecimal getMoney() {
		return money;
	}

	public static void main(String[] args) {
		ExtendTest extendTest = new ExtendTest();
		System.out.println(extendTest.getName());
		System.out.println(extendTest.name);
	}
}
