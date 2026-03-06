package w4_1_another_type_of_employee;

/**
 *
 * @author ZAHRA
 */

// ****************************************************
// Commission.java
//
// Represents an hourly employee who also earns commission on sales.
// ****************************************************

public class Commission extends Hourly{
    private double totalSales;
    private double commissionRate;

    public Commission(String name, String address, String phone,String ssn, double rate, double commRate){
        super(name, address, phone, ssn, rate);
        this.commissionRate = commRate;
        this.totalSales = 0.0;
    }

    public void addSales(double sales) {
        totalSales += sales;
    }

    //-----------------------------------------------------------------
    // Returns the pay for this commission employe.
    //-----------------------------------------------------------------
    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0.0;
        return payment;
    }
    
    //-----------------------------------------------------------------
    // Returns information about this commission employee as a string,
    // including inherited info and the current total sales figure.
    //-----------------------------------------------------------------
    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}
