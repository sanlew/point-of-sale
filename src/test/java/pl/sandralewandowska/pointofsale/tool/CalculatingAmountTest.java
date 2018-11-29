package pl.sandralewandowska.pointofsale.tool;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CalculatingAmountTest {

	@Test
	public void testRoundPrice() {
		 final BigDecimal expected = new BigDecimal("0.50");
		 BigDecimal actual = CalculatingAmount.roundPrice(new BigDecimal("0.49769"));
		 Assert.assertEquals(actual, expected);
	}

}
