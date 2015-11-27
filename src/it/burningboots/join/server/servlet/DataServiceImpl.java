package it.burningboots.join.server.servlet;

import it.burningboots.join.client.service.DataService;
import it.burningboots.join.server.PropertyReader;
import it.burningboots.join.server.jdo.EntityDao;
import it.burningboots.join.server.jdo.PMF;
import it.burningboots.join.shared.PropertyBean;
import it.burningboots.join.shared.entity.Config;
import it.burningboots.join.shared.entity.Participant;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DataServiceImpl extends RemoteServiceServlet implements
		DataService {

	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	@Override
	public PropertyBean getPropertyBean() {
		PropertyBean bean = new PropertyBean();
		bean.setVersion(PropertyReader.readProperty(PropertyReader.PROPERTY_VERSION));
		String closedString = PropertyReader.readProperty(PropertyReader.PROPERTY_CLOSED);
		if (closedString.equals("false")) bean.setClosed(false);
		if (closedString.equals("true")) bean.setClosed(true);
		bean.setBedAvailableFrom(PropertyReader.readProperty(PropertyReader.PROPERTY_BED_FROM));
		bean.setBedAvailableUntil(PropertyReader.readProperty(PropertyReader.PROPERTY_BED_UNTIL));
		bean.setTentAvailableFrom(PropertyReader.readProperty(PropertyReader.PROPERTY_TENT_FROM));
		bean.setTentAvailableUntil(PropertyReader.readProperty(PropertyReader.PROPERTY_TENT_UNTIL));
		return bean;
	}
	
	@Override
	public String findConfigValueByKey(String key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Config config = EntityDao.findByKey(pm, key, Config.class);
		if (config != null) return config.getVal();
		return null;
	}

	@Override
	public String saveOrUpdateConfig(Config config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participant findParticipantByKey(String key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Participant p = EntityDao.findByKey(pm, key, Participant.class);
		return p;
	}

	@Override
	public List<Participant> findParticipants() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Participant> pList = EntityDao.find(pm, Participant.class);
		return pList;
	}

	
}
