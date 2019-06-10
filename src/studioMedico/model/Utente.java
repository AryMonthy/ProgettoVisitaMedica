package studioMedico.model;

import java.sql.Date;

public class Utente {

	private String cf;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String città;
	private String telefono;
	private String password;
	
	public Utente ()
	{}
	
	public Utente(String cf, String nome, String cognome, Date dataNascita, String città, String telefono,
			String password) 
	{
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.città = città;
		this.telefono = telefono;
		this.password = password;
	}



	public String getCf()
	{
		return cf;
	}
	public void setCf(String cf)
	{
		this.cf = cf;
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
	
	public Date getDataNascita() 
	{
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita)
	{
		this.dataNascita = dataNascita;
	}
	
	public String getCittà() 
	{
		return città;
	}
	public void setCittà(String città)
	{
		this.città = città;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String toString ()
	{
		return "L'utente è: " + nome + " " + cognome + " nato a " + città + " il " + dataNascita + " recapito telefonico " + telefono; 
	}
	
}
