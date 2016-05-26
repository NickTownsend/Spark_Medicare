package edu.easternct.bigdata;

import java.io.Serializable;






//der", "entityCode", "street1", "street2", "city", "state", "zip", "country", "provType"})
//@JsonPropertyOrder(alphabetic=true)
public class Provider implements Serializable, Comparable<Provider>{
			
	
		private static final long serialVersionUID = -4794073702192449104L;
	  
		
		private static String INDIVIDUAL = "I";
		private static String ORGANIZATION = "O";
		private int npi;
		private String lastName;
		private String firstName;
		private String middleInit;
		private String credentials;
		private String gender;
		private String entityCode;
		private String street1;
		private String street2;
		private String city;
		private String state;
		private String zip;
		private String country;
		private String provType;
		private boolean clean;
		
		
		
		public Provider() {
			this.npi = 0;
			this.lastName = "";
			this.firstName = "";
			this.middleInit = "";
			this.credentials = "";
			this.gender = "";
			this.entityCode = "";
			this.street1 = "";
			this.street2 = "";
			this.city = "";
			this.state = "";
			this.zip  = "";
			this.country = "";
			this.provType = "";
			
		}
		
		public Provider(String npi, String lastName, String firstName, String middleInit, String credentials, String gender, String entityCode,
                String street1, String street2, String city, String state, String zip, String country, String provType) {
	
	       this.setNpi(npi);
	       this.lastName = lastName;
	       this.firstName = firstName;
	       this.middleInit = middleInit;
	       this.credentials = credentials;
	       this.gender = gender;
	       this.entityCode = entityCode;
	       this.street1 = street1;
	       this.street2 = street2;
	       this.city = city;
	       this.state = state;
	       this.zip  = zip;
	       this.country = country;
	       this.provType = provType;
	
	
}


		public int getNpi() {
			return npi;
		}

		public void setNpi(String npi) {
			
			this.npi = Integer.parseInt(npi);
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleInit() {
			return middleInit;
		}

		public void setMiddleInit(String middleInit) {
			this.middleInit = middleInit;
		}

		public String getCredentials() {
			return credentials;
		}

		public void setCredentials(String credentials) {
			this.credentials = credentials;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getEntityCode() {
			return entityCode;
		}

		public void setEntityCode(String entityCode) {
			this.entityCode = entityCode;
		}

		public String getStreet1() {
			return street1;
		}

		public void setStreet1(String street1) {
			this.street1 = street1;
		}

		public String getStreet2() {
			return street2;
		}

		public void setStreet2(String street2) {
			this.street2 = street2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getProvType() {
			return provType;
		}

		public void setProvType(String provType) {
			this.provType = provType;
		}

		/**
		 * @return the clean
		 */
		public boolean isClean() {
			return clean;
		}

		/**
		 * @param clean the clean to set
		 */
		public void setClean(boolean clean) {
			this.clean = clean;
		}
		
		public boolean equals(Object obj) {
			
			if (!(obj instanceof Provider)) 
				return false;
			
			if (obj == this)
				return true;
			
			return this.npi == ((Provider) obj).npi;
			
		}
		
		public int hashCode() {
			
			return (int)this.npi/10;
			
		}
		
		public int compareTo(Provider prov) {
			
			
			if (this.npi == prov.npi)
				return 0;
			else if (this.npi > prov.npi)
			     return +1;
			else 
			      return -1;
			
		}

public String toFormattedString() {
			
			
			StringBuffer tempString = new StringBuffer(100);
			
			tempString.append("NPI : " + this.npi + ",");
			tempString.append("Entity Code : " + this.getEntityCode() + ",");
			
			if (this.entityCode.equals(INDIVIDUAL)) {
				tempString.append("First Name : " + this.getFirstName() + " ");
			    tempString.append("Middle Init : " + this.getMiddleInit() + " ");
			    tempString.append("Last Name : " + this.getLastName() + " ");
			    tempString.append("Gender : " + this.getGender() + " ");
			    tempString.append("Credentials : " + this.getCredentials() + " ");
			}   
			else
				tempString.append("Name : " + this.getLastName() + " ");
			
			tempString.append("Provider Type : " + this.getProvType() + " ");
			tempString.append("Street Address 1 : " + this.getStreet1() + " ");
			tempString.append("Street Address 2 : " + this.getStreet2() + " ");
			tempString.append("City : " + this.getCity() + " ");
			tempString.append("State : " + this.getState() + " ");
			tempString.append("Zip : " + this.getZip() + " ");
			tempString.append("Country : " + this.getCountry() + " ");
		
		    return tempString.toString();
			
		}

		public String toString() {
			
			
			StringBuffer tempString = new StringBuffer(100);
			
			tempString.append(this.getNpi() + ",");
			tempString.append(this.getLastName() + ",");
			tempString.append(this.getFirstName() + ",");
			tempString.append(this.getMiddleInit() + ",");
			tempString.append(this.getCredentials() + ",");
			tempString.append(this.getGender() + ",");
			tempString.append(this.getEntityCode() + ",");
			tempString.append(this.getStreet1() + ",");
			tempString.append(this.getStreet2() + ",");
			tempString.append(this.getCity() + ",");
			tempString.append(this.getState() + ",");
			tempString.append(this.getZip() + ",");
			tempString.append(this.getCountry() + ",");
			tempString.append(this.getProvType());
			
		    return tempString.toString();
			
		}
	
		

}
