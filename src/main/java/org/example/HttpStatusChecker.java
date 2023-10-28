package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = null;

        try {
            URL imageURL = new URL(url);
            connection = (HttpURLConnection) imageURL.openConnection();

            if (connection.getResponseCode() == 404) {
                throw new Exception("Image not found for status cod " + code);
            }

            if (connection.getResponseCode() == 200) {
                return url;
            } else {
                throw new Exception("Http reqest failed with cod " + connection.getResponseCode());
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
