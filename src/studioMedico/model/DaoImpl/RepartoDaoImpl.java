package studioMedico.model.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studioMedico.connection.DbConnection;
import studioMedico.model.Reparto;
import studioMedico.model.Dao.RepartoDao;

public class RepartoDaoImpl implements RepartoDao {

	private DbConnection dbConn;
	PreparedStatement ps;
	

	@Override
	public void aggiungi(Reparto r)
	{
		String q=" Insert into Reparto (id_ambito, ambito) values (?,?)";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "id_ambito");
			ps.setString(2, "ambito");
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Reparto visualizza(String ambito)
	{
		Reparto r =null;
		try
		{
			String q = "Select * from Reparto where ambito=?";
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "ambito");
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				r = new Reparto (rs.getString("id_ambito"), rs.getString("ambito"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public void aggiorna(Reparto r)
	{
		String q= "Update Medico set id_ambito=?, ambito=?";
		try {
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "id_ambito");
			ps.setString(2, "ambito");
			ps.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void elimina(String id_ambito) 
	{

		String q = "Delete from Reparto where id_ambito=?";
		try 
		{
			ps = dbConn.getConnection().prepareStatement(q);
			ps.setString(1, "id_ambito");
			ps.executeQuery();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reparto> visualizzaTutto() 
	{
		ArrayList <Reparto> lista = new ArrayList <Reparto> ();
		String q="Select * From Reparto";
		Reparto r = null;
		try 
		{
			ps = DbConnection.getDbConnection().getConnection().prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ps.setString(1,"id_ambito");
				ps.setString(2,"ambito");
				lista.add(r);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return lista;
	
	}
}
