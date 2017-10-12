package server.interfaces;


import server.AccountState;
import server.api.Request;
import server.api.Response;

import java.io.Serializable;

/**
 * Created by bakla410 on 08.10.17.
 */

/**
 * Интерфейс сервера, обрабатывающего входные данные с терминала
 *
 */
public interface TerminalServer {

    // TODO узкое место - возврат значения в листенер
    Response processRequest(Request request);

    boolean putCurrency();

    boolean withdrawCurrency();

    AccountState accountState();

}
