import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int rowNum = 0;
        int seatNum = 0;
        String[][] seeCine = cinema(rows, seats);

        boolean run = true;
        while(run) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println();
            int val = scanner.nextInt();
            switch(val) {
                case 1:
                    System.out.println("Cinema:");
                    //String[][] seeCine = cinema(rows, seats);
                    for (int i = 0; i < seeCine.length; i++) {
                        for (int j = 0; j < seeCine[0].length; j++) {
                            System.out.print(seeCine[i][j] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case 2:
                    boolean start = true;
                    while (start) {
                        System.out.println("Enter a row number:");
                        rowNum = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNum = scanner.nextInt();
                        if(rowNum<1 || rowNum>rows || seatNum<1 || seatNum>seats){
                            System.out.println("Wrong input!");
                        } else if (seeCine[rowNum][seatNum] == "B") {
                            System.out.println("That ticket has already been purchased!");
                        }else {
                            start = false;
                        }
                    }
                    ticketPrice(rows, seats, rowNum);
                    seeCine[rowNum][seatNum] = "B";
                    break;
                case 3:
                    int totalPurchasedTickets = purchasedTicketsNum(seeCine);
                    System.out.println("Number of purchased tickets: "+totalPurchasedTickets);
                    double purchasedTicketsPercentage = ((double) totalPurchasedTickets /(rows*seats))*100;
                    System.out.println(purchasedTicketsPercentage);
                    double roundedPercentage = Math.round(purchasedTicketsPercentage * 100.0) / 100.0;
                    System.out.println("Percentage: " +roundedPercentage+"%");
                    totalIncome(rows, seats);
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

    public static void ticketPrice(int rows, int seats, int rowNum){
        int ticketPrice;
        if(rows*seats>60){
            if(rowNum<=rows/2){
                ticketPrice = 10;
            }else{
                ticketPrice = 8;
            }
        }else{
            ticketPrice = 10;
        }
        System.out.println("Ticket price: $" + ticketPrice);
    }

    public static String[][] cinema(int rows, int seats){
        String[][] cinemaView = new String[rows+1][seats+1];
        for(int i = 0; i< cinemaView.length; i++){
            for(int j = 0; j<cinemaView[0].length; j++){
                if(i==0 && j==0){
                    cinemaView[i][j] = " ";
                } else if (i==0) {
                    cinemaView[i][j] = String.valueOf(j);
                } else if (j==0) {
                    cinemaView[i][j] = String.valueOf(i);
                }else{
                    cinemaView[i][j] = "S";
                }
            }
        }
        return cinemaView;
    }

    public static int purchasedTicketsNum(String[][] seeCine){
        int tNum = 0;
        for(int i =0; i< seeCine.length; i++){
            for(int j=0; j<seeCine[0].length; j++){
                if(seeCine[i][j]=="B"){
                    tNum++;
                }
            }
        }
        return tNum;
    }

    public static void totalIncome(int rows, int seats){
        int totalIncome = 0;
        if(rows*seats < 60){
            totalIncome = rows * seats * 10;
        }else {
            int firstHalf = rows/2;
            int firstHalfPrice = firstHalf * seats * 10;
            int secondHalf = rows - firstHalf;
            int secondHalfPrice = secondHalf * seats * 8;
            totalIncome = firstHalfPrice + secondHalfPrice;
        }
        System.out.println("Total income: $" + totalIncome);
    }
}
