public class EmployeeDTO {
    private String name;
    private String department;

    public EmployeeDTO(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
}