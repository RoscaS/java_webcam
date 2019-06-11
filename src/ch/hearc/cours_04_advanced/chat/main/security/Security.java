package ch.hearc.cours_04_advanced.chat.main.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.security.*;
import java.util.Arrays;

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


        // Initialize symmetrical key;
        try{
            this.symKey = KeyGenerator.getInstance("DES").generateKey();
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
        byte[] byteArrayEncrypted = encryptWithKey(symKey, byteArray);
        byte[] keyEncrypted = encryptWithKey(foreignKey, symKey.getEncoded());

        symKeyEncryptedSize = keyEncrypted.length;

        // Concatenate both byteArray
        // NOT WORKING
        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try{
            stream.write(keyEncrypted);
            stream.write(byteArrayEncrypted);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.err.println("Error writing to buffer");
        }

        System.out.println("Message sent length" + stream.toByteArray().length);

        return stream.toByteArray();
        */

        byte[] message = new byte[byteArrayEncrypted.length+keyEncrypted.length];
        for(int i = 0; i < byteArrayEncrypted.length;i++)
        {
            message[i] = byteArrayEncrypted[i];
        }

        for(int i = 0; i < keyEncrypted.length;i++)
        {
            message[i + byteArrayEncrypted.length] = keyEncrypted[i];
        }

        System.out.println("Message sent length " + message.length);

        return message;
    }

    @Override
    public byte[] decrypt(byte[] byteArray) {

        // Decrypt foreign key
        if(symKeyEncryptedSize == 0)
        {
            symKeyEncryptedSize = encryptWithKey(foreignKey, symKey.getEncoded()).length;
        }

        System.out.println("Message received length " + byteArray.length);
        int keyByteSize = symKeyEncryptedSize;
        byte[] encryptedKey = new byte[keyByteSize];

        int indexEncryptedKey = 0;
        for(int i=byteArray.length-keyByteSize; i<byteArray.length;i++)
        {
            encryptedKey[indexEncryptedKey] = byteArray[i];
            indexEncryptedKey++;
        }

        byte[] foreignKeyDecrypted = decryptWithKey(privateKey, encryptedKey);
        SecretKey foreignSimKey = new SecretKeySpec(foreignKeyDecrypted, 0, foreignKeyDecrypted.length, "DES");

        // Decrypt byte array with symmetrical key
        byte[] encryptedByteArray = new byte[byteArray.length - keyByteSize];

        for(int i=0; i<byteArray.length - keyByteSize; i++)
        {
            encryptedByteArray[i] = byteArray[i];
        };

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

        if(key == null)
        {
            System.err.println("ERREUR, keyIsNull");
        }

        try {
            cipherSym = Cipher.getInstance(key.getAlgorithm());
            cipherSym.init(Cipher.ENCRYPT_MODE, key);

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
                cipherAsym.init(Cipher.DECRYPT_MODE, key);

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
    SecretKey symKey;
    int symKeyEncryptedSize = 0;

    PublicKey foreignKey;
}
