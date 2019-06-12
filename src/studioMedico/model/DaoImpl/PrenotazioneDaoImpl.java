package studioMedico.model.DaoImpl;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Prenotazione;
import studioMedico.model.Dao.PrenotazioneDao;


public class PrenotazioneDaoImpl implements PrenotazioneDao {
	
	private DbConnection dbConn;
	PreparedStatement ps;
	
	public PrenotazioneDaoImpl ()
	{
		dbConn = DbConnection.getDbConnection();
	}
	

	@Override
	public void aggiungi(Prenotazione p)
	{
		String q=" Insert into Prenotazione values (codice_prenotazione.nextval,?,?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, p.getCodice_visita());
			ps.setString(2, p.getCf());
			java.sql.Date r=new java.sql.Date(p.getGiorno().getTime());
			ps.setDate(3,r);
			ps.executeQuery();
			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Prenotazione visualizza(String codice_prenotazione)
	{

		Prenotazione p=null;
		try
		{
			String q = "Select * from Prenotazione where codice_prenotazione=?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, codice_prenotazione);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				p= new Prenotazione (rs.getString("codice_prenotazione"), rs.getString("codice_visita"), rs.getString("cf"), rs.getDate("giorno"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void aggiorna(Prenotazione p) 
	{
		String q= "Update Prenotazione set codice_prenotazione=?, codice_visita=?, cf=?, giorno=?";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, p.getCodice_prenotazione());
			ps.setString(2, p.getCodice_visita());
			ps.setString(3, p.getCf());
			java.sql.Date r=new java.sql.Date(p.getGiorno().getTime());
			ps.setDate(4,r);
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		
	}

	@Override
	public void elimina(String codice_prenotazione)
	{
		String q = "Delete from Prenotazione where codice_prenotazione=?";
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, codice_prenotazione);
			ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<Prenotazione> visualizzaTutto() {
		ArrayList <Prenotazione> lista = new ArrayList <Prenotazione> ();
		String q="Select * From Prenotazione";
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Prenotazione p = new Prenotazione();
				p.setCf(rs.getString("cf"));
				p.setCodice_prenotazione(rs.getString("codice_prenotazione"));
				p.setCodice_visita(rs.getString("codice_visita"));
				p.setGiorno(rs.getDate("giorno"));
		
				lista.add(p);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	
	}
	
	public List<Prenotazione> miaPrenotazione (String cf) 
	{
		ArrayList <Prenotazione> lista = new ArrayList <Prenotazione> ();
		String q = "Select * from Prenotazione p join Visita v on p.codice_visita=v.codice_visita where p.cf=?";
		try
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, cf);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				 Prenotazione p= new Prenotazione ();
				 p.setCf(rs.getString("cf"));
				 p.setCodice_prenotazione(rs.getString("codice_prenotazione"));
				 p.setCodice_visita(rs.getString("codice_visita"));
				 p.setGiorno(rs.getDate("giorno"));
				 p.setDescrizione(rs.getString("descrizione"));
				 
				 lista.add(p);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return lista;
	
	}


	@Override
	public int numeroPrenotazioni(String codice_visita, Date giorno) 
	{
		int ris=-1;
		//String q="select count (codice_visita, giorno) conteggio from prenotazione Group by codice_visita,giorno having codice_visita=?";
		String q="select giorno,count(*) conteggio from prenotazione where giorno=? and codice_visita=? group by giorno";
		
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			java.sql.Date r=new java.sql.Date(giorno.getTime());
			ps.setDate(1,r);
			ps.setString(2, codice_visita);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ris= rs.getInt("conteggio");
			}
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return ris;
	}
	
	

}
