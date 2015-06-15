package util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.security.Base64Encoder;

public class EncripiterSenha {
	
	public static String encriptar(String senha) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = MessageDigest.getInstance("MD5");

		digest.update(senha.getBytes());

		return Base64Encoder.encode(digest.digest());
	}

}
