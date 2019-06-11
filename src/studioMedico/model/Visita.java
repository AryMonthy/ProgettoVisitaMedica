package studioMedico.model;


public class Visita {

	private String codice_visita;
	private String descrizione;
	private String matricola_medico;
	private String reparto;
	
	
	public Visita()
	{}

	public Visita(String codice_visita, String descrizione, String matricola_medico, String reparto)
	{
		this.codice_visita = codice_visita;
		this.descrizione = descrizione;
		this.matricola_medico = matricola_medico;
		this.reparto=reparto;
	}
	
	public String getReparto() 
	{
		return reparto;
	}

	public void setReparto(String reparto)
	{
		this.reparto = reparto;
	}

	public String getCodice_visita()
	{
		return codice_visita;
	}
	public void setCodice_visita(String codice_visita)
	{
		this.codice_visita = codice_visita;
	}
		
	public String getDescrizione()
	{
		return descrizione;
	}
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}
	
	public String getMatricola_medico() 
	{
		return matricola_medico;
	}
	public void setMatricola_medico(String matricola_medico) 
	{
		this.matricola_medico = matricola_medico;
	}

	@Override
	public String toString()
	{
		return "La visita è: " + codice_visita + " " + descrizione;
	}
	
	
}
