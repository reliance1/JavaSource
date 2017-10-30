package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalculateService;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/form/calculate")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		String cal = request.getParameter("operator");
		int result, value1, value2;
		String resultMessage;
		try {
			value1 = Integer.parseInt(num1);
			value2 = Integer.parseInt(num2);
			
			CalculateService service = CalculateService.getInstance();
			resultMessage = service.calculate(value1, cal, value2);
			
			request.setAttribute("result", resultMessage);
			request.getRequestDispatcher("/WEB-INF/view/calc_result.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			resultMessage = "피연산자는 정수만 가능합니다." + e.getMessage();
			// calculate_form.jsp로 이동
			request.setAttribute("error_message", resultMessage);
			request.getRequestDispatcher("/calculate_form.jsp").forward(request, response);
		}

	}
}
