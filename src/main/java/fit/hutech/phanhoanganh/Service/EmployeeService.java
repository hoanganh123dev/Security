package fit.hutech.phanhoanganh.Service;
import org.springframework.data.domain.Page;

import fit.hutech.phanhoanganh.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    //trả về tk
    Page<Employee> findPaginated(int pageNo, int pageSize);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
