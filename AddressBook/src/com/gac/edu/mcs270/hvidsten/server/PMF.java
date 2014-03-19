package com.gac.edu.mcs270.hvidsten.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * Persistence for Address Book Entries
 * @author Dustin Luhmann, Kevin Dexter, and Aaron Brau
 */
public final class PMF {
	
/*
 * Attributes
 */
 private static final PersistenceManagerFactory pmfInstance =
     JDOHelper.getPersistenceManagerFactory("transactions-optional");

 /*
  * Constructors
  */
 private PMF() {}

 /*
  * Getters
  */
 public static PersistenceManagerFactory get() {
   return pmfInstance;
 }
}
