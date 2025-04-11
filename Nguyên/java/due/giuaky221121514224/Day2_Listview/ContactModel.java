package due.giuaky221121514224.Day2_Listview;

public class ContactModel {
    private String name;
    private String phoneNumber;
    private int imageResId;

    public ContactModel(String name, String phoneNumber, int imageResId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageResId() {
        return imageResId;
    }
}