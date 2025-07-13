import org.springframework.beans.factory.annotation.Value;

public interface EmployeeWithDeptString {
    @Value("#{target.name + ' works in ' + target.department.name}")
    String getFormattedInfo();
}
