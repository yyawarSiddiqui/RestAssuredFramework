package com.api.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import com.api.constant.Roles;
import com.api.models.response.JwtDecodedResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtDecoder extends ParseToken {

	public static JwtDecodedResponse DecodedJWTbyUSer(Roles roles) {

		JwtDecodedResponse decodedResponse = null;
		ObjectMapper obj = new ObjectMapper();
		String token = AuthTokenProvider.getToken(roles);

		String jwtToken = Parsetoken(token);

		String[] parts = jwtToken.split("\\.");

		// String headerJson = new String(Base64.getUrlDecoder().decode(parts[0]),
		// StandardCharsets.UTF_8);
		String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

		try {
			decodedResponse = obj.readValue(payloadJson, JwtDecodedResponse.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to decode token", e);
		}

		return decodedResponse;

	}

}
