package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = null;

        try {
            URL imageUrl = new URL(url);
            connection = (HttpURLConnection) imageUrl.openConnection();

            if (connection.getResponseCode() == 404) {
                throw new Exception("Image not found for status code " + code);
            }

            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                String fileName = code + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(fileName);

                int byteRead;
                byte[] buffer = new byte[1024];

                while ((byteRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, byteRead);
                }

                fileOutputStream.close();
                inputStream.close();

                System.out.println("Image saved " + fileName);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
