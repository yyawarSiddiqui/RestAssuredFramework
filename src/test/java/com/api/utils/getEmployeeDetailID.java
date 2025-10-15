package com.api.utils;

import com.api.constant.Roles;
import com.api.models.response.JwtDecodedResponse;

public class getEmployeeDetailID {

	static JwtDecodedResponse decodedResponse = new JwtDecodedResponse();

	public static String GetEmployeedetailID(Roles roles) {

		try {
			decodedResponse = JwtDecoder.DecodedJWTbyUSer(roles);
			return decodedResponse.getEmploymentTypeID();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}
}
