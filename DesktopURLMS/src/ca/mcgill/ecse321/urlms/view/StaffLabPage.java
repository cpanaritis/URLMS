package ca.mcgill.ecse321.urlms.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.urlms.controller.URLMSController;
import ca.mcgill.ecse321.urlms.model.Laboratory;
import ca.mcgill.ecse321.urlms.model.URLMS;
import java.awt.BorderLayout;
/**
 * UI for the home page of a selected lab.
 * @author Group 1
 *
 */
public class StaffLabPage extends JFrame{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1020649756845890686L;
	/**
	 * URLMS System
	 */
	private URLMS urlms;
	/**
	 * Current lab that user is viewing/editing
	 */
	private Laboratory currentLab;
	/**
	 * URLMS controller
	 */
	private URLMSController urlmsCont;
	/**
	 * Constructor of StaffLabPage frame
	 * @param urlms current URLMS system
	 * @param lab current lab user is viewing
	 */
	public StaffLabPage(URLMS urlms, Laboratory lab, URLMSController urlmsCont) {
		setResizable(false);
		this.urlms = urlms;
		this.currentLab = lab;
		this.urlmsCont = urlmsCont;
		
		try {
	           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	               if ("Nimbus".equals(info.getName())) {
	                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                   break;
	               }
	           }
	       } catch (ClassNotFoundException ex) {
	           java.util.logging.Logger.getLogger(StaffLabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	       } catch (InstantiationException ex) {
	           java.util.logging.Logger.getLogger(StaffLabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	       } catch (IllegalAccessException ex) {
	           java.util.logging.Logger.getLogger(StaffLabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	           java.util.logging.Logger.getLogger(StaffLabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	       }
		initComponents();
	}
	
	private void initComponents() {
		
		this.setTitle("University Lab Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JButton btnEquipment = new JButton("Manage Equipment");
		btnEquipment.setBackground(new Color(0, 191, 255));
		btnEquipment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JButton btnSupplies = new JButton("Manage Supplies");
		btnSupplies.setBackground(new Color(0, 191, 255));
		btnSupplies.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JButton btnUpdateProf = new JButton("Update Profile");
		btnUpdateProf.setBackground(new Color(0, 191, 255));
		btnUpdateProf.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		
		JButton btnProgReport = new JButton("View Weekly Progress Report");
		btnProgReport.setBackground(new Color(0, 191, 255));
		btnProgReport.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	    
	    JButton backBtn = new JButton("Back");
	    backBtn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
	    backBtn.setBackground(new Color(255, 255, 13));
	    
	    JButton lgtButn = new JButton("Logout");
	    lgtButn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
	    lgtButn.setBackground(Color.RED);
		
	    getContentPane().setBackground(new Color(216, 247, 255));
	    
	    JPanel headerPanel = new JPanel();
	    headerPanel.setBackground(new Color(14, 96, 131));
	    
	    JButton btnCreateReport = new JButton("Create Progress Report");
	    btnCreateReport.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	    btnCreateReport.setBackground(new Color(0, 191, 255));
	    
	    JButton btnAddExp = new JButton("Add Expense");
	    btnAddExp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
	    btnAddExp.setBackground(new Color(0, 191, 255));

		// Layout
	    GroupLayout layout = new GroupLayout(getContentPane());
	    layout.setHorizontalGroup(
	    	layout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
	    			.addComponent(lgtButn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap())
	    		.addGroup(layout.createSequentialGroup()
	    			.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 822, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(45, Short.MAX_VALUE))
	    		.addGroup(layout.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
	    					.addGap(49)
	    					.addComponent(btnCreateReport, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
	    					.addGap(49)
	    					.addComponent(btnSupplies))
	    				.addComponent(btnEquipment, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
	    			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
	    						.addComponent(btnUpdateProf)
	    						.addComponent(btnProgReport)))
	    				.addGroup(layout.createSequentialGroup()
	    					.addGap(107)
	    					.addComponent(btnAddExp, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(109))
	    );
	    layout.setVerticalGroup(
	    	layout.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(layout.createSequentialGroup()
	    			.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
	    			.addGap(51)
	    			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(btnProgReport, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(btnSupplies, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
	    			.addGap(65)
	    			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(btnUpdateProf, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(btnEquipment, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
	    			.addGap(58)
	    			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(btnAddExp, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(btnCreateReport, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
	    			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lgtButn, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap())
	    );
	    layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnEquipment, btnSupplies, btnUpdateProf, btnProgReport});
	    headerPanel.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblWelcome = new JLabel("Welcome User");
	    lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
	    lblWelcome.setForeground(Color.WHITE);
	    lblWelcome.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 27));
	    headerPanel.add(lblWelcome, BorderLayout.CENTER);
	    getContentPane().setLayout(layout);
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	
	    btnEquipment.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new ManageEquipmentPage(urlms, currentLab, urlmsCont).setVisible(true);
	    		dispose();
	    	}
	    });
	
	    btnSupplies.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new ManageSupplyPage(urlms, currentLab, urlmsCont).setVisible(true);
	    		dispose();
	    	}
	    });
	    
	    backBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new LabSelectionPage(urlms,urlmsCont.getActiveUser().getEmail(), urlmsCont).setVisible(true);
	    		dispose();
	    	}
	    });
	
	    lgtButn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	urlmsCont.logout();
				new LoginPage(urlms).setVisible(true);
				dispose();
	    	}
	    });
	    
	    btnProgReport.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
				new SelectProgressRepPage(urlms, currentLab, urlmsCont).setVisible(true);
				setVisible(false);
	    	}
	    });
	    
	    btnUpdateProf.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
				new UpdateProfilePage(urlms, currentLab, urlmsCont).setVisible(true);
				setVisible(false);
	    	}
	    });
	    
	   btnCreateReport.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
				new CreateProgReportPage(urlms, currentLab, urlmsCont).setVisible(true);
				setVisible(false);
	    	}
	    });
	   
	   btnAddExp.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {
				new CreateExpReportPage(urlms, currentLab, urlmsCont).setVisible(true);
				setVisible(false);
	    	}
	    });
	   
	    pack();
		// makes window appear in center of screen
		this.setLocationRelativeTo(null);
	}
}