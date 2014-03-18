package com.gac.edu.mcs270.hvidsten.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;

import com.gac.edu.mcs270.hvidsten.shared.AddressBookEntry;

public class AddressBookView {
	
/*
 * Attributes
 */
	private AddressBook controller;
	final PopupPanel searchPopup = new PopupPanel(false);
	
/*
 * Constructor
 */
	public AddressBookView() {}
	
	
/*
 * Getters and Setters
 */
	public AddressBook getController() {
		return controller;
	}
		
	public void setController(AddressBook controler) {
		this.controller = controler;
	}
	
	public void viewWelcomePage(){
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		horizontalPanel.setSize("1000px", "211px");
		
	}

	public void viewAddressBookEntries(List<AddressBookEntry> addressBookEntries) {
		
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setWidth("1000px");
		rootPanel.add(horizontalPanel, 10, 79);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		if(addressBookEntries == null) { return; }
		makeAddressBookEntryTable(addressBookEntries, flowPanel);
	}
	
	public void viewAddressBookEntryForm() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		Label progTitlebar = new Label("New Entry");
		progTitlebar.addStyleName("appTTT");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(progTitlebar);
		
		createAddressBookEntryForm(flowPanel);
	}
	private void createAddressBookEntryForm(FlowPanel flowPanel) {
		
		// First Name TextBox
		HorizontalPanel firstNamePanel = new HorizontalPanel();
		Label firstNameLabel = new Label("First Name");
		firstNameLabel.addStyleName("entryLabel");
		firstNamePanel.add(firstNameLabel);
		flowPanel.add(firstNamePanel);
		final TextBox firstNameTextBox = new TextBox();
		flowPanel.add(firstNameTextBox);
		
				
		// Last Name TextBox
		HorizontalPanel lastNamePanel = new HorizontalPanel();
		Label lastNameLabel = new Label("Last Name");
		lastNameLabel.addStyleName("entryLabel");
		lastNamePanel.add(lastNameLabel);
		flowPanel.add(lastNamePanel);
		final TextBox lastNameTextBox = new TextBox();
		flowPanel.add(lastNameTextBox);
										
		// Address TextArea
		HorizontalPanel addressPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address");
		addressLabel.addStyleName("entryLabel");
		addressPanel.add(addressLabel);
		flowPanel.add(addressPanel);
		final TextBox addressTextBox = new TextBox();
		flowPanel.add(addressTextBox);
										
		// City TextBox
		HorizontalPanel cityPanel = new HorizontalPanel();
		Label cityLabel = new Label("City");
		cityLabel.addStyleName("entryLabel");
		cityPanel.add(cityLabel);
		flowPanel.add(cityPanel);
		final TextBox cityTextBox = new TextBox();
		flowPanel.add(cityTextBox);
						
		// State TextBox
		HorizontalPanel statePanel = new HorizontalPanel();
		Label stateLabel = new Label("State");
		stateLabel.addStyleName("entryLabel");
		statePanel.add(stateLabel);
		flowPanel.add(statePanel);
		final TextBox stateTextBox = new TextBox();
		flowPanel.add(stateTextBox);
						
		// Zip TextBox
		HorizontalPanel zipPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip Code");
		zipLabel.addStyleName("entryLabel");
		zipPanel.add(zipLabel);
		flowPanel.add(zipPanel);
		final TextBox zipTextBox = new TextBox();
		flowPanel.add(zipTextBox);
						
		// Email TextBox
		HorizontalPanel emailPanel = new HorizontalPanel();
		Label emailLabel = new Label("Email");
		emailLabel.addStyleName("entryLabel");
		emailPanel.add(emailLabel);
		flowPanel.add(emailPanel);
		final TextBox emailTextBox = new TextBox();
		flowPanel.add(emailTextBox);
								
		// Phone Number TextBox
		HorizontalPanel phoneNumberPanel = new HorizontalPanel();
		Label phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.addStyleName("entryLabel");
		phoneNumberPanel.add(phoneNumberLabel);
		flowPanel.add(phoneNumberPanel);
		final TextBox phoneNumberTextBox = new TextBox();
		flowPanel.add(phoneNumberTextBox);
				
		// Submit Button
		Button submitButton = new Button("Submit Entry");
		submitButton.setStyleName("sideBarButton");
		submitButton.setText("Submit Entry");
				
		// Submit Button Click Handler
		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String firstName = firstNameTextBox.getText();
				String lastName = lastNameTextBox.getText();
				String address = addressTextBox.getText();
				String city = cityTextBox.getText();
				String state = stateTextBox.getText();
				int zip = Integer.parseInt(zipTextBox.getText());
				String email = emailTextBox.getText();
				Long phoneNumber = Long.parseLong(phoneNumberTextBox.getText());
				// Validate entries
				if(firstName.length()>0 && lastName.length()>0 && address.length()>0 && city.length()>0
					&& state.length()>0 && email.length()>0){
					if(zipTextBox.getText().length() == 5) {
						if(phoneNumberTextBox.getText().length() == 10 || phoneNumberTextBox.getText().length() == 11) {
							AddressBookEntry newEntry = new AddressBookEntry(firstName, lastName, address, city, state, zip,
									email, phoneNumber);
							controller.handleEntrySubmit(newEntry);
						} else {
							Window.alert("Phone Number must be ten or eleven digits");
						}
					} else {
						Window.alert("Zip Code must be five digits");
					}
				} else {
					Window.alert("Post must have every field filled");
				}
			}
		});
		flowPanel.add(submitButton);
	}
	
	private void makeAddressBookEntryTable(List<AddressBookEntry> entries, FlowPanel flowPanel) {
		Label progTitlebar = new Label("Entries");
		progTitlebar.addStyleName("appTTT");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		progTitlebar.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(progTitlebar);
		for(AddressBookEntry entry: entries){
			flowPanel.add(makeAddressBookEntryRow(entry));
		}
	}
	
	private HorizontalPanel makeAddressBookEntryRow(final AddressBookEntry entry) {
		HorizontalPanel row = new HorizontalPanel();
		Label nameLabel = new Label(entry.getFirstName() + " " + entry.getLastName());
		nameLabel.addStyleName("entryLabel");
		Button infoButton = new Button("Info");
		infoButton.addStyleName("moreInfoButton");
		infoButton.setText("Info");
		infoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				viewAddressBookEntry(entry);
			}
	      });
		row.add(nameLabel);
		row.add(infoButton);
		return row;
	}
	
	private void viewAddressBookEntry(final AddressBookEntry entry) {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		// Delete Entry Button
		Button deleteEntryButton = new Button("-");
		deleteEntryButton.setStyleName("deleteEntryButton");
		deleteEntryButton.setText("-");
												
		// Delete Entry Click Handler
		deleteEntryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.handleEntryDelete(entry);
			}
		});
				
		flowPanel.add(deleteEntryButton);
		
		// First Name TextBox
		HorizontalPanel firstNamePanel = new HorizontalPanel();
		Label firstNameLabel = new Label(entry.getFirstName());
		firstNameLabel.addStyleName("entryLabel");
		firstNamePanel.add(firstNameLabel);
		flowPanel.add(firstNamePanel);

						
		// Last Name TextBox
		HorizontalPanel lastNamePanel = new HorizontalPanel();
		Label lastNameLabel = new Label(entry.getLastName());
		lastNameLabel.addStyleName("entryLabel");
		lastNamePanel.add(lastNameLabel);
		flowPanel.add(lastNamePanel);
								
		// Address TextArea
		HorizontalPanel addressPanel = new HorizontalPanel();
		Label addressLabel = new Label(entry.getAddress());
		addressLabel.addStyleName("entryLabel");
		addressPanel.add(addressLabel);
		flowPanel.add(addressPanel);
								
		// City TextBox
		HorizontalPanel cityPanel = new HorizontalPanel();
		Label cityLabel = new Label(entry.getCity());
		cityLabel.addStyleName("entryLabel");
		cityPanel.add(cityLabel);
		flowPanel.add(cityPanel);
				
		// State TextBox
		HorizontalPanel statePanel = new HorizontalPanel();
		Label stateLabel = new Label(entry.getState());
		stateLabel.addStyleName("entryLabel");
		statePanel.add(stateLabel);
		flowPanel.add(statePanel);
				
		// Zip TextBox
		HorizontalPanel zipPanel = new HorizontalPanel();
		Label zipLabel = new Label(Integer.toString(entry.getZip()));
		zipLabel.addStyleName("entryLabel");
		zipPanel.add(zipLabel);
		flowPanel.add(zipPanel);
				
		// Email TextBox
		HorizontalPanel emailPanel = new HorizontalPanel();
		Label emailLabel = new Label(entry.getEmail());
		emailLabel.addStyleName("entryLabel");
		emailPanel.add(emailLabel);
		flowPanel.add(emailPanel);
						
		// Phone Number TextBox
		HorizontalPanel phoneNumberPanel = new HorizontalPanel();
		Label phoneNumberLabel = new Label(Long.toString(entry.getPhoneNumber()));
		phoneNumberLabel.addStyleName("entryLabel");
		phoneNumberPanel.add(phoneNumberLabel);
		flowPanel.add(phoneNumberPanel);
								
		// Edit Entry Button
		Button editEntryButton = new Button("Edit Entry");
		editEntryButton.setStyleName("sideBarButton");
		editEntryButton.setText("Edit Entry");
								
		// Edit Entry Click Handler
		editEntryButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				viewEditAddressBookEntryForm(entry);
			}
		});
						
		flowPanel.add(editEntryButton);
		}	

	public void makeMenuBar(RootPanel rp){
		MenuBar menuBar = new MenuBar(false);
		rp.add(menuBar, 0, 39);
		menuBar.setSize("1000px", "60px");	
		
		MenuItem menuHomeItem = new MenuItem("Entries", false, new Command() {
			public void execute() {
				controller.viewEntriesFromServer();
			}
		});
		menuHomeItem.setHTML("Entries");
		menuHomeItem.setWidth("600px");
		menuHomeItem.addStyleName("menuBarButton");
		menuBar.addItem(menuHomeItem);
		MenuItemSeparator homeSeparator = new MenuItemSeparator();
		homeSeparator.setSize("100px", "33px");
		menuBar.addSeparator(homeSeparator);
		
		MenuItem menuSearchItem = new MenuItem("Search", false, new Command() {
			public void execute() {
				doEntrySearch();
			}
		});
		menuSearchItem.setHTML("Search");
		menuSearchItem.setWidth("125px");
		menuSearchItem.addStyleName("menuBarButton");
		menuBar.addItem(menuSearchItem);
		menuBar.addSeparator(new MenuItemSeparator());
		
		MenuItem menuSortItem = new MenuItem("Sort", false, new Command() {
			public void execute() {
				doEntrySort();
			}
		});
		menuSortItem.setHTML("Sort");
		menuSortItem.setWidth("125px");
		menuSortItem.addStyleName("menuBarButton");
		menuBar.addItem(menuSortItem);
		menuBar.addSeparator(new MenuItemSeparator());
		
		MenuItem menuPlusItem = new MenuItem("+", false, new Command() {
			public void execute() {
				viewAddressBookEntryForm();
			}
		});
		menuPlusItem.setHTML("+");
		menuPlusItem.setWidth("50px");
		menuPlusItem.addStyleName("menuBarButton");
		menuBar.addItem(menuPlusItem);
		menuBar.addSeparator(new MenuItemSeparator());
	}

	public void viewEditAddressBookEntryForm(AddressBookEntry entry) {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.clear();
		makeMenuBar(rootPanel);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 10, 79);
		
		VerticalPanel dataListPanel = new VerticalPanel();
		horizontalPanel.add(dataListPanel);
		
		FlowPanel flowPanel = new FlowPanel();
		dataListPanel.add(flowPanel);
		
		Label progTitlebar = new Label("New Entry");
		progTitlebar.addStyleName("appTTT");
		progTitlebar.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowPanel.add(progTitlebar);
		
		createEditAddressBookEntryForm(entry, flowPanel);
	}
	private void createEditAddressBookEntryForm(final AddressBookEntry entry, FlowPanel flowPanel) {
		
		// First Name TextBox
		HorizontalPanel firstNamePanel = new HorizontalPanel();
		Label firstNameLabel = new Label("First Name");
		firstNameLabel.addStyleName("entryLabel");
		firstNamePanel.add(firstNameLabel);
		flowPanel.add(firstNamePanel);
		final TextBox firstNameTextBox = new TextBox();
		firstNameTextBox.setText(entry.getFirstName());
		flowPanel.add(firstNameTextBox);
		
				
		// Last Name TextBox
		HorizontalPanel lastNamePanel = new HorizontalPanel();
		Label lastNameLabel = new Label("Last Name");
		lastNameLabel.addStyleName("entryLabel");
		lastNamePanel.add(lastNameLabel);
		flowPanel.add(lastNamePanel);
		final TextBox lastNameTextBox = new TextBox();
		lastNameTextBox.setText(entry.getLastName());
		flowPanel.add(lastNameTextBox);
										
		// Address TextArea
		HorizontalPanel addressPanel = new HorizontalPanel();
		Label addressLabel = new Label("Address");
		addressLabel.addStyleName("entryLabel");
		addressPanel.add(addressLabel);
		flowPanel.add(addressPanel);
		final TextBox addressTextBox = new TextBox();
		addressTextBox.setText(entry.getAddress());
		flowPanel.add(addressTextBox);
										
		// City TextBox
		HorizontalPanel cityPanel = new HorizontalPanel();
		Label cityLabel = new Label("City");
		cityLabel.addStyleName("entryLabel");
		cityPanel.add(cityLabel);
		flowPanel.add(cityPanel);
		final TextBox cityTextBox = new TextBox();
		cityTextBox.setText(entry.getCity());
		flowPanel.add(cityTextBox);
						
		// State TextBox
		HorizontalPanel statePanel = new HorizontalPanel();
		Label stateLabel = new Label("State");
		stateLabel.addStyleName("entryLabel");
		statePanel.add(stateLabel);
		flowPanel.add(statePanel);
		final TextBox stateTextBox = new TextBox();
		stateTextBox.setText(entry.getState());
		flowPanel.add(stateTextBox);
						
		// Zip TextBox
		HorizontalPanel zipPanel = new HorizontalPanel();
		Label zipLabel = new Label("Zip Code");
		zipLabel.addStyleName("entryLabel");
		zipPanel.add(zipLabel);
		flowPanel.add(zipPanel);
		final TextBox zipTextBox = new TextBox();
		zipTextBox.setText("" + entry.getZip());
		flowPanel.add(zipTextBox);
						
		// Email TextBox
		HorizontalPanel emailPanel = new HorizontalPanel();
		Label emailLabel = new Label("Email");
		emailLabel.addStyleName("entryLabel");
		emailPanel.add(emailLabel);
		flowPanel.add(emailPanel);
		final TextBox emailTextBox = new TextBox();
		emailTextBox.setText(entry.getEmail());
		flowPanel.add(emailTextBox);
								
		// Phone Number TextBox
		HorizontalPanel phoneNumberPanel = new HorizontalPanel();
		Label phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.addStyleName("entryLabel");
		phoneNumberPanel.add(phoneNumberLabel);
		flowPanel.add(phoneNumberPanel);
		final TextBox phoneNumberTextBox = new TextBox();
		phoneNumberTextBox.setText("" + entry.getPhoneNumber());
		flowPanel.add(phoneNumberTextBox);
				
		// Submit Button
		Button submitButton = new Button("Submit Entry");
		submitButton.setStyleName("sideBarButton");
		submitButton.setText("Submit Entry");
				
		// Submit Button Click Handler
		submitButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String firstName = firstNameTextBox.getText();
				String lastName = lastNameTextBox.getText();
				String address = addressTextBox.getText();
				String city = cityTextBox.getText();
				String state = stateTextBox.getText();
				int zip = Integer.parseInt(zipTextBox.getText());
				String email = emailTextBox.getText();
				Long phoneNumber = Long.parseLong(phoneNumberTextBox.getText());
				// Validate entries
				if(firstName.length()>0 && lastName.length()>0 && address.length()>0 && city.length()>0
					&& state.length()>0 && email.length()>0){
					if(zipTextBox.getText().length() == 5) {
						if(phoneNumberTextBox.getText().length() == 10 || phoneNumberTextBox.getText().length() == 11) {
							AddressBookEntry changes = new AddressBookEntry(firstName, lastName, address, city, state, zip,
									email, phoneNumber);
							controller.handleEntryEdit(entry, changes);
						} else {
							Window.alert("Phone Number must be ten or eleven digits");
						}
					} else {
						Window.alert("Zip Code must be five digits");
					}
				} else {
					Window.alert("Post must have every field filled");
				}
			}
		});
		flowPanel.add(submitButton);
	}

	protected void doEntrySearch() {		
		VerticalPanel content = new VerticalPanel();
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		HorizontalPanel inputRow = new HorizontalPanel();
		Label searchTermLabel = new Label("Search Title Term: ");
		final TextBox searchTermTextBox = new TextBox();
		inputRow.add(searchTermLabel);
		inputRow.add(searchTermTextBox);
		
		HorizontalPanel btnRow = new HorizontalPanel();
		btnRow.setStyleName("search-button-row");
		Button cancelBtn = new Button("Cancel");
		cancelBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchPopup.hide();
			}
	      });
		Button searchBtn = new Button("Search");
		searchBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.searchAddressBookEntries(searchTermTextBox.getText());
				searchPopup.hide();
			}
	      });
		btnRow.add(cancelBtn);
		btnRow.add(new Label(""));
		btnRow.add(searchBtn);
		
		content.add(inputRow);
		content.add(btnRow);
		searchPopup.setWidget(content);
		searchPopup.center();
	}
	
	protected void doEntrySort() {		
		VerticalPanel content = new VerticalPanel();
		content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		HorizontalPanel btnRow = new HorizontalPanel();
		btnRow.setStyleName("search-button-row");
		Button sortLastNameBtn = new Button("Sort by Last Name");
		sortLastNameBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.sortAddressBookEntriesByLastName();
				searchPopup.hide();
			}
	      });
		
		Button sortZipBtn = new Button("Sort by Zip Code");
		sortZipBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				controller.sortAddressBookEntriesByZip();
				searchPopup.hide();
			}
	      });
		
		Button cancelBtn = new Button("Sort by Last Name");
		cancelBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				searchPopup.hide();
			}
	      });
		
		btnRow.add(sortLastNameBtn);
		btnRow.add(new Label(""));
		btnRow.add(sortZipBtn);
		btnRow.add(new Label(""));
		btnRow.add(cancelBtn);
		
		content.add(btnRow);
		searchPopup.setWidget(content);
		searchPopup.center();
	}
	
	public void sendSuccessfulPostmessage() {
		Window.alert("Entry was successfully stored.");
	}
	
	public void sendSuccessfulChangemessage() {
		Window.alert("Entry was successfully changed.");
	}
	
	public void sendSuccessfulDeletePostMessage() {
		Window.alert("Entry was successfully deleted.");
	}
}


















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	