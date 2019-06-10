package studioMedico.Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studioMedico.model.Dao.PrenotazioneDao;
import studioMedico.model.DaoImpl.PrenotazioneDaoImpl;


/**
 * Servlet implementation class ServletPrenotazione
 */
@WebServlet("/ServletPrenotazione")
public class ServletPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrenotazioneDao pt; 
       
    
    public ServletPrenotazione() {
        super();
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		ServletPrenotazione.pt=new PrenotazioneDaoImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
