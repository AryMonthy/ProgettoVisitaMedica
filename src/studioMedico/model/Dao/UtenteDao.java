package studioMedico.model.Dao;

import java.util.List;

import studioMedico.model.Utente;

public interface UtenteDao {

	public void aggiungi (Utente u);
	public Utente visualizza (String cf);
	public void aggiorna (Utente u);
	public void elimina (String cf);
	public List <Utente> visualizzaTutto();
	public Utente logIn(String cf, String password);

}
