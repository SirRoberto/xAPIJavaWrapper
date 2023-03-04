package pro.xstore.api.message.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import pro.xstore.api.message.error.APICommandConstructionException;
import pro.xstore.api.message.error.APICommunicationException;
import pro.xstore.api.message.records.RedirectRecord;
import pro.xstore.api.message.response.LoginResponse;
import pro.xstore.api.sync.Credentials;
import pro.xstore.api.sync.Server;
import pro.xstore.api.sync.SyncAPIConnector;

/**
 * Main class for creating and executing commands.
 */
public class APICommandFactory {

    private static final ThreadLocal<Integer> redirectCounter = new ThreadLocal<>();

    public static LoginRequest createLoginCommand(Credentials credentials) throws APICommandConstructionException {
        return LoginRequest.builder()
                .arguments(new LoginRequest.Arguments(
                        credentials.getLogin(),
                        credentials.getPassword(),
                        credentials.getAppName())
                )
                .build();
    }

//    public static LoginResponse executeLoginCommand(SyncAPIConnector connector, Credentials credentials) throws APICommandConstructionException, APICommunicationException, APIReplyParseException, APIErrorResponse, IOException {
//        LoginRequest lc = createLoginCommand(credentials);
//        LoginResponse response = executeLoginCommandHelper(connector, lc);
//        redirectCounter.set(0);
//        while (isRedirectNeeded(response)) {
//            checkIfTooManyRedirects();
//            redirectCounter.set(redirectCounter.get() + 1);
//            Server server = createServerFromLoginResponse(response);
//            System.out.println("Redirecting to: " + server);
//            connector.redirect(server);
//            response = executeLoginCommandHelper(connector, lc);
//        }
//        String streamSessionId = response.getStreamSessionId();
//        if (streamSessionId != null) {
//            connector.setStreamSessionId(streamSessionId);
//        }
//        return response;
//    }

    private static boolean isRedirectNeeded(LoginResponse lr) {
        return lr != null && !lr.getStatus() && lr.isRedirectSet();
    }

    private static void checkIfTooManyRedirects() throws APICommunicationException {
        if (redirectCounter.get() >= SyncAPIConnector.MAX_REDIRECTS) {
            throw new APICommunicationException("too many redirects");
        }
    }

    private static Server createServerFromLoginResponse(LoginResponse lr) {
        Server response = null;
        if (lr != null) {
            RedirectRecord redir = lr.getRedirect();
            if (redir != null) {
                String address = redir.getAddress();
                int mainPort = redir.getMainPort();
                int streamingPort = redir.getStreamingPort();
                boolean secure = true;
                boolean partOfXapiList = false;
                String description = "redirected server " + redirectCounter.get();
                response = new Server(address, mainPort, streamingPort, secure, description, partOfXapiList);
            }
        }
        return response;
    }

    public static String execute(SyncAPIConnector connector, BaseRequest request) throws APICommunicationException, JsonProcessingException {
        return connector.safeExecuteCommand(request);
    }
}