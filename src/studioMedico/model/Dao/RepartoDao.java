package studioMedico.model.Dao;

import java.util.List;

import studioMedico.model.Reparto;

public interface RepartoDao {

	public void aggiungi (Reparto r);
	public Reparto visualizza (String ambito);
	public void aggiorna (Reparto r);
	public void elimina (String id_ambito);
	public List<Reparto> visualizzaTutto();
	
}
