package com.gac.edu.mcs270.hvidsten.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("get")
public interface GetAddressBookEntryService extends RemoteService {
	public List<AddressBookEntry> getAddressBookEntriesFromServer();
	public List<AddressBookEntry> getSearchedAddressBookEntryFromServer(String searchString);
	public void viewAllAddressBookEntries();	
	public List<AddressBookEntry> searchAddressBookEntries(String searchString);
	public List<AddressBookEntry> sortAddressBookEntriesByLastName();
	public List<AddressBookEntry> sortAddressBookEntriesByZip();
}
