package it.unipd.math.pcd.actors;

import it.unipd.math.pcd.actors.exceptions.NoSuchActorException;

/**
 * Created by Eduard on 30/06/2016.
 */
public class ActorRefImp implements ActorRef {

    private AbsActorSystem actorSystem;

    public ActorRefImp(AbsActorSystem system) {
        actorSystem = system;
    }

    @Override
    public void send(Message message, ActorRef to) {
        try {
            AbsActor sender = (AbsActor) actorSystem.getUnderlyingActor(to);
            sender.newMessage(this, message);
        }
        catch (NoSuchActorException e) {
            throw e;
        }

    }

    @Override
    public int compareTo(Object o) {
        if (o.hashCode() == this.hashCode())
            return 0;
        else
            return 1;
    }
}
