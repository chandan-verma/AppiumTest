package utility;

import java.util.List;

import org.testng.asserts.SoftAssert;

/**
 * The Class SoftAssertion.
 */
public class SoftAssertion {

	/** The soft assertion. */
	private static SoftAssert softAssertion = new SoftAssert();

	/**
	 * @return the softAssertion
	 */
	public static SoftAssert getSoftAssertion() {
		return softAssertion;
	}

	/**
	 * @param softAssertion the softAssertion to set
	 */
	public static void setSoftAssertion(SoftAssert softAssertion) {
		SoftAssertion.softAssertion = softAssertion;
	}

	/**
	 * Assert equals.
	 *
	 * @param expected the expected
	 * @param actual   the actual
	 */
	public static void assertEquals(String expected, String actual) {
		softAssertion.assertEquals(actual, expected);
	}

	/**
	 * Assert equals.
	 *
	 * @param expected the expected
	 * @param actual   the actual
	 */
	public static void assertEquals(List<String> expected, List<String> actual) {
		softAssertion.assertEquals(actual, expected);
	}

	/**
	 * Assert equals.
	 *
	 * @param expected the expected
	 * @param actual   the actual
	 */
	public static void assertEquals(int expected, int actual) {
		softAssertion.assertEquals(actual, expected);
	}

	/**
	 * Assert true.
	 *
	 * @param condition the condition
	 */
	public static void assertTrue(Boolean condition) {
		softAssertion.assertTrue(condition);
	}

	/**
	 * Assert false.
	 *
	 * @param condition the condition
	 */

	public static void assertFalse(Boolean condition) {
		softAssertion.assertFalse(condition);
	}

}
