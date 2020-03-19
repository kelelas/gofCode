package mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat, "Alex");
        User user = new SimpleUser("Marry", textChat);
        User user1 = new SimpleUser("Steve", textChat);
        User user2 = new SimpleUser("Olly", textChat);
        user2.setEnable(false);

        textChat.setAdmin(admin);
        textChat.addUser(user);
        textChat.addUser(user1);
        textChat.addUser(user2);
        user.sendMessage("Hello, I'm user");
        admin.sendMessage("hi, users!");
    }
}

abstract class User{
    Chat chat;
    String name;
    boolean isEnable = true;

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public User(String name,Chat chat) {
        this.name = name;
        this.chat = chat;
    }

    public String getName() {
        return name;
    }

    void sendMessage(String message){
        chat.sendMessage(message, this);
    }
    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
interface Chat{
    void sendMessage(String message, User user);
}

class Admin extends User{

    public Admin(Chat chat, String name) {
        super(name, chat);
    }
    @Override
    public void getMessage(String message) {
        System.out.println("Admin " + name + " get message: '" + message + "'");
    }
}

class SimpleUser extends User{
    public SimpleUser(String name, Chat chat) {
        super(name, chat);
    }
    @Override
    public void getMessage(String message) {
        System.out.println("User " + name + " get message: '" + message + "'");
    }
}

class TextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin!=null && admin instanceof Admin)
        this.admin = admin;
        else throw new RuntimeException("not admin");
    }
    public void addUser(User user){
        if (admin==null)
            throw new RuntimeException("no admin in the chat");
        if (user instanceof SimpleUser)
        users.add(user);
        else throw new RuntimeException("Admin cant join to another chat");
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if (user instanceof SimpleUser){
            for (User u : users) {
                if (u.isEnable && u!=user)
                u.getMessage(user.getName() + ": " + message);
            }
            if (admin.isEnable)
                admin.getMessage(user.getName()+ ": " + message);
        }
    }
}