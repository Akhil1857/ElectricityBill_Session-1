import org.scalatest.funsuite.AnyFunSuite
class ElectricityBillTestCase extends AnyFunSuite {

  test("totalBillAmount() should return correct amount for 0 units consumed") {
    val account = ElectricityBillCalculator(1, "User", "Noida", 0, 0)
    assert(account.totalBillAmount() == 0.0)
  }

  test("totalBillAmount() should return correct bill for units consumed from 0 to 250") {
    val account = ElectricityBillCalculator(2, "Akhil", "Delhi", 1489, 1568)
    assert(account.totalBillAmount() == 489.405)
  }

  test("totalBillAmount() should return correct bill for units consumed from 251 to 450") {
    val account = ElectricityBillCalculator(11, "Prashant", "NCR", 2010, 2500)
    assert(account.totalBillAmount() == 3542.95)
  }

  test("totalBillAmount() should give correct bill for units consumed more than 450 ") {
    val account = ElectricityBillCalculator(21, "Akhil", "Delhi", 5062, 5904)
    assert(account.totalBillAmount() == 7073.51)
  }

  // Test case for handling the Exception.
  test("throw IllegalArgumentException when units are less than 0") {
    val account = ElectricityBillCalculator(31, "Akhil", "Delhi", 150, 50)
    assertThrows[IllegalArgumentException] {
      account.totalBillAmount()
    }
  }

}