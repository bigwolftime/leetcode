package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/
 */
public class GetImportance {

    private static HashMap<Integer, Employee> EMPLOYEE_MAP;

    private static int getImportance(List<Employee> employees, int id) {
        EMPLOYEE_MAP = new HashMap<>();
        for (Employee employee : employees) {
            EMPLOYEE_MAP.put(employee.id, employee);
        }

        int importance = 0;

        Stack<Employee> stack = new Stack<>();
        stack.push(EMPLOYEE_MAP.get(id));

        while (!stack.isEmpty()) {
            Employee employee = stack.pop();
            importance += calcImportance(employee.subordinates);

            for (Integer employeeId : employee.subordinates) {
                stack.push(EMPLOYEE_MAP.get(employeeId));
            }
        }

        return importance + EMPLOYEE_MAP.get(id).importance;
    }

    private static int calcImportance(List<Integer> employeeIds) {
        int importance = 0;
        for (int employeeId : employeeIds) {
            importance += EMPLOYEE_MAP.get(employeeId).importance;
        }

        return importance;
    }


    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {

    }

}
