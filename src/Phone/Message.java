package Phone;

public class Message {
    private String number;
    private String text;

    public Message(String number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }
}
