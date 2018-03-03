package pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ServiceList {

    @SerializedName("total")
    private int total;

    public int getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceList serviceList = (ServiceList) o;
        return total == serviceList.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
