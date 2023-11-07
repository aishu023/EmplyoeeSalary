
//help desk ticket processing

	class Employee implements IEmployee {
	    private String fullName;
	    private int pointLevel;
	    private List <Category> assignedCategories;

	    public Employee(String fullName, int pointLevel, List <Category> assignedCategories) {
	        this.fullName = fullName;
	        this.pointLevel = pointLevel;
	        this.assignedCategories = assignedCategories;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getFullName() {
	        return this.fullName;
	    }

	    public void setPointLevel(int pointLevel) {
	        this.pointLevel = pointLevel;
	    }

	    public int getPointLevel() {
	        return this.pointLevel;
	    }

	    public void setAssignedCategories(List <Category> assignedCategories) {
	        this.assignedCategories = assignedCategories;
	    }

	    public List <Category> getAssignedCategories() {
	        return this.assignedCategories;
	    }
	}

	class Ticket implements ITicket {
	    private int id;
	    private String name;
	    private Category category;
	    private int point;
	    private boolean isCompleted;
	    private String assignedEmployee;

	    public Ticket(int id, String name, Category category, int point) {
	        this.id = id;
	        this.name = name;
	        this.category = category;
	        this.point = point;
	        this.isCompleted = false;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getId() {
	        return this.id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return this.name;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }

	    public Category getCategory() {
	        return this.category;
	    }

	    public void setPoint(int point) {
	        this.point = point;
	    }

	    public int getPoint() {
	        return this.point;
	    }

	    public void setIsCompleted(boolean isCompleted) {
	        this.isCompleted = isCompleted;
	    }

	    public boolean getIsCompleted() {
	        return this.isCompleted;
	    }

	    public void setAssignedEmployee(String assignedEmployee) {
	        this.assignedEmployee = assignedEmployee;
	    }

	    public String getAssignedEmployee() {
	        return this.assignedEmployee;
	    }
	}

	class HelpDesk implements IHelpDesk {
	    private List<IEmployee> employees;
	    private List<ITicket> tickets;

	    public HelpDesk() {
	        employees = new ArrayList<IEmployee>();
	        tickets = new ArrayList<ITicket>();
	    }

	    public void addTicket(ITicket ticket) {
	        tickets.add(ticket);
	    }

	    public void addEmployee(IEmployee employee) {
	        employees.add(employee);
	    }

	    public void completeTicket(String employeeFullName, int ticketId) {
	        IEmployee employee = employees.stream().filter(e -> e.getFullName().equals(employeeFullName)).findFirst().orElse(null);
	        if (employee == null) {
	            return;
	        }
	        ITicket ticket = tickets.stream().filter(t -> t.getId() == ticketId && !t.getIsCompleted() && t.getPoint() <= employee.getPointLevel()).findFirst().orElse(null);
	        if (ticket != null && employee.getAssignedCategories().contains(ticket.getCategory()) && employee.getPointLevel() >= ticket.getPoint()) {
	            ticket.setIsCompleted(true);
	            ticket.setAssignedEmployee(employeeFullName);
	        }
	    }

	    public int getWaitingTicketCount() {
	        return (int) tickets.stream().filter(t -> !t.getIsCompleted()).count();
	    }

	    public int getCompletedTicketsTotalPoint() {
	        return tickets.stream().filter(ITicket::getIsCompleted).mapToInt(ITicket::getPoint).sum();
	    }

	    public List<CategoryNode> getTicketsTotalPointByCategory() {
	        List<CategoryNode> result = new ArrayList<>();
	        for (Category category : EnumSet.allOf(Category.class)) {
	            int totalPoint = tickets.stream().filter(t -> t.getCategory() == category).mapToInt(ITicket::getPoint).sum();
	            result.add(new CategoryNode(category, totalPoint));
	        }
	        return result;
	    }

	    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
	        List<EmployeeNode> result = new ArrayList<>();
	        for (IEmployee employee : employees) {
	            int totalPoint = tickets.stream().filter(t -> t.getIsCompleted() && t.getAssignedEmployee().equals(employee.getFullName())).mapToInt(ITicket::getPoint).sum();
	            result.add(new EmployeeNode(employee, totalPoint));
	        }
	        return result;
	    }
	}
	

