package fit.hutech.phanhoanganh.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import fit.hutech.phanhoanganh.model.Employee;
import fit.hutech.phanhoanganh.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl1 implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        // TODO Auto-generated method stub
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        }else {
            throw new RuntimeException(" Employee not found for id ::"+id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        // TODO Auto-generated method stub
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        //pageRQ dể chỉ định trang hiện tại pn và kích thước size
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        // TODO Auto-generated method stub
        //sDT vs s.dt.asc.n if true use s.by(sf để tạo oj sort
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

}

