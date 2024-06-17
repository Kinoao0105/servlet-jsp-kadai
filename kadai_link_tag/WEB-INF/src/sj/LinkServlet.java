package sj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getJspData(request, response);
    }

    private void getJspData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
        String userName = request.getParameter("name");
        
        // JSPに送るデータをリクエスト属性に設定
        request.setAttribute("text", "Servletからデータを受信しました：" +userName + "さん、こんにちは！");
        
        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?");
        dispatcher.forward(request, response);
    }
}
