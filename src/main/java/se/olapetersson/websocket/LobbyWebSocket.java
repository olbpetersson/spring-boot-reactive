package se.olapetersson.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import se.olapetersson.entities.Lobby;

public class LobbyWebSocket extends TextWebSocketHandler{

        @Override
        protected void handleTextMessage(WebSocketSession session,
                                         TextMessage message) throws Exception {
            ObjectMapper mapper = new ObjectMapper();
            Lobby lobby = new Lobby("hej websocket!");
            TextMessage returnMessage = new TextMessage(lobby.toString());
            session.sendMessage(returnMessage);
        }
}
