package pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ServiceItem {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ServiceItem{" +
               "name='" + name + '\'' +
               ", id='" + id + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceItem serviceItem = (ServiceItem) o;
        return Objects.equals(name, serviceItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
