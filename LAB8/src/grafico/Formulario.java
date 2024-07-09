package grafico;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import logica.Becas;
import logica.Estudiantes;

public class Formulario extends JFrame {
	
	 private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField textNombre;
	    private JTextField textIndice;
	    private JTextField textCedula;
	    private JComboBox<String> comboBoxCarreras;
	    private ArrayList<Estudiantes> estudiantes;

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Formulario frame = new Formulario();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    public Formulario() {
	        estudiantes = new ArrayList<>();
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 600, 400); // Ajusta el tamaño según tus necesidades
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel = new JLabel("Información de estudiantes");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        lblNewLabel.setBounds(150, 10, 300, 30);
	        contentPane.add(lblNewLabel);

	        JLabel lblNewLabel_1 = new JLabel("Nombre:");
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblNewLabel_1.setBounds(50, 70, 80, 20);
	        contentPane.add(lblNewLabel_1);

	        textNombre = new JTextField();
	        textNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textNombre.setBounds(150, 70, 200, 25);
	        contentPane.add(textNombre);
	        textNombre.setColumns(10);

	        JLabel lblNewLabel_2 = new JLabel("Índice:");
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblNewLabel_2.setBounds(50, 120, 80, 20);
	        contentPane.add(lblNewLabel_2);

	        textIndice = new JTextField();
	        textIndice.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textIndice.setBounds(150, 120, 200, 25);
	        contentPane.add(textIndice);
	        textIndice.setColumns(10);

	        JLabel lblNewLabel_3 = new JLabel("Cédula:");
	        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblNewLabel_3.setBounds(50, 170, 80, 20);
	        contentPane.add(lblNewLabel_3);

	        textCedula = new JTextField();
	        textCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        textCedula.setBounds(150, 170, 200, 25);
	        contentPane.add(textCedula);
	        textCedula.setColumns(10);

	        JLabel lblNewLabel_4 = new JLabel("Carrera:");
	        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        lblNewLabel_4.setBounds(50, 220, 80, 20);
	        contentPane.add(lblNewLabel_4);

	        comboBoxCarreras = new JComboBox<>();
	        comboBoxCarreras.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[] {
	                "Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial",
	                "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"
	        }));
	        comboBoxCarreras.setBounds(150, 220, 200, 25);
	        contentPane.add(comboBoxCarreras);

	        JButton btnGuardar = new JButton("Guardar Datos");
	        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        btnGuardar.setBounds(100, 270, 200, 30);
	        contentPane.add(btnGuardar);

	        JButton btnReportes = new JButton("Mostrar Reportes");
	        btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        btnReportes.setBounds(320, 270, 200, 30);
	        contentPane.add(btnReportes);

	        btnGuardar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                guardarDatos();
	            }
	        });

	        btnReportes.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Becas becas = new Becas();
	                for (Estudiantes estudiante : estudiantes) {
	                    becas.agregarEstudiante(estudiante);
	                }
	                Reportes reportes = new Reportes();
	                reportes.setVisible(true);
	                ArrayList<String> nombresBecados = becas.obtenerEstudiantesBecados();
	                reportes.mostrarBecados(nombresBecados); // Mostrar nombres de los estudiantes becados
	            }
	        });
	    }

	    private void guardarDatos() {
	        try {
	            String nombre = textNombre.getText();
	            String cedula = textCedula.getText();
	            double indice = Double.parseDouble(textIndice.getText());
	            String carrera = (String) comboBoxCarreras.getSelectedItem();

	            Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, indice, ""); // Agrega un valor para sexo
	            estudiantes.add(estudiante);

	            JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

	            textNombre.setText("");
	            textCedula.setText("");
	            textIndice.setText("");
	            comboBoxCarreras.setSelectedIndex(-1);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos para Índice.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}