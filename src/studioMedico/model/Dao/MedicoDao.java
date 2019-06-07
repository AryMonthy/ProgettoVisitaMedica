package studioMedico.model.Dao;

import java.util.List;

import studioMedico.model.Medico;

public interface MedicoDao {

	public void aggiungi(Medico m);
	public Medico visualizza(String matricola);
	public void aggiorna(Medico m);
	public void elimina(String matricola);
	public List<Medico> visualizzaTutto();
}
