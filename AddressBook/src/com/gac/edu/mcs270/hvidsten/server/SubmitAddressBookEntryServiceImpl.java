package com.gac.edu.mcs270.hvidsten.server;

import com.gac.edu.mcs270.hvidsten.client.SubmitAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Servlet that submits an entry to the persistence
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
@SuppressWarnings("serial")
public class SubmitAddressBookEntryServiceImpl extends RemoteServiceServlet implements
SubmitAddressBookEntryService {

/*
 * Servlet Methods
 */
	/**
	 * Enters an Address Book Entry into the persistence
	 * @return String describing the submits success
	 */
	@Override
	public String addAddressBookEntry(AddressBookEntry newAddressBookEntry) {
		AddressBookModel.addAddressBookEntry(newAddressBookEntry);
		return "entry submitted okay";
	}
	
	/**
	 * Edits an Address Book Entry from the persistence
	 * @return String describing the edits success
	 */
	@Override
	public String editAddressBookEntry(AddressBookEntry changingAddressBookEntry, AddressBookEntry changes) {
		AddressBookModel.editAddressBookEntry(changingAddressBookEntry, changes);
		return "entry edited okay";
	}

	/**
	 * Delete an Address Book Entry from the persistence
	 * @return String describing the deletes success
	 */
	@Override
	public String deleteAddressBookEntry(AddressBookEntry addressBookEntry) {
		AddressBookModel.deleteAddressBookEntry(addressBookEntry);
		return "entry deleted okay";
	}

}
