package it.burningboots.join.client.frame;

import it.burningboots.join.client.UiSingleton;
import it.burningboots.join.client.UriManager;
import it.burningboots.join.client.UriParameters;
import it.burningboots.join.client.WizardSingleton;
import it.burningboots.join.client.service.DataService;
import it.burningboots.join.client.service.DataServiceAsync;
import it.burningboots.join.shared.AppConstants;
import it.burningboots.join.shared.PropertyBean;
import it.burningboots.join.shared.entity.Participant;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Join0Frame extends FramePanel implements IWizardPanel {
	
	private final DataServiceAsync dataService = GWT.create(DataService.class);
	
	private UriParameters params = null;
	private VerticalPanel cp = null; // Content panel
	private int participantCount = 0;
	
	private TextBox firstNameText;
	private TextBox lastNameText;
	private TextBox emailText;
	
	public Join0Frame(UriParameters params) {
		super();
		if (params != null) {
			this.params = params;
		} else {
			this.params = new UriParameters();
		}
		String itemNumberKey = this.params.getValue(AppConstants.PARAMS_ID);
		cp = new VerticalPanel();
		this.add(cp);
		this.setWidth("100%");
		loadAsyncData(itemNumberKey);
	}
	
	private void draw() {
		PropertyBean properties = WizardSingleton.get().getPropertyBean();
		Participant participant = WizardSingleton.get().getParticipantBean();
		
		//Check if joining wizard can be active
		if ( properties.getClosed() ) {
			UriManager.loadContent(UriManager.STEP_CLOSED);
		}
		if ( (participantCount >= properties.getBedAvailableUntil()) &&
				(participantCount >= properties.getTentAvailableUntil()) ) {
			UriManager.loadContent(UriManager.STEP_FULL);
		}
		//TITLE
		GWT.debugger();//TODO
		setTitle("Registration / Iscrizione");
		
		cp.add(new HTML("<i>What are your first and last name?</i><br/>"+
				"<b>Quale &egrave; il tuo nome e cognome?</b>"));
		
		HorizontalPanel nameHolder = new HorizontalPanel();
		firstNameText = new TextBox();
		firstNameText.setValue(participant.getFirstName());
		nameHolder.add(firstNameText);
		lastNameText = new TextBox();
		lastNameText.setValue(participant.getLastName());
		nameHolder.add(lastNameText);
		cp.add(nameHolder);
		
		cp.add(new HTML("<p>&nbsp;</p>"));
		
		cp.add(new HTML("<i>Your email to receive important info about the event</i><br/>"+
				"<b>La tua email per ricevere dettagli e avvisi sull'evento</b>"));
		
		emailText = new TextBox();
		emailText.setValue(participant.getEmail());
		cp.add(emailText);
		
		
	}
	
	@Override
	public void goForward() {
		//TODO
	}
	
	@Override
	public void goBackward() {
		//TODO
	}

	
	
	//Async methods
	
	private void loadAsyncData(String itemNumberKey) {
		GWT.debugger();
		AsyncCallback<Participant> callback = new AsyncCallback<Participant>() {
			@Override
			public void onFailure(Throwable caught) {
				UiSingleton.get().addInfo(caught.getMessage());
			}
			@Override
			public void onSuccess(Participant result) {
				WizardSingleton.get().setParticipantBean(result);
				draw();
			}
		};
		if (itemNumberKey != null) {
			if (!itemNumberKey.equals("")) {
				dataService.findParticipantByKey(itemNumberKey, callback);
			} else {
				dataService.createParticipant(callback);
			}
		} else {
			dataService.createParticipant(callback);
		}
	}
	
}
