package tiktaktoe;

import java.util.Scanner;

public class ConcertPromoter {

    private String brandName;
    private int venueCapacity;
    private int soldTickets;
    private double soldByphonePrice;
    private double priceAtconcert;
    private double totalSales;

    /* It will hold a boolean value to indicate whether it is the same day or not 
for true, it is concert day. if false then it means it is day before concert
     */
    public boolean concertDay;
    public int availTickets; // initially available tickets will be euqal to venue capacity 

// Default constructor for default values 
    ConcertPromoter() {

        venueCapacity = 50; // keeping it 50 for default 
        availTickets = venueCapacity;
        concertDay = false; // Day before concert 
        soldTickets = 0;
        totalSales = 0;
        soldByphonePrice = 100.50;
        priceAtconcert = 140.60;
        brandName = "XYZ brand";
    }

// Display the price of ticket for phone call and concert as per the eligibility 
    public boolean buyTickets(int ticketCount) {

// If it is day before concert then selling will be done by only phone
        if (!concertDay) {
            System.out.println("Ticket price by phone for each person: " + soldByphonePrice);
// Records the sales done by phone 
            if (ticketCount <= availTickets && ticketCount > 0) {
                soldTickets += ticketCount;
// calculate the sales amount and add them into the totalsales 
                totalSales = totalSales + soldByphonePrice * ticketCount;
                availTickets -= ticketCount;
                System.out.printf("Congrats! you have bought %d tickets. ", ticketCount);
                return true; // for success 
            } // If requested number of tickets is greater than capacity 
            else {
                System.out.printf("Only %d tickets you can book. Try again!", availTickets);
                return false; // for failure 
            }
        } // Else at the concert only
        else {

            System.out.println("Ticket price at concert: " + priceAtconcert);

// Records the sales done at the concert 
            if (ticketCount <= availTickets && ticketCount > 0) {
                soldTickets += ticketCount;
                totalSales = totalSales + priceAtconcert * ticketCount;
                availTickets -= ticketCount;
                System.out.printf("Congrats! you have bought %d tickets. ", ticketCount);

                return true;
            } // If requested number of tickets is greater than capacity 
            else {
                System.out.printf("Only %d tickets you can book. Try again!", availTickets);
                return false;
            }
        }

    }
// Change from sales by phone to at concert

    public void changePhoneToConcert() {

        // Set concertDay to true 
        if (concertDay) {
            System.out.println("\nNow sales are by phone! ");
            concertDay = false;
        } else {
            concertDay = true; // Indicates now selling will be at concert only
            System.out.println("\nNow sales are at concert! ");
        }

    }

// Return the no. of sold tickets 
    public int getSoldTickets() {
        return soldTickets;
    }
// Return the no. of remaining tickets 

// Venue capacity is representing total no. of tickets for the concert
// So, total - sold will be the remaining tickets       
    public int getRemainTicketCounts() {
        return availTickets;
    }
// Return the total sales for the concert

    public double getTotalSales() {
        return totalSales;
    }

    public static void main(String[] args) {

        ConcertPromoter concert = new ConcertPromoter(); // create an instance of the class 

        Scanner in = new Scanner(System.in);

        System.out.println("Currently you are buying on phone only!");

        String res1, res2;
        int numTickets;
        boolean status;

        do {

// Will keep prompting the user until the ticket buys sucessfully 
            do {

                System.out.print("\nHow many tickets wanna buy? ");
                numTickets = in.nextInt();
                status = concert.buyTickets(numTickets);
                System.out.println("\nRemaining tickets are " + concert.getRemainTicketCounts());

            } while (!status);

            System.out.print("\nWanna swap phone sales and concert (y/n) ? ");

            res1 = in.next();

            if (res1.equals("y")) {
                concert.changePhoneToConcert();
            }

            System.out.print("\nWanna buy more tickets (y/n) ? ");

            res2 = in.next();

        } while (res2.equals("y"));

        System.out.println("\nTotal sold tickets are " + concert.getSoldTickets());
        System.out.println("Total sales amount is " + concert.getTotalSales());

    }

}
