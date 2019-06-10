package studioMedico.model;

import java.sql.Date;


public class Prenotazione {

	private String codice_prenotazione;
	private String codice_visita;
	private String cf;
	private Date giorno;
	
	public Prenotazione()
	{}

	public Prenotazione(String codice_prenotazione, String codice_visita, String cf, Date giorno) 
	{
		this.codice_prenotazione = codice_prenotazione;
		this.codice_visita = codice_visita;
		this.cf = cf;
		this.giorno = giorno;
	}

	public String getCodice_prenotazione() 
	{
		return codice_prenotazione;
	}

	public void setCodice_prenotazione(String codice_prenotazione) 
	{
		this.codice_prenotazione = codice_prenotazione;
	}

	public String getCodice_visita()
	{
		return codice_visita;
	}

	public void setCodice_visita(String codice_visita)
	{
		this.codice_visita = codice_visita;
	}

	public String getCf() 
	{
		return cf;
	}

	public void setCf(String cf)
	{
		this.cf = cf;
	}

	public Date getGiorno()
	{
		return giorno;
	}

	public void setGiorno(Date giorno)
	{
		this.giorno = giorno;
	}

	@Override
	public String toString()
	{
		return "Prenotazione numero " + codice_prenotazione + " " + codice_visita + ", in data: " + giorno;
	}
	
	
	
	
	
}
