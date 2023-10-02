class UserInfo {
    private String name;
    private String lastname;

    public getInputInfo() {
        Scaner sc = new Scaner(System.in);
        System.out.println("Enter a name: ");
        setName(sc.nextLine());
        System.out.println("Enter a lastname: ");
        setLastname(sc.nextLine());
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }
}