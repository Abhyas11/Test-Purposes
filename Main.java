import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] seeCine = cinema(rows, seats);

        boolean run = true;
        while(run) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            System.out.println();
            int val = scanner.nextInt();
            switch(val){
                case 1:
                    System.out.println("Cinema:");
                    //String[][] seeCine = cinema(rows, seats);
                    for(int i =0; i<seeCine.length; i++){
                        for(int j=0; j<seeCine[0].length;j++){
                            System.out.print(seeCine[i][j] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    int rowNum = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seatNum = scanner.nextInt();
                    ticketPrice(rows, seats, rowNum);
                    seeCine[rowNum][seatNum] = "B";
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
}
