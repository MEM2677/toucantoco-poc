package org.entando.entando.plugins.jptoucantoco.aps.system.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTUtil {

	public static String generateToucanTocoJWT(String secret, String username) throws Throwable {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		
		return generateJWT(algorithm, username);
	}
	
	public static String generateJWT(Algorithm algorithm, String username) {
		String token = JWT.create()
				.withSubject(username)
				.sign(algorithm);
		return token;
	}
	
}
