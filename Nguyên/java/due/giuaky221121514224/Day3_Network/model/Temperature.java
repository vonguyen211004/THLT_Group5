package due.giuaky221121514224.Day3_Network.model;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    private Double Value;
    private String Unit;
    public Double getValue() {return Value;}
    public void setValue(Double value) {Value = value;}

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {Unit = unit;}
}
