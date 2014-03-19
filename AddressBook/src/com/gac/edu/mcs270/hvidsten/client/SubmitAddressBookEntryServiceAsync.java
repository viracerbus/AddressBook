package com.gac.edu.mcs270.hvidsten.client;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Abstract Async Servlet to submit Address Book Entries into a persistence
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
public interface SubmitAddressBookEntryServiceAsync {

	void addAddressBookEntry(AddressBookEntry newAddressBookEntry,
			AsyncCallback<String> callback);

	void deleteAddressBookEntry(AddressBookEntry addressBookEntry,
			AsyncCallback<String> callback);

	void editAddressBookEntry(AddressBookEntry changingAddressBookEntry,
			AddressBookEntry changes, AsyncCallback<String> callback);

}
