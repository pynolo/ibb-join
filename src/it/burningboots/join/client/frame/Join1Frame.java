package it.burningboots.join.client.frame;

import it.burningboots.join.client.UiSingleton;
import it.burningboots.join.client.UriManager;
import it.burningboots.join.client.UriParameters;
import it.burningboots.join.client.WizardSingleton;
import it.burningboots.join.client.service.DataService;
import it.burningboots.join.client.service.DataServiceAsync;
import it.burningboots.join.shared.AppConstants;
import it.burningboots.join.shared.PropertyBean;
import it.burningboots.join.shared.StringValidator;
import it.burningboots.join.shared.ValidationException;
import it.burningboots.join.shared.entity.Participant;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Join1Frame extends FramePanel implements IWizardPanel {
	
	private final DataServiceAsync dataService = GWT.create(DataService.class);
	
	private UriParameters params = null;
	private VerticalPanel cp = null; // Content panel
	private int participantCount = 0;
	
	private TextBox firstNameText;
	private TextBox lastNameText;
	private TextBox emailText;
	
	public Join1Frame(UriParameters params) {
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
		setTitle("Registration / Iscrizione");
		
		cp.add(new HTML("<i>What is your name?</i><br />"+
				"<b>Quale &egrave; il tuo nome?</b>"));
		firstNameText = new TextBox();
		firstNameText.setValue(participant.getFirstName());
		cp.add(firstNameText);
		cp.add(new HTML("<i>What is your last name?</i><br />"+
				"<b>Quale &egrave; il tuo cognome?</b>"));
		lastNameText = new TextBox();
		lastNameText.setValue(participant.getLastName());
		cp.add(lastNameText);
		
		cp.add(new HTML("<p>&nbsp;</p>"));
		
		cp.add(new HTML("<i>Your email to receive information about the event</i><br/>"+
				"<b>La tua email per ricevere dettagli e avvisi sull'evento</b>"));
		
		emailText = new TextBox();
		emailText.setValue(participant.getEmail());
		cp.add(emailText);
		
		cp.add(new HTML("<p>&nbsp;</p>"));
		
		cp.add(new HTML("<p><i>(You will be signed up to the mailing list for participants and official announcements)</i><br/>"
				+ "<b>(Il tuo indirizzo sar&agrave; inserito nella mailing list dei partecipanti e degli annunci ufficiali)</b></p>"));
		
		//Wizard panel
		WizardButtons wb = new WizardButtons(this, false, true);
		cp.add(wb);
	}
	
	@Override
	public void goForward() {
		//Verification
		String errorMessage = "";
		String firstName = firstNameText.getValue();
		try {
			StringValidator.validateName(firstName);
		} catch (ValidationException e) {
			errorMessage += e.getMessage()+"<br />";
		}
		String lastName = lastNameText.getValue();
		try {
			StringValidator.validateName(lastName);
		} catch (ValidationException e) {
			errorMessage += e.getMessage()+"<br />";
		}
		String email = emailText.getValue();
		try {
			StringValidator.validateEmail(email);
		} catch (ValidationException e) {
			errorMessage += e.getMessage()+"<br />";
		}
		
		if (errorMessage.length() > 0) {
			UiSingleton.get().addWarning(errorMessage);
		} else {
			//Store in bean
			Participant participant = WizardSingleton.get().getParticipantBean();
			participant.setFirstName(firstName);
			participant.setLastName(lastName);
			participant.setEmail(email);
			//Forward
			//UriManager.loadContent(UriManager.STEP_JOIN_1);
			UriManager.loadContent(UriManager.STEP_JOIN_CHECKOUT);
		}
	}
	
	@Override
	public void goBackward() {
		/* disabled */
	}

	
	
	//Async methods
	
	
	private void loadAsyncData(String itemNumberKey) {
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
		
		if (itemNumberKey == null) itemNumberKey = "";
		if (itemNumberKey.equals("")) {
			//No itemNumberKey passed => brand new participant
			dataService.createParticipant(callback);
		} else {
			//itemNumberKey passed => check participant in WizardSingleton and load it from DB if empty
			Participant prt = WizardSingleton.get().getParticipantBean();
			if (prt == null) {
				dataService.findParticipantByKey(itemNumberKey, callback);
			}
		}
		
	}
	
}
