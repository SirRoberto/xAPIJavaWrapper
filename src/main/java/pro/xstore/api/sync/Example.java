package pro.xstore.api.sync;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONObject;
import pro.xstore.api.message.command.APICommandFactory;
import pro.xstore.api.sync.ServerData.ServerEnum;

public class Example {

	ObjectWriter ow = new ObjectMapper()
			.setSerializationInclusion(JsonInclude.Include.NON_NULL)
			.writer()
			.withDefaultPrettyPrinter();

	public void runExample(ServerEnum server, Credentials credentials) throws Exception {
		try {
			var connector = new SyncAPIConnector(server);
			var loginRequest = APICommandFactory.createLoginCommand(credentials);
			System.out.println(loginRequest);
			System.out.println(ow.writeValueAsString(loginRequest));
			String response = APICommandFactory.execute(connector, loginRequest);
			System.out.println(new JSONObject(response).toString(4));
//			LoginResponse loginResponse = APICommandFactory.executeLoginCommand(connector, credentials);

//			if (loginResponse.getStatus())
//			{
//				StreamingListener sl = new StreamingListener() {
//					@Override
//					public void receiveTradeRecord(STradeRecord tradeRecord) {
//						System.out.println("Stream trade record: " + tradeRecord);
//					}
//
//					@Override
//					public void receiveTickRecord(STickRecord tickRecord) {
//						System.out.print("Stream tick record: " + tickRecord);
//					}
//				};
//
//				LinkedList<String> list = new LinkedList<>();
//				String symbol = "DE30";
//				list.add(symbol);
//
//				TickPricesResponse resp = APICommandFactory.executeTickPricesCommand(connector, 0L, list, 0L);
//				for (TickRecord tr : resp.getTicks()) {
//					System.out.println("TickPrices result: "+tr.getSymbol() + " - ask: " + tr.getAsk());
//				}
//
//				connector.connectStream(sl);
//				System.out.println("Stream connected.");
//
//				connector.subscribePrice(symbol);
//				connector.subscribeTrades();
//
//				Thread.sleep(10000);
//
//				connector.unsubscribePrice(symbol);
//				connector.unsubscribeTrades();
//
//				connector.disconnectStream();
//				System.out.println("Stream disconnected.");
//
//				Thread.sleep(5000);
//
//				connector.connectStream(sl);
//				System.out.println("Stream connected again.");
//				connector.disconnectStream();
//				System.out.println("Stream disconnected again.");
//				System.exit(0);
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

//	protected Map<String,Server> getAvailableServers() {
//		return ServerData.getProductionServers();
//	}
}