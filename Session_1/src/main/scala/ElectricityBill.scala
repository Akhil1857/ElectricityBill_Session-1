
case class ElectricityBillCalculator(account_Number: Int, account_Username: String, address: String, previous_Unit: Int, current_Unit: Int) {

  def totalUnits(): Int = {
    current_Unit - previous_Unit
  }

  def totalBillAmount(): Double = {
    val units = totalUnits()
    if (units < 0)
      throw new IllegalArgumentException()
    else if (units <= 250) {
      val totalBill = units * 5.25
      val gstIncludedBill = totalBill + (totalBill * 18 / 100)
      gstIncludedBill
    }
    else if (units <= 450) {
      val totalBill = 250 * 5.25 + (units - 250) * 6.75
      val gstIncludedBill = totalBill + (totalBill * 18 / 100)
      gstIncludedBill
    }
    else {
      val totalBill = 250 * 5.25 + 200 * 6.75 + (units - 450) * 8.50
      val gstIncludedBill = totalBill + (totalBill * 18 / 100)
      gstIncludedBill
    }
  }
}
