package commons;

import java.io.File;

public class GlobalConstands {
	public static final String PORTAL_PAGE_URL="https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL="https://admin-demo.nopcommerce.com";
	public static final String PORTAL_DEV_URL="https://demo.nopcommerce.com/";
	public static final String PORTAL_TESTING_URL="https://admin-demo.nopcommerce.com";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION=System.getProperty("java.version") ;
	public static final String OS_NAME=System.getProperty("os.name") ;
	public static final String UPLOAD_FILE= PROJECT_PATH + File.separator +"uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE= PROJECT_PATH + File.separator +"downloadFiles";
	public static final String BROWSER_LOGS= PROJECT_PATH + File.separator +"browserLogs";
	public static final String REPORTNG_SCREENSHOT= PROJECT_PATH + File.separator +"ReportNGScreenShots" + File.separator;
	public static final String EXTENT_SCREENSHOT= PROJECT_PATH + File.separator + "extentV2" + File.separator;
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator +"dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator +"autoIT";
	public static final String DB_DEV_URL = "32.19.21.1:1980";
	public static final String DB_DEV_USER = "TinNguyen1994";
	public static final String DB_DEV_PASS = "1234567";
	public static final String DB_TEST_URL = "32.19.21.1:1980";
	public static final String DB_TEST_USER = "TinNguyen9001";
	public static final String DB_TEST_PASS = "1234567";
	
	
	public static final long LONG_TIMEOUT = 15;
	public static final long SHORT_TIMEOUT = 5;
	public static final long RETRY_TEST_FAIL = 3;
	
	
	public static final String LIVE_GURU_USER="http://live.techpanda.org/";
	public static final String LIVE_GURU_ADMIN="http://live.techpanda.org/index.php/backendlogin";
}
