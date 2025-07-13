@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double salary;

    @ManyToOne
    private Department department;

    // Getters and setters
}
