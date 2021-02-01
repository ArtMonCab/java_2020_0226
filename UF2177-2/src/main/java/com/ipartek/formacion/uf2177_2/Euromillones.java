package com.ipartek.formacion.uf2177_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ipartek.formacion.uf2177_2.accesodatos.SorteoDaoJdbc;
import com.ipartek.formacion.uf2177_2.entidades.Sorteo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Euromillones {
	
	private SorteoDaoJdbc dao = SorteoDaoJdbc.getInstancia();
	private Long idSeleccionado = null;

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Número 1");
	private DefaultTableModel modelo;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfNum3;
	private JTextField tfNum4;
	private JTextField tfNum5;
	private JTextField tfEst1;
	private JTextField tfEst2;
	private JTextField tfFecha;
	private JTable tEuromillon;
	private JTextField tfMensaje;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Euromillones window = new Euromillones();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Euromillones() {
		initialize();

		modelo = new DefaultTableModel(new Object[][] {}, new String[] {"Fecha", "Número 1", "Número 2", "Número 3", "Número 4", "Número 5", "Estrella 1", "Estrella 2",});

		tEuromillon.setModel(modelo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 373, 810, 30);
		frame.getContentPane().add(panel);
		
		tfMensaje = new JTextField();
		tfMensaje.setForeground(Color.LIGHT_GRAY);
		tfMensaje.setBackground(Color.LIGHT_GRAY);
		panel.add(tfMensaje);
		tfMensaje.setColumns(100);

		cargarTabla();
		
		tEuromillon.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				int selectedRow = tEuromillon.getSelectedRow();

				if (selectedRow != -1) {
					System.out.println("Selected row: " + selectedRow);
					System.out.println("ValueAt:      " + tEuromillon.getValueAt(selectedRow, 0).toString());

					tfFecha.setText(tEuromillon.getValueAt(selectedRow, 0).toString());
					tfNum1.setText(tEuromillon.getValueAt(selectedRow, 1).toString());
					tfNum2.setText(tEuromillon.getValueAt(selectedRow, 2).toString());
					tfNum3.setText(tEuromillon.getValueAt(selectedRow, 3).toString());
					tfNum4.setText(tEuromillon.getValueAt(selectedRow, 4).toString());
					tfNum5.setText(tEuromillon.getValueAt(selectedRow, 5).toString());
					tfEst1.setText(tEuromillon.getValueAt(selectedRow, 6).toString());
					tfEst2.setText(tEuromillon.getValueAt(selectedRow, 7).toString());
					
					idSeleccionado = (Long)tEuromillon.getValueAt(selectedRow, 0);
				} else {
					idSeleccionado = null;
				}
			}
		});
		
		
	}
	
	private void btnAgregarClick(){
		
		int num1,num2, num3, num4, num5, est1, est2;
		Date fecha;// = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		num1 = Integer.parseInt(tfNum1.getText());
		num2 = Integer.parseInt(tfNum2.getText());
		num3 = Integer.parseInt(tfNum3.getText());
		num4 = Integer.parseInt(tfNum4.getText());
		num5 = Integer.parseInt(tfNum5.getText());
		est1 = Integer.parseInt(tfEst1.getText());
		est2 = Integer.parseInt(tfEst2.getText());
		try {
			fecha = formato.parse(tfFecha.getText());
			Sorteo sorteo = new Sorteo(0,num1, num2, num3, num4, num5, est1, est2, fecha);
			
			
			dao.agregar(sorteo);
			tfMensaje.setText("");
			tfNum1.setText("");
			tfNum2.setText("");
			tfNum3.setText("");
			tfNum4.setText("");
			tfNum5.setText("");
			tfEst1.setText("");
			tfEst2.setText("");
			tfFecha.setText("");
		}catch (ParseException ex){
			tfMensaje.setText("Error en el formato de la fecha");
			
		}
		
		cargarTabla();
		
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0);

		modelo.addRow(new Object[] {"Fecha", "Número 1",  "Número 2",  "Número 3",  "Número 4",  "Número 5", "Estrella 1",  "Estrella 2"  });

		for (Sorteo sorteo : dao.obtenerTodos()) {

			modelo.addRow(new Object[] { sorteo.getFecha(), sorteo.getNum1(), sorteo.getNum2(), sorteo.getNum3(), sorteo.getNum4(), sorteo.getNum5(), sorteo.getEst1(), sorteo.getEst2(), });
		}
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel pIntroducir = new JPanel();
		pIntroducir.setBackground(Color.LIGHT_GRAY);
		pIntroducir.setBounds(10, 11, 169, 351);
		frame.getContentPane().add(pIntroducir);
		pIntroducir.setLayout(null);
		lblNewLabel.setBounds(10, 87, 86, 22);
		pIntroducir.add(lblNewLabel);
		
		JLabel lblNmero = new JLabel("Número 2");
		lblNmero.setBounds(10, 120, 86, 22);
		pIntroducir.add(lblNmero);
		
		JLabel lblNmero_1 = new JLabel("Número 3");
		lblNmero_1.setBounds(10, 149, 86, 22);
		pIntroducir.add(lblNmero_1);
		
		JLabel lblNmero_2 = new JLabel("Número 4");
		lblNmero_2.setBounds(10, 182, 86, 22);
		pIntroducir.add(lblNmero_2);
		
		JLabel lblNmero_3 = new JLabel("Número 5");
		lblNmero_3.setBounds(10, 211, 86, 22);
		pIntroducir.add(lblNmero_3);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(106, 88, 50, 20);
		pIntroducir.add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setColumns(10);
		tfNum2.setBounds(106, 121, 50, 20);
		pIntroducir.add(tfNum2);
		
		tfNum3 = new JTextField();
		tfNum3.setColumns(10);
		tfNum3.setBounds(106, 150, 50, 20);
		pIntroducir.add(tfNum3);
		
		tfNum4 = new JTextField();
		tfNum4.setColumns(10);
		tfNum4.setBounds(106, 183, 50, 20);
		pIntroducir.add(tfNum4);
		
		tfNum5 = new JTextField();
		tfNum5.setColumns(10);
		tfNum5.setBounds(106, 212, 50, 20);
		pIntroducir.add(tfNum5);
		
		JLabel lblEstrella = new JLabel("Estrella 1");
		lblEstrella.setBounds(10, 243, 86, 22);
		pIntroducir.add(lblEstrella);
		
		JLabel lblEstrella_2 = new JLabel("Estrella 2");
		lblEstrella_2.setBounds(10, 275, 86, 22);
		pIntroducir.add(lblEstrella_2);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 56, 50, 22);
		pIntroducir.add(lblFecha);
		
		tfEst1 = new JTextField();
		tfEst1.setBackground(Color.YELLOW);
		tfEst1.setColumns(10);
		tfEst1.setBounds(106, 244, 50, 20);
		pIntroducir.add(tfEst1);
		
		tfEst2 = new JTextField();
		tfEst2.setBackground(Color.YELLOW);
		tfEst2.setHorizontalAlignment(SwingConstants.LEFT);
		tfEst2.setColumns(10);
		tfEst2.setBounds(106, 276, 50, 20);
		pIntroducir.add(tfEst2);
		
		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(70, 57, 86, 20);
		pIntroducir.add(tfFecha);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAgregarClick();
			}


		});
		btnAgregar.setBounds(10, 308, 146, 32);
		pIntroducir.add(btnAgregar);
		
		JLabel lblNewLabel_1 = new JLabel("Combinación ganadora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 11, 159, 22);
		pIntroducir.add(lblNewLabel_1);
		
		JPanel pTabla = new JPanel();
		pTabla.setBackground(Color.LIGHT_GRAY);
		pTabla.setBounds(190, 11, 630, 351);
		frame.getContentPane().add(pTabla);
		
		JLabel lblNewLabel_1_1 = new JLabel("Histórico  de boletos premiados");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		pTabla.add(lblNewLabel_1_1);
		
		tEuromillon = new JTable();
		pTabla.add(tEuromillon);
	}
}
