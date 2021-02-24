package ba.unsa.etf.rpr.model;

import ba.unsa.etf.rpr.model.Department;
import ba.unsa.etf.rpr.model.Employee;
import ba.unsa.etf.rpr.model.Job;
import ba.unsa.etf.rpr.model.Manager;

public class Worker extends Employee {

    private Manager manager;

    public Worker() {
    }

    public Worker(int employeeId, String employeeName, String email, String hireDate, Department department, Job job, int salary, double cmp, String expireDate,String password, Manager manager) {
        super(employeeId, employeeName, email, hireDate, department, job, salary, cmp, expireDate,password);
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
