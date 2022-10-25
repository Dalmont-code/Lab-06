package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */
    Map<U, String> followed = new HashMap<>();

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    public boolean addFollowedUser(final String circle, final U user) {
        if (followed.get(user) == null) {
            followed.put(user, circle);
            return true;
        }
        return false;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Set<Map.Entry<U,String>> set = followed.entrySet();
        Collection<U> users = new HashSet<>();
        for (var elem : set) {
            if (elem.getValue().equals(groupName)) {
                users.add(elem.getKey());
            }
        }
        return users;
    }

    public List<U> getFollowedUsers() {
        Set<Map.Entry<U,String>> set = followed.entrySet();
        List<U> users = new ArrayList<>();
        for (var elem : set) {
            users.add(elem.getKey());
        }
        return users;
    }
}
