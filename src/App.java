public class App {
    UserInfo userInfo;

    public void requestInput() {
        userInfo.getInputInfo();
    }

    public void run() {
        UserInterface userInterface = new UserInterface();
        userInterface.printUserInfo(userInfo);
        }
    public static void main(String[]args){
       App app = new App();
       app.run();
    }
}