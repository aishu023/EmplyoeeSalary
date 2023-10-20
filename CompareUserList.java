package com.cg.havherrank;

class UserManager {
    public static List<User>[] compareUsers(List<User> usersListInDB, List<User> newUsersList) {
        List<User> updated = new ArrayList<User>();
        List<User> inserted = new ArrayList<User>();

        for (User user : newUsersList) {
            User userInDB = null;
            for (User u : usersListInDB) {
                if (u.getId() == user.getId()) {
                    userInDB = u;
                    break;
                }
            }

            if (userInDB != null) {
                for (java.lang.reflect.Field field : User.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    try {
                        Object valueInDB = field.get(userInDB);
                        Object valueInNewList = field.get(user);

                        if ((valueInDB == null && valueInNewList == null) || (valueInDB == null || valueInNewList == null)) {
                            continue;
                        }

                        if (!valueInDB.equals(valueInNewList)) {
                            updated.add(user);
                            break;
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                inserted.add(user);
            }
        }
        List<User>[] res = new ArrayList[2];
        res[0] = updated;
        res[1] = inserted;
        return res;
    }
}
