package com.mohamed.tamer.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public abstract class Security
{
	private static final String ALGO = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'A', 'M', 'E' ,'R'
		, 'M', 'O', 'H', 'A', 'M', 'E', 'D', 'A', 'B', 'D', 'A' };

	public String encrypt(String data)
	{
		String encryptedValue = null;
		try
		{
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(data.getBytes());
			encryptedValue = new BASE64Encoder().encode(encVal);
		}// end try
		catch(Exception e)
		{
			e.printStackTrace();
		}// end catch
		
		return encryptedValue;
	}// end of method encrypt

	public String decrypt(String encryptedData)
	{
		String decryptedValue = null;
		try
		{
			Key key = generateKey();
			Cipher c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		}// end try
		catch(Exception e)
		{
			e.printStackTrace();
		}// end catch
		
		return decryptedValue;
	}// end of method decrypt

	private Key generateKey() throws Exception
	{
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}// end of method generateKey
	
}// end of class Security
