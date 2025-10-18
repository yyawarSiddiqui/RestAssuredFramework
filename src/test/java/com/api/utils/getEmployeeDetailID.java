package com.api.utils;

import com.api.constant.Roles;
import com.api.models.response.JwtDecodedResponse;

public class getEmployeeDetailID {

	 

	public static String GetEmployeedetailID(Roles roles) {

		JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
		try {
			decodedResponse = JwtDecoder.DecodedJWTbyUSer(roles);
			return decodedResponse.getEmploymentTypeID();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}
}
