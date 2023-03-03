package pro.xstore.api.sync;

import pro.xstore.api.sync.ServerData.ServerEnum;

public class RunExample {

    //please change the login and password below
    private static final String LOGIN = "14398599";
    private static final String PASSWORD = "xoh66437";

    //please provide the application details if you received them
    private static final String APP_ID = null;
    private static final String APP_NAME = null;

    public static void main(String[] args) throws Exception {
        Example ex = new Example();
        Credentials credentials = new Credentials(LOGIN, PASSWORD, APP_ID, APP_NAME);
        ex.runExample(ServerEnum.DEMO, credentials);
    }
}