import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		TestCase tc = TestReader.readTestCase(15);
		System.out.println(Arrays.deepToString(tc.hmap).replace("]", "\n"));
	}

}
