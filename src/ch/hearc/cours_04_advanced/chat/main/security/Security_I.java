
package ch.hearc.cours_04_advanced.chat.main.security;

import java.security.PublicKey;

public interface Security_I
	{

	public byte[] encrypt(byte[] byteArray);

	public byte[] decrypt(byte[] byteArray);

	public void init(PublicKey publicKey);

	public PublicKey getPublicKey();

	}

