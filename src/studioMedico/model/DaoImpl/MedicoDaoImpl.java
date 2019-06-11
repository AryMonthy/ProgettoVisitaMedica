package studioMedico.model.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Medico;
import studioMedico.model.Visita;
import studioMedico.model.Dao.MedicoDao;

public class MedicoDaoImpl implements MedicoDao {

	private DbConnection dbConn;
	PreparedStatement ps;
	
	public MedicoDaoImpl ()
	{
		dbConn = DbConnection.getDbConnection();
	}
	
	@Override
	public void aggiungi(Medico m)
	{
		String q=" Insert into Medico (matricola, nome, cognome, specializzazione, telefono) values (?,?,?,?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, m.getMatricola());
			ps.setString(2, m.getNome());
			ps.setString(3, m.getCognome());
			ps.setString(4, m.getSpecializzazione());
			ps.setString(5, m.getTelefono());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Medico visualizza(String matricola) 
	{
		Medico m=null;
		try
		{
			String q = "Select * from Utente where cf=?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "cf");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				m= new Medico (rs.getString("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("specializzazione"),rs.getString("telefono"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void aggiorna(Medico m)
	{
		String q= "Update Medico set matricola=?, nome=?, cognome=?, specializzazione=?, telefono=?";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, m.getMatricola());
			ps.setString(2, m.getNome());
			ps.setString(3, m.getCognome());
			ps.setString(4, m.getSpecializzazione());
			ps.setString(5, m.getTelefono());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void elimina(String matricola) 
	{

		String q = "Delete from Utente where cf=?";
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "cf");
			ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Medico> visualizzaTutto() 
	{
		ArrayList <Medico> lista = new ArrayList <Medico> ();
		String q="Select * From Medico";
		
		try 
		{
			
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Medico m = new Medico();
				m.setMatricola(rs.getString("matricola"));
				m.setNome(rs.getString("nome"));
				m.setCognome(rs.getString("cognome"));
				m.setSpecializzazione(rs.getString("specializzazione"));
				m.setTelefono(rs.getString("telefono"));
				lista.add(m);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;

	}
	
	@Override
	public Medico visualizzaReparto(String reparto) 
	{
		Medico m=null;
		try
		{
			String q = "Select * from Medico m join Visita v on m.matricola=v.matricola_medico where reparto = ?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, reparto);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				m=new Medico (rs.getString("matricola"),rs.getString("nome"), rs.getString("cognome"), rs.getString("specializzazione"), rs.getString("telefono"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Medico> visualizzaPerReparto(String reparto) 
	{
		ArrayList <Medico> lista = new ArrayList <Medico> ();
		String q="Select * from Medico m join Visita v on m.matricola=v.matricola_medico where lower(reparto) = lower(?)";
		
		try 
		{
			
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ps.setString(1, reparto);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Medico m = new Medico();
				m.setMatricola(rs.getString("matricola"));
				m.setNome(rs.getString("nome"));
				m.setCognome(rs.getString("cognome"));
				m.setSpecializzazione(rs.getString("specializzazione"));
				m.setTelefono(rs.getString("telefono"));
				m.setDescrizione(rs.getString("descrizione"));
				lista.add(m);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	}	

	
}
