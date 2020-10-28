package poly.util;

public class EncryptTest {
	public static void main(String[] args) throws Exception {

		System.out.println("------------------------------");
		System.out.println("해시 암호화 알고리즘");

		String str = "암호화할 문자열";
		// 암호화 문자열
		String hashEnc = EncryptUtil.encHashSHA256(str);
		// 복호화가 불가능한 해시암호화 알고리즘 실행
		System.out.println("hashEnc : " + hashEnc);

		System.out.println("AES128-CBC 암, 복호화 알고리즘");

		String enc = EncryptUtil.encAES128CBC(str);
		// AES128-CBC 암호화 알고리즘 실행

		System.out.println("enc : " + enc);
		// AES128-CBC 암호화 알고리즘 출력

		String dec = EncryptUtil.decAES128CBC(enc);
		// AES128-CBC 복호화 알고리즘 실행

		System.out.println("dec : " + dec);
		// AES128-CBC 복호화 알고리즘 출력

		System.out.println("------------------------------");
	}
}