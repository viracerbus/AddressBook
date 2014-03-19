package com.gac.edu.mcs270.hvidsten.client;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Abstract Servlet to submit Address Book Entries into a persistence
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
@RemoteServiceRelativePath("submit")
public interface SubmitAddressBookEntryService extends RemoteService {
	public String addAddressBookEntry(AddressBookEntry newAddressBookEntry);	
	public String editAddressBookEntry(AddressBookEntry changingAddressBookEntry, AddressBookEntry changes);	
	public String deleteAddressBookEntry(AddressBookEntry addressBookEntry);
}
