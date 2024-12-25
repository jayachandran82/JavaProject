package leetcode;

public class LicenseKeyFormatting {

	public static void main(String[] args) {

		LicenseKeyFormatting lic = new LicenseKeyFormatting();
		System.out.println("output  :  " + lic.licenseKeyFormatting("5F3Z-2e-9-w-i", 4));
	}

	String licenseKeyFormatting(String s, int k) {
		String s1 = s.replace("-", "");
		StringBuilder sb = new StringBuilder(s1);
		for (int i = s1.length(); i > k; i = i - k) {
			sb.insert(i - k, '-');
		}
		return sb.toString().toUpperCase();
	}

}
