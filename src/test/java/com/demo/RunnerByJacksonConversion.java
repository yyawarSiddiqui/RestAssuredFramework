package com.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunnerByJacksonConversion {

	public static void main(String[] args) {

		User user = new User("Test", "Pass");

		// Jackson//Serialization
		ObjectMapper objectMapper = new ObjectMapper();

		try {

			// Serializtion//

			// String data = objectMapper.writeValueAsString(user);
			// System.out.println(data);
			// System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));

			// Deserialization//

			String data = "{\r\n" + "  \"name\" : \"Test\",\r\n" + "  \"password\" : \"Pass\"\r\n" + "}";
			User us = objectMapper.readValue(data, User.class);
			System.out.println(us);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
