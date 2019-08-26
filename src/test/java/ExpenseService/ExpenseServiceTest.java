package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
		ProjectType projectType = ProjectType.INTERNAL;
		String projectName = "";
		
    	Project project = new Project(projectType,projectName);
    	ExpenseService expenseService = new ExpenseService();
    	ExpenseType expenseType = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // when
        // then
    	assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE,expenseType);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
    	ProjectType projectType = ProjectType.EXTERNAL;
    	String projectName = "Project A";
    	Project project = new Project(projectType,projectName);
    	ExpenseService expenseService = new ExpenseService();
    	ExpenseType expenseType = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // when
        // then
    	assertEquals(ExpenseType.EXPENSE_TYPE_A,expenseType);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
    	 // given
    	ProjectType projectType = ProjectType.EXTERNAL;
    	String projectName = "Project B";
    	Project project = new Project(projectType,projectName);
    	ExpenseService expenseService = new ExpenseService();
    	ExpenseType expenseType = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // when
        // then
    	assertEquals(ExpenseType.EXPENSE_TYPE_B,expenseType);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
    	 // given
    	ProjectType projectType = ProjectType.EXTERNAL;
    	String projectName = "Project C";
    	Project project = new Project(projectType,projectName);
    	ExpenseService expenseService = new ExpenseService();
    	ExpenseType expenseType = expenseService.getExpenseCodeByProjectTypeAndName(project);
        // when
        // then
    	assertEquals(ExpenseType.OTHER_EXPENSE,expenseType);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
    	 // given
    	ProjectType projectType = ProjectType.UNEXPECTED_PROJECT_TYPE;
    	String projectName = "";
    	Project project = new Project(projectType,projectName);
    	ExpenseService expenseService = new ExpenseService();
    	//try {
    		
//    	}catch() {
//    		
//    	}
    //	expenseService.getExpenseCodeByProjectTypeAndName(project);
    	assertEquals(ExpenseType.OTHER_EXPENSE,"You enter invalid project type");
    }
}