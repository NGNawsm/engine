package engine.utils;

//import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPUtils {

	/**
	 * Performs a POST HTTP request, sending a form to the specified url, waits for
	 * upto 10 seconds and sends the response body as string, in case of failure
	 * null is returned
	 * 
	 * @param url
	 * @param formParameters
	 * @return
	 * @author nandagopal
	 * @throws IOException
	 */

	public String postForm(String url, HashMap<String, String> formParameters) throws IOException {

		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		String body = "";
		for (String key : formParameters.keySet()) {
			body += key + "=" + formParameters.get(key) + "&";
		}
		body = body.substring(0, body.length() - 1);
		System.out.println(body);
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		con.disconnect();

		//System.out.println(response.toString());
		return response.toString() ;

	}
}
