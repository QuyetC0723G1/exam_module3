package model;

public class Clazz {
    String id;
    String className;

    public Clazz(String className) {
        this.className = className;
    }

    public Clazz(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
