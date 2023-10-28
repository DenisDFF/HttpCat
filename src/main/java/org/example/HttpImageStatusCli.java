package org.example;


import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        int cod = scanner.nextInt();
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        String imageLink = statusChecker.getStatusImage(cod);
        System.out.println(imageLink);

        if (imageLink != null) {
            httpStatusImageDownloader.downloadStatusImage(cod);
        }
    }
}
