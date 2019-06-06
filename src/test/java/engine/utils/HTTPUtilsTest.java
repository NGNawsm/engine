package engine.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

public class HTTPUtilsTest {
	@Test
	public void testpostForm() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("sentence1", "hello");
		params.put("sentence2", "hello");
		String response = null;
		try {
			response = new HTTPUtils().postForm("http://35.200.182.146:5010/sentence_similarity", params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response);
		assertEquals("{\"sentence1\":\"hello\",\"sentence2\":\"hello\",\"similarityScore\":\"1.0\"}", response);

	}

}
