package com.somallg.sample.bundle.rsa;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public final class RSAUtilsCipher {

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

	public static void main(String[] args) {
		String textStream = "somallg";
		byte[] cipher;
		Base64 base64 = new Base64();
		System.out.println("input: " + textStream);
		cipher = encrypt(textStream);
		System.out.println("cipher: " + base64.encodeToString(cipher));
		System.out.println("decrypt: " + decrypt(base64.encodeToString(cipher)));

		String pidCrypt = "OydLwkJV1QApUwymdqpaEYMr8WcWgHxbLZYYe/S9zrQ7UnIpnqP3b/qcvFe/joxr NvRpMVLLgHBlY2jM7Q2oatKOLEqzSBxQdh3ZCxMX4UVw7FLOmgpl+vkWEpdB8wpU 8jlAsx9ilFKriJPavru2KrW8kXZSK8npcsF9VAIw98w=";


		System.out.println(new String(Base64.decodeBase64(decrypt(pidCrypt))));
	}

	private static byte[] encrypt(String textStream) {
		// try {
		// PublicKey publicKey = getPublicKey("public_key.der");
		//
		// Cipher rsa = Cipher.getInstance("RSA");
		// rsa.init(Cipher.ENCRYPT_MODE, publicKey);
		//
		// return rsa.doFinal(textStream.getBytes());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(
					Base64.decodeBase64(PUBLIC_KEY));
			Key encryptionKey = keyFactory.generatePublic(pubSpec);

			Cipher rsa = Cipher.getInstance(ALGORITHM);
			rsa.init(Cipher.ENCRYPT_MODE, encryptionKey);

			return rsa.doFinal(textStream.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String decrypt(String cipherText) {
		// try {
		// PrivateKey privateKey = getPrivateKey("private_key.der");
		// Cipher rsa = Cipher.getInstance("RSA");
		// rsa.init(Cipher.DECRYPT_MODE, privateKey);
		//
		// return new String(rsa.doFinal(cipher));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
					Base64.decodeBase64(PRIVATE_KEY));
			// Key decryptionKey = keyFactory.generatePrivate(privSpec);
			RSAPrivateKey privKey = (RSAPrivateKey) keyFactory
					.generatePrivate(keySpec);

			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privKey);

			return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static PublicKey getPublicKey(String filename) throws Exception {
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

	public static PrivateKey getPrivateKey(String filename) throws Exception {
		File f = new File(filename);
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		byte[] keyBytes = new byte[(int) f.length()];
		dis.readFully(keyBytes);
		dis.close();

		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}
}
