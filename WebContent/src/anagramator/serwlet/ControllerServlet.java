package anagramator.serwlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import anagramator.bean.AnagramatorBean;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AnagramatorBean anagramatorBean = new AnagramatorBean();
			
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String duzeLitery = request.getParameter("slowoWejsciowe");
		String maleLitery = duzeLitery.toLowerCase();
		
		anagramatorBean.setSlowoWejsciowe(maleLitery);
		request.setAttribute("anagramatorBean", anagramatorBean);
		
		request.getRequestDispatcher("outputServlet.jsp").forward(request, response);

	}

}
