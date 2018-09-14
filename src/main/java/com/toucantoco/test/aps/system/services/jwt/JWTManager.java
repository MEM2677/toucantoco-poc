package com.toucantoco.test.aps.system.services.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agiletec.aps.system.common.AbstractService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.toucantoco.test.aps.system.services.utils.JWTUtil;

public class JWTManager extends AbstractService {

	private static final Logger logger =  LoggerFactory.getLogger(JWTManager.class);
	
	@Override
	public void init() throws Exception {
		logger.debug("{} ready.", this.getClass().getName());
		generate();
	}

	private void generate() {
		try {/*
			Algorithm algorithm = Algorithm.HMAC256(SECRET);
			String token = JWT.create()
//					.withIssuer(USER)
//					.withClaim("username", USER)
					.withSubject(USER)
					.sign(algorithm);
			System.out.println("\n>>> " + token);
			*/
			String tok = JWTUtil.generateToucanTocoJWT(SECRET, USER);
			System.out.println("\n>>> " + tok);
		} catch (JWTCreationException t) {
			logger.error("error generating token", t);
		} catch (Throwable t) {
			logger.error("error detected during token creation", t);				
		}
	}

	public final static String SECRET = "secret";
	public final static String USER = "user@example.com";
	
}
