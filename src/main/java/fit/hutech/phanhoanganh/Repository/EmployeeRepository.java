package fit.hutech.phanhoanganh.Repository;

import fit.hutech.phanhoanganh.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
