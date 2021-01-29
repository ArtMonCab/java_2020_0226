package com.ipartek.formacion.spring.uf2177_1.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.spring.uf2177_1.accesodatos.MedicamentoDao;
import com.ipartek.formacion.spring.uf2177_1.accesodatos.MedicamentoDaoJdbc;
import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BoxLayout;

public class PresentacionSwing {
	
	private MedicamentoDao dao = MedicamentoDaoJdbc.getInstancia();
	private Long idSeleccionado = null;

	private JFrame frame;
	private JTable table;
	private JPanel pSaludar;
	private JLabel lblNombre;
	private JTextField tfEjemplo;
	private JButton btnSaludar;
	private JLabel lblResultado;
	private JPanel pFormulario;
	private JLabel lblNewLabel;
	private JTextField tfNombre;
	private JLabel lblNewLabel_1;
	private JTextField tfReferencia;
	private JLabel lblNewLabel_2;
	private JTextField tfPrecio;
	private JButton btnAceptar;
	private JButton btnBorrar;
	
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
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
	public PresentacionSwing() {
		initialize();
		
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nombre", "Referencia", "Precio" });

		table.setModel(modelo);

		cargarTabla();

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow != -1) {
					System.out.println("Selected row: " + selectedRow);
					System.out.println("ValueAt:      " + table.getValueAt(selectedRow, 0).toString());

					tfNombre.setText(table.getValueAt(selectedRow, 1).toString());
					tfReferencia.setText(table.getValueAt(selectedRow, 2).toString());
					tfPrecio.setText(table.getValueAt(selectedRow, 3).toString());
					
					idSeleccionado = (Long)table.getValueAt(selectedRow, 0);
				} else {
					idSeleccionado = null;
				}
			}
		});
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 878, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBackground(SystemColor.controlHighlight);
		table.setBounds(0, 74, 862, 154);
		frame.getContentPane().add(table);
		
		pSaludar = new JPanel();
		pSaludar.setBackground(SystemColor.controlHighlight);
		pSaludar.setBounds(0, 287, 862, 42);
		frame.getContentPane().add(pSaludar);
		pSaludar.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(175, 13, 50, 14);
		pSaludar.add(lblNombre);
		
		tfEjemplo = new JTextField();
		tfEjemplo.setBounds(275, 10, 194, 20);
		pSaludar.add(tfEjemplo);
		tfEjemplo.setColumns(10);
		
		btnSaludar = new JButton("Saludar");
		btnSaludar.setBounds(502, 10, 109, 23);
		pSaludar.add(btnSaludar);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(696, 13, 135, 14);
		pSaludar.add(lblResultado);
		
		pFormulario = new JPanel();
		pFormulario.setBackground(SystemColor.controlHighlight);
		pFormulario.setBounds(0, 0, 862, 42);
		frame.getContentPane().add(pFormulario);
		pFormulario.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 14, 40, 14);
		pFormulario.add(lblNewLabel);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(60, 11, 141, 17);
		pFormulario.add(tfNombre);
		tfNombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Referencia");
		lblNewLabel_1.setBounds(233, 14, 61, 14);
		pFormulario.add(lblNewLabel_1);
		
		tfReferencia = new JTextField();
		tfReferencia.setBounds(304, 11, 191, 20);
		pFormulario.add(tfReferencia);
		tfReferencia.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(522, 14, 46, 14);
		pFormulario.add(lblNewLabel_2);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(566, 11, 86, 20);
		pFormulario.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(674, 10, 89, 23);
		pFormulario.add(btnAceptar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(763, 10, 89, 23);
		pFormulario.add(btnBorrar);
		
		btnSaludar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSaludarClick(lblResultado);
				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptarClick();
			}
		});
		
		JButton btnBorrar = new JButton("Borrar Ref.");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrarClick();
			}
		});
		
		
	}

	protected void btnSaludarClick(JLabel lblResultado2) {
		JOptionPane.showMessageDialog(frame, "Prueba de botón");
		lblResultado.setText("Hola " + tfEjemplo.getText());
		
	}
	
	private void btnAceptarClick() {
		Medicamento medicamento = new Medicamento(null, tfReferencia.getText(), tfNombre.getText(),
				new BigDecimal(tfPrecio.getText()));

		if(idSeleccionado != null) {
			//dao.modificar(medicamento);
			System.out.println("dao.modificar(" + medicamento + ")");
		} else {
			dao.agregar(medicamento);
		}

		cargarTabla();
	}

	private void btnBorrarClick() {
		dao.borrar(tfReferencia.getText());

		cargarTabla();
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0);

		modelo.addRow(new Object[] { "Id", "Nombre", "Referencia", "Precio" });

		for (Medicamento medicamento : dao.obtenerTodos()) {

			modelo.addRow(new Object[] { medicamento.getId(), medicamento.getNombre(), medicamento.getReferencia(),
					medicamento.getPrecio() });
		}
	}

}
