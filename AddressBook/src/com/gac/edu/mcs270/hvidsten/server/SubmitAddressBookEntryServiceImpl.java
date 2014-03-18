package com.gac.edu.mcs270.hvidsten.server;

import com.gac.edu.mcs270.hvidsten.client.GetAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.client.SubmitAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class SubmitAddressBookEntryServiceImpl extends RemoteServiceServlet implements
SubmitAddressBookEntryService {

	@Override
	public String addAddressBookEntry(AddressBookEntry newAddressBookEntry) {
		AddressBookModel.addAddressBookEntry(newAddressBookEntry);
		return "entry submitted okay";
	}
	@Override
	public String editAddressBookEntry(AddressBookEntry changingAddressBookEntry, AddressBookEntry changes) {
		AddressBookModel.editAddressBookEntry(changingAddressBookEntry, changes);
		return "entry edited okay";
	}

	@Override
	public String deleteAddressBookEntry(AddressBookEntry addressBookEntry) {
		AddressBookModel.deleteAddressBookEntry(addressBookEntry);
		return "entry deleted okay";
	}

}
