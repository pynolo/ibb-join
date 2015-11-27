package it.burningboots.join.client.service;

import it.burningboots.join.shared.PropertyBean;
import it.burningboots.join.shared.entity.Config;
import it.burningboots.join.shared.entity.Participant;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("dataService")
public interface DataService extends RemoteService {
	
	//Properties
	public PropertyBean getPropertyBean();
	
	//Config
	public String findConfigValueByKey(String key);
	public String saveOrUpdateConfig(Config config);
	
	//Participants
	public Participant findParticipantByKey(String key);
	public List<Participant> findParticipants();
}
