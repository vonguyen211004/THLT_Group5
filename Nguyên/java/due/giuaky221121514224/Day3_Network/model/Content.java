package due.giuaky221121514224.Day3_Network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content {
    @SerializedName("items")
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
