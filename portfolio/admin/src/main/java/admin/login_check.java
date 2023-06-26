package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_check.do")
public class login_check extends HttpServlet {
	PrintWriter pw = null;
	login_go lg = new login_go();
	private static final long serialVersionUID = 1L;
	
    public login_check() {
        super();
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		this.pw = res.getWriter();
		
		String t1 = req.getParameter("t1").intern();
		String t2 = req.getParameter("t2").intern();
		
		String result = this.lg.logingo(t1,t2);
		String result2[] = result.split(",");
		if(result2[0] == "true") {
			HttpSession session = req.getSession();
			session.setAttribute("unm", result2[1]);
			pw.write("<script>alert('"+result2[1]+"님 로그인 되셨습니다.'); location.href = './index.html';</script>");
		}
		else {
			pw.write("<script>alert('아이디 및 패스워드를 확인해주세요.'); location.href = './index.html';</script>");
		}
	}

}
