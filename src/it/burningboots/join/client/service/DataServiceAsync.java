package it.burningboots.join.client.service;

import it.burningboots.join.shared.PropertyBean;
import it.burningboots.join.shared.entity.Config;
import it.burningboots.join.shared.entity.Participant;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DataService</code>.
 */
public interface DataServiceAsync {

	void getPropertyBean(AsyncCallback<PropertyBean> callback);

	//Config
	void findConfigByKey(String nameKey, AsyncCallback<Config> callback);
	void saveOrUpdateConfig(Config config, AsyncCallback<String> callback);
	
	//Participant
	void findParticipantByKey(String itemNumberKey, AsyncCallback<Participant> callback);
	void findParticipants(AsyncCallback<List<Participant>> callback);
	void createParticipant(AsyncCallback<Participant> callback);
	void saveOrUpdateParticipant(Participant prt, AsyncCallback<String> callback);
	
}
