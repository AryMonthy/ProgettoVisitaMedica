package studioMedico.model.Dao;

import java.util.List;

import studioMedico.model.Visita;

public interface VisitaDao {

	public void aggiungi(Visita v);
	public Visita visualizza(String ambito);
	public void aggiorna(Visita v);
	public void elimina(String codice_visita);
	public List<Visita> visualizzaTutto();
	public List<Visita> leMieVisite (String cf);
}
