package studioMedico.model.DaoImpl;

import java.sql.Date;
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
		String q=" Insert into Prenotazione (codice_prenotazione, codice_visita, cf, specializzazione, telefono) values (?,?,?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, p.getCodice_prenotazione());
			ps.setString(2, p.getCodice_visita());
			ps.setString(3, p.getCf());
			ps.setDate(4,(Date)p.getGiorno());
			ps.executeQuery();
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
			ps.setDate(4,(Date)p.getGiorno());
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
			if (rs.next())
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
	

}
