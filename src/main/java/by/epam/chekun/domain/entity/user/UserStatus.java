package by.epam.chekun.domain.entity.user;

public enum UserStatus {

    ADMIN(1),
    CUSTOMER(2),
    GUEST(3);


    private static final long serialVersionUID = 1L;
    private int userStatusId;

    private UserStatus(int userStatusId) {
        this.userStatusId = userStatusId;
    }


    public int getUserStatusId() {
        return userStatusId;
    }


}
