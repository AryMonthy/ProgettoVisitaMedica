package studioMedico.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studioMedico.model.Medico;
import studioMedico.model.Dao.MedicoDao;
import studioMedico.model.DaoImpl.MedicoDaoImpl;


@WebServlet("/ServletPrenotazione")
public class ServletPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MedicoDao md;  
    
    public ServletPrenotazione() {
        super();
       
    }

    public void init(ServletConfig config) throws ServletException 
	{
    	ServletPrenotazione.md = new MedicoDaoImpl();
	}
	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			String reparto = request.getParameter("reparto");
			List<Medico> lm = md.visualizzaPerReparto(reparto);
			request.setAttribute("listaVisite", lm);
			RequestDispatcher d = request.getRequestDispatcher("./view/effettuaPrenotazione.jsp");
			d.forward(request,response);
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
