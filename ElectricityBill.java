 import java.util.Scanner;
 public class ElectricityBill {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the number of units consumed: ");
         int units = sc.nextInt();
         double billAmount = calculateBill(units);
         System.out.println("Total Electricity Bill: " + billAmount + " rupees");
     }

     public static double calculateBill(int units) {
        double bill =
    (units <= 100) ? units * 5 :
    (units <= 200) ? (100 * 5) + ((units - 100) * 7) :
                     (100 * 5) + (100 * 7) + ((units - 200) * 10);

return bill;
//double bill = 0;
         //if (units <= 100) {
          //   bill = units * 5;
         //} else if (units <= 200) {
           //  bill = (100 * 5) + ((units - 100) * 7);
         //} else {
           //  bill = (100 * 5) + (100 * 7) + ((units - 200) * 10);
         //}
         //return bill;
     }
 }