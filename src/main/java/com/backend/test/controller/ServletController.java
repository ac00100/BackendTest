package com.backend.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.test.dto.AddressBlock;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ServletController {
	private static final String url = "https://www.ing.nl/api/locator/atms/";

	@SuppressWarnings("unchecked")
	@RequestMapping("/admin/get_json_from_url")
	public String getJsonFromUrl(HttpSession session)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		String validJsonStr = correctJsonStr(getStringFromInputStream(new URL(url).openStream()));

		ObjectMapper mapper = new ObjectMapper();
		List<AddressBlock> addressBlocks = mapper.readValue(validJsonStr, List.class);

		// session storage for addressBlocks
		session.setAttribute("addressBlocks", addressBlocks);

		return "get_json_success";
	}

	@RequestMapping("/usr/post_json_from_url")
	public String postJsonFromUrl(Map<String, Object> model, HttpSession session)
			throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		String validJsonStr = correctJsonStr(getStringFromInputStream(new URL(url).openStream()));

		// ObjectMapper mapper = new ObjectMapper();
		// List<AddressBlock> addressBlocks = mapper.readValue(validJsonStr,
		// List.class);

		// session storage for addressBlocks
		// session.setAttribute("addressBlocks", addressBlocks);

		try {
			URL url = new URL("http://localhost:8080/address_blocks;jsessionid=" + session.getId());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = validJsonStr;

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			StringBuilder sb = new StringBuilder();
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				sb.append(output);
			}
			model.put("inputStream", sb.toString());

			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "post_json_success";
	}

	@RequestMapping("/usr/list_addresses")
	public String listAddresses(Map<String, Object> model, HttpSession session) {
		model.put("addressBlocks", session.getAttribute("addressBlocks"));

		return "list_addresses";
	}
	
	@RequestMapping("/dba/clear_session")
	public String clearSession(HttpSession session) {
		session.removeAttribute("addressBlocks");
		
		return "clear_session_success";
	}
	
	/**
	 * Because of the invalid json string start with ")]}'," character , so this
	 * method is to remove the prefix wrong json format of the string.
	 * 
	 * @param jsonStr
	 * @return validJsonString
	 */
	private static String correctJsonStr(String jsonStr) {
		StringBuffer sb = new StringBuffer(jsonStr);

		if (sb.subSequence(0, 5).equals(")]}',")) {
			return sb.substring(5).toString();
		} else {
			return jsonStr;
		}
	}

	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
