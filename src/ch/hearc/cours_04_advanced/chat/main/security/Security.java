package ch.hearc.cours_04_advanced.chat.main.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;

public class Security implements Security_I {


	/*------------------------------------------------------------------*\
	|*							Constructors						  *|
	\*------------------------------------------------------------------*/
	public Security()
    {

        // Initialize private and public key
        KeyPairGenerator keyGen = null;
        try{
             keyGen = KeyPairGenerator.getInstance("RSA");
             keyGen.initialize(1024);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.err.println("Couldn't generate private and public key");
        }

        KeyPair pair = keyGen.generateKeyPair();

        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();


        // Initialize simmetrical key;
        try{
            this.simKey = KeyGenerator.getInstance("DES").generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.err.println("Couldn't generate simetrical key.");
        }

        // Get Foreign key and set public key in ChatRMI

    }

	/*------------------------------------------------------------------*\
	|*							Public Methods 						  *|
	\*------------------------------------------------------------------*/

    @Override
    public byte[] encrypt(byte[] byteArray) {

        // Encrypt byteArray and simmetrical key
        byte[] byteArrayEncrypted = encryptWithKey(simKey, byteArray);
        byte[] keyEncrypted = encryptWithKey(foreignKey, simKey.getEncoded());

        // Concatenate both byteArray
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try{
            stream.write(keyEncrypted);
            stream.write(byteArrayEncrypted);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.err.println("Error writing to buffer");
        }

        return stream.toByteArray();
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {

        // Decrypt foreign key
        int keyByteSize = publicKey.getEncoded().length;
        byte[] encryptedKey = new byte[keyByteSize];

        ByteArrayInputStream stream = new ByteArrayInputStream(byteArray);
        stream.read(encryptedKey, byteArray.length - 1 - keyByteSize, keyByteSize);

        byte[] foreignKeyDecrypted = decryptWithKey(privateKey, encryptedKey);
        SecretKey foreignSimKey = new SecretKeySpec(foreignKeyDecrypted, 0, foreignKeyDecrypted.length, "DES");

        // Decrypt byte array with simmetrical key
        byte[] encryptedByteArray = null;
        stream.read(encryptedByteArray, 0, byteArray.length - 1 - keyByteSize);

        return decryptWithKey(foreignSimKey, encryptedByteArray);
    }

    @Override
    public void init(PublicKey publicKey){
        this.foreignKey = publicKey;
    }

	/*------------------------------*\
	|*				Getters		    *|
	\*------------------------------*/

	@Override
    public PublicKey getPublicKey()
    {
        return this.publicKey;
    }

	/*------------------------------*\
	|*				Setters		   *|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Private Methods 				        *|
	\*------------------------------------------------------------------*/

	private byte[] encryptWithKey(Key key, byte[] byteArray)
    {
        Cipher cipherSym = null;
        byte[] encryptedByteArray = null;

        try {
            cipherSym = Cipher.getInstance(key.getAlgorithm());
            cipherSym.init(Cipher.ENCRYPT_MODE, simKey);

            encryptedByteArray = cipherSym.doFinal(byteArray);
        }
        catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e)
        {
            e.printStackTrace();
            System.err.println("Error initializing cipherSim");
        }
        catch(BadPaddingException | IllegalBlockSizeException e)
        {
            e.printStackTrace();
            System.err.println("Couldn't encrypt byteArray");
        }

        return encryptedByteArray;
    }

    private byte[] decryptWithKey(Key key, byte[] encryptedByteArray)
        {
            Cipher cipherAsym = null;
            byte[] decryptedByteArray = null;

            try {
                cipherAsym = Cipher.getInstance(key.getAlgorithm());
                cipherAsym.init(Cipher.DECRYPT_MODE, simKey);

                decryptedByteArray = cipherAsym.doFinal(encryptedByteArray);
            }
            catch(NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e)
            {
                e.printStackTrace();
                System.err.println("Error initializing cipherSim");
            }
            catch(BadPaddingException | IllegalBlockSizeException e)
            {
                e.printStackTrace();
                System.err.println("Couldn't encrypt byteArray");
            }

            return decryptedByteArray;
        }

    /*------------------------------------------------------------------*\
   	|*							Attributs Private						*|
   	\*------------------------------------------------------------------*/

    PublicKey publicKey;
    PrivateKey privateKey;
    SecretKey simKey;

    PublicKey foreignKey;
}
