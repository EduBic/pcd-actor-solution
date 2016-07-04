package it.unipd.math.pcd.actors.utils.actors.conversation;

import it.unipd.math.pcd.actors.AbsActor;
import it.unipd.math.pcd.actors.utils.messages.Conversation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduard on 04/07/2016.
 */
public class Bob extends AbsActor<SpeakMessage> {

    List<SpeakMessage> receivedMessage = new ArrayList<>();

    @Override
    public void receive(SpeakMessage newMessage) {
        receivedMessage.add(newMessage);

        if (newMessage instanceof HelloMessage) {
            self.send(new HelloMessage(), sender);
        }
        else if (newMessage instanceof PublicKeyMessage){
            self.send(new AcknowledgeMessage(), sender);
        }
    }

    public boolean hasReceivedMessage(SpeakMessage msg) {
        for (SpeakMessage message : receivedMessage) {
            if (message.isEquals(msg)) {
                return true;
            }
        }
        return false;
    }
}
