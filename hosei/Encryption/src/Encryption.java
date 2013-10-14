import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
/**
����* ͨ��DES���ܽ���ʵ��һ��String�ַ����ļ��ܺͽ���.
����*
����*
����*/
public class Encryption{
public static void main(String[] args) throws NoSuchAlgorithmException,InvalidKeyException, NoSuchPaddingException,
InvalidKeySpecException, IllegalBlockSizeException,BadPaddingException {
//SecureRandom sr = new SecureRandom();
SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
System.out.println("�����===>" + random);
// Ϊ����ѡ���DES�㷨����һ��KeyGenerator����
KeyGenerator kg = KeyGenerator.getInstance("DES");
kg.init(random);
// �����ܳ�
SecretKey key = kg.generateKey();
// ��ȡ�ܳ�����
byte rawKeyData[] = key.getEncoded();
System.out.println("�ܳ�===>" + rawKeyData);
String str = "Liang Bing is god like"; // ����������
// 2.1 >>> ���ü��ܷ���
byte[] encryptedData = encrypt(rawKeyData, str);
// 3.1 >>> ���ý��ܷ���
decrypt(rawKeyData, encryptedData);

}

public static byte[] encrypt(byte rawKeyData[], String str)throws InvalidKeyException, NoSuchAlgorithmException,
IllegalBlockSizeException, BadPaddingException,NoSuchPaddingException, InvalidKeySpecException {

SecureRandom sr = new SecureRandom();

DESKeySpec dks = new DESKeySpec(rawKeyData);

SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey key = keyFactory.generateSecret(dks);
//Cipher����ʵ����ɼ��ܲ���
Cipher cipher = Cipher.getInstance("DES");
// ���ܳ׳�ʼ��Cipher����
cipher.init(Cipher.ENCRYPT_MODE, key, sr);
// ���ڣ���ȡ���ݲ�����
byte data[] = str.getBytes();
// ��ʽִ�м��ܲ���
byte[] encryptedData = cipher.doFinal(data);
System.out.println("���ܺ�===>" + encryptedData);
return encryptedData;
}
/**
* ���ܷ���
*
* @param rawKeyData
* @param encryptedData
* @throws IllegalBlockSizeException
* @throws BadPaddingException
* @throws InvalidKeyException
* @throws NoSuchAlgorithmException
* @throws NoSuchPaddingException
* @throws InvalidKeySpecException
*/
public static String decrypt(byte rawKeyData[], byte[] encryptedData)
throws IllegalBlockSizeException, BadPaddingException,
InvalidKeyException, NoSuchAlgorithmException,
NoSuchPaddingException, InvalidKeySpecException {
// DES�㷨Ҫ����һ�������ε������Դ
SecureRandom sr = new SecureRandom();
// ��ԭʼ�ܳ����ݴ���һ��DESKeySpec����
DESKeySpec dks = new DESKeySpec(rawKeyData);
// ����һ���ܳ׹�����Ȼ��������DESKeySpec����ת����һ��SecretKey����
SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
SecretKey key = keyFactory.generateSecret(dks);
// Cipher����ʵ����ɽ��ܲ���
Cipher cipher = Cipher.getInstance("DES");
// ���ܳ׳�ʼ��Cipher����
cipher.init(Cipher.DECRYPT_MODE, key, sr);
// ��ʽִ�н��ܲ���
byte decryptedData[] = cipher.doFinal(encryptedData);
System.out.println("���ܺ�===>" + new String(decryptedData));
return new String(decryptedData);
}
}