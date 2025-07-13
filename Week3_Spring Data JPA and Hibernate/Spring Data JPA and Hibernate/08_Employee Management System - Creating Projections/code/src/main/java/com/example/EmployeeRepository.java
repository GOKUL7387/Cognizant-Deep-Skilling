@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Interface-based projection
    List<EmployeeNameSalary> findByDepartmentName(String name);

    // DTO-based projection
    @Query("SELECT new com.example.projection.dto.EmployeeDTO(e.name, e.department.name) FROM Employee e")
    List<EmployeeDTO> fetchEmployeeDTOs();

    // @Value-based projection
    List<EmployeeWithDeptString> findAllBy();
}
