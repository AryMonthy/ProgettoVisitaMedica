package studioMedico.model.DaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Utente;
import studioMedico.model.Dao.UtenteDao;

public class UtenteDaoImpl implements UtenteDao{
	
	private DbConnection dbConn;
	PreparedStatement ps;
	
	
	public UtenteDaoImpl ()
	{
		dbConn = DbConnection.getDbConnection();
	}
	
	
	@Override
	public void aggiungi(Utente u)
	{
		String q="Insert into Utente (cf, nome, cognome, dataNascita, città, telefono, password) values (?,?,?,?,?,?,?)";
		try
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1,u.getCf());
			ps.setString(2,u.getNome());
			ps.setString(3,u.getCognome());
			ps.setDate(4,(Date)u.getDataNascita());
			ps.setString(5,u.getCittà());
			ps.setString(6,u.getTelefono());
			ps.setString(7,u.getPassword());
			ps.executeQuery();
			ps.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente visualizza(String cf) 
	{
		Utente u=null;
		try
		{
			String q = "Select * from Utente where cf = ?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, cf);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				u=new Utente (rs.getString("cf"), rs.getString("nome"), rs.getString("cognome"), rs.getDate("dataNascita"),  rs.getString("città"),  rs.getString("telefono"), rs.getString("password"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void aggiorna(Utente u)
	{
		String q = "Update Utente SET cf=?, nome=?, cognome=?, dataNascita=?, città=?, telefono=?, password=? Where cf='"+ u.getCf()+"'"; 
		try
		{
			PreparedStatement ps=dbConn.getConnection().prepareStatement(q);
			ps.setString(1,u.getCf());
			ps.setString(2,u.getNome());
			ps.setString(3,u.getCognome());
			ps.setDate(4,(Date)u.getDataNascita());
			ps.setString(5,u.getCittà());
			ps.setString(6,u.getTelefono());
			ps.setString(7,u.getPassword());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
	}

	@Override
	public void elimina(String cf) 
	{
		String q = "Delete from Utente where cf=?";
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, cf);
			ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}


	@Override
	public List<Utente> visualizzaTutto()
	{
		ArrayList <Utente> lista = new ArrayList <Utente> ();
		String q="Select * From Utente";
		Utente u = null;
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ps.setString(1,u.getCf());
				ps.setString(2,u.getNome());
				ps.setString(3,u.getCognome());
				ps.setDate(4,(Date)u.getDataNascita());
				ps.setString(5,u.getCittà());
				ps.setString(6,u.getTelefono());
				ps.setString(7,u.getPassword());
				lista.add(u);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
		
		
	}

	@Override
	public Utente logIn(String cf, String password)
	{
		String q = "Select * from Utente where cf=? AND password=?";
		Utente u = null;
		try 
		{
			PreparedStatement ps=dbConn.getConnection().prepareStatement(q);
			ps.setString(1, cf);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				u=new Utente (cf, rs.getString("nome"), rs.getString("cognome"), rs.getDate("dataNascita"),  rs.getString("città"),  rs.getString("telefono"),password);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return u;
	}
	
	
}
