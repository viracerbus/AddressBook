package com.gac.edu.mcs270.hvidsten.client;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.gac.edu.mcs270.hvidsten.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gac.edu.mcs270.hvidsten.client.GetAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.client.SubmitAddressBookEntryService;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddressBook implements EntryPoint {
	private final AddressBookView addressBookView = new AddressBookView();
	private final GetAddressBookEntryServiceAsync getAddressBookEntryService = GWT
			.create(GetAddressBookEntryService.class);
	private final SubmitAddressBookEntryServiceAsync submitAddressBookEntryService = GWT
			.create(SubmitAddressBookEntryService.class);

	public void onModuleLoad() {
	    // Wire controller to view
		//  Note: Model is on server side - can only
		//   communicate to Model through RPC calls
		//   Cannot wire it directly as a class attribute
		addressBookView.setController(AddressBook.this);
		// Show welcome page
		addressBookView.viewWelcomePage();
		//RootPanel rootPanel = RootPanel.get();
		//rootPanel.clear();
	}
	
	
	public AddressBookView getView() {
		return addressBookView;
	}
	
	 public void handleEntrySubmit(AddressBookEntry entry) {
		 submitAddressBookEntryService.addAddressBookEntry(entry, 
				new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(String result) {
				viewEntriesFromServer();
				addressBookView.sendSuccessfulPostmessage();
			}
		});
		
	}
	 
	 public void handleEntryEdit(AddressBookEntry entry, AddressBookEntry changes) {
		 submitAddressBookEntryService.editAddressBookEntry(entry, changes,
					new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					return;
				}

				@Override
				public void onSuccess(String result) {
					viewEntriesFromServer();
					addressBookView.sendSuccessfulChangemessage();
				}
			});
	 }
	 
	 public void handleEntryDelete(AddressBookEntry entry) {
		 submitAddressBookEntryService.deleteAddressBookEntry(entry,
					new AsyncCallback<String>() {
				public void onFailure(Throwable caught) {
					return;
				}

				@Override
				public void onSuccess(String result) {
					viewEntriesFromServer();
					addressBookView.sendSuccessfulDeletePostMessage();
				}
			});
	 }
	 
	 public void viewEntriesFromServer(){
		 getAddressBookEntryService.getAddressBookEntriesFromServer(
			new AsyncCallback<List<AddressBookEntry>>() {
				public void onFailure(Throwable caught) {
					return;
				}

				@Override
				public void onSuccess(List<AddressBookEntry> addressBookEntries) {
					addressBookView.viewAddressBookEntries(addressBookEntries);
				}
			});
	 
	}
	 
	 public void searchAddressBookEntries(String searchString) {
		 getAddressBookEntryService.searchAddressBookEntries(searchString, 
				new AsyncCallback<List<AddressBookEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressBookEntry> addressBookEntries) {
						addressBookView.viewAddressBookEntries(addressBookEntries);
					}
				});
	 }
	 
	 public void sortAddressBookEntriesByLastName() {
		 getAddressBookEntryService.sortAddressBookEntriesByLastName(
				new AsyncCallback<List<AddressBookEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressBookEntry> addressBookEntries) {
						addressBookView.viewAddressBookEntries(addressBookEntries);
					}
				});
	 }
	 public void sortAddressBookEntriesByZip() {
		 getAddressBookEntryService.sortAddressBookEntriesByZip(
				new AsyncCallback<List<AddressBookEntry>>() {
					public void onFailure(Throwable caught) {
						return;
					}

					@Override
					public void onSuccess(List<AddressBookEntry> addressBookEntries) {
						addressBookView.viewAddressBookEntries(addressBookEntries);
					}
				});
	 }
}