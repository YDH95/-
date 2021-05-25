package com.company.Spring_Annotation_Board.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * SHA256 ��ȣȭ �˰���
 * SHA(Secure Hash Algorithm)���ڷ� �̱� �����Ⱥ��� ǥ������ ������ 
 * �ؽ��Լ� ��������� ���� ���� ���Ǵ� ��ǥ���� ���� �ؽ� �˰����̴�.
 *
 */
public class EncryptUtil {
	public static String EncryptSHA256(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String sha256 = "";
		
		try {
			//SHA256 MessageDigest ��ü �ν��Ͻ� ���
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			//�ؽ��� ������Ʈ
			mdSHA256.update(plainText.getBytes("UTF-8"));
			//�ؽ� ��� ��ȯ���� ����Ʈ �Ҵ��Ѵ�.
			byte[] sha256Hash = mdSHA256.digest();
			//[����] String Ŭ���� ��ü�� ����Ǹ� ���ο� ��ü�� �޸�
			//����ؼ� ���������� StringBuffer ���� �ϳ��� ��ü�� �����ȴ�.
			StringBuffer hexSHA256hash = new StringBuffer();
			
			for(byte b : sha256Hash) {
				String hexString = String.format("%02x", b);
				hexSHA256hash.append(hexString);
			}
			
			sha256 = hexSHA256hash.toString();
			
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sha256;
	}
}
