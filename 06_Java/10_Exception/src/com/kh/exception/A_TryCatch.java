package com.kh.exception;

public class A_TryCatch {
		
	/*
	 * 컴파일에러(compile-time error) : 컴파일 시에 발생하는 에러 (실행하기 전부터)
	 * 런타임 에러(runtime error) : 실헹 시에 발생하는 에러
	 * 논리적 에러(logical error) : 실행은 되지만, 의도와 다르게 동작
	 * 
	 * 런타임 에러 두 가지!
	 * - 에러 (error) : 프로그램 코드에 의해서 수습될수 없는 심각한 오류
	 * - 예외 (exception) : 프로그램 코드에 의해서 수습될수 있는 약한 오류
	 * 
	 * 에러는 메모리 부족(OutOfMemory Error)이나 스택오버플로우(StackOverflowError)
	 * 와 같이 일단 발생하면 복구 할 수 없는 심각한 오류
	 * 
	 * 예외는 발생하더라도 수습될수 있는 비교적 덜 심각
	 * 
	 * Object -> Throwable -> Exception
	 * --> IOException -> FilNotFoundException, SockeException, RuntimeException -> ArithmeticException, TndexOutofBoundsException
	 * 
	 * try ~ catch
	 * 
	 * try{
	 * 		// 예외가 발생할 가능성이 있는 코드들
	 * } catch(예외클레스 예외변수){
	 * 		// try에서 예외가 발생하면 실행을 멈추고 catch로 돌아와서 예외 처리
	 * } finally{
	 * 		//에외가 발생하거나 발생하지 않든 무조건 실행
	 * 		// close()...주로 자원 반납
	 * */

	public static void main(String[] args) {
		try {
			throw new Exception();// 고의로 발생
			
			}catch(Exception e) {
				// printStackTrace : 예외발생 당시의 호출스택(call Stack)에 있었던
				// 					 메서드의 정보와 예외 메세지를 화면에 출력
				e.printStackTrace();
				//getMessge : 발생한 예외클라스의 객체에 저장된 메세지
				System.out.println(e.getMessage());
				
			}
		
		}
	}


