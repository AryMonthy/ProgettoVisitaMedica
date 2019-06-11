package studioMedico.model;

public class Medico {

	private String matricola;
	private String nome;
	private String cognome;
	private String specializzazione;
	private String telefono;
	private String descrizione;
	
	
	public Medico ()
	{}
	
	public Medico(String nome, String cognome, String telefono)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}
	
	public Medico(String matricola, String nome, String cognome, String specializzazione, String telefono)
	{
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.telefono = telefono;
	}
	
	
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMatricola() 
	{
		return matricola;
	}
	public void setMatricola(String matricola) 
	{
		this.matricola = matricola;
	}
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	public String getSpecializzazione() 
	{
		return specializzazione;
	}
	public void setSpecializzazione(String specializzazione) 
	{
		this.specializzazione = specializzazione;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String toString ()
	{
		return "Il medico è: " + nome + " " + cognome + ", reperibile al " + telefono + ", effettua le seguenti visite: " + descrizione; 
	}
	
}
