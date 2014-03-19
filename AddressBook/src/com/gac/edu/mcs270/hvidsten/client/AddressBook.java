package com.gac.edu.mcs270.hvidsten.client;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gac.edu.mcs270.hvidsten.client.GetAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.client.SubmitAddressBookEntryService;

/**
 * Controller for an Address Book
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
public class AddressBook implements EntryPoint {
	
/*
 * Attributes
 */
	private final AddressBookView addressBookView = new AddressBookView();
	private final GetAddressBookEntryServiceAsync getAddressBookEntryService = GWT
			.create(GetAddressBookEntryService.class);
	private final SubmitAddressBookEntryServiceAsync submitAddressBookEntryService = GWT
			.create(SubmitAddressBookEntryService.class);

/*
 * Getters
 */
	public AddressBookView getView() {
		return addressBookView;
	}

/*
 * Module Load
 */
	public void onModuleLoad() {
		addressBookView.setController(AddressBook.this);
		addressBookView.viewWelcomePage();
	}
	
/*
 * Public Methods connecting to servlets
 */
	/**
	 * Sends an Address Book Entry to the submit servlet
	 * @param entry Address Book Entry being added to the persistence
	 */
	 public void handleEntrySubmit(AddressBookEntry entry) {
		 submitAddressBookEntryService.addAddressBookEntry(entry, 
				new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				return;
			}

			@Override
			public void onSuccess(String result) {
				viewEntriesFromServer();
				addressBookView.sendSuccessfulStoremessage();
			}
		});
		
	}
	 
	 /**
	  * Sends an Address Book Entry that is being changed and an Address Book Entry that contains the changes to the servlet
	  * @param entry Address Book Entry that is being changed then added to the persistence
	  * @param changes Address Book Entry that contains the changes for the entry
	  */
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
	 
	 /**
	  * Sends an Address Book Entry to the submit servlet that is being deleted
	  * @param entry Address Book Entry that is being deleted
	  */
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
	 
	 /**
	  * Gets Address Book Entries from a servlet callback
	  */
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
	 
	 /**
	  * Gets Address Book Entries from a servlet callback based on the searchString
	  * @param searchString String being compared to all Address Book Entries in the persistence
	  */
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
	 
	 /**
	  * Gets Address Book Entries from a servlet callback that are sorted by last name
	  */
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
	 
	 /**
	  * Gets Address Book Entries from a servlet callback that are sorted by zip code
	  */
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