package com.somallg.sample.bundle.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.servlet.ServletException;

import org.apache.commons.codec.binary.Base64;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.service.log.LogService;

@SlingServlet(paths = "/somallg/rsa")
public class RSACipherServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2601332629394208605L;
	
	private static final String ALGORITHM = "RSA";

	private static String PRIVATE_KEY = 
			"MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMjECtC9H/R6HIZt" +
			"tygP4DoTQS8LTM8uXzQJmmeViqQHuDfrD7LZnVnwVEHu9WrraA2ADenHJBsDaf+C" +
			"Rj73KaaV7ejcO/JppdhE9Q/Kct0MwXP6NS5ljgusU3evJd8fznPhR9xDZxoDbZS9" +
			"+PoQaQnEAG0tUyroijque2EYjsMPAgMBAAECgYBKKWjZXNN+CtGYstSyntK0gUJV" +
			"73WrHrUaUuXPl8UD/LoHJfTBm3NtssJdLLlJirYALqp1DhP/So6QTP5H6iNe9spD" +
			"g1uzqX0oWNicSc6z0TFf+jEunqtaNWyT2qLGLSfQPKNsMT3zcYkeD5QM/OFN1VpO" +
			"2S2PsF659ZGxZ0KaSQJBAPlIHjohS82wPDgY2g4jn9IjsnEpG66uJGimifmuVs7N" +
			"kMjp7DPq7DA4xK27JtBUgQY/jrL6HXnMLI1XSUBlCaMCQQDOLTIhcOAvj7GJqW3p" +
			"9cg+ViHwEtfDPJHYY1kBwYDvpLcD+5XaMAuccfhFbjKqXLrWLd6kWIO7K8txapKw" +
			"lQ+lAkBn2CAnbRlr7R+Y6tljjHmWi6JZO5u5j/fA1KejqHmnGsFWwQPRuOp9SBi+" +
			"mrkXjixVkwJ6EnFW/LQOiS8NsUlrAkArllR1y2Ypx+gRoVcSUhquSwlLtsAUj1aJ" +
			"957WhzEZ+KmUVvi8MtIRleqVyxE9APOi2fmqpufahwywgoZWfHzdAkAUJOs4yj6W" +
			"ripopcoFCZITnM1THSbbRYLh8DmxrX5mov+bCjhqy0qbJxIpA6GhqyM6C7tLSUZz" +
			"MeBz8esgvwOv";

	private static String PUBLIC_KEY = 
			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIxArQvR/0ehyGbbcoD+A6E0Ev" +
			"C0zPLl80CZpnlYqkB7g36w+y2Z1Z8FRB7vVq62gNgA3pxyQbA2n/gkY+9ymmle3o" +
			"3DvyaaXYRPUPynLdDMFz+jUuZY4LrFN3ryXfH85z4UfcQ2caA22Uvfj6EGkJxABt" +
			"LVMq6Io6rnthGI7DDwIDAQAB";
	
	@Reference()
	private LogService logger; 

	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", "hello lala");
			response.setContentType("application/json");
			response.getWriter().println(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {
		
		BufferedReader bufferedReader = request.getReader();
		
		String line;
		StringBuilder jsonRequest = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			jsonRequest.append(line);
		}
		
		try {
			JSONObject requestJson = new JSONObject(jsonRequest.toString());
			logger.log(LogService.LOG_INFO, requestJson.toString());

			JSONObject jsonObject = new JSONObject();
			response.setContentType("application/json");
			long begin = System.currentTimeMillis();
			jsonObject.put("response", decrypt(requestJson.get("response").toString()));
			long end = System.currentTimeMillis();
			
			jsonObject.put("time", end - begin);
			response.getWriter().println(jsonObject.toString());
			System.out.println(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private static String encrypt(String plainText) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(Base64.decodeBase64(PUBLIC_KEY));
			Key encryptionKey = keyFactory.generatePublic(pubSpec);

			Cipher rsa = Cipher.getInstance(ALGORITHM);
			rsa.init(Cipher.ENCRYPT_MODE, encryptionKey);

			return new String(rsa.doFinal(plainText.getBytes()), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String decrypt(String cipherText) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
					Base64.decodeBase64(PRIVATE_KEY));
			Key privKey = keyFactory.generatePrivate(keySpec);

			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privKey);

			return new String(Base64.decodeBase64(cipher.doFinal(Base64.decodeBase64(cipherText))), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
