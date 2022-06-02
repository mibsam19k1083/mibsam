package lab4;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;




public class task2 {

	private JFrame frame;
	private JTextField textField;
//	ArrayList<TelephoneRecord> records = new ArrayList<>();
	private JButton btnNewButton;
	private JTabbedPane tabbedPane;
	
	TelephoneRecord[] trecords;
	private static int counter = 0;
	
	
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel_1;
	private JLabel lblNewLabel_8;
	private JTextField textField_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnNewButton_4;
	
	
	class TelephoneRecord{
		String name;
		String area_code;
		String telephone_num;
		
		TelephoneRecord(){}
		TelephoneRecord(String name, String area_code, String telephone_num){
			this.name=name;
			this.area_code=area_code;
			this.telephone_num=telephone_num;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		public void setArea(String area) {
			this.area_code=area;
		}
		public void setTel(String tel) {
			this.telephone_num=tel;
		}
		
		
		public String getName() {
			return name;
		}
		public String getArea() {
			return area_code;
		}
		public String getTel() {
			return telephone_num;
		}
	}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					task2 window = new task2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public task2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void add(TelephoneRecord tr) {
		trecords[counter++] = tr;
	}
	public TelephoneRecord display(int rec) {
		return trecords[rec-1];
	}
	public void update(int rec, String name, String area, String tel) {
		trecords[rec-1].setName(name);
		trecords[rec-1].setArea(area);
		trecords[rec-1].setTel(tel);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How many records do you want to create?");
		lblNewLabel.setBounds(10, 24, 254, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(271, 21, 91, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Confirm");
		btnNewButton.setBounds(271, 46, 91, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(false);
				int rec = Integer.parseInt(textField.getText());
				trecords = new TelephoneRecord[rec];
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 93, 394, 157);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Add", null, panel, null);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(47, 26, 46, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Area Code:");
		lblNewLabel_2.setBounds(47, 51, 68, 14);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telephone:");
		lblNewLabel_3.setBounds(47, 76, 68, 14);
		panel.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 23, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 48, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(125, 73, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_1 = new JButton("Add Record");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, area_code,telephone_num;
				
				name = textField_1.getText();
				area_code = textField_2.getText();
				telephone_num = textField_3.getText();
				TelephoneRecord tr = new TelephoneRecord(name,area_code,telephone_num);
				add(tr);
				JOptionPane.showMessageDialog(frame, "\nRecord added:  "
				  + "\nName: " + name
				  + "\nArea code: " + area_code
				  + "\nTelephone: " + telephone_num);
			}
		});
		btnNewButton_1.setBounds(125, 104, 101, 23);
		panel.add(btnNewButton_1);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Display", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Enter record number to display: ");
		lblNewLabel_4.setBounds(10, 11, 189, 14);
		panel_2.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 8, 86, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rec = Integer.parseInt(textField_4.getText());
				TelephoneRecord tr = new TelephoneRecord();
				tr = display(rec);
				textField_5.setText(tr.getName());
				textField_6.setText(tr.getArea());
				textField_7.setText(tr.getTel());
			}
		});
		btnNewButton_2.setBounds(296, 7, 86, 23);
		panel_2.add(btnNewButton_2);
		
		lblNewLabel_5 = new JLabel("Name:");
		lblNewLabel_5.setBounds(27, 51, 76, 14);
		panel_2.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Area Code:");
		lblNewLabel_6.setBounds(27, 76, 88, 14);
		panel_2.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Telephone:");
		lblNewLabel_7.setBounds(27, 101, 88, 14);
		panel_2.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(113, 48, 86, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(113, 73, 86, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(113, 101, 86, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Update", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_8 = new JLabel("Record Number:");
		lblNewLabel_8.setBounds(10, 11, 108, 14);
		panel_1.add(lblNewLabel_8);
		
		textField_8 = new JTextField();
		textField_8.setBounds(127, 8, 86, 20);
		textField_8.setColumns(10);
		panel_1.add(textField_8);
		
		lblNewLabel_9 = new JLabel("Name:");
		lblNewLabel_9.setBounds(10, 36, 53, 14);
		panel_1.add(lblNewLabel_9);
		
		textField_9 = new JTextField();
		textField_9.setBounds(127, 33, 86, 20);
		textField_9.setColumns(10);
		panel_1.add(textField_9);
		
		lblNewLabel_10 = new JLabel("Area Code:");
		lblNewLabel_10.setBounds(10, 62, 77, 14);
		panel_1.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Telephone:");
		lblNewLabel_11.setBounds(10, 87, 76, 14);
		panel_1.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setBounds(127, 59, 86, 20);
		textField_11.setColumns(10);
		panel_1.add(textField_11);
		
		textField_10 = new JTextField();
		textField_10.setBounds(127, 84, 86, 20);
		textField_10.setColumns(10);
		panel_1.add(textField_10);
		
		btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rec = Integer.parseInt(textField_8.getText());
				String name = textField_9.getText();
				String area_code = textField_10.getText();
				String telephone_num = textField_11.getText();
				update(rec,name,area_code,telephone_num);
				JOptionPane.showMessageDialog(frame, "\nRecord updated:  "
						  + "\nName: " + name
						  + "\nArea code: " + area_code
						  + "\nTelephone: " + telephone_num);
			}
		});
		btnNewButton_4.setBounds(127, 109, 91, 23);
		panel_1.add(btnNewButton_4);
		
	}
}
