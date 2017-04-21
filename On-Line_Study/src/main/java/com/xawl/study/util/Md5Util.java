package com.xawl.study.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/*
 * md5º”√‹
 */
public class Md5Util {
		public static String createMd5(String password){
			
		        MessageDigest md5 = null;
		        try {
		            md5 = MessageDigest.getInstance("MD5");
		        } catch (Exception e) {
		            System.out.println(e.toString());
		            e.printStackTrace();
		            return "";
		        }
		        byte[] byteArray=null;
				try {
					byteArray = password.getBytes("UTF-8");
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
		        byte[] md5Bytes = md5.digest(byteArray);
		        StringBuffer hexValue = new StringBuffer();
		        for (int i = 0; i < md5Bytes.length; i++) {
		            int val = (md5Bytes[i]) & 0xff;
		            if (val < 16) {
		                hexValue.append("0");
		            }
		            hexValue.append(Integer.toHexString(val));
		        }
		        return hexValue.toString();
			}
}
