package pro.xstore.api.message.command;

import org.json.JSONObject;

import pro.xstore.api.message.error.APICommandConstructionException;

public class CommissionDefCommand extends BaseCommand {

    public CommissionDefCommand(JSONObject arguments) throws APICommandConstructionException {
        super(arguments);
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("command", commandName);
        obj.put("arguments", arguments);
        return obj.toString();
    }

    @Override
    public String getCommandName() {
        return "getCommissionDef";
    }

    @Override
    public String[] getRequiredArguments() throws APICommandConstructionException {
        return new String[]{"symbol", "volume"};
    }
}