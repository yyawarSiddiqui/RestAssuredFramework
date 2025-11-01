package com.api.utils;

import java.util.Random;

public class generateRandomString {

	public static String generateRandomStringvalue(int length) {

		// Characters to be used in generating the random string
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXY#$%^&*(JHBGVCDER&UHGVCXE$%^YHBVCXSWE#$%^&UJHBGVCDE$%^&UJHBVCD$WSXCVGHU&^%REDCVBHJUI*&^%RDCVGHU&^%REDCVGHU&TREDFGHU&^%RDCVGHU&^%REDCVGHU*&^%REDFGY&%$ESDCVGHU*&^%REDFGY&^%$ESDCVGBHJUI*&^RDCVBHJU*&^TRDCZabcdefghijklmnopqrs987yutgfh9uesyfe89wyrge87ryuw8e97ytr89ew7y89w7gyu89rewfgusdyer89wguyfder89ufysdgrw9qiuyfsdhguyrygsderuisyuydgsiyfgyirhdsguyfghuyewgsdufhguewhsduytweghsduyhuegdshbuygsduyusdhuywe78ysdg87weughsduyghdsvuysdgydhgsvuyvdshuyxghdsvuyhgdsvuhgsvzyusdsvtuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();

		Random random = new Random();

		// Generate random characters and append them to the StringBuilder
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}

		// Convert StringBuilder to String and return
		return sb.toString();
	}

}
