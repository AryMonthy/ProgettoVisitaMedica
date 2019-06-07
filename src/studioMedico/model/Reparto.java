package studioMedico.model;

public class Reparto {

	private String id_ambito;
	private String ambito;
	
	
	public Reparto() 
	{}
	
	
	public Reparto(String id_ambito, String ambito) 
	{
		super();
		this.id_ambito = id_ambito;
		this.ambito = ambito;
	}


	public String getId_ambito() 
	{
		return id_ambito;
	}
	public void setId_ambito(String id_ambito) 
	{
		this.id_ambito = id_ambito;
	}
	
	public String getAmbito()
	{
		return ambito;
	}
	public void setAmbito(String ambito) 
	{
		this.ambito = ambito;
	}
	
	
}
