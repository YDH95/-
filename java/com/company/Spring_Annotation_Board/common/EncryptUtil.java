package com.company.Spring_Annotation_Board.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * SHA256 암호화 알고리즘
 * SHA(Secure Hash Algorithm)약자로 미국 국가안보국 표준으로 지정된 
 * 해쉬함수 현재까지도 가장 많이 사용되는 대표적인 보안 해쉬 알고리즘이다.
 *
 */
public class EncryptUtil {
	public static String EncryptSHA256(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String sha256 = "";
		
		try {
			//SHA256 MessageDigest 객체 인스턴스 얻기
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			//해쉬값 업데이트
			mdSHA256.update(plainText.getBytes("UTF-8"));
			//해쉬 계산 반환값은 바이트 할당한다.
			byte[] sha256Hash = mdSHA256.digest();
			//[이유] String 클래스 객체는 변경되면 새로운 객체가 메모리
			//계속해서 생성되지만 StringBuffer 오직 하나의 객체만 생성된다.
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
