
class Acquaintance {
    protected String name; // Change visibility to protected

    public Acquaintance(String name) {
        this.name = name;
    }

    public void getStatus() {
        System.out.println(name + " is just an acquaintance.");
    }
}

class Friend extends Acquaintance {
    protected String homeTown; // Change visibility to protected

    public Friend(String name, String homeTown) {
        super(name);
        this.homeTown = homeTown;
    }

    @Override
    public void getStatus() {
        System.out.println(name + " is a friend and he is from " + homeTown + ".");
    }
}

class BestFriend extends Friend {
    private String favoriteSong;

    public BestFriend(String name, String homeTown, String favoriteSong) {
        super(name, homeTown);
        this.favoriteSong = favoriteSong;
    }

    @Override
    public void getStatus() {
        System.out.println(name + " is my best friend. He is from " + homeTown + " and his favorite song is " + favoriteSong + ".");
    }
}
