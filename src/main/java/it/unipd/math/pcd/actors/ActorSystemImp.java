package it.unipd.math.pcd.actors;

import it.unipd.math.pcd.actors.exceptions.NoSuchActorException;

/**
 * Created by Eduard on 30/06/2016.
 */
public class ActorSystemImp extends AbsActorSystem {

    private static final AbsActorSystem system = new ActorSystemImp();

    public ActorSystemImp() {}

    public static AbsActorSystem getInstance() {return system;}

    @Override
    protected ActorRef createActorReference(ActorMode mode) throws IllegalArgumentException {
        if (mode == ActorMode.LOCAL) {
            return new ActorRefImp(this);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void stop(ActorRef<?> actor) {
        super.stop(actor);
    }

    @Override
    public void stop() {

    }
}