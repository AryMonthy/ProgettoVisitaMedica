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

import studioMedico.model.Utente;
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
		Utente l= ut.logIn(cf,p);
		
		
		
		HttpSession session=request.getSession();
		
		if(l==null)
		{
			RequestDispatcher d=request.getRequestDispatcher("./view/erroreLogIn.jsp");
			d.include(request,response);
		}
//		else
//		{
//			String nome=l.getNome();
//			String cognome=l.getCognome();
//			String città= l.getCittà();
//			String telefono = l.getTelefono();
//			session.setAttribute("cf",cf);	
//			session.setAttribute("nome",nome);
//			session.setAttribute("cognome", cognome);
//			session.setAttribute("città", città);
//			session.setAttribute("telefono", telefono);
//			RequestDispatcher d = request.getRequestDispatcher("./view/areaRiservata.jsp");
//			d.forward(request,response);
//		}
	
		
		if(request.getParameter("push").equals("Login"))
		{
			String nome=l.getNome();
			String cognome=l.getCognome();
			String città= l.getCittà();
			String telefono = l.getTelefono();
			session.setAttribute("cf",cf);	
			session.setAttribute("nome",nome);
			session.setAttribute("cognome", cognome);
			session.setAttribute("città", città);
			session.setAttribute("telefono", telefono);
			RequestDispatcher d = request.getRequestDispatcher("./view/areaRiservata.jsp");
			d.forward(request,response);
		}
		if (request.getParameter("push").equals("Registrati"))
		{
			RequestDispatcher d=request.getRequestDispatcher("./view/registrazione.jsp");
			d.include(request,response);
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
