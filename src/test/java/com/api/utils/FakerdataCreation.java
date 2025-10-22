package com.api.utils;

import com.github.javafaker.Faker;

public class FakerdataCreation {

	private static final Faker faker = new Faker();

	public static String getFullName() {

		return faker.name().fullName();
	}

	public static String getEmail() {
		return faker.internet().emailAddress();
	}

	public static String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String getCity() {
		return faker.address().city();
	}

	public static String getCompany() {
		return faker.company().name();
	}

	public static String getRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(faker.random().nextInt(characters.length())));
		}
		return sb.toString();
	}

}
