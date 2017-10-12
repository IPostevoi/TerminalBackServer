package server.transporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.api.Request;
import server.interfaces.TerminalServer;

import javax.jms.*;

/**
 * Created by bakla410 on 08.10.17.
 */

@Service
public class MessageListenerImpl implements MessageListener {

    @Autowired
    TerminalServer orchestration;

    public void onMessage(Message message) {
        ObjectMessage msg = (ObjectMessage) message;
        try {
            Request request = (Request) (msg.getObject());
            orchestration.processRequest(request);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
