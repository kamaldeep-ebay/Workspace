

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, Employee> hm ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
        hm = new HashMap<String,Employee>();
    }
    public void init(ServletConfig config) throws ServletException {
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation = request.getParameter("operation");
		int i = new Integer(operation).intValue();
		
		if(i==1)
		{
			String name = request.getParameter("name");
			String temp = request.getParameter("empno");
			String temp2 = request.getParameter("salary");
			//System.out.println(temp);		System.out.println(temp2);

			int empno= new Integer(temp).intValue();
			float salary = new Float(temp2).floatValue();
			
			Employee e = new Employee(empno, name, salary);
			
			hm.put(name, e);
			//response.setContentType("text/t ");
			PrintWriter pw = response.getWriter();
			pw.println("success");
			pw.close();

		}
		else
		{
			String name = request.getParameter("name");
			
			Employee e = hm.get(name);
			
			StringBuffer strbuf = new StringBuffer();
			
			strbuf.append("<EMP>"+"\n"+"<EMPNO>"+e.empno+"</EMPNO>"
			+"\n"+"<NAME>"+e.name+"</NAME>"+"\n"+"<SALARY>"+e.salary+"</SALARY>");
			
			PrintWriter pw = response.getWriter();
			pw.println(strbuf.toString());
			pw.close();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
