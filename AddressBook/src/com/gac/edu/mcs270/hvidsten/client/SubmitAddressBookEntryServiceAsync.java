package com.gac.edu.mcs270.hvidsten.client;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SubmitAddressBookEntryServiceAsync {

	void addAddressBookEntry(AddressBookEntry newAddressBookEntry,
			AsyncCallback<String> callback);

	void deleteAddressBookEntry(AddressBookEntry addressBookEntry,
			AsyncCallback<String> callback);

	void editAddressBookEntry(AddressBookEntry changingAddressBookEntry,
			AsyncCallback<String> callback);

}
