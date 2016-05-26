package edu.easternct.bigdata;

import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ProviderTester {
	
public static void main(String[] args) throws Exception {

    
    SparkConf conf = new SparkConf().setAppName("Provider Tester");
    conf.setMaster(args[0]);      //args[0]      
	JavaSparkContext sc = new JavaSparkContext(conf);
	JavaRDD<String>	mydata = sc.textFile(args[1]);	
	
	JavaRDD<String> cleanStrings = mydata.filter((String l) -> 
			{ProviderValidator temp = new ProviderValidator(l);
            temp.parser();
            return temp.isClean();});
    
	JavaRDD<Provider> providerMap = cleanStrings.map((String l) ->
			{String[] token = l.split(",");
			return new Provider(token[0], "", "", "", "", token[5], "","", "", "", token[11], "", "", token[13]);});
	
	JavaRDD<Provider> uniquePro = providerMap.distinct();
	
	long lineCount_ll =  uniquePro.count(); 
    System.out.println( "Total amount of providers " + lineCount_ll);
	
	//STATES *************************
	JavaRDD<String> States = uniquePro.map( Provider -> Provider.getState() );
	Map<String,Long> stateResults = States.countByValue();
	for(Map.Entry<String,Long> state : stateResults.entrySet())
		System.out.println(state.getKey() + " Count : " +	state.getValue());
	System.out.println("\n");
	
	
	//GENDER *************************	
	JavaRDD<String> Gender = uniquePro.map( Provider -> Provider.getGender() );
	Map<String,Long> genderResults = Gender.countByValue();
	for(Map.Entry<String,Long> gender : genderResults.entrySet())
		System.out.println(gender.getKey() + " Count : " +	gender.getValue());	
	System.out.println("\n");
	
	
	//TYPE *************************	
		JavaRDD<String> Type = uniquePro.map( Provider -> Provider.getProvType() );
		Map<String,Long> typeResults = Type.countByValue();
		for(Map.Entry<String,Long> type : typeResults.entrySet())
			System.out.println(type.getKey() + " Count : " +	type.getValue());
	

    
    
    

	
	
	
	    
	    sc.close();   

	  }
}