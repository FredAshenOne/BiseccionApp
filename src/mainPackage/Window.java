package mainPackage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;


public class Window extends JFrame {
	private JTextField limit1;
	private JTextField limit2;
	private JTextField txt_parameter;
	double limite1,limite2;
	private JTable table;
	int seleccion;
	
	
	public Window() {
		
		
		setTitle("Biseccion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setBounds(50,50,800,400);
		
		JPanel setpanel = new JPanel();
		setpanel.setBounds(10, 11, 165, 291);
		getContentPane().add(setpanel);
		setpanel.setLayout(null);
		
		
		limit1 = new JTextField();
		limit1.setBounds(13, 36, 110, 20);
		setpanel.add(limit1);
		limit1.setColumns(10);
		
		JButton randomizer1 = new JButton("New button");
		randomizer1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limit1.setText(Integer.toString((int)(Math.random()*100)+1));
				
			}
		});
		randomizer1.setBounds(133, 35, 22, 23);
		setpanel.add(randomizer1);
		
		
		limit2 = new JTextField();
		limit2.setBounds(13, 86, 110, 20);
		setpanel.add(limit2);
		limit2.setColumns(10);
		
		JLabel lblLimit1 = new JLabel("Limit 1");
		lblLimit1.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblLimit1.setBounds(10, 11, 46, 14);
		setpanel.add(lblLimit1);
		
		JLabel lblLimit2 = new JLabel("Limit 2");
		lblLimit2.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lblLimit2.setBounds(10, 61, 46, 14);
		setpanel.add(lblLimit2);
		
		txt_parameter = new JTextField();
		txt_parameter.setBounds(13, 220, 110, 20);
		setpanel.add(txt_parameter);
		txt_parameter.setColumns(10);
		txt_parameter.setVisible(false);
		
		JButton randomizer2 = new JButton("rndm1");
		randomizer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limit2.setText(Integer.toString((int)(Math.random()*100)+1));
			}
		});
		randomizer2.setBounds(133, 85, 22, 23);
		setpanel.add(randomizer2);
		
		JButton randomizer3 = new JButton("rndm2");
		randomizer3.setVisible(false);
		randomizer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_parameter.setText(Integer.toString((int)(Math.random()*100)+1));
			}
		});
		randomizer3.setBounds(133, 219, 22, 23);
		setpanel.add(randomizer3);
		
		JLabel lbl_parameter = new JLabel("Iterations");
		lbl_parameter.setVisible(false);
		lbl_parameter.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		lbl_parameter.setBounds(13, 195, 142, 14);
		setpanel.add(lbl_parameter);
		
		JRadioButton sl_iterations = new JRadioButton("Iterations");
		sl_iterations.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		sl_iterations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_parameter.setVisible(true);
				seleccion = 1;
				lbl_parameter.setVisible(true);
				lbl_parameter.setText("Iterations");
			
			}
		});
		sl_iterations.setBounds(13, 113, 109, 23);
		setpanel.add(sl_iterations);
		
		JRadioButton sl_relerr = new JRadioButton("Relative Error");
		sl_relerr.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		sl_relerr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_parameter.setVisible(true);
				lbl_parameter.setVisible(true);
				seleccion = 2;
				lbl_parameter.setText("Desired Error");
			}
		});
		sl_relerr.setBounds(14, 139, 109, 23);
		setpanel.add(sl_relerr);
		
		JRadioButton sl_eval = new JRadioButton("Evaluate");
		sl_eval.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		sl_eval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_parameter.setVisible(true);
				seleccion = 3;
				lbl_parameter.setText("Desired Function Result");
			}
		});
		sl_eval.setBounds(14, 165, 109, 23);
		setpanel.add(sl_eval);
		
		ButtonGroup select = new ButtonGroup();
		select.add(sl_iterations);
		select.add(sl_relerr);
		select.add(sl_eval);
		
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(43, 313, 89, 23);
		getContentPane().add(btnStart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 11, 599, 291);
		getContentPane().add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Iteration");
		model.addColumn("Minor Limit");
		model.addColumn("Major Limit");
		model.addColumn("New Limit");
		model.addColumn("Function Result");
		model.addColumn("Absolute Error");
		model.addColumn("Relative Error");
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		Registro regs = new Registro();
		Functions fun = new Functions();
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limite1 = Float.parseFloat(limit1.getText());
				limite2 = Float.parseFloat(limit2.getText());
				
				if (limite1 < limite2) {
					regs.setLimiteMenor(limite1);
					regs.setLimiteMayor(limite2);
				}else {
					regs.setLimiteMayor(limite1);
					regs.setLimiteMenor(limite2);					
				}								
				
				switch (seleccion) {
					case 1:
						
						int iter = Integer.parseInt(txt_parameter.getText());
						System.out.println(iter);
						fun.iteraciones(iter,regs, model);
						break;
					case 2:
						double errRel = Double.parseDouble(txt_parameter.getText());
						fun.errResult(errRel, regs, model);
						break;
					case 3:												
						double res = Double.parseDouble(txt_parameter.getText());
						System.out.println(res);
						fun.funResult(res, regs, model);
						break;
					
				}
			}
		});
			
		
	}



	
}
