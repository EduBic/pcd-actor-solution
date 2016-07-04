package it.unipd.math.pcd.actors.utils.actors.conversation;

import it.unipd.math.pcd.actors.AbsActor;
import it.unipd.math.pcd.actors.utils.messages.Conversation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduard on 04/07/2016.
 */
public class Alice extends AbsActor<SpeakMessage> {

    List<SpeakMessage> receivedMessage = new ArrayList<>();

    @Override
    public void receive(SpeakMessage newMessage) {
        receivedMessage.add(newMessage);

        if (newMessage instanceof HelloMessage) {
            self.send(new PublicKeyMessage(), sender);
        }
        else if (newMessage instanceof AcknowledgeMessage){
            self.send(new ByeMessage(), sender);
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
