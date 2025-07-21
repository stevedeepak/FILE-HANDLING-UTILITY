import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIClient {
    public static void main(String[] args) {
        try {
            String url = "https://dog.ceo/api/breeds/image/random";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder jsonData = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                jsonData.append(inputLine);
            }
            in.close();

            System.out.println("Response from API:");
            System.out.println(jsonData.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
