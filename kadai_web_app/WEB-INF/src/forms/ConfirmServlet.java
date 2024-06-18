package forms;

 import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmServlet extends HttpServlet {
     // POSTメソッドのリクエスト受信時に実行されるメソッド
     public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
    	 
    	// リクエスト・レスポンスの設定
         request.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=UTF-8");

         // JSPからのリクエストデータ取得
         String name = request.getParameter("user_name");
         String email = request.getParameter("user_email");
         String address = request.getParameter("user_address");
         String number = request.getParameter("user_number");

         // リクエストスコープにデータ保存
         request.setAttribute( "name", name );
         request.setAttribute( "email", email );
         request.setAttribute( "address", address);
         request.setAttribute( "number", number);

         // フォワードによる画面遷移
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
         dispatcher.forward(request, response);
    
     }
}