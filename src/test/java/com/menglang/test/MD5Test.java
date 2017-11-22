package com.menglang.test;

import org.junit.Test;

import com.menglang.ssh.util.MD5Util;

public class MD5Test {

	@Test
	public void test1() {
		String encodeUtf8 = MD5Util.EncodeUtf8("abc");
		System.out.println(encodeUtf8);
	}
	
	@Test
	public void test2() {
		String encodeUtf8AddSalt = MD5Util.EncodeUtf8AddSalt("123");
		System.out.println(encodeUtf8AddSalt);
	}
}
