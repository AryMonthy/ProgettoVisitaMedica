package studioMedico.model.DaoImpl;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import studioMedico.model.Prenotazione;
import studioMedico.model.Utente;
import studioMedico.model.Dao.PrenotazioneDao;

public class Principale {

	public static void main(String[] args) {
		
//		UtenteDaoImpl cis=new UtenteDaoImpl ();
		
//		VisitaDaoImpl ns= new VisitaDaoImpl();
		java.util.Date d1 = new java.util.Date(2019, 10, 04);
		Date d = new Date(d1.getTime());
//		Utente u = new Utente ("STRN98ST34NJT","Giorgio", "Capasso", d, "Sulmona", "3387613895", "francy" );
//		PrenotazioneDaoImpl n= new PrenotazioneDaoImpl();
//		cis.aggiungi(u);
		
//		double V[]= {9.00, 10.00, 11.00, 12.00, 14.00, 15.00, 16.00, 17.00, 18.00, 19.00};
//		double k=9.00;
//		for(int i=0; i<=V.length; i++)
//		{
//			if(V[i])
//		}

		
		PrenotazioneDaoImpl pdao = new PrenotazioneDaoImpl();
		MedicoDaoImpl md= new MedicoDaoImpl();
		//System.out.println(md.visualizzaPerReparto("Dermatologia"));
		
		
		
		
//		Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
//		calendar.setTime(list.get(0).getGiorno());   // assigns calendar to given date 
		; // gets hour in 24h format
//		calendar.get(Calendar.HOUR);        // gets hour in 12h format
//		calendar.get(Calendar.MONTH);       // gets month number, NOTE this is zero based!
		
		
	}

}
