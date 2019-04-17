import java.io.IOException;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title Test -> Class
 * @Package CommonUtils -> PACKAGE_NAME
 * @Description 随便写的一些测试
 * @date 2019/4/17 11:26 
 */
public class TryWithResourceTest {

	public static void startTest() {
		try (A a = new A();
				B b = new B()) {
			a.test();
			b.test();
		} catch (Exception e) {
			System.out.println("Main: exception");
			System.out.println(e.getMessage());
			Throwable[] suppressed = e.getSuppressed();
			for (int i = 0; i < suppressed.length; i++)
				System.out.println(suppressed[i].getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		startTest();
	}


}

class A implements AutoCloseable {

	public void test() throws IOException {
		System.out.println("test a");
		throw new IOException("a IOException");
	}

	@Override
	public void close() throws Exception {
		System.out.println("a closed");
		throw new ClassNotFoundException("a close exception");
	}
}

class B implements AutoCloseable {

	public void test() throws IOException {
		System.out.println("test b");
		throw new IOException("b IOException");
	}

	@Override
	public void close() throws Exception {
		System.out.println("b closed");
		throw new ClassNotFoundException("b close exception");
	}
}



