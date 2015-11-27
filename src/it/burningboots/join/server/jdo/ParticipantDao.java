package it.burningboots.join.server.jdo;

import it.burningboots.join.shared.entity.Participant;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class ParticipantDao {

	@SuppressWarnings("unchecked")
	public static Participant findByItemNumber(PersistenceManager pm, String itemNumber) {
		//PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Participant.class);
		query.declareParameters("String p");
		query.setFilter("itemNumber == p");
		query.setOrdering("key ASC");
		List<Participant> entities = (List<Participant>) query.execute(itemNumber);
		Participant result = null;
		if (entities != null) {
			if (entities.size() > 0) result = entities.get(0);
		}
		return result;
	}
	
}
