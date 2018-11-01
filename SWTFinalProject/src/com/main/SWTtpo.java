package com.main;

import java.util.List;




import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.model.Enrollment;
import com.model.Student;
import com.service.EnrollmentService;
import com.service.EnrollmentServiceImpl;
import com.service.StudentService;
import com.service.StudentServiceImpl;
import com.service.TpoAssistantService;
import com.service.TpoAssistantServiceImpl;




public class SWTtpo extends Shell {

	

	public static void main(String[] args) {
		try{
			Display display =  Display.getDefault(); //Display listens to event and generates event loops
		
			SWTtpo shell=new SWTtpo(display); //Shell is th window that is displayed...It will listen from the event queue named display
		
			
			
		shell.layout();
		shell.open();
		while(!shell.isDisposed())
		{
			if(!display.readAndDispatch()) //Read an event from display and dispatch it to the shell
			{
				display.sleep();
			}
		}
		display.dispose();
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public SWTtpo(Display display) {
		super(display,SWT.SHELL_TRIM);
		createContents();
	}

	private void createContents() {
		
		
		
		TpoAssistantService tpoAssistantService = new TpoAssistantServiceImpl();
		List<Student> studentEligibleForDreamStatus = tpoAssistantService.getStudentEligibleForDreamStatus();
		
		StudentService studentService = new StudentServiceImpl();
		List<Student> placedStudents = studentService.getPlacedStudent();
		
//		GetAllOrders_Service getAllOrders_Service = new GetAllOrders_Service();
//		GetAllOrders orderPort = getAllOrders_Service.getNewPort();
//		List<Order> allOrders = orderPort.getAllOrders();
//		
		
		setText("TPO");
		Button buttonDreamStatus=new Button(this ,SWT.PUSH);
		 buttonDreamStatus.setBounds(0,0,250,30);
		 buttonDreamStatus.setText("Students Eligible for dream status");
		 
		 Button buttonPlacedStudents=new Button(this ,SWT.PUSH);
		 buttonPlacedStudents.setBounds(300,0,160,30);
		 buttonPlacedStudents.setText("View Placed Students");
		 
//		 Button viewQuotations=new Button(this ,SWT.PUSH);
//		 viewQuotations.setBounds(300,0,100,30);
//		 viewQuotations.setText("ViewQuotations");
		 
//		 org.eclipse.swt.widgets.List list=new org.eclipse.swt.widgets.List(this ,SWT.BORDER|SWT.MULTI|SWT.V_SCROLL|SWT.H_SCROLL);
//		 list.setBounds(0,70,300,300);
		 
		 Table tableDreamStatus = new Table(this,SWT.BORDER);
		 	
		 tableDreamStatus.addDisposeListener(new DisposeListener(){

				@Override
				public void widgetDisposed(DisposeEvent e) {
			
					
					
					
				}
				
			});
			tableDreamStatus.setBounds(0,50,1020,400);
			tableDreamStatus.setLinesVisible(true);
			tableDreamStatus.setVisible(true);
			
			
			Table tablePlacedStudents = new Table(this,SWT.BORDER);
		 	
			 tablePlacedStudents.addDisposeListener(new DisposeListener(){

					@Override
					public void widgetDisposed(DisposeEvent e) {
				
						
						
						
					}
					
				});
				tablePlacedStudents.setBounds(0,50,1020,400);
				tablePlacedStudents.setLinesVisible(true);
				tablePlacedStudents.setVisible(true);
		 
			buttonDreamStatus.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//list.add(""+"ProductId"+"  "+"ProductName"+"  "+"ProductDetails");
				
					
					//list.add("Product Id:"+product.getProductId()+"  Product Name:"+product.getProductName()+"  Product Details:"+product.getProductDetails());
					
					
					tableDreamStatus.setVisible(true);
					TableColumn studentId = new TableColumn(tableDreamStatus, SWT.RIGHT);
					studentId.setText("Student ID");
					studentId.setWidth(50);
					
					TableColumn backlog = new TableColumn(tableDreamStatus, SWT.LEFT);
					backlog.setText("Backlog");
					backlog.setWidth(150);

					TableColumn status = new TableColumn(tableDreamStatus, SWT.RIGHT);
					status.setText("Status");
					status.setWidth(100);

					TableColumn password = new TableColumn(tableDreamStatus, SWT.LEFT);
					password.setText("Password");
					password.setWidth(200);
					
					TableColumn studentName = new TableColumn(tableDreamStatus, SWT.LEFT);
					studentName.setText("Student name");
					studentName.setWidth(100);
				
					TableColumn branch = new TableColumn(tableDreamStatus, SWT.RIGHT);
					branch.setText("Branch");
					branch.setWidth(100);
					
					TableColumn instituteName = new TableColumn(tableDreamStatus, SWT.LEFT);
					instituteName.setText("Institute name");
					instituteName.setWidth(100);
					
					TableColumn email = new TableColumn(tableDreamStatus, SWT.RIGHT);
					email.setText("Email");
					email.setWidth(100);
					
					TableColumn yop = new TableColumn(tableDreamStatus, SWT.LEFT);
					yop.setText("Year Of Passing");
					yop.setWidth(100);
					
					TableColumn phoneNumber = new TableColumn(tableDreamStatus, SWT.RIGHT);
					phoneNumber.setText("Phone Number");
					phoneNumber.setWidth(100);
					
					TableColumn ssc = new TableColumn(tableDreamStatus, SWT.LEFT);
					ssc.setText("SSC");
					ssc.setWidth(100);
					
					TableColumn hsc = new TableColumn(tableDreamStatus, SWT.RIGHT);
					hsc.setText("HSC");
					hsc.setWidth(100);
					
					TableColumn beaggregate = new TableColumn(tableDreamStatus, SWT.RIGHT);
					beaggregate.setText("B.E. Aggregate");
					beaggregate.setWidth(150);
				
					studentId.setResizable(true);
					backlog.setResizable(true);
					status.setResizable(true);
					branch.setResizable(true);
					password.setResizable(true);
					studentName.setResizable(true);
					instituteName.setResizable(true);
					email.setResizable(true);
					yop.setResizable(true);
					phoneNumber.setResizable(true);
					ssc.setResizable(true);
					hsc.setResizable(true);
					beaggregate.setResizable(true);
					tableDreamStatus.setHeaderVisible(true);
					
					for(Student student: studentEligibleForDreamStatus)
					{
					TableItem item1 = new TableItem(tableDreamStatus, SWT.None);
					item1.setText(new String[] {""+student.getSid(),""+student.getBacklog(),""+student.getStatus(),""+student.getPassword(),""+student.getSname(),""+student.getBranch(),""+student.getInstituteName(),""+student.getEmail(),""+student.getYop(),""+student.getPhone(),""+student.getSsc(),""+student.getHsc(),""+student.getBeaggregate()});
				
				}
					
					
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 //When view orders button is clicked
			
		 buttonPlacedStudents.addSelectionListener(new SelectionListener() {
			
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					
					tableDreamStatus.setVisible(false);
					tablePlacedStudents.setVisible(true);
					
					TableColumn studentId = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					studentId.setText("Student ID");
					studentId.setWidth(50);
					
					TableColumn backlog = new TableColumn(tablePlacedStudents, SWT.LEFT);
					backlog.setText("Backlog");
					backlog.setWidth(150);

					TableColumn status = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					status.setText("Status");
					status.setWidth(100);

					TableColumn password = new TableColumn(tablePlacedStudents, SWT.LEFT);
					password.setText("Password");
					password.setWidth(200);
					
					TableColumn studentName = new TableColumn(tablePlacedStudents, SWT.LEFT);
					studentName.setText("Student name");
					studentName.setWidth(100);
				
					TableColumn branch = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					branch.setText("Branch");
					branch.setWidth(100);
					
					TableColumn instituteName = new TableColumn(tablePlacedStudents, SWT.LEFT);
					instituteName.setText("Institute name");
					instituteName.setWidth(100);
					
					TableColumn email = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					email.setText("Email");
					email.setWidth(100);
					
					TableColumn yop = new TableColumn(tablePlacedStudents, SWT.LEFT);
					yop.setText("Year Of Passing");
					yop.setWidth(100);
					
					TableColumn phoneNumber = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					phoneNumber.setText("Phone Number");
					phoneNumber.setWidth(100);
					
					TableColumn ssc = new TableColumn(tablePlacedStudents, SWT.LEFT);
					ssc.setText("SSC");
					ssc.setWidth(100);
					
					TableColumn hsc = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					hsc.setText("HSC");
					hsc.setWidth(100);
					
					TableColumn beaggregate = new TableColumn(tablePlacedStudents, SWT.RIGHT);
					beaggregate.setText("B.E. Aggregate");
					beaggregate.setWidth(150);
				
					studentId.setResizable(true);
					backlog.setResizable(true);
					status.setResizable(true);
					branch.setResizable(true);
					password.setResizable(true);
					studentName.setResizable(true);
					instituteName.setResizable(true);
					email.setResizable(true);
					yop.setResizable(true);
					phoneNumber.setResizable(true);
					ssc.setResizable(true);
					hsc.setResizable(true);
					beaggregate.setResizable(true);
					tablePlacedStudents.setHeaderVisible(true);
					
					for(Student student: placedStudents)
					{
					TableItem item1 = new TableItem(tablePlacedStudents, SWT.None);
					item1.setText(new String[] {""+student.getSid(),""+student.getBacklog(),""+student.getStatus(),""+student.getPassword(),""+student.getSname(),""+student.getBranch(),""+student.getInstituteName(),""+student.getEmail(),""+student.getYop(),""+student.getPhone(),""+student.getSsc(),""+student.getHsc(),""+student.getBeaggregate()});
				
				}
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		
	}
	
	
	@Override
	protected void checkSubclass(){
		
	}

}
