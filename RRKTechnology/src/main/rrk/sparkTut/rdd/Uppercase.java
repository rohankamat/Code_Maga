package sparkTut.rdd;


import java.io.File;
import java.net.URL;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;



public class Uppercase {

    public static void main(String[] args) throws Exception {
        // Create a Java Spark Context.
        SparkConf conf = new SparkConf().setAppName("uppercase").setMaster("local[*]");
        Uppercase user=new Uppercase();
        JavaSparkContext sc = new JavaSparkContext(conf);
        String classpath=Uppercase.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        classpath=user.getFile("uppercase.text");
       /* String strClassPath = System.getProperty("java.class.path");
       String str= Uppercase.class
                .getClassLoader().getParent().
                getResource("src/main/resources/in/uppercase.text");*/
        System.out.println(classpath);
   
        JavaRDD<String> lines = sc.textFile(classpath);
        JavaRDD<String> lowerCaseLines = lines.map(line -> line.toUpperCase());

        lowerCaseLines.saveAsTextFile("out/uppercase.text");
    }
    
    private String getFile(String filename) {

			try {
				ClassLoader classLoader = Uppercase.class.getClassLoader().getParent();
				URL uri = getClass().getResource("/in" + java.io.File.separator + filename);
				String databasePathName = uri.toURI().getPath();
                return databasePathName;
			} catch (Exception ex) {
				System.out.println(ex.toString());
			}
			return filename;
		}
	}

