package com.yedam.web;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String message = "{\"cmd\":\"login\", \"id\":\"chichi\", \"msg\":\"hi!!!\"}";
		ObjectMapper mapper = new ObjectMapper();
		MsgVO msgVO = mapper.readValue(message, MsgVO.class);
		System.out.println(msgVO.getMsg() + "::::" + msgVO);
	}
}
