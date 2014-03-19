package com.gac.edu.mcs270.hvidsten.server;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.client.GetAddressBookEntryService;
import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Servlet that gets Address Book Entries from the persistence
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
@SuppressWarnings("serial")
public class GetAddressBookEntryServiceImpl extends RemoteServiceServlet implements GetAddressBookEntryService {
	
/*
 * Servlet Methods
 */
	/**
	 * Gets the Address Book Entries from the persistence
	 * @return All Address Book Entries in the persistence
	 */
	@Override
	public List<AddressBookEntry> getAddressBookEntriesFromServer() {
		return AddressBookModel.getAddressBookEntries();
	}

	/**
	 * Prints out all Address Book Entries in mailing format from the persistence
	 */
	@Override
	public void viewAllAddressBookEntries() {
		AddressBookModel.viewAllAddressBookEntries();
	}

	/**
	 * Gets the Address Book Entries that match the search string from the persistence
	 * @return All Address Book Entries matching the search string from the persistence
	 */
	@Override
	public List<AddressBookEntry> searchAddressBookEntries(String searchString) {
		return AddressBookModel.searchAddressBookEntries(searchString);
	}

	/**
	 * Gets sorted Address Book Entries in order of last name from the persistence
	 * @return All Address Book Entries sorted by last name
	 */
	@Override
	public List<AddressBookEntry> sortAddressBookEntriesByLastName() {
		return AddressBookModel.sortAddressBookEntriesByLastName();
	}

	/**
	 * Gets sorted Address Book Entries in order of zip code from the persistence
	 * @return All Address Book Entries sorted by zip code
	 */
	@Override
	public List<AddressBookEntry> sortAddressBookEntriesByZip() {
		return AddressBookModel.sortAddressBookEntriesByZip();
	}

}
