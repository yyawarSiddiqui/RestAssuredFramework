package com.api.utils;

import com.api.constant.Roles;
import com.api.models.response.JwtDecodedResponse;

public class GetEmpolyeeID {

	static JwtDecodedResponse decodedResponse = new JwtDecodedResponse();

	public static String getEmployeeID(Roles roles) {

		try {
			decodedResponse = JwtDecoder.DecodedJWTbyUSer(roles);
			return decodedResponse.getEmployeeID();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

}
