package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> bridge;
    private ArrayList<String> userBridge;


    public User(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public ArrayList<String> getUserBridge() {
        return userBridge;
    }

    public void setUserBridge(ArrayList<String> userBridge) {
        this.userBridge = userBridge;
    }

    public boolean onGame() {
        if (this.userBridge.size() == this.bridge.size()) {
            return false;
        }
        return true;
    }
}
