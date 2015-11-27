package it.burningboots.join.server.jdo;

import it.burningboots.join.shared.entity.Entity;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.apache.commons.beanutils.PropertyUtils;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class EntityDao {

	public static <T extends Entity> Key getKey(String key, Class<T> cls) {
		return KeyFactory.createKey(cls.getSimpleName(), key);
	}
	
	public static void saveOrUpdate(PersistenceManager pm, Entity entity) {
		//PersistenceManager pm = PMF.get().getPersistenceManager();
		String pKey = KeyFactory.keyToString(getKey(entity.getKey(), entity.getClass()));
		//pm.currentTransaction().begin();
		try {
			//Update
			Entity persisted = pm.getObjectById(entity.getClass(), pKey);
			PropertyUtils.copyProperties(persisted, entity);
		} catch (JDOObjectNotFoundException e) {
			//Save
			pm.makePersistent(entity);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();/* this cannot happen */
		}
		//pm.currentTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public static <T extends Entity> List<T> find(PersistenceManager pm, Class<T> cls) {
		//PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(cls);
		query.setOrdering("key ASC");
		List<T> entities = (List<T>) query.execute();
		return entities;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Entity> T findByKey(PersistenceManager pm, String key, Class<T> cls) {
		//PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(cls);
		String pKey = KeyFactory.keyToString(getKey(key, cls));
		query.declareParameters("String pKey");
		query.setFilter("key == pKey");
		query.setOrdering("key ASC");
		List<T> entities = (List<T>) query.execute(pKey);
		T result = null;
		if (entities != null) {
			if (entities.size() > 0) result = entities.get(0);
		}
		return result;
	}
	
}
