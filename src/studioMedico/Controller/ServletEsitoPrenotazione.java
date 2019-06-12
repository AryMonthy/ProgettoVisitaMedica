package studioMedico.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studioMedico.model.Prenotazione;
import studioMedico.model.Dao.PrenotazioneDao;
import studioMedico.model.DaoImpl.PrenotazioneDaoImpl;

/**
 * Servlet implementation class ServletEsitoPrenotazione
 */
@WebServlet("/ServletEsitoPrenotazione")
public class ServletEsitoPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrenotazioneDao pren;
       
    
    public ServletEsitoPrenotazione() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		ServletEsitoPrenotazione.pren= new PrenotazioneDaoImpl ();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String seleziona= request.getParameter("seleziona");
	
		Date date = null;
		String dt = request.getParameter("d");
		try
		{
			SimpleDateFormat trasformatore = new SimpleDateFormat("yyyy-MM-dd");
			date = trasformatore.parse(dt);			
		}
		
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		int risultato = pren.numeroPrenotazioni(seleziona, date);
		 
		System.out.println(risultato);
		
		if(risultato>=2)
		{
			RequestDispatcher d = request.getRequestDispatcher("./view/esitoPrenotazione.jsp");
			d.forward(request,response);
		}
		else
		{
			Prenotazione p=new Prenotazione ();
			p.setCodice_visita(seleziona);
			String codfis = (String) request.getSession().getAttribute("cf");
			p.setCf(codfis);
			p.setGiorno(date);
			pren.aggiungi(p);

		}			
			
			
		
		
		RequestDispatcher d = request.getRequestDispatcher("./view/esitoPrenotazione.jsp");
		d.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
