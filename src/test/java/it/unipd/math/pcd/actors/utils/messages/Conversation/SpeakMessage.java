package it.unipd.math.pcd.actors.utils.messages.Conversation;

import it.unipd.math.pcd.actors.Message;

/**
 * Created by Eduard on 04/07/2016.
 */
public class SpeakMessage implements Message {

    private String message;

    public SpeakMessage(String msg) {
        this.message = msg;
    }

    public boolean isEquals(SpeakMessage message) {
        if (message.message.equals(this.message)) {
            return true;
        }
        return false;
    }
}
