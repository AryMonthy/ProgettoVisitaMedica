package studioMedico.model.Dao;

import java.util.List;

import studioMedico.model.Prenotazione;

public interface PrenotazioneDao {

	public void aggiungi(Prenotazione p);
	public Prenotazione visualizza(String codice_prenotazione);
	public void aggiorna(Prenotazione p);
	public void elimina(String codice_prenotazione);
	public List<Prenotazione> visualizzaTutto();
	public List<Prenotazione> miaPrenotazione (String cf);
	
	
}
