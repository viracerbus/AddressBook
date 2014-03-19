package com.gac.edu.mcs270.hvidsten.client;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Abstract Async Servlet to submit Address Book Entries into a persistence
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
@RemoteServiceRelativePath("get")
public interface GetAddressBookEntryService extends RemoteService {
	public List<AddressBookEntry> getAddressBookEntriesFromServer();
	public void viewAllAddressBookEntries();	
	public List<AddressBookEntry> searchAddressBookEntries(String searchString);
	public List<AddressBookEntry> sortAddressBookEntriesByLastName();
	public List<AddressBookEntry> sortAddressBookEntriesByZip();
}
