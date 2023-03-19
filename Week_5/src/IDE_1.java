// CSC-222
// Andrew Clark
// IDE Project 1
// Electric or Gas Car?

//importing scanner
import java.text.DecimalFormat;
import java.util.Scanner;
public class IDE_1 {
    public static void main(String[] args) {
        //New scanner
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");



        //Defining gas car variables
        String gas_car_name;
        double gas_car_payment;
        double gas_car_gallon_cost;
        double gas_car_mileage;
        //Defining electric car variables
        String e_car_name;
        double e_car_payment;
        double e_car_electricity_cost;
        //Defining dual-used variables
        double miles_weekly;
        final double WEEKS_IN_MONTH = 4.3;




        //Start of output
        System.out.println("**************************");
        System.out.println("Lets begin by getting details for the gas car.");

        //Name of gas car
        System.out.println("Enter a name for your gas car (Example: Toyota Camry):");
        gas_car_name = input.nextLine();

        //Monthly finance for gas car
        System.out.println("Enter the monthly finance payment for your car:");
        gas_car_payment = input.nextDouble();

        //Cost per gallon for gas car
        System.out.println("Enter the cost of gas per gallon:");
        gas_car_gallon_cost = input.nextDouble();

        //Mileage
        System.out.println("Enter the average mileage the car is rated at:");
        gas_car_mileage = input.nextDouble();



        System.out.println("**************************");
        System.out.println("Now, since we have the details for the gas car, let's begin getting data for the electric car!");
        input.nextLine();

        //Name of electric car
        System.out.println("Enter a name for your electric car (Example: Tesla Model X):");
        e_car_name = input.nextLine();

        //Monthly finance for electric car
        System.out.println("Enter the monthly finance payment for your car:");
        e_car_payment = input.nextDouble();

        //Cost per mile for electric car
        System.out.println("Enter the cost of electricity per mile:");
        e_car_electricity_cost = input.nextDouble();


        //Introduction to use of dual-variable Miles Weekly
        System.out.println("**************************");
        System.out.println("Great, we now have information on both cars. Almost done!");
        System.out.println("**************************");
        input.nextLine();

        //Miles Driven
        System.out.println("How many miles on average do you drive each week?");
        miles_weekly = input.nextInt();





        //Costs per week of each
        double GC_Costs = calc_gas_car_calculations(miles_weekly,gas_car_mileage,gas_car_gallon_cost);
        double EC_Costs = calc_e_car_calculations(miles_weekly, e_car_electricity_cost);

        //Monthly costs of each
        double GC_monthly_cost = GC_Costs*WEEKS_IN_MONTH + gas_car_payment;
        double EC_monthly_cost = EC_Costs*WEEKS_IN_MONTH + e_car_payment;

        double GC_yearly_cost = GC_monthly_cost*12;
        double EC_yearly_cost = EC_monthly_cost*12;

        double ECvsGC_Costs_per_month = EC_monthly_cost-GC_monthly_cost;
        double ECvsGC_Costs_per_year = EC_yearly_cost-GC_yearly_cost;



        

        //Output for this is what we have for gas car
        System.out.println("**************************");
        System.out.println("GAS CAR DATA:");
        System.out.println("Car name: " + gas_car_name);
        System.out.println("Average Cost/Week for gas: $" + df.format(GC_Costs));
        System.out.println("Average Cost/Month for Payment and Gas: $" + df.format(GC_monthly_cost));
        System.out.println("Average Cost/Year for Payment and Gas: $" + df.format(GC_yearly_cost));

        //Output for this is what we have for electric car
        System.out.println("**************************");
        System.out.println("ELECTRIC CAR DATA:");
        System.out.println("Car name: " + e_car_name);
        System.out.println("Average Cost/Week for Electricity: $" + EC_Costs);
        System.out.println("Average Cost/Month for Payment and Electricity: $" + df.format(EC_monthly_cost));
        System.out.println("Average Cost/Year for Payment and Electricity: $" + df.format(EC_yearly_cost));

        //Output on savings/losses
        System.out.println("**************************");
        System.out.println("COMPARISON:");
        System.out.println("Based on comparisons, if you bought the electric car, you would save or lose the following money:");
        System.out.println("Negative means savings, positive means loss/you are paying more.");
        System.out.println("Savings/Cost per month: $" + df.format(ECvsGC_Costs_per_month));
        System.out.println("Savings/Cost per year: $" + df.format(ECvsGC_Costs_per_year));
        }


        //Gas Car Gas Calculations per week
        public static double calc_gas_car_calculations (double miles_weekly, double gas_car_mileage, double gas_car_gallon_cost){
            double gas_car_weekly_consumption = miles_weekly / gas_car_mileage;
            double gas_costs_per_wk = gas_car_weekly_consumption * gas_car_gallon_cost;

            return gas_costs_per_wk;
        }

        //Electric Car Electricity Calculations per week
        public static double calc_e_car_calculations(double miles_weekly, double e_car_electricity_cost){
            double e_car_weekly_costs = miles_weekly * e_car_electricity_cost;

            return e_car_weekly_costs;


        }
    }