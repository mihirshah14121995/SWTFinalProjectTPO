package com.main;

import java.util.List;

import org.apache.log4j.Logger;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.model.Student;
import com.service.TpoAssistantService;
import com.service.TpoAssistantServiceImpl;

public class TpoHome extends Shell
{
	
	Text text;
	String textdata;
	Button buttonnumber[]=new Button[10];
	Button buttonaddcompany;
	Button buttonstudentseligiblefordreamstatus;
	Button buttonlistofplacedstudents;
	Button buttonlistofunplacedstudents;
	
	Button buttonstudentsenrolledinacompany;
	
	
	Button buttondummy[]=new Button[3];
	
	private final static Logger logger = Logger.getRootLogger();
	Shell shell =this;
	
	public static void main(String[] args)
	{
		try
		{
			
			Display display = Display.getDefault();
			TpoHome shell = new TpoHome(display);
			shell.open();
			shell.layout();
			while(!shell.isDisposed())
			{
				if(!display.readAndDispatch())
					display.sleep();
			}
			display.dispose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public TpoHome(Display display) 
	{
		super(display,SWT.SHELL_TRIM);
		createContents();
		
	}
	private void createContents() 
	{
		
			
		setText("TPO Home");
		setSize(450,300);
		
		
		
		GridLayout gridLayout=new GridLayout();
		gridLayout.numColumns=2;
		
		textdata="";
//		text=new Text(shell, SWT.NONE);
//		text.setBounds(0, 200, 200, 200);
//		GridData textgriddata=new GridData(GridData.FILL_HORIZONTAL);
//		textgriddata.horizontalSpan=2;
//		text.setLayoutData(textgriddata);
		
//		GridData textgriddata2=new GridData(GridData.FILL_HORIZONTAL);
//		textgriddata2.horizontalSpan=4;
//		textgriddata2.minimumHeight=30;
//		textgriddata2.verticalAlignment = GridData.FILL;
//		textgriddata2.grabExcessHorizontalSpace = true;
//		textgriddata2.grabExcessVerticalSpace = true;
//		text.setLayoutData(textgriddata2);
		//textdata="";
		shell.setLayout(gridLayout);
		//text=new Text(shell, SWT.NONE);
		//text.setBounds(0, 200, 200, 200);
		//GridData textgriddata=new GridData(GridData.FILL_HORIZONTAL);
		//textgriddata.horizontalSpan=2;
		//text.setLayoutData(textgriddata);
		
		Text text3 = new Text(shell, SWT.MULTI|SWT.WRAP);
		//text3.setBounds(340, 10, 100, 40);
		GridData textgriddata=new GridData(GridData.FILL_HORIZONTAL);
		textgriddata.horizontalSpan=4;
		textgriddata.minimumHeight=30;
		textgriddata.verticalAlignment = GridData.FILL;
		textgriddata.grabExcessHorizontalSpace = true;
		textgriddata.grabExcessVerticalSpace = true;
		text3.setLayoutData(textgriddata);
		
		
		
		
		GridData gridData=new GridData();
		gridData.horizontalAlignment=GridData.FILL;
		gridData.verticalAlignment=GridData.FILL;
		gridData.grabExcessHorizontalSpace=true;
		gridData.grabExcessVerticalSpace=true;
//		for(int i=0;i<10;i++)
//		{
//			buttonnumber[i]=new Button(shell, SWT.PUSH);
//			buttonnumber[i].setText(i+"");	
//			buttonnumber[i].setLayoutData(gridData);
//		}
		buttonaddcompany=new Button(shell, SWT.PUSH);
		buttonaddcompany.setText("Add Company");
		buttonaddcompany.setLayoutData(gridData);
//		
		buttonstudentseligiblefordreamstatus=new Button(shell, SWT.PUSH);
		buttonstudentseligiblefordreamstatus.setText("Students Eligible for dream status");
		buttonstudentseligiblefordreamstatus.setLayoutData(gridData);
		buttonstudentseligiblefordreamstatus.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				TpoAssistantService tpoAssistantService = new TpoAssistantServiceImpl();
				
				List<Student> studentEligibleForDreamStatus = tpoAssistantService.getStudentEligibleForDreamStatus();
				//text3.setText("hi");
				for(Student student : studentEligibleForDreamStatus)
				{
					System.out.println(student);
					text3.setData(student);
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		buttonlistofplacedstudents=new Button(shell, SWT.PUSH);
		buttonlistofplacedstudents.setText("List of Placed Students");
		buttonlistofplacedstudents.setLayoutData(gridData);
		
		buttonlistofunplacedstudents=new Button(shell, SWT.PUSH);
		buttonlistofunplacedstudents.setText("List of Unplaced Students");
		buttonlistofunplacedstudents.setLayoutData(gridData);
		
		
		
		
		
//		for(int i=0;i<3;i++)
//		{
//			buttondummy[i]=new Button(shell, SWT.PUSH);
//			//buttondummy[i].setText(i+"");	
//			buttondummy[i].setLayoutData(gridData);
//		}
//		
		
		
		
		
		buttonstudentsenrolledinacompany=new Button(shell, SWT.PUSH);
		buttonstudentsenrolledinacompany.setText("View Enrolled Students");
		buttonstudentsenrolledinacompany.setLayoutData(gridData);
	
		
		
		
		
		
		class MySelectionListener implements SelectionListener
		{

			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				
				  
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) 
			{
				
				
			}
			
		}
		
		
	}
	

	@Override
	protected void checkSubclass()
	{
		
	}
}
