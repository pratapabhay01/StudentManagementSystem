package model;

public class Department {

    private int deptId;
    private String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return deptId + " | " + deptName;
    }
}