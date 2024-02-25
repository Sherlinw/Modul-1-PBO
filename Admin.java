class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }
}
class Student extends User {
    private String nim;

    public Student(String username, String password, String nim) {
        super(username, password);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public boolean isStudent() {
        return true;
    }
}