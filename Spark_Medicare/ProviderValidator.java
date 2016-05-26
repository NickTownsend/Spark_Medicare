package edu.easternct.bigdata;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProviderValidator {
	
	String line;
	
	String npi;
	String firstName;
	String lastName;
	String entityCode;
	String provType;
	String state;
	String gender;
	String country;
	boolean clean;
	
	int npiCnt, stateCnt, genderCnt, fnameCnt, lnameCnt;
	
	String[] stateSet = {"AA","AE","AK","AL","AP","AR","AS", "AZ","CA","CO","CT","DC",
            "DE","FL","FM","GA","GU","HI","IA","ID","IL","IN","KS",
            "KY","LA","MA","MD","ME","MH", "MI","MN","MO","MP","MS","MT","NC","ND","NE","NH",
            "NJ","NM","NV","NY","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN" ,
            "TX","UT","VA","VI","VT","WA","WI","WV", "WY"};
    
	List<String> goodStates = Arrays.asList(stateSet);
	

/*  error count */	
	int errorCnt = 0;
	
	public ProviderValidator() {
	
	      this.line = null;
	}
	
	public ProviderValidator(String line) {
		
	      this.line = line;
	}
	
	
	/**
	 * @return the npi
	 */
	public String getNpi() {
		return npi;
	}

	/**
	 * @param npi the npi to set
	 */
	public void setNpi(String npi) {
		this.npi = npi;
	}
	
		/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the entityCode
	 */
	public String getEntityCode() {
		return entityCode;
	}

	/**
	 * @param entityCode the entityCode to set
	 */
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	/**
	 * @return the provider type
	 */
	public String getProvType() {
		return provType;
	}

	/**
	 * @param ProvType the ProvType to set
	 */
	public void setProvType(String provType) {
		this.provType = provType;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param state the state to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return clean indicator
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

	/**
	 * @return the errorCnt
	 */
	public int getErrorCnt() {
		return errorCnt;
	}

	/**
	 * @param errorCnt the errorCnt to set
	 */
	public void setErrorCnt(int errorCnt) {
		this.errorCnt = errorCnt;
	}

	public boolean parser() {
		
		String[] tokens = line.split(",");
		if (tokens.length < 15) 
			return false;
		
// validate npi		
		if (validateNPI(tokens[0]))
			this.npi = tokens[0];
		else {
			this.npi = "0"; 
			npiCnt++;
		}

// validate ProvType
		if (validateProvType(tokens[13]))
			this.provType = tokens[13];
		else
			errorCnt++;

// validate gender
		if (validateGender(tokens[5]))
			this.gender = tokens[5];
		else
			errorCnt++;

// validate state 		
		if (validateState(tokens[11])){
		 	this.state = tokens[11];
		}
		else
			errorCnt++;

// validate country 		
		if (validateCountry(tokens[12])) {
			this.country = tokens[12];
		}
		else
			errorCnt++;

// validate entity code 		
		if (validateEntityCode(tokens[6])) {
			this.entityCode = tokens[6];
		}
		else
			errorCnt++;

// validate first name 		
		if (validateFirstName(tokens[2])) {
			this.firstName = tokens[2];
		}
		else
			errorCnt++;

// validate last name	
		if (validateLastName(tokens[1])) {
			this.lastName = tokens[1];
		}
		else
			errorCnt++;
				
		
		if (errorCnt > 0) {
			setClean(false);
			return false;
		  }	
		else {
			setClean(true);
			return true;
		     }
	}
	
	public boolean validateNPI(String npi) {
		
		boolean valid = true;
		
		
		
		if ((npi == null) || (!npi.matches("^\\d+$")))
			valid = false;
			
		
		return valid;	
	}

    public boolean validateProvType(String provType) {
		
		boolean valid = true;
		
		if (provType == null)
			valid = false;
		
		return valid;	
	}
    
    public boolean validateGender(String gender) {
		
		boolean valid = true;
		
		if (gender == null) 
			valid = false;
		else if (!gender.matches("^[MF]$"))
			valid = false;
				
		return valid;	
	}
    
    public boolean validateCountry(String country) {
		
		boolean valid = true;
		
		if (country == null) 
			valid = false;
		else if (!country.equals("US"))
			valid = false;
				
		return valid;	
	}

    public boolean validateState(String state) {
		
		boolean valid = true;
		
		if (state == null) 
			valid = false;
		else if (Collections.binarySearch(goodStates, state) < 0)
			valid = false;
				
		return valid;	
	}
    
    public boolean validateEntityCode(String entityCode) {
		
		boolean valid = true;
		
		if (entityCode == null) 
			valid = false;
		else if ((!entityCode.matches("^[IO]$")))
			valid = false;
				
		return valid;	
	}
    
    public boolean validateFirstName(String firstName) {
		
		boolean valid = true;
		
		if (firstName == null) 
			valid = false;
						
		return valid;	
	}
    
    public boolean validateLastName(String lastName) {
		
		boolean valid = true;
		
		if (lastName == null) 
			valid = false;
						
		return valid;	
	}
    
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return npi + ", " + provType + ", " + gender + ", " + state + ", " + country;
	}
    
}
