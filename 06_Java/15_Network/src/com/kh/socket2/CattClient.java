package com.kh.socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class CattClient {

	public static void main(String[] args) {
		
		try {
			// 1. 소켓 생성
			Socket socket = new Socket("192.168.0.35", 3000);
			System.out.println("서버와 연결 되었습니다..");
			
			SendThread send = new SendThread(socket);
			send.start();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(br != null) {
				System.out.println(br.readLine());
			}
			
		} catch (IOException e) {
			System.out.println("서버 접속 종료...");
			
			e.printStackTrace();
		}
	}

}
