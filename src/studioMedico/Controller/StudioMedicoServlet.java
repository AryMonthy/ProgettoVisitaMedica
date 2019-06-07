package studioMedico.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studioMedico.model.Dao.UtenteDao;
import studioMedico.model.DaoImpl.UtenteDaoImpl;

/**
 * Servlet implementation class StudioMedicoServlet
 */
@WebServlet("/StudioMedicoServlet")
public class StudioMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtenteDao ut;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudioMedicoServlet() {
        super();     
    }
    
    public void init(ServletConfig config) throws ServletException 
	{
		StudioMedicoServlet.ut= new UtenteDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cf= request.getParameter("cf");
		String p = request.getParameter("password");
		String nome=ut.logIn(cf,p).getNome();
		
		 
		HttpSession session=request.getSession();
		
		if(ut.logIn(cf, p)==null)
		{
			RequestDispatcher d=request.getRequestDispatcher("./view/erroreUtente.jsp");
			d.include(request,response);
		}
		else
		{
			
			session.setAttribute("cf",cf);	
			session.setAttribute("nome",nome);
			RequestDispatcher d = request.getRequestDispatcher("./view/accesso.jsp");
			d.forward(request,response);
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
