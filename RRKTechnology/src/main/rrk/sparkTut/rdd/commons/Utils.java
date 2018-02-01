package sparkTut.rdd.commons;

import java.net.URL;



public class Utils {

    private Utils(){
    };

    // a regular expression which matches commas but not commas within double quotations
    public static final String COMMA_DELIMITER = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";


    public static String getFile(String filename) {

		try {
			URL uri = Utils.class.getResource("/in" + java.io.File.separator + filename);
			String databasePathName = uri.toURI().getPath();
            return databasePathName;
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return filename;
	}

}
