package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import server.api.Request;
import server.api.Response;
import server.interfaces.TerminalServer;
import server.transporting.MessageSender;

import java.io.Serializable;

/**
 * Created by bakla410 on 08.10.17.
 */
@Component
public class Orchestration implements TerminalServer {

    @Autowired
    MessageSender sender;

    @Override
    public Response processRequest(Request request) {

        Response response = new Response();

        switch (request.getType()) {
            case ACCOUNTSTATE:
                response.setBody(accountState());
                break;
            case VALIDATEPIN:
                System.out.println("Валидация pin");
                String pin = request.getBody();
                response.setSuccess(validatePin(pin));
                break;
            case WITHDRAW:
                response.setSuccess(withdrawCurrency());
                break;
            case PUT:
                System.out.println("Внесение средств на счет: +"
                        + request.getOperation().getCount()
                        + " "
                        + request.getOperation().getType().getName());
                response.setSuccess(putCurrency());
                break;
        }
        sender.send(response);
        return response;
    }

    public boolean validatePin(String pin) {
        if (pin.equals("1234")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean putCurrency() {
        return true;
    }

    @Override
    public boolean withdrawCurrency() {
        return false;
    }

    @Override
    public AccountState accountState() {
        return new AccountState();
    }
}
