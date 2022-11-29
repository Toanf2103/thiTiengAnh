package Model;

import java.io.Serializable;

public class Thi implements Serializable {
    private String name;
    private String congThuc;
    private  int id;
    public Thi() {
    }

    public Thi(String name, String congThuc, int id) {
        this.name = name;
        this.congThuc = congThuc;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Thi(String name, String congThuc) {
        this.name = name;
        this.congThuc = congThuc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCongThuc() {
        return congThuc;
    }

    public void setCongThuc(String congThuc) {
        this.congThuc = congThuc;
    }
}
