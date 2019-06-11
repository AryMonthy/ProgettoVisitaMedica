package studioMedico.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studioMedico.model.Prenotazione;
import studioMedico.model.Dao.PrenotazioneDao;
import studioMedico.model.Dao.UtenteDao;
import studioMedico.model.DaoImpl.PrenotazioneDaoImpl;





/**
 * Servlet implementation class ServletPrenotazione
 */
@WebServlet("/ServletStoricoPrenotazione")
public class ServletStoricoPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrenotazioneDao pd;
       
    
    public ServletStoricoPrenotazione() {
        super();
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		ServletStoricoPrenotazione.pd= new PrenotazioneDaoImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			String cf= (String) request.getSession().getAttribute("cf");
					
			request.setAttribute("prenotazioni", pd.miaPrenotazione(cf));

			RequestDispatcher d = request.getRequestDispatcher("./view/storicoPrenotazione.jsp");
			d.forward(request,response);
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
