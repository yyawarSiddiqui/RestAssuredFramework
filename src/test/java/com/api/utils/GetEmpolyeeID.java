package com.api.utils;

import com.api.constant.Roles;
import com.api.models.response.JwtDecodedResponse;

public class GetEmpolyeeID {


	public static String getEmployeeID(Roles roles) {

		 JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
		try {
			decodedResponse = JwtDecoder.DecodedJWTbyUSer(roles);
			return decodedResponse.getEmployeeID();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

}
