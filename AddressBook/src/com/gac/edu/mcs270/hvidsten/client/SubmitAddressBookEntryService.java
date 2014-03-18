package com.gac.edu.mcs270.hvidsten.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("submit")
public interface SubmitAddressBookEntryService extends RemoteService {
	public String addAddressBookEntry(AddressBookEntry newAddressBookEntry);	
	public String editAddressBookEntry(AddressBookEntry changingAddressBookEntry);	
	public String deleteAddressBookEntry(AddressBookEntry addressBookEntry);
}
