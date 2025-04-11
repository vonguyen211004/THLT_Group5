package due.giuaky221121514224.Day2_Listview_advanced;

public class ContactModel {
    private String name;
    private String phone;
    private int avatarResId;

    public ContactModel(String name, String phone, int avatarResId) {
        this.name = name;
        this.phone = phone;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }
}
