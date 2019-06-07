package studioMedico.model.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Medico;
import studioMedico.model.Dao.MedicoDao;

public class MedicoDaoImpl implements MedicoDao {

	private DbConnection dbConn;
	PreparedStatement ps;
	
	
	@Override
	public void aggiungi(Medico m)
	{
		String q=" Insert into Medico (matricola, nome, cognome, specializzazione, telefono) values (?,?,?,?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "matricola");
			ps.setString(2, "nome");
			ps.setString(3, "cognome");
			ps.setString(4, "specializzazione");
			ps.setString(5, "telefono");
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
			ps.setString(1, "matricola");
			ps.setString(2, "nome");
			ps.setString(3, "cognome");
			ps.setString(4, "specializzazione");
			ps.setString(5, "telefono");
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
	public List<Medico> visualizzaTutto() {
		ArrayList <Medico> lista = new ArrayList <Medico> ();
		String q="Select * From Medico";
		Medico m = null;
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ps.setString(1,"matricola");
				ps.setString(2,"nome");
				ps.setString(3,"cognome");
				ps.setString(4,"specializzazione");
				ps.setString(5,"telefono");
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
