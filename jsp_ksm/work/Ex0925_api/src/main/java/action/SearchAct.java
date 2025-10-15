package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAct
 */
@WebServlet("/list.do")
public class SearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.do?search_txt=ㅁㅁㅁㅁ 입력한 정보가 담김
		String search_txt = request.getParameter("search_txt");
		
		// 웹에 보넬 검색어를 UTF-8로 인코딩 
		String search = URLEncoder.encode(search_txt, "UTF8");
		
		//get 방식으로 보네기 / display=20 - 검색결과는 20개
		String urlStr = "https://openapi.naver.com/v1/search/book.json?query="+search+"&display=20";
		
		//접속
		URL url = new URL(urlStr);
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		// 발급 받은 id
		conn.setRequestProperty("X-Naver-Client-Id", "WpwjUdufHt5joIBNWgJI");
		
		// 발급 받은 secret
		conn.setRequestProperty("X-Naver-Client-Secret", "An_calXT1M");
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream() ));
		
	
		String line;
		String resultJson = "";
		//api에서 읽어온 Json구조의 내용들을
		//resultJson변수에 저장
		while( (line = br.readLine() ) != null){
			resultJson += line;
		}
		
		//다하면 닫아주기
		br.close();
		conn.disconnect();
		// 포워딩
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println("["+resultJson+"]");
		
	}

}











































