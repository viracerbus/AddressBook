package com.gac.edu.mcs270.hvidsten.client;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GetAddressBookEntryServiceAsync {

	void viewAllAddressBookEntries(AsyncCallback<Void> asyncCallback);

	void searchAddressBookEntries(String searchString,
			AsyncCallback<List<AddressBookEntry>> asyncCallback);

	void sortAddressBookEntriesByLastName(
			AsyncCallback<List<AddressBookEntry>> asyncCallback);

	void sortAddressBookEntriesByZip(
			AsyncCallback<List<AddressBookEntry>> asyncCallback);

	void getAddressBookEntriesFromServer(
			AsyncCallback<List<AddressBookEntry>> asyncCallback);

	void getSearchedAddressBookEntryFromServer(String searchString,
			AsyncCallback<List<AddressBookEntry>> asyncCallback);

}
