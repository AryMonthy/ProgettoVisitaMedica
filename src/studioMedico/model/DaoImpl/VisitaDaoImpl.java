package studioMedico.model.DaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Medico;
import studioMedico.model.Prenotazione;
import studioMedico.model.Utente;
import studioMedico.model.Visita;
import studioMedico.model.Dao.VisitaDao;

public class VisitaDaoImpl implements VisitaDao {

	private DbConnection dbConn;
	PreparedStatement ps;
	

	public VisitaDaoImpl ()
	{
		dbConn = DbConnection.getDbConnection();
	}
	
	
	
	@Override
	public void aggiungi(Visita v) 
	{

		String q=" Insert into Visita (codice_visita, descrizione, matricola_medico) values (?,?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, v.getCodice_visita());
			ps.setString(2, v.getDescrizione());
			ps.setString(3,v.getMatricola_medico());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
			
	}

	@Override
	public Visita visualizza(String descrizione) 
	{
		
		Visita v=null;
		try
		{
			String q = "Select * from Visita v join Medico m on m.matricola=v.matricola_medico"
					+ " where descrizione = ?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, descrizione);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				v=new Visita (rs.getString("codice_visita"), rs.getString("descrizione"), rs.getString("matricola_medico"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public void aggiorna(Visita v) {
		String q= "Update Visita set codice_visita=?, descrizione=?, matricola_medico=?";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1,v.getCodice_visita());
			ps.setString(2, v.getDescrizione());
			ps.setString(3,v.getMatricola_medico());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		
	}

	@Override
	public void elimina(String codice_visita) {
		String q = "Delete from Visita where codice_visita=?";
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, codice_visita);
			ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Visita> visualizzaTutto() {
		ArrayList <Visita> lista = new ArrayList <Visita> ();
		String q="Select * From Visita";
		Visita v = null;
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ps = dbConn.getConnection().prepareStatement(q);
				ps.setString(1,v.getCodice_visita());
				ps.setString(2, v.getDescrizione());
				ps.setString(3,v.getMatricola_medico());
				lista.add(v);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	}

	public List<Visita> leMieVisite ()
	{
		ArrayList <Visita> lista = new ArrayList <Visita> ();
		String q="Select * From Visita v join Prenotazione p on v.codice_visita=p.codice_visita";
		Visita v = null;
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ps = dbConn.getConnection().prepareStatement(q);
				ps.setString(1,v.getCodice_visita());
				ps.setString(2, v.getDescrizione());
				ps.setString(3,v.getMatricola_medico());
				lista.add(v);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
