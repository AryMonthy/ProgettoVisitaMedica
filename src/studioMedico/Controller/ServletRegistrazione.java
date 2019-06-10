package studioMedico.Controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtenteDao utn;   
    
	
    public ServletRegistrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException 
	{
		ServletRegistrazione.utn= new UtenteDaoImpl();
	}
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String cf= request.getParameter("cf");
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String dataNascita=request.getParameter("dataNascita");
			String città=request.getParameter("citta");
			String telefono=request.getParameter("telefono");
			String p = request.getParameter("p");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date c = sdf.parse(dataNascita);
			java.sql.Date dateSql = new java.sql.Date(c.getTime());
			Utente utente= new Utente (cf,nome,cognome, dateSql,città, telefono, p);
			utn.aggiungi(utente);
			
			HttpSession session=request.getSession();
			request.getSession().invalidate();
		
			request.getSession().setAttribute("cf", utente.getCf());
			request.getSession().setAttribute("nome", utente.getNome());
			request.getSession().setAttribute("cognome", utente.getCognome());
			request.getSession().setAttribute("città", utente.getCittà());
			request.getSession().setAttribute("dataNascita", utente.getDataNascita());
			request.getSession().setAttribute("telefono", utente.getTelefono());
			request.getSession().setAttribute("password", utente.getPassword());
			
			
			RequestDispatcher d = request.getRequestDispatcher("./view/areaRiservata.jsp");
			d.forward(request,response);
		} 
		catch(Exception e) 
		{
			//gestione dell'errore
//			RequestDispatcher d = request.getRequestDispatcher("./view/accesso.jsp");
//			d.forward(request,response);
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
