package com.SerializationDeserialization;

import com.google.gson.Gson;

public class Runner {

	public static void main(String[] args) {

		User user = new User("Test", "Pass");
		//System.out.println(user);

		// serialization//

		Gson gson = new Gson();
		String data = gson.toJson(user);
		System.out.println(data);

		// Deserilaization//

		String jsondata = "{\"name\":\"Test\",\"password\":\"Pass\"}";
		User user1 = gson.fromJson(jsondata, User.class);
		System.out.println(user1);

	}

}
