package com.gac.edu.mcs270.hvidsten.server;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.client.GetAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class GetAddressBookEntryServiceImpl extends RemoteServiceServlet implements GetAddressBookEntryService {
	
	@Override
	public List<AddressBookEntry> getAddressBookEntriesFromServer() {
		return AddressBookModel.getAddressBookEntries();
	}

	@Override
	public List<AddressBookEntry> getSearchedAddressBookEntryFromServer(String searchString) {
		return AddressBookModel.searchAddressBookEntries(searchString);
	}

	@Override
	public void viewAllAddressBookEntries() {
		AddressBookModel.viewAllAddressBookEntries();
	}

	@Override
	public List<AddressBookEntry> searchAddressBookEntries(String searchString) {
		return AddressBookModel.searchAddressBookEntries(searchString);
	}

	@Override
	public List<AddressBookEntry> sortAddressBookEntriesByLastName() {
		return AddressBookModel.sortAddressBookEntriesByLastName();
	}

	@Override
	public List<AddressBookEntry> sortAddressBookEntriesByZip() {
		return AddressBookModel.sortAddressBookEntriesByZip();
	}

}
