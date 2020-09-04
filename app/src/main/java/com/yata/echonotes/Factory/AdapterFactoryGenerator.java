package com.yata.echonotes.Factory;

import com.yata.echonotes.Factory.AdapterFactory.*;

public class AdapterFactoryGenerator {

    public static AdapterAbstractFactory getAdapterFactory(ADAPTER_TYPES types){
        switch (types){
            case FEED:
                return new FeedAdapterFactory();
            case FEED_POLL:
                return new FeedPollAdapterFactory();
            case POLL_MUTUAL:
                return new FeedPollMutualVoterAdapterFactory();
            case PROFILE_ITEMS:
                return new ProfileItemAdapterFactory();
            case ADD_OPTIONS:
                return new AddOptionsAdapterFactory();
            default:
                return null;
        }
    }

    public enum ADAPTER_TYPES{
        FEED,
        FEED_POLL,
        POLL_MUTUAL,
        PROFILE_ITEMS,
        ADD_OPTIONS,
    }
}
