package org.example;


import java.util.Scanner;

public class HttpImageStatusCli {

    private int cod;
    public void askStatus() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int cod = 0;

        System.out.println("Enter HTTP status code");
        while (true) {
            if (scanner.hasNextInt()) {
                cod = scanner.nextInt();
                break;
            } else {
                System.out.println("Please enter valid number");
                scanner.next();
            }
        }


        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        String imageLink = statusChecker.getStatusImage(cod);
        System.out.println(imageLink);

        if (imageLink != null) {
            httpStatusImageDownloader.downloadStatusImage(cod);
        }
    }
}
